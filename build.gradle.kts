plugins {
    kotlin("jvm") version "2.2.10"
}

group = "vitaliy.grab"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    testImplementation("org.junit.jupiter:junit-jupiter-engine:6.0.1")
    testImplementation("org.assertj:assertj-core:3.24.2")
    testImplementation("org.junit.jupiter:junit-jupiter-params:6.0.1")
}

tasks.test {
    useJUnitPlatform()
    jvmArgs("-Djunit.jupiter.execution.parallel.enabled=true")
}


kotlin {
    jvmToolchain(17)
}
