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
    compileSdkVersion(29)

    defaultConfig {
        applicationId = "io.zluan.logoswap"
        versionCode = 1
        versionName = "1.0"
        minSdkVersion(21)
        targetSdkVersion(29)
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    compileOptions {
        sourceCompatibility = rootProject.extra["java_version"] as JavaVersion
        targetCompatibility = rootProject.extra["java_version"] as JavaVersion
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
    implementation("androidx.core:core-ktx:1.1.0")
    implementation("org.jetbrains.kotlin:kotlin-stdlib:${rootProject.extra["kotlin_version"]}")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.0")

    // App compat
    implementation("androidx.appcompat:appcompat:1.1.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.2.0-alpha05")

    // Navigation library
    val navVersion = "2.1.0"
    implementation("androidx.navigation:navigation-fragment-ktx:$navVersion")
    implementation("androidx.navigation:navigation-ui-ktx:$navVersion")

    // CameraX
    val cameraxVersion = "1.0.0-alpha05"
    implementation("androidx.camera:camera-core:$cameraxVersion")
    implementation("androidx.camera:camera-camera2:$cameraxVersion")

    // Glide
    implementation("com.github.bumptech.glide:glide:4.9.0")
    kapt("com.github.bumptech.glide:compiler:4.9.0")

    // UI
    implementation("androidx.constraintlayout:constraintlayout:1.1.3")

    // PixelMod
    implementation(project(":pixelmod"))

    // Unit testing
    testImplementation("androidx.test.ext:junit:1.1.1")
    testImplementation("androidx.test:rules:1.2.0")
    testImplementation("androidx.test:runner:1.2.0")
    testImplementation("androidx.test.espresso:espresso-core:3.2.0")
    testImplementation("org.robolectric:robolectric:4.3")

    // Instrumented testing
    androidTestImplementation("androidx.test.ext:junit:1.1.1")
    androidTestImplementation("androidx.test:rules:1.2.0")
    androidTestImplementation("androidx.test:runner:1.2.0")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.2.0")
}
