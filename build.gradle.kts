import java.net.URI

val kotlinxCoroutinesVersion = "1.6.1"
val logbackVersion = "1.2.11"

group = "net.dinkla"
version = "1.0"

plugins {
    kotlin("multiplatform") version "1.6.21"
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
        }
        val jsMain by getting {
            dependsOn(commonMain)
        }
        val jsTest by getting {
            dependsOn(commonTest)
        }
    }

}
