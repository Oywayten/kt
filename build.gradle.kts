plugins {
    kotlin("jvm") version "2.2.10"
    id("io.gitlab.arturbosch.detekt") version "1.23.8"
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
}

tasks.withType<io.gitlab.arturbosch.detekt.Detekt> {
    reports {
        html.required.set(true)
        xml.required.set(true)
        txt.required.set(false)
    }
}


kotlin {
    jvmToolchain(17)
}

detekt {
    toolVersion = "1.23.8"
    config.setFrom("$projectDir/config/detekt/detekt.yml")
    buildUponDefaultConfig = true
    allRules = false
}