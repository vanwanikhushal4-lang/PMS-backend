#!/usr/bin/env bash
set -euo pipefail
umask 077
root=$(cd "$(dirname "$0")/.." && pwd)
module="$root/backend/mobile-auth"
legacy_lib=${SCM_LEGACY_LIB_DIR:-"$root/.scm-runtime/tomcat/webapps/SCM/WEB-INF/lib"}
out=${1:-"$root/.qa/mobile-auth-build"}
[[ -d "$legacy_lib" ]] || { echo 'Set SCM_LEGACY_LIB_DIR to the supplied SCM WAR library directory' >&2; exit 1; }
mkdir -p "$out"
classes=$(mktemp -d "$out/production.XXXXXX")
trap 'rm -rf "$classes"' EXIT
find "$module/src/main/java" -name '*.java' -print0 | xargs -0 javac --release 8 -cp "$legacy_lib/*" -d "$classes"
cp -R "$module/src/main/resources/." "$classes/"
jar cf "$out/scm-mobile-auth.jar" -C "$classes" .
printf 'Built %s\n' "$out/scm-mobile-auth.jar"
