plugins {
    kotlin("jvm") version "1.9.21"
}

group = "io.github.freitaseric"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

kotlin {
    jvmToolchain(17)
}