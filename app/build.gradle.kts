apply {
    plugin("androidx.navigation.safeargs")
}

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
}

android {
    compileSdkVersion(deps.build.compileSdk)

    defaultConfig {
        applicationId = "io.zluan.logoswap"
        versionCode = 1
        versionName = "1.0"
        minSdkVersion(deps.build.minSdk)
        targetSdkVersion(deps.build.targetSdk)
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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

    sourceSets {
        val commonTest = "src/test/java"
        getByName("androidTest").java.srcDirs(commonTest)
        getByName("test").java.srcDirs(commonTest)
    }

    splits {
        abi {
            isEnable = true
            reset()
            if (rootProject.extra["ci"] as Boolean || gradle.startParameter.taskNames.any { it.contains("release") }) {
                include("armeabi", "armeabi-v7a", "armeabi-v8a", "arm64-v8a", "mips", "mips64", "x86", "x86_64")
            } else {
                include("arm64-v8a", "x86_64")
            }
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
    implementation(deps.android.core)
    implementation(deps.kotlin.stdlib)
    implementation(deps.kotlin.coroutines)

    // App compat
    implementation(deps.android.appcompat)
    implementation(deps.android.lifecycle)

    // Navigation library
    implementation(deps.android.navigation.fragment)
    implementation(deps.android.navigation.ui)

    // CameraX
    implementation(deps.android.camera.core)
    implementation(deps.android.camera.camera2)

    // Glide
    implementation(deps.glide.glide)
    kapt(deps.glide.compiler)

    // UI
    implementation(deps.android.constraintlayout)

    // PixelMod
    implementation(project(":pixelmod"))

    // Unit testing
    testImplementation(deps.android.test.junit)
    testImplementation(deps.android.test.runner)
    testImplementation(deps.android.test.core)
    testImplementation(deps.test.robolectric)

    // Instrumented testing
    androidTestImplementation(deps.android.test.core)
    androidTestImplementation(deps.android.test.junit)
    androidTestImplementation(deps.android.test.runner)
    androidTestImplementation(deps.android.test.core)
}
