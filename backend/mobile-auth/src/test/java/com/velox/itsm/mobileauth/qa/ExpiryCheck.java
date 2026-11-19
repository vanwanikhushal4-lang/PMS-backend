package com.velox.itsm.mobileauth.qa;

import com.velox.itsm.mobileauth.AuthService;
import java.nio.file.Paths;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONObject;

/** Test production expiry windows without sleeping or exposing a clock control endpoint. */
public final class ExpiryCheck {
    public static void main(String[] args) throws Exception {
        AtomicLong clock = new AtomicLong(System.currentTimeMillis());
        try (AuthService service = StagingInitializer.QA.createStage("clock", Paths.get(args[0]), clock::get)) {
            JSONObject input = new JSONObject().put("companyCode", "QA-A").put("username", "sms").put("password", "Stage-only-password-28");
            AuthService.Reply sms = service.dispatch("sign-in", input, null, "expiry-test");
            if (sms.status != 202) throw new AssertionError("Expected SMS challenge");
            clock.set(sms.body.getLong("expiresAt"));
            if (service.dispatch("challenge/verify", new JSONObject().put("challengeId", sms.body.getString("challengeId"))
                    .put("code", "123456"), null, "expiry-test").status != 410) throw new AssertionError("Expired challenge accepted");
            AuthService.Reply active = service.dispatch("sign-in", input.put("username", "alex"), null, "expiry-test");
            if (active.status != 200) throw new AssertionError("Expected session");
            clock.set(active.body.getLong("expiresAt"));
            if (service.dispatch("session", new JSONObject(), active.body.getString("sessionToken"), "expiry-test").status != 401)
                throw new AssertionError("Expired session accepted");
            System.out.println("Java clock test passed: challenge and session expire at their published deadline.");
        }
    }
}
