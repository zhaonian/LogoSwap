import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    rootProject.extra["ci"] = rootProject.hasProperty("ci")

    repositories {
        google()
        gradlePluginPortal()
    }

    dependencies {
        classpath(deps.plugin.gradle)
        classpath(deps.plugin.kotlin)
        classpath(deps.plugin.safeArgs)
        classpath(deps.plugin.ktlint)
        classpath(deps.plugin.protoBuf)
        classpath(deps.plugin.versions)
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
        jvmTarget = deps.versions.java.toString()
    }
}
