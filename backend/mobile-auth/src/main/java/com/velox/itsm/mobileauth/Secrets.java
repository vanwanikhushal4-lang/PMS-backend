package com.velox.itsm.mobileauth;

import java.io.ByteArrayOutputStream;
import java.net.URLEncoder;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Base64;
import java.util.Locale;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

public final class Secrets {
    private static final int ITERATIONS = 600000;
    private static final String BASE32 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ234567";
    private final SecureRandom random = new SecureRandom();
    private final SecretKeySpec encryptionKey;
    private final SecretKeySpec codeKey;

    public Secrets(byte[] key) {
        if (key.length != 32) throw new IllegalArgumentException("Mobile auth key must contain exactly 32 bytes");
        encryptionKey = new SecretKeySpec(key, "AES");
        codeKey = new SecretKeySpec(hmac(new SecretKeySpec(key, "HmacSHA256"), "scm-mobile-code-v1".getBytes(StandardCharsets.US_ASCII)), "HmacSHA256");
    }

    private byte[] bytes(int size) { byte[] value = new byte[size]; random.nextBytes(value); return value; }
    public String token() { return encode(bytes(32)); }
    public String smsCode() { return String.format(Locale.ROOT, "%06d", random.nextInt(1000000)); }
    byte[] codeHash(String token, String code) { return hmac(codeKey, (token + ":" + code).getBytes(StandardCharsets.US_ASCII)); }
    static String tokenHash(String token) {
        try { return encode(MessageDigest.getInstance("SHA-256").digest(token.getBytes(StandardCharsets.UTF_8))); }
        catch (GeneralSecurityException e) { throw new IllegalStateException("SHA256 unavailable", e); }
    }
    private static String encode(byte[] value) { return Base64.getUrlEncoder().withoutPadding().encodeToString(value); }

    public String passwordHash(String password) {
        byte[] salt = bytes(16);
        return "pbkdf2-sha256$" + ITERATIONS + "$" + encode(salt) + "$" + encode(derive(password, salt, ITERATIONS));
    }

    public boolean passwordMatches(String password, String hash) {
        if (hash == null) return false;
        String[] parts = hash.split("\\$", -1);
        if (parts.length != 4 || !"pbkdf2-sha256".equals(parts[0])) return false;
        try {
            int iterations = Integer.parseInt(parts[1]);
            byte[] salt = Base64.getUrlDecoder().decode(parts[2]);
            byte[] expected = Base64.getUrlDecoder().decode(parts[3]);
            if (iterations < ITERATIONS || iterations > 2000000 || salt.length != 16 || expected.length != 32) return false;
            return MessageDigest.isEqual(expected, derive(password, salt, iterations));
        } catch (IllegalArgumentException e) { return false; }
    }

    private byte[] derive(String password, byte[] salt, int iterations) {
        char[] chars = password.toCharArray();
        PBEKeySpec spec = new PBEKeySpec(chars, salt, iterations, 256);
        try { return SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256").generateSecret(spec).getEncoded(); }
        catch (GeneralSecurityException e) { throw new IllegalStateException("Password hashing unavailable", e); }
        finally { spec.clearPassword(); Arrays.fill(chars, '\0'); }
    }

    public String newTotpSecret() {
        StringBuilder result = new StringBuilder(32);
        for (byte value : bytes(32)) result.append(BASE32.charAt(value & 31));
        return result.toString();
    }

    public String encryptTotp(int id, String secret) {
        if (!secret.matches("[A-Z2-7]{16,128}")) throw new IllegalArgumentException("Invalid authenticator key");
        byte[] iv = bytes(12);
        byte[] encrypted = crypt(Cipher.ENCRYPT_MODE, id, iv, secret.getBytes(StandardCharsets.US_ASCII));
        return encode(ByteBuffer.allocate(iv.length + encrypted.length).put(iv).put(encrypted).array());
    }

    public String decryptTotp(int id, String data) {
        byte[] buffer = Base64.getUrlDecoder().decode(data);
        if (buffer.length < 29) throw new IllegalStateException("Invalid encrypted authenticator key");
        return new String(crypt(Cipher.DECRYPT_MODE, id, Arrays.copyOfRange(buffer, 0, 12), Arrays.copyOfRange(buffer, 12, buffer.length)), StandardCharsets.US_ASCII);
    }

    private byte[] crypt(int mode, int id, byte[] iv, byte[] value) {
        try {
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            cipher.init(mode, encryptionKey, new GCMParameterSpec(128, iv));
            cipher.updateAAD(ByteBuffer.allocate(4).putInt(id).array());
            return cipher.doFinal(value);
        } catch (GeneralSecurityException e) { throw new IllegalStateException("Authenticator keys unavailable", e); }
    }

    static String enrollmentUri(String company, String username, String secret) {
        return "otpauth://totp/" + uri(company + ":" + username) + "?secret=" + secret + "&issuer=" + uri(company) + "&digits=6&period=30";
    }

    private static String uri(String value) {
        try { return URLEncoder.encode(value, "UTF-8").replace("+", "%20"); }
        catch (java.io.UnsupportedEncodingException e) { throw new IllegalStateException(e); }
    }

    static long matchingStep(String secret, String code, long now) {
        long step = now / 30000;
        for (long candidate = step + 1; candidate >= step - 1 && candidate >= 0; candidate--) {
            if (MessageDigest.isEqual(totp(secret, candidate).getBytes(StandardCharsets.US_ASCII), code.getBytes(StandardCharsets.US_ASCII))) return candidate;
        }
        return -1;
    }

    public static String totp(String secret, long step) {
        if (!secret.matches("[A-Z2-7]{16,128}")) throw new IllegalArgumentException("Invalid authenticator key");
        ByteArrayOutputStream decoded = new ByteArrayOutputStream();
        int bits = 0, buffer = 0;
        for (int i = 0; i < secret.length(); i++) {
            buffer = (buffer << 5) | BASE32.indexOf(secret.charAt(i));
            bits += 5;
            if (bits >= 8) { bits -= 8; decoded.write((buffer >> bits) & 255); }
        }
        byte[] output = hmac(new SecretKeySpec(decoded.toByteArray(), "HmacSHA1"), ByteBuffer.allocate(8).putLong(step).array());
        int position = output[output.length - 1] & 15;
        int number = ByteBuffer.wrap(output, position, 4).getInt() & 0x7fffffff;
        return String.format(Locale.ROOT, "%06d", number % 1000000);
    }

    private static byte[] hmac(SecretKeySpec key, byte[] input) {
        try { Mac mac = Mac.getInstance(key.getAlgorithm()); mac.init(key); return mac.doFinal(input); }
        catch (GeneralSecurityException e) { throw new IllegalStateException("Authentication hashing unavailable", e); }
    }
}
