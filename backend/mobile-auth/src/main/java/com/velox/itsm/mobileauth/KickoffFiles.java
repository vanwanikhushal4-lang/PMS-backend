package com.velox.itsm.mobileauth;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URLDecoder;
import java.nio.charset.CodingErrorAction;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartException;

final class KickoffFiles {
    static final long MAX_FILE = 10 * 1024 * 1024;
    static final long MAX_REQUEST = 2 * MAX_FILE + 32_768;
    private static final Logger LOG = Logger.getLogger(KickoffFiles.class.getName());
    private KickoffFiles() {}

    interface Source { Upload read(Path root) throws IOException, Invalid; }
    static final class Invalid extends Exception {
        final int status;
        Invalid(int status) { super("Invalid kickoff upload"); this.status = status; }
    }
    private interface Item { String filename(); long size(); InputStream open() throws IOException; }

    static Upload read(HttpServletRequest request, Path configured) throws IOException, Invalid {
        if (request.getContentLengthLong() > MAX_REQUEST) throw new Invalid(413);
        Path root = configured.toRealPath();
        if (!Files.isDirectory(root, LinkOption.NOFOLLOW_LINKS)) throw new IOException("Attachment storage is unavailable");
        Map<String, Item> items = new LinkedHashMap<>();
        List<Part> cleanup = new ArrayList<>();
        Staged agenda = null, plan = null;
        boolean encodedNames = "percent".equals(request.getHeader("X-SCM-Filename-Encoding"));
        try {
            if (request instanceof MultipartHttpServletRequest) {
                MultipartHttpServletRequest parsed = (MultipartHttpServletRequest) request;
                if (parsed.getParameterMap().size() != 1 || parsed.getParameterValues("details") == null || parsed.getParameterValues("details").length != 1) throw new Invalid(400);
                byte[] details = parsed.getParameter("details").getBytes(StandardCharsets.UTF_8);
                if (details.length > 8192) throw new Invalid(400);
                items.put("details", bytes(details));
                for (Map.Entry<String, List<MultipartFile>> entry : parsed.getMultiFileMap().entrySet()) {
                    if (entry.getValue().size() != 1 || items.containsKey(entry.getKey())) throw new Invalid(400);
                    MultipartFile file = entry.getValue().get(0);
                    items.put(entry.getKey(), new Item() {
                        public String filename() { return file.getOriginalFilename(); }
                        public long size() { return file.getSize(); }
                        public InputStream open() throws IOException { return file.getInputStream(); }
                    });
                }
            } else {
                Collection<Part> parts;
                try { parts = request.getParts(); }
                catch (IllegalStateException failure) {
                    if (uploadLimit(failure)) throw new Invalid(413);
                    throw failure; // Missing container multipart configuration is an unavailable dependency.
                } catch (ServletException failure) { throw new Invalid(uploadLimit(failure) ? 413 : 400); }
                cleanup.addAll(parts);
                for (Part part : parts) {
                    if (items.put(part.getName(), new Item() {
                        public String filename() { return part.getSubmittedFileName(); }
                        public long size() { return part.getSize(); }
                        public InputStream open() throws IOException { return part.getInputStream(); }
                    }) != null) throw new Invalid(400);
                }
            }
            if (!items.containsKey("details") || !items.containsKey("agenda") || items.size() != (items.containsKey("plan") ? 3 : 2)) throw new Invalid(400);
            Item details = items.get("details");
            if (details.filename() != null || details.size() < 1 || details.size() > 8192) throw new Invalid(400);
            JSONObject input;
            try (InputStream stream = details.open()) {
                input = new JSONObject(new String(limited(stream, 8192), StandardCharsets.UTF_8));
            } catch (JSONException failure) { throw new Invalid(400); }
            agenda = stage(root, items.get("agenda"), encodedNames);
            if (items.containsKey("plan")) plan = stage(root, items.get("plan"), encodedNames);
            return new Upload(input, agenda, plan);
        } catch (IOException | Invalid | RuntimeException failure) {
            if (agenda != null) agenda.delete();
            if (plan != null) plan.delete();
            if (failure instanceof MultipartException) throw new Invalid(uploadLimit(failure) ? 413 : 400);
            throw failure;
        } finally {
            for (Part part : cleanup) try { part.delete(); } catch (IOException failure) { LOG.warning("SCM multipart temporary cleanup will be retried by container"); }
        }
    }

