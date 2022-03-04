load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")
RULES_JVM_EXTERNAL_TAG = "4.0"
RULES_JVM_EXTERNAL_SHA = "31701ad93dbfe544d597dbe62c9a1fdd76d81d8a9150c2bf1ecf928ecdf97169"
http_archive(
    name = "rules_jvm_external",
    sha256 = RULES_JVM_EXTERNAL_SHA,
    strip_prefix = "rules_jvm_external-%s" % RULES_JVM_EXTERNAL_TAG,
    url = "https://github.com/bazelbuild/rules_jvm_external/archive/%s.zip" % RULES_JVM_EXTERNAL_TAG,
)
load("@rules_jvm_external//:defs.bzl", "maven_install")
maven_install(
    artifacts = [
        "org.hamcrest:hamcrest-library:2.2",
        "junit:junit:4.12",
        "org.flywaydb:flyway-core:8.5.1",
        "org.testcontainers:testcontainers:1.15.3",
        "org.testcontainers:postgresql:1.15.3",
                "org.postgresql:postgresql:42.2.23",
    ] ,
    generate_compat_repositories = True,
    repositories = [
        "http://maven.aliyun.com/nexus/content/groups/public/",
        "https://repo1.maven.org/maven2",
    ],
)
