plugins {
    id("io.freefair.lombok") version "8.11"
    id("com.gradleup.shadow") version "8.3.2"
    id("io.github.revxrsal.zapper") version "1.0.3"
    kotlin("jvm")
}

group = "com.example"
version = "0.0.0"

repositories {
    mavenCentral()
    maven(url = "https://oss.sonatype.org/content/repositories/snapshots")
    maven(url = "https://oss.sonatype.org/content/repositories/central")
    maven(url = "https://hub.spigotmc.org/nexus/content/groups/public/")
}

dependencies {
    zap(kotlin("stdlib-jdk8"))
    compileOnly("org.spigotmc:spigot-api:1.12.2-R0.1-SNAPSHOT")
}

zapper {
    libsFolder = "libs"
    relocationPrefix = "com.example.plugin.libs"

    repositories { includeProjectRepositories() }

    // relocation path is com.example.plugin.libs.kotlin
//    relocate("kotlin", "kotlin")
}

kotlin {
    jvmToolchain(8)
}