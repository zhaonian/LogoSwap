import com.google.protobuf.gradle.*
import org.gradle.kotlin.dsl.provider.gradleKotlinDslOf

apply {
    plugin("com.google.protobuf")
}

plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
}

android {
    compileSdkVersion(deps.build.compileSdk)

    defaultConfig {
        minSdkVersion(deps.build.minSdk)
        targetSdkVersion(deps.build.targetSdk)
    }

    compileOptions {
        sourceCompatibility = deps.versions.java
        targetCompatibility = deps.versions.java
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFile(getDefaultProguardFile("proguard-android-optimize.txt"))
            proguardFile(file("proguard-rules.pro"))
        }
    }

    testOptions {
        animationsDisabled = true
        unitTests.apply {
            isReturnDefaultValues = true
            isIncludeAndroidResources = true
        }
    }
}

dependencies {
    // Kotlin
    implementation(deps.kotlin.stdlib)

    // Protocol buffer
    implementation(deps.protobuf.protobufLite)

    // OpenCV Android
    implementation(deps.opencv.opencvAndroid)

    // Unit testing
    testImplementation(deps.android.test.junit)
    testImplementation(deps.android.test.runner)
}

protobuf {
    protoc {
        // The artifact spec for the Protobuf Compiler
        artifact = "com.google.protobuf:protoc:3.6.1"
    }
    generateProtoTasks {
        all().forEach { task ->
            task.builtins {
            }
            task.plugins {
                kotlin { }
            }
        }
    }
}