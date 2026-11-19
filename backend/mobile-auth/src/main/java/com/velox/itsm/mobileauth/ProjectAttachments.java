package com.velox.itsm.mobileauth;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.nio.channels.Channels;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.StringJoiner;
import org.json.JSONArray;
import org.json.JSONObject;

final class ProjectAttachments {
    private enum Scope {
        ORDER("purchase-order", null, new Field("masked-po", "MassPOFile"), new Field("product-features", "productFeaturedFileList")),
        REQUIREMENT(ProjectRecords.Kind.REQUIREMENT, new Field("requirement-file", "rdUpload"), new Field("masked-po", "maskedPOfile"),
            new Field("scope-of-work", "ScopeWork_File"), new Field("rfp", "RFP_File"), new Field("other", "Other_File")),
        UNDERSTANDING(ProjectRecords.Kind.UNDERSTANDING, new Field("understanding-file", "udFile"),
            new Field("other-understanding", "Other_UDFile"), new Field("requirement-file", "rdFile"),
            new Field("masked-po", "maskedPOFile"), new Field("scope-of-work", "ScopeWork_File"), new Field("rfp", "RFP_File"),
            new Field("other", "Other_File")),
        KICKOFF(ProjectRecords.Kind.KICKOFF, new Field("kickoff-agenda", "UploadFile1"), new Field("kickoff-plan", "UploadFile2"));

        final String key;
        final ProjectRecords.Kind record;
        final Field[] fields;
        Scope(String key, ProjectRecords.Kind record, Field... fields) { this.key = key; this.record = record; this.fields = fields; }
        Scope(ProjectRecords.Kind record, Field... fields) { this(record.key, record, fields); }
    }

    private static final class Field {
        final String kind, column;
        Field(String kind, String column) { this.kind = kind; this.column = column; }
    }

    static final class Target {
        final Scope scope;
        final int id, recordId;
        final String kind;
        private Target(Scope scope, int id, int recordId, String kind) {
            this.scope = scope; this.id = id; this.recordId = recordId; this.kind = kind;
        }

        static Target parse(JSONObject input, boolean download) {
            Scope chosen = null;
            for (Scope candidate : Scope.values()) if (candidate.key.equals(input.opt("scope"))) chosen = candidate;
            if (chosen == null || !AssignedTasks.validId(input.opt("id"))) return null;
            boolean record = chosen != Scope.ORDER;
            if (input.length() != 2 + (record ? 1 : 0) + (download ? 1 : 0)) return null;
            if (record && !AssignedTasks.validId(input.opt("recordId"))) return null;
            String kind = "";
            if (download) {
                for (Field candidate : chosen.fields) if (candidate.kind.equals(input.opt("kind"))) kind = candidate.kind;
                if (kind.isEmpty()) return null;
            }
            return new Target(chosen, input.getInt("id"), record ? input.getInt("recordId") : 0, kind);
        }
    }

    private ProjectAttachments() {}

    static Map<String, String> filenames(Connection db, Accounts.Account account, Target target) throws SQLException {
        boolean order = target.scope == Scope.ORDER;
        String alias = order ? "p." : "d.";
        StringJoiner columns = new StringJoiner(",");
        for (Field field : target.scope.fields) columns.add(alias + field.column);
        StringBuilder sql = new StringBuilder("SELECT ").append(columns);
        if (order) sql.append(PublishedProjects.ORDER_SCOPE).append(PublishedProjects.ORDER_FILTER).append(" AND p.SR_NO=?");
        else sql.append(target.scope.record.scopedFrom()).append(" AND l.RECORD_ID=?");
        try (PreparedStatement query = db.prepareStatement(sql.toString())) {
            if (order) {
                query.setInt(1, account.id);
                query.setString(2, account.companyCode);
                query.setInt(3, target.id);
            } else {
                ProjectRecords.bindScope(query, account, target.id, target.scope.record);
                query.setInt(5, target.recordId);
            }
            try (ResultSet row = query.executeQuery()) {
                if (!row.next()) return null;
                Map<String, String> names = new LinkedHashMap<>();
                for (Field field : target.scope.fields) {
                    String filename = row.getString(field.column);
                    if (validFilename(filename)) names.put(field.kind, filename);
                }
                return names;
            }
        }
    }

    static JSONObject list(Target target, Map<String, String> files) {
        JSONArray items = new JSONArray();
        files.forEach((kind, name) -> items.put(new JSONObject().put("kind", kind).put("name", name).put("mimeType", mimeType(name))));
        JSONObject reply = new JSONObject().put("kind", "project-attachments").put("scope", target.scope.key).put("id", target.id)
            .put("items", items);
        if (target.recordId != 0) reply.put("recordId", target.recordId);
        return reply;
    }

