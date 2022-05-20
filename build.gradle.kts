import java.net.URI

val kotlinxCoroutinesVersion = "1.6.1"
val logbackVersion = "1.2.11"
val kotestVersion = "5.3.0"

group = "net.dinkla"
version = "1.0"

buildscript {
    repositories {
        mavenCentral()
        mavenLocal()
    }
}

plugins {
    kotlin("multiplatform") version "1.6.21"
    id("io.kotest.multiplatform") version "5.0.2"
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
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.1")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
                // implementation("io.kotest:kotest:$kotestVersion")
                // implementation("io.kotest:kotest-property:$kotestVersion")
                // implementation("io.kotest:kotest-assertions-core:$kotestVersion")
                // implementation("io.kotest:kotest-framework-engine:$kotestVersion")
                // implementation("io.kotest:kotest-framework-datatest:$kotestVersion")
                // implementation("org.jetbrains.kotlin:kotlin-test-common:1.6.0")
                // implementation("org.jetbrains.kotlin:kotlin-test-annotations-common:1.6.0")
            }
        }
        val jvmMain by getting {
            dependsOn(commonMain)
            dependencies {
                implementation("ch.qos.logback:logback-classic:${logbackVersion}")
            }
        }
        val jvmTest by getting {
            dependsOn(commonTest)
            dependencies {
                implementation("io.kotest:kotest-runner-junit5-jvm:$kotestVersion")
            }
        }
        val jsMain by getting {
            dependsOn(commonMain)
        }
        val jsTest by getting {
            dependsOn(commonTest)
        }
    }

}

tasks.named<Test>("jvmTest") {
    useJUnitPlatform()
}

