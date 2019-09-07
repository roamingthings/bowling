import org.gradle.api.JavaVersion.VERSION_1_8

extra["assertjVersion"] = "3.13.2"
extra["junitVersion"] = "5.5.1"
extra["mockitoVersion"] = "3.0.0"
extra["lombokVersion"] = "1.18.8"

buildscript {
    repositories {
        mavenCentral()
    }
}

plugins {
    application
}

group = "de.roamingthings"
version = "1.0.0-SNAPSHOT"

application {
    mainClassName = "de.roamingthings.bowling.GameRunner"
}

val run by tasks.getting(JavaExec::class) {
    standardInput = System.`in`
}

repositories {
    mavenCentral()
}

val junitVersion: String by extra
val mockitoVersion: String by extra
val assertjVersion: String by extra
val lombokVersion: String by extra
dependencies {
    compileOnly("org.projectlombok:lombok:$lombokVersion")
    annotationProcessor("org.projectlombok:lombok:$lombokVersion")

    testImplementation("org.junit.jupiter:junit-jupiter:$junitVersion")

    testCompile("org.assertj:assertj-core:$assertjVersion")
    testCompile("org.mockito:mockito-core:$mockitoVersion")
    testCompile("org.mockito:mockito-junit-jupiter:$mockitoVersion")
}

configure<JavaPluginConvention> {
    sourceCompatibility = VERSION_1_8
}

tasks.test {
    useJUnitPlatform()
    testLogging {
        events("passed", "skipped", "failed")
    }
}
