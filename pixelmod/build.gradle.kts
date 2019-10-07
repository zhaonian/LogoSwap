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
    compileSdkVersion(29)

    defaultConfig {
        minSdkVersion(21)
        targetSdkVersion(29)
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFile(getDefaultProguardFile("proguard-android-optimize.txt"))
            proguardFile(file("proguard-rules.pro"))
        }
    }
}

dependencies {
    // Kotlin
    implementation("org.jetbrains.kotlin:kotlin-stdlib:${rootProject.extra["kotlin_version"]}")

    // Protocol buffer
    implementation("com.google.protobuf:protobuf-lite:3.0.0")

    // OpenCV Android
    implementation("com.github.iamareebjamal:opencv-android:4.1.1")

    // Unit testing
    testImplementation("androidx.test.ext:junit:1.1.1")
    testImplementation("androidx.test:rules:1.2.0")
    testImplementation("androidx.test:runner:1.2.0")
}
