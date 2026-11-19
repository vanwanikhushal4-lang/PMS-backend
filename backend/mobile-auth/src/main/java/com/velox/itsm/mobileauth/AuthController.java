package com.velox.itsm.mobileauth;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.Locale;
import java.util.logging.Logger;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Profile("scm-mobile-auth")
@RequestMapping("/mobile/v1/auth")
public class AuthController {
    private static final int MAX_BODY = 8192;
    private static final Logger LOG = Logger.getLogger(AuthController.class.getName());
    private final AuthService auth;
    private final boolean loopbackQa;

    @Autowired public AuthController(AuthService auth) { this(auth, false); }
    /** Available to the isolated assembly; never enabled by the production Spring profile. */
    protected AuthController(AuthService auth, boolean loopbackQa) { this.auth = auth; this.loopbackQa = loopbackQa; }

    @RequestMapping(value = {"/sign-in", "/challenge/verify", "/challenge/resend", "/sign-out", "/recovery/start", "/recovery/verify", "/recovery/complete",
        "/projects/list", "/projects/detail", "/projects/records", "/projects/records/detail", "/projects/tasks", "/projects/favorite",
        "/projects/records/review-queue", "/projects/records/review",
        "/projects/kickoff/options", "/projects/kickoff/schedule",
        "/projects/create-options", "/projects/create",
        "/projects/publishing/tree", "/projects/publishing/orders", "/projects/publishing/order", "/projects/publishing/tasks",
        "/projects/attachments/list", "/projects/attachments/download",
        "/tasks/assigned-by-me", "/tasks/assigned-to-me", "/tasks/completed", "/tasks/work-log", "/tasks/progress", "/tasks/complete",
        "/tasks/dates/list", "/tasks/dates/detail", "/tasks/dates/request", "/tasks/dates/approve",
        "/tasks/dates/request-batch", "/tasks/dates/approve-batch",
        "/tasks/assignments/list", "/tasks/assignments/project-options", "/tasks/assignments/options",
        "/tasks/assignments/create", "/tasks/assignments/reassign", "/tasks/assignments/reassign-bulk",
        "/tasks/assignments/contexts", "/tasks/assignments/standalone-options",
        "/tasks/assignments/standalone-create"}, method = RequestMethod.POST)
    public void post(HttpServletRequest request, HttpServletResponse response) throws IOException { respond(request, response, true); }

    @RequestMapping(value = {"/session", "/workspace", "/profile"}, method = RequestMethod.GET)
    public void get(HttpServletRequest request, HttpServletResponse response) throws IOException { respond(request, response, false); }

    private void respond(HttpServletRequest request, HttpServletResponse response, boolean withBody) throws IOException {
        response.setHeader("Cache-Control", "no-store");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("X-Content-Type-Options", "nosniff");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        if (!request.isSecure() && !(loopbackQa && loopback(request.getRemoteAddr()) && loopback(request.getLocalAddr()))) {
            error(response, 403, "account-unavailable"); return;
        }
        String base = request.getContextPath() + "/mobile/v1/auth/";
        String path = request.getRequestURI();
        if (!path.startsWith(base) || request.getQueryString() != null) { error(response, 400, "account-unavailable"); return; }
        String action = path.substring(base.length());
        boolean scheduling = "projects/kickoff/schedule".equals(action);
        String expectedType = scheduling ? "multipart/form-data" : "application/json";
        if (withBody && (request.getContentType() == null || !expectedType.equals(request.getContentType().split(";", 2)[0].trim().toLowerCase(Locale.ROOT)))) {
            error(response, 415, "account-unavailable"); return;
        }
        String authorization = request.getHeader("Authorization");
        String bearer = authorization != null && authorization.startsWith("Bearer ") && authorization.length() == 50 ? authorization.substring(7) : null;
        try {
            if (scheduling) {
                AuthService.Reply reply = auth.scheduleKickoff(bearer, root -> KickoffFiles.read(request, root));
                write(response, reply.status, reply.body);
                return;
            }
            int limit = "tasks/dates/request-batch".equals(action) ? MAX_BODY * 5 : MAX_BODY;
            JSONObject data = withBody ? read(request, limit) : new JSONObject();
            AuthService.Reply reply = auth.dispatch(action, data, bearer, request.getRemoteAddr());
            if (reply.download == null) write(response, reply.status, reply.body);
            else try (ProjectAttachments.Download file = reply.download) {
                response.setStatus(reply.status);
                response.setContentType(file.mimeType());
                response.setHeader("Cache-Control", "no-store, no-transform");
                response.setHeader("Content-Disposition", file.disposition());
                response.setHeader("Content-Security-Policy", "sandbox");
                response.setContentLengthLong(file.length);
                file.writeTo(response.getOutputStream());
            }
        } catch (BodyTooLarge e) { error(response, 413, "account-unavailable"); }
        catch (JSONException e) { error(response, 400, "account-unavailable"); }
        catch (SQLException | AuthService.Unavailable | IllegalStateException e) {
            // Framework/driver exception messages can contain connection or credential material.
            LOG.warning("SCM mobile authentication dependency unavailable: " + e.getClass().getSimpleName());
            error(response, 503, "account-unavailable");
        }
    }

    private JSONObject read(HttpServletRequest request, int limit) throws IOException, BodyTooLarge {
        if (request.getContentLengthLong() > limit) throw new BodyTooLarge();
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        byte[] chunk = new byte[1024];
        ServletInputStream stream = request.getInputStream();
        for (int n; (n = stream.read(chunk)) != -1;) {
            if (bytes.size() + n > limit) throw new BodyTooLarge();
            bytes.write(chunk, 0, n);
        }
        return new JSONObject(new String(bytes.toByteArray(), StandardCharsets.UTF_8));
    }

    private void error(HttpServletResponse response, int status, String reason) throws IOException {
        write(response, status, new JSONObject().put("kind", "rejected").put("reason", reason));
    }
    private void write(HttpServletResponse response, int status, JSONObject body) throws IOException {
        response.setStatus(status);
        if (body != null) response.getWriter().write(body.toString());
    }
    private boolean loopback(String ip) { return "127.0.0.1".equals(ip) || "0:0:0:0:0:0:0:1".equals(ip) || "::1".equals(ip); }
    private static final class BodyTooLarge extends Exception { private static final long serialVersionUID = 1L; }
}
