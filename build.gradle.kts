plugins {
    java
    application
    id("org.springframework.boot") version "3.0.1"
    id("io.spring.dependency-management") version "1.1.0"
}

group = "org.octoosmo"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
    mavenCentral()
    mavenLocal()
}

dependencies {
    annotationProcessor("org.mapstruct:mapstruct-processor:1.5.5.Final")
    implementation("org.mapstruct:mapstruct:1.5.3.Final")
    // Spring
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.0.3")
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-api:2.0.3")
    // DB
    implementation("org.hibernate.validator:hibernate-validator:8.0.0.Final")
    implementation("org.flywaydb:flyway-core:9.15.2")
    // Jsonb support
    implementation("com.fasterxml.jackson.module:jackson-module-jakarta-xmlbind-annotations:2.14.2")
    // Json support
    implementation("org.json:json:20230227")
    runtimeOnly("org.postgresql:postgresql")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.restdocs:spring-restdocs-mockmvc")
    testImplementation("org.springframework.security:spring-security-test")
    // Test data
    implementation("net.datafaker:datafaker:1.9.0")
    // Junit
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
    testImplementation("org.mockito:mockito-core:5.3.1")

}

tasks.withType<Test> {
    useJUnitPlatform()
}
