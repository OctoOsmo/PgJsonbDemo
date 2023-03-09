plugins {
    java
    id("org.springframework.boot") version "3.0.1"
    id("io.spring.dependency-management") version "1.1.0"
}

group = "org.octoosmo"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.0.2")
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-api:2.0.2")
    implementation("org.hibernate.validator:hibernate-validator:8.0.0.Final")
    implementation("org.flywaydb:flyway-core:9.11.0")
    // Jsonb support
    implementation("com.vladmihalcea:hibernate-types-60:2.21.1")
    implementation("com.fasterxml.jackson.module:jackson-module-jakarta-xmlbind-annotations:2.14.2")
    // Json support
    implementation("org.json:json:20230227")
    // Record builder
    annotationProcessor("io.soabase.record-builder:record-builder-processor:35")
    compileOnly("io.soabase.record-builder:record-builder-core:35")
    implementation("org.mapstruct:mapstruct:1.5.3.Final")
    annotationProcessor("org.mapstruct:mapstruct-processor:1.5.3.Final")
    runtimeOnly("org.postgresql:postgresql")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.restdocs:spring-restdocs-mockmvc")
    testImplementation("org.springframework.security:spring-security-test")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
