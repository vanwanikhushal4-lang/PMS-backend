import com.velox.itsm.mobileauth.Secrets;
import java.io.Console;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Base64;
import java.util.Locale;

/** Offline CLI: create material for operator provisioning without contacting a database. */
public final class Provision {
    public static void main(String[] args) {
        boolean password = args.length == 1 && "hash-password".equals(args[0]);
        boolean totp = args.length == 2 && "encrypt-totp".equals(args[0]) && args[1].matches("[1-9][0-9]{0,9}");
        Console console = System.console();
        if ((!password && !totp) || console == null) {
            System.err.println("In an interactive terminal, use hash-password or encrypt-totp LOGINID");
            System.exit(2);
        }
        if (password) {
            byte[] unused = new byte[32];
            new SecureRandom().nextBytes(unused);
            char[] first = console.readPassword("Mobile password: ");
            char[] second = console.readPassword("Confirm mobile password: ");
            try {
                if (first == null || first.length < 12 || first.length > 512 || !Arrays.equals(first, second)) {
                    System.err.println("Passwords must match and contain between 12 and 512 characters");
                    System.exit(2);
                }
                System.out.println(new Secrets(unused).passwordHash(new String(first)));
            } finally {
                Arrays.fill(unused, (byte)0);
                if (first != null) Arrays.fill(first, '\0');
                if (second != null) Arrays.fill(second, '\0');
            }
        } else {
            String configured = System.getenv("SCM_MOBILE_AUTH_KEY");
            byte[] key;
            int loginId;
            try { key = Base64.getDecoder().decode(configured == null ? "" : configured); loginId = Integer.parseInt(args[1]); }
            catch (IllegalArgumentException e) { System.err.println("Invalid key configuration or LOGINID"); return; }
            char[] seed = console.readPassword("Existing authenticator setup key: ");
            try {
                if (seed == null || key.length != 32 || !new String(seed).matches("[A-Za-z2-7]{16,128}")) {
                    System.err.println("Expected a Base32 authenticator key and a 32-byte SCM_MOBILE_AUTH_KEY");
                    System.exit(2);
                }
                System.out.println(new Secrets(key).encryptTotp(loginId, new String(seed).toUpperCase(Locale.ROOT)));
            } finally {
                Arrays.fill(key, (byte)0);
                if (seed != null) Arrays.fill(seed, '\0');
            }
        }
    }
}
