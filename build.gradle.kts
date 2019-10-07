import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    rootProject.extra["kotlin_version"] = "1.3.50"
    rootProject.extra["java_version"] = JavaVersion.VERSION_1_8
    rootProject.extra["ci"] = rootProject.hasProperty("ci")

    repositories {
        google()
        gradlePluginPortal()
    }

    dependencies {
        classpath("com.android.tools.build:gradle:3.5.1")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${rootProject.extra["kotlin_version"]}")
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:2.1.0")
        classpath("org.jlleitschuh.gradle:ktlint-gradle:8.2.0")
        classpath("com.google.protobuf:protobuf-gradle-plugin:0.8.10")
    }
}

allprojects {
    apply {
        plugin("org.jlleitschuh.gradle.ktlint")
    }

    repositories {
        google()
        gradlePluginPortal()
        maven { setUrl("https://jitpack.io") }
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        allWarningsAsErrors = true
        jvmTarget = "1.8"
    }
}
