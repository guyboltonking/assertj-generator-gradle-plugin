buildscript {
    repositories {
        mavenCentral()
    }
}

plugins {
    `kotlin-dsl`
    id("org.jetbrains.dokka") version "1.4.30"
    id("com.gradle.plugin-publish") version "0.12.0"
    id("org.jmailen.kotlinter") version "3.3.0"
}

group = "com.waftex.gradle"
version = "1.1.4"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.assertj:assertj-assertions-generator:2.2.1") {
        exclude(module="logback-classic")
    }
}

gradlePlugin {
    plugins {
        create("assertjGenerator") {
            id = "com.waftex.assertj-generator"
            implementationClass = "com.github.fhermansson.gradle.assertj.plugin.AssertjGeneratorPlugin"
        }
    }
}

pluginBundle {
    website = "https://github.com/guyboltonking/assertj-generator-gradle-plugin"
    vcsUrl = "https://github.com/guyboltonking/assertj-generator-gradle-plugin"
    description = """Generate Assertj assertion classes.

    Forked from com.github.fhermansson.assertj-generator via
    com.github.dimamura.assertj-generator, with latest assertj generator and
    Gradle 7 compatibility"""

    tags = listOf("code-generation", "assertj", "java")

    (plugins) {
        "assertjGenerator" {
            displayName = "Assertj Generator plugin"
        }
    }

    mavenCoordinates {
        groupId = "com.waftex.gradle"
        artifactId = "assertj-generator"
    }
}
