plugins {
    kotlin("jvm") version "2.2.20"
    id("io.gitlab.arturbosch.detekt") version "1.23.8"
}

group = "oywayten"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

val postgresqlVersion = "42.7.3"
val junitVersion = "6.0.1"
val assertjVersion = "3.24.2"
val h2Version = "2.4.240"
val dbcpVersion = "2.9.0"

dependencies {
    runtimeOnly("org.postgresql:postgresql:$postgresqlVersion")

    implementation("org.apache.commons:commons-dbcp2:$dbcpVersion")

    testImplementation(kotlin("test"))
    testImplementation("org.junit.jupiter:junit-jupiter-engine:$junitVersion")
    testImplementation("org.assertj:assertj-core:$assertjVersion")
    testImplementation("org.junit.jupiter:junit-jupiter-params:$junitVersion")
    testImplementation("com.h2database:h2:$h2Version")
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