    private static boolean uploadLimit(Throwable failure) {
        // Tomcat and Spring's Commons resolver use separate classes for file and request limits.
        for (Throwable cause = failure; cause != null; cause = cause.getCause()) {
            if (cause instanceof MaxUploadSizeExceededException || cause.getClass().getSimpleName().endsWith("SizeLimitExceededException")) return true;
        }
        return false;
    }

    private static Item bytes(byte[] value) {
        return new Item() {
            public String filename() { return null; }
            public long size() { return value.length; }
            public InputStream open() { return new java.io.ByteArrayInputStream(value); }
        };
    }

    private static byte[] limited(InputStream input, int max) throws IOException, Invalid {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        byte[] chunk = new byte[1024];
        for (int read; (read = input.read(chunk)) != -1;) {
            if (output.size() + read > max) throw new Invalid(400);
            output.write(chunk, 0, read);
        }
        return output.toByteArray();
    }

    private static Staged stage(Path root, Item item, boolean encodedName) throws IOException, Invalid {
        String name = item.filename();
        if (name == null) throw new Invalid(400);
        // Expo's native FormData encodes filenames; a literal '+' remains a plus.
        if (encodedName) {
            try { name = URLDecoder.decode(name.replace("+", "%2B"), "UTF-8"); }
            catch (IllegalArgumentException malformedEscape) { throw new Invalid(400); }
        }
        if (!validName(name) || item.size() < 1 || item.size() > MAX_FILE) throw new Invalid(item.size() > MAX_FILE ? 413 : 400);
        Path temporary = Files.createTempFile(root, ".scm-kickoff-", ".pending");
        boolean kept = false;
        try {
            MessageDigest digest;
            try { digest = MessageDigest.getInstance("SHA-256"); } catch (NoSuchAlgorithmException failure) { throw new IllegalStateException(failure); }
            long count = 0;
            byte[] prefix = new byte[8]; int prefixSize = 0;
            try (InputStream input = item.open(); OutputStream output = Files.newOutputStream(temporary, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING)) {
                byte[] chunk = new byte[32_768];
                for (int read; (read = input.read(chunk)) != -1;) {
                    count += read;
                    if (count > MAX_FILE) throw new Invalid(413);
                    int copied = Math.min(prefix.length - prefixSize, read);
                    if (copied > 0) { System.arraycopy(chunk, 0, prefix, prefixSize, copied); prefixSize += copied; }
                    output.write(chunk, 0, read); digest.update(chunk, 0, read);
                }
            }
            if (count != item.size() || !content(temporary, name, prefix, prefixSize)) throw new Invalid(400);
            Staged result = new Staged(temporary, name, count, Base64.getUrlEncoder().withoutPadding().encodeToString(digest.digest()));
            kept = true;
            return result;
        } finally { if (!kept) Files.deleteIfExists(temporary); }
    }

    private static boolean validName(String name) {
        return name.length() <= 160 && name.equals(name.trim()) && !name.codePoints().anyMatch(Character::isISOControl)
            && !name.matches(".*[\\\\/:*?\"<>|].*") && name.matches("(?i).+\\.(pdf|docx?|xlsx?|pptx?|txt|csv|jpe?g|png|zip)");
    }

    private static boolean content(Path file, String name, byte[] prefix, int size) throws IOException {
        String extension = name.substring(name.lastIndexOf('.') + 1).toLowerCase(Locale.ROOT);
        switch (extension) {
            case "pdf": return starts(prefix, size, 0x25, 0x50, 0x44, 0x46, 0x2d);
            case "png": return starts(prefix, size, 0x89, 0x50, 0x4e, 0x47, 0x0d, 0x0a, 0x1a, 0x0a);
            case "jpg": case "jpeg": return starts(prefix, size, 0xff, 0xd8, 0xff);
            case "doc": case "xls": case "ppt": return starts(prefix, size, 0xd0, 0xcf, 0x11, 0xe0, 0xa1, 0xb1, 0x1a, 0xe1);
            case "docx": case "xlsx": case "pptx": return starts(prefix, size, 0x50, 0x4b, 0x03, 0x04);
            case "zip": return starts(prefix, size, 0x50, 0x4b, 0x03, 0x04) || starts(prefix, size, 0x50, 0x4b, 0x05, 0x06);
            default:
                try (InputStreamReader reader = new InputStreamReader(Files.newInputStream(file), StandardCharsets.UTF_8.newDecoder()
                        .onMalformedInput(CodingErrorAction.REPORT).onUnmappableCharacter(CodingErrorAction.REPORT))) {
                    char[] chunk = new char[4096];
                    for (int read; (read = reader.read(chunk)) != -1;) for (int i = 0; i < read; i++) {
                        if (Character.isISOControl(chunk[i]) && chunk[i] != '\n' && chunk[i] != '\r' && chunk[i] != '\t') return false;
                    }
                    return true;
                } catch (java.nio.charset.CharacterCodingException failure) { return false; }
        }
    }
    private static boolean starts(byte[] prefix, int size, int... expected) {
        if (size < expected.length) return false;
        for (int i = 0; i < expected.length; i++) if ((prefix[i] & 255) != expected[i]) return false;
        return true;
    }

    static final class Staged {
        Path path;
        final String name, hash, storageName;
        final long size;
        private boolean published;
        Staged(Path path, String name, long size, String hash) {
            this.path = path; this.name = name; this.size = size; this.hash = hash;
            this.storageName = UUID.randomUUID() + name.substring(name.lastIndexOf('.')).toLowerCase(Locale.ROOT);
        }
        void publish() throws IOException {
            if (published) return;
            Path target = path.resolveSibling(storageName);
            // Random names and same-filesystem atomic publication never overwrite a legacy file.
            Files.move(path, target, StandardCopyOption.ATOMIC_MOVE);
            path = target; published = true;
        }
        JSONArray fingerprint() { return new JSONArray().put(name).put(size).put(hash); }
        void delete() { try { Files.deleteIfExists(path); } catch (IOException failure) { LOG.warning("SCM unused kickoff upload needs storage reconciliation"); } }
    }

    static final class Upload implements Closeable {
        final JSONObject details;
        final Staged agenda, plan;
        private boolean retained;
        Upload(JSONObject details, Staged agenda, Staged plan) { this.details = details; this.agenda = agenda; this.plan = plan; }
        void publish() throws IOException { agenda.publish(); if (plan != null) plan.publish(); }
        void retain() { retained = true; }
        boolean retained() { return retained; }
        void metadata(Connection db, String company, int meeting) throws SQLException {
            try (PreparedStatement insert = db.prepareStatement("INSERT INTO scm_mobile_kickoff_file"
                    + " (COMPANY_CODE,MEETING_ID,FILE_KIND,STORAGE_NAME,ORIGINAL_NAME,SIZE_BYTES,CONTENT_HASH) VALUES (?,?,?,?,?,?,?)")) {
                List<Staged> files = plan == null ? Arrays.asList(agenda) : Arrays.asList(agenda, plan);
                for (Staged file : files) {
                    insert.setString(1, company); insert.setInt(2, meeting); insert.setString(3, file == agenda ? "kickoff-agenda" : "kickoff-plan");
                    insert.setString(4, file.storageName); insert.setString(5, file.name); insert.setLong(6, file.size); insert.setString(7, file.hash); insert.executeUpdate();
                }
            }
        }
        @Override public void close() { if (!retained) { agenda.delete(); if (plan != null) plan.delete(); } }
    }
}
