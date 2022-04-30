import java.net.URI
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val kotlinxCoroutinesVersion = "1.6.1"
val logbackVersion = "1.2.11"

group = "net.dinkla"
version = "1.0"

plugins {
    kotlin("jvm") version "1.6.20"
    application
}

repositories {
    mavenCentral()
    maven {
        url = URI.create("https://kotlin.bintray.com/kotlinx")
    }
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:${kotlinxCoroutinesVersion}")
    implementation("ch.qos.logback:logback-classic:${logbackVersion}")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "17"
}