    static final class Names {
        final Map<String, String> storage, display;
        Names(Map<String, String> storage, Map<String, String> display) { this.storage = storage; this.display = display; }
    }

    static Names names(Connection db, Accounts.Account account, Target target) throws SQLException {
        Map<String, String> storage = filenames(db, account, target);
        if (storage == null) return null;
        if (target.scope != Scope.KICKOFF || storage.isEmpty()) return new Names(storage, storage);
        Map<String, String> display = new LinkedHashMap<>(storage);
        try (PreparedStatement query = db.prepareStatement("SELECT FILE_KIND,STORAGE_NAME,ORIGINAL_NAME FROM scm_mobile_kickoff_file WHERE COMPANY_CODE=? AND MEETING_ID=?")) {
            query.setString(1, account.companyCode);
            query.setInt(2, target.recordId);
            try (ResultSet row = query.executeQuery()) {
                while (row.next()) {
                    String kind = row.getString(1), original = row.getString(3);
                    if (row.getString(2).equals(storage.get(kind)) && validFilename(original)) display.put(kind, original);
                }
            }
        }
        return new Names(storage, display);
    }

    private static boolean validFilename(String name) {
        if (name == null || name.isEmpty() || name.length() > 255 || !name.equals(name.trim()) || name.endsWith(".")
                || name.codePoints().anyMatch(Character::isISOControl)) return false;
        for (char reserved : new char[]{'/', '\\', ':', '*', '?', '"', '<', '>', '|'}) {
            if (name.indexOf(reserved) >= 0) return false;
        }
        String literal = name.toLowerCase(Locale.ROOT);
        return !("na".equals(literal) || "n/a".equals(literal) || "null".equals(literal)
            || "no file available".equals(literal) || "file not attached".equals(literal));
    }

    static Download open(Path configured, String filename, String displayName) throws IOException {
        if (!validFilename(filename) || !validFilename(displayName)) return null;
        Path root = configured.toRealPath();
        Path file = root.resolve(filename);
        try {
            BasicFileAttributes attributes = Files.readAttributes(file, BasicFileAttributes.class, LinkOption.NOFOLLOW_LINKS);
            if (!attributes.isRegularFile()) return null;
            SeekableByteChannel channel = Files.newByteChannel(file, StandardOpenOption.READ, LinkOption.NOFOLLOW_LINKS);
            try {
                long length = channel.size();
                return new Download(displayName, length, Channels.newInputStream(channel));
            } catch (IOException | RuntimeException failure) {
                channel.close();
                throw failure;
            }
        } catch (NoSuchFileException missing) {
            return null;
        }
    }

    private static String mimeType(String name) {
        String suffix = name.substring(name.lastIndexOf('.') + 1).toLowerCase(Locale.ROOT);
        switch (suffix) {
            case "pdf": return "application/pdf";
            case "doc": return "application/msword";
            case "docx": return "application/vnd.openxmlformats-officedocument.wordprocessingml.document";
            case "xls": return "application/vnd.ms-excel";
            case "xlsx": return "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
            case "ppt": return "application/vnd.ms-powerpoint";
            case "pptx": return "application/vnd.openxmlformats-officedocument.presentationml.presentation";
            case "csv": return "text/csv";
            case "txt": return "text/plain";
            case "jpg": case "jpeg": return "image/jpeg";
            case "png": return "image/png";
            case "zip": return "application/zip";
            default: return "application/octet-stream";
        }
    }

    static final class Download implements Closeable {
        final String name;
        final long length;
        private final InputStream content;
        Download(String name, long length, InputStream content) { this.name = name; this.length = length; this.content = content; }
        String mimeType() { return ProjectAttachments.mimeType(name); }
        String disposition() throws IOException {
            return "attachment; filename=\"" + name.replaceAll("[^A-Za-z0-9._ -]", "_") + "\"; filename*=UTF-8''"
                + URLEncoder.encode(name, "UTF-8").replace("+", "%20").replace("*", "%2A").replace("%7E", "~");
        }
        void writeTo(OutputStream output) throws IOException {
            byte[] buffer = new byte[32_768];
            long remaining = length;
            while (remaining > 0) {
                int read = content.read(buffer, 0, (int)Math.min(buffer.length, remaining));
                if (read < 0) throw new IOException("SCM attachment was truncated while being read");
                output.write(buffer, 0, read);
                remaining -= read;
            }
        }
        @Override public void close() throws IOException { content.close(); }
    }
}
