# SCM backend

Java 8 Spring MVC and Hibernate application imported from the local SCM project. Maven packages the application as `SCM.war` for a compatible servlet container. The server renders JSP pages, so their static assets are included alongside the Java backend.

## Project layout

- `src/main/java`: controllers, services, data access, models, and integration code.
- `src/main/resources`: configuration template.
- `src/main/webapp`: JSP views, servlet configuration, and static resources.
- `java/in/co/velox/fileSending`: additional legacy file-transfer sources retained from the supplied project; this directory is outside Maven's default source tree.
- `pom.xml`: the supplied Maven WAR build descriptor.

## Configuration and build

Use a JDK supporting Java 8 targets and Maven. Configure an SCM MySQL database and the deployment's attachment and barcode directories before starting the application.

```sh
cp src/main/resources/application.properties.example src/main/resources/application.properties
# Edit application.properties locally with your deployment settings.
mvn clean package
```

Deploy `target/SCM.war` using the application's servlet-container configuration. The original deployment database, schema/data export, packaged WAR, dependency JARs, and IDE caches are not included. The supplied Maven descriptor is retained; dependency and deployment compatibility must be verified in your environment.

The import was checked by compiling all 225 main Java sources with JDK 17, Java 8 targets, and the supplied SCM deployment libraries. Maven packaging and a database-backed application startup have not been tested. Three legacy characters in `UserActivityDaoImpl.java` were normalized to UTF-8, and the Maven source encoding is explicitly set to UTF-8.

Embedded credentials have been replaced with environment-variable reads in the published source:

| Variable | Purpose |
| --- | --- |
| `SCM_SMTP_USER` | Sender account for the legacy mail integration and examples |
| `SCM_SMTP_PASSWORD` | SMTP account credential |
| `SCM_SMTP_TEST_RECIPIENT` | Mail example recipient |
| `SCM_SMTP_TEST_CC` | Mail example additional recipients |
| `SCM_SMS_USER` | SMS example account |
| `SCM_SMS_PASSWORD` | SMS example credential |
| `SCM_SMS_RECIPIENT` | SMS example destination |
| `SCM_SMS_SENDER` | SMS example sender |
| `SCM_SMS_TOTP_SECRET` | Base32 secret used by the existing SMS OTP flow |
| `SCM_FILE_TRANSFER_USER` | Login account for the additional file-transfer sources |
| `SCM_FILE_TRANSFER_PASSWORD` | File-transfer login credential |

Supply the relevant values through the servlet container's environment. There are no built-in secret defaults. Keep deployment credentials in the ignored local configuration or your deployment's secret storage.
