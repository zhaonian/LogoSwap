@file:Suppress("ClassName", "SpellCheckingInspection")

import org.gradle.api.JavaVersion

object deps {
    object versions {
        const val androidGradle = "3.5.1"
        const val kotlin = "1.3.50"
        const val glide = "4.10.0"
        val java = JavaVersion.VERSION_1_8
    }

    object build {
        const val minSdk = 21
        const val targetSdk = 29
        const val compileSdk = 29
    }

    object plugin {
        const val gradle = "com.android.tools.build:gradle:${deps.versions.androidGradle}"
        const val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${deps.versions.kotlin}"
        const val versions = "com.github.ben-manes:gradle-versions-plugin:0.25.0"
        const val ktlint = "org.jlleitschuh.gradle:ktlint-gradle:8.2.0"
        const val safeArgs = "androidx.navigation:navigation-safe-args-gradle-plugin:2.1.0"
        const val protoBuf = "com.google.protobuf:protobuf-gradle-plugin:0.8.10"
    }

    object kotlin {
        const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib:${versions.kotlin}"
        const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.0"
    }

    object android {
        const val constraintlayout = "androidx.constraintlayout:constraintlayout:1.1.3"
        const val core = "androidx.core:core-ktx:1.1.0"
        const val appcompat = "androidx.appcompat:appcompat:1.1.0"
        const val lifecycle = "androidx.lifecycle:lifecycle-runtime-ktx:2.2.0-alpha05"

        object navigation {
            private const val navVersion = "2.1.0"
            const val fragment = "androidx.navigation:navigation-fragment-ktx:$navVersion"
            const val ui = "androidx.navigation:navigation-ui-ktx:$navVersion"
        }

        object camera {
            private const val cameraxVersion = "1.0.0-alpha05"
            const val core = "androidx.camera:camera-core:$cameraxVersion"
            const val camera2 = "androidx.camera:camera-camera2:$cameraxVersion"
        }

        object test {
            const val core = "androidx.test:core:1.2.0"
            const val junit = "androidx.test.ext:junit:1.1.1"
            const val runner = "androidx.test:runner:1.2.0"
        }
    }

    object protobuf {
        const val protobufLite = "com.google.protobuf:protobuf-lite:3.0.0"
    }

    object opencv {
        const val opencvAndroid = "com.github.iamareebjamal:opencv-android:4.1.1"
    }

    object glide {
        const val glide = "com.github.bumptech.glide:glide:${versions.glide}"
        const val compiler = "com.github.bumptech.glide:compiler:${versions.glide}"
    }

    object test {
        const val robolectric = "org.robolectric:robolectric:4.3"
    }
}
