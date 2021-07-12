import com.osacky.doctor.DoctorExtension
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("com.github.ben-manes.versions") version "0.39.0" // run scripts/checkForDependencyUpdates.sh to list all available updates
    id("com.osacky.doctor") version "0.7.0" // gives hints how to speed-up builds
}

buildscript {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:4.2.2")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}")
        classpath("com.google.dagger:hilt-android-gradle-plugin:${Versions.hilt}")
        classpath("com.google.gms:google-services:4.3.8")
        classpath("com.google.firebase:firebase-crashlytics-gradle:2.7.1")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
        maven { setUrl("https://jitpack.io") }
    }

    tasks {
        withType<KotlinCompile> {
            kotlinOptions {
                jvmTarget = JdkSettings.jvmTarget
                freeCompilerArgs = freeCompilerArgs + "-Xopt-in=kotlin.RequiresOptIn"
            }
        }
    }

    pluginManager.withPlugin("java") {
        configure<JavaPluginExtension> {
            sourceCompatibility = JdkSettings.sourceCompatibility
            targetCompatibility = JdkSettings.targetCompatibility
        }
    }
}

configure<DoctorExtension> {
    javaHome {
        failOnError.set(false)
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}