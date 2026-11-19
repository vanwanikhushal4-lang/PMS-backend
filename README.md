# SCM backend

Java 8 Spring MVC and Hibernate application imported from the local SCM project. Maven packages the application as `SCM.war` for a compatible servlet container. The server renders JSP pages, so their static assets are included alongside the Java backend.

## Project layout

- `src/main/java`: controllers, services, data access, models, and integration code.
- `src/main/resources`: configuration template.
- `src/main/webapp`: JSP views, servlet configuration, and static resources.
- `java/in/co/velox/fileSending`: additional legacy file-transfer sources retained from the supplied project; this directory is outside Maven's default source tree.
- `pom.xml`: the supplied Maven WAR build descriptor.

## Mobile API

The current mobile backend is in [`backend/mobile-auth`](backend/mobile-auth/README.md). It adds authentication, company-scoped profiles and incidents, projects, task assignment and progress, date approvals, document review, publishing, attachment transfer, and kickoff scheduling. SQL migrations, synthetic local accounts, and integration tests are included. The [API contract](docs/backend-api-requirements.md) describes request formats and remaining feature work.

This module was synchronized from [PMS-Mobile at `b3b924a`](https://github.com/vanwanikhushal4-lang/PMS-Mobile/tree/b3b924a13156848e8ce866bba4fb7f4c57eba0f7/backend/mobile-auth). Production Java sources and SQL migrations match that revision. The HTTP test launcher accepts a separate mobile checkout through `SCM_MOBILE_CLIENT_DIR`.

The module builds separately as `scm-mobile-auth.jar`; the existing Maven WAR build does not include it automatically. Follow the module's deployment instructions to add it to a staging WAR, apply the migrations, and configure the opt-in `scm-mobile-auth` Spring profile. Local QA uses an in-memory H2 database with synthetic data. No original SCM database or production account data is included.

To build and run the isolated HTTP suite, use JDK 17, Node.js 24+, the supplied SCM deployment libraries and compiled entities, Tomcat 9, H2 2.1.214, and a matching PMS-Mobile checkout:

```sh
export SCM_LEGACY_LIB_DIR=/path/to/SCM/WEB-INF/lib
export SCM_LEGACY_CLASSES_DIR=/path/to/SCM/WEB-INF/classes
export SCM_TOMCAT_HOME=/path/to/apache-tomcat-9
export SCM_H2_JAR=/path/to/h2-2.1.214.jar
export SCM_MOBILE_CLIENT_DIR=/path/to/PMS-Mobile/mobile/src/scm
./tools/build_mobile_auth.sh
./tools/test_mobile_auth_java.sh
```

The QA server binds to loopback port 8091 by default. Set `SCM_AUTH_QA_PORT` for a different local port, or `SCM_AUTH_QA_SERVE=1` to leave the seeded service running for manual checks. The setup and account list are in the [module README](backend/mobile-auth/README.md).

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
