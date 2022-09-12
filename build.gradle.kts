import java.net.URI

val logbackVersion = "1.2.11"
val kotestVersion = "5.4.2"
val coroutinesVersion = "1.6.4"
val mockkVersion = "1.12.7"
val serializationVersion = "1.4.0"
val ktorVersion = "2.1.0"
val jsoupVersion = "1.15.3"

group = "net.dinkla"
version = "1.0"

buildscript {
    repositories {
        mavenCentral()
        mavenLocal()
    }
}

plugins {
    kotlin("multiplatform") version "1.7.10"
    id("io.kotest.multiplatform") version "5.4.2"
    kotlin("plugin.serialization") version "1.7.10"
    application
}

repositories {
    mavenCentral()
    maven {
        url = URI.create("https://kotlin.bintray.com/kotlinx")
    }
}

kotlin {
    jvm()
    js() {
        nodejs()
        binaries.executable()
    }
    linuxX64() {
        binaries.executable()
    }
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(kotlin("stdlib-common"))
                implementation(kotlin("script-runtime"))
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:$serializationVersion")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
                implementation("io.kotest:kotest-assertions-core:$kotestVersion")
                implementation("io.kotest:kotest-framework-engine:$kotestVersion")
            }
        }
        val jvmMain by getting {
            dependsOn(commonMain)
            dependencies {
                implementation("ch.qos.logback:logback-classic:${logbackVersion}")
                implementation("io.ktor:ktor-client-core:$ktorVersion")
                implementation("io.ktor:ktor-client-cio:$ktorVersion")
                implementation("io.ktor:ktor-client-content-negotiation:$ktorVersion")
                implementation("io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")
                implementation("org.jsoup:jsoup:$jsoupVersion")
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-swing:${coroutinesVersion}")
            }
        }
        val jvmTest by getting {
            dependsOn(commonTest)
            dependencies {
                implementation("io.kotest:kotest-runner-junit5-jvm:$kotestVersion")
                implementation("io.mockk:mockk:$mockkVersion")
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-debug:$coroutinesVersion")
                implementation("app.cash.turbine:turbine:0.9.0")
            }
        }
        val jsMain by getting {
            dependsOn(commonMain)
        }
        val jsTest by getting {
            dependsOn(commonTest)
        }
        val linuxX64Main by getting {
            dependsOn(commonMain)
        }
        val linuxX64Test by getting {
            dependsOn(commonTest)
        }
    }
}

tasks.named<Test>("jvmTest") {
    useJUnitPlatform()
}

