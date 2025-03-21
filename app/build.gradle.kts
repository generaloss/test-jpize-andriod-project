plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "io.github.generaloss"
    compileSdk = 35

    defaultConfig {
        applicationId = "io.github.generaloss"
        minSdk = 34
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

dependencies {
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.jpize.utils)
    implementation(libs.jpize.core)
    implementation(libs.jpize.core.android)
    androidTestImplementation(libs.espresso.core)
}