package com.velox.itsm.mobileauth;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.Hashtable;
import javax.naming.AuthenticationException;
import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.InitialDirContext;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONObject;

final class Integrations {
    private Integrations() {}

    static AuthService.Directory directory(String endpoint, String company, String realm) {
        if (blank(endpoint) && blank(company) && blank(realm)) return (c, u, p) -> { throw new AuthService.Unavailable(); };
        URI location = endpoint(endpoint, "ldaps");
        if (!location.getPath().isEmpty() && !"/".equals(location.getPath())) throw new IllegalArgumentException("LDAPS URL may not specify a path");
        if (blank(company) || realm == null || !realm.matches("[A-Za-z0-9][A-Za-z0-9.-]{0,252}")) throw new IllegalArgumentException("Invalid directory configuration");
        return (actualCompany, username, password) -> {
            if (!company.equals(actualCompany)) throw new AuthService.Unavailable();
            if (!username.matches("[A-Za-z0-9][A-Za-z0-9_.-]{0,127}") || password.isEmpty()) return false;
            if (Boolean.getBoolean("com.sun.jndi.ldap.object.disableEndpointIdentification")) throw new AuthService.Unavailable();
            Hashtable<String, String> settings = new Hashtable<>();
            settings.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
            settings.put(Context.PROVIDER_URL, location.toASCIIString());
            settings.put(Context.SECURITY_AUTHENTICATION, "simple");
            settings.put(Context.SECURITY_PRINCIPAL, username + "@" + realm);
            settings.put(Context.SECURITY_CREDENTIALS, password);
            settings.put(Context.REFERRAL, "ignore");
            settings.put("com.sun.jndi.ldap.connect.timeout", "4000");
            settings.put("com.sun.jndi.ldap.read.timeout", "4000");
            try {
                InitialDirContext bind = new InitialDirContext(settings);
                bind.close();
                return true;
            } catch (AuthenticationException e) { return false; }
            catch (NamingException e) { throw new AuthService.Unavailable(); }
            finally { settings.remove(Context.SECURITY_CREDENTIALS); }
        };
    }

    static AuthService.Delivery delivery(String address, String bearer) {
        if (blank(address) && blank(bearer)) return (c, d, s) -> { throw new AuthService.Unavailable(); };
        URI location = endpoint(address, "https");
        if (bearer == null || !bearer.matches("[A-Za-z0-9._~+/-]{22,500}={0,2}")) throw new IllegalArgumentException("Invalid delivery credential configuration");
        return (channel, destination, code) -> {
            HttpsURLConnection connection = null;
            try {
                connection = (HttpsURLConnection)location.toURL().openConnection();
                connection.setInstanceFollowRedirects(false);
                connection.setConnectTimeout(3000); connection.setReadTimeout(3500);
                connection.setRequestMethod("POST"); connection.setDoOutput(true);
                connection.setRequestProperty("Content-Type", "application/json");
                connection.setRequestProperty("Authorization", "Bearer " + bearer);
                byte[] body = new JSONObject().put("channel", channel).put("destination", destination).put("code", code).toString().getBytes(StandardCharsets.UTF_8);
                connection.setFixedLengthStreamingMode(body.length);
                try (OutputStream writer = connection.getOutputStream()) { writer.write(body); }
                int result = connection.getResponseCode();
                if (result < 200 || result >= 300) throw new AuthService.Unavailable();
            } catch (IOException e) { throw new AuthService.Unavailable(); }
            finally { if (connection != null) connection.disconnect(); }
        };
    }

    private static boolean blank(String data) { return data == null || data.trim().isEmpty(); }
    private static URI endpoint(String raw, String scheme) {
        if (raw == null) throw new IllegalArgumentException("Missing integration address");
        URI address;
        try { address = URI.create(raw); }
        catch (IllegalArgumentException e) { throw new IllegalArgumentException("Invalid integration address"); }
        if (!scheme.equals(address.getScheme()) || address.getHost() == null || address.getUserInfo() != null
            || address.getFragment() != null || address.getQuery() != null) throw new IllegalArgumentException("Invalid integration address");
        return address;
    }
}
