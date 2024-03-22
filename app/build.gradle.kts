plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    id("com.google.devtools.ksp") version "1.9.21-1.0.15"
    id("com.google.dagger.hilt.android")
    id("androidx.navigation.safeargs.kotlin")
    id("com.google.gms.google-services")
}

android {
    namespace = "com.example.weather"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.weather"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0.2"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {

        debug {
            buildConfigField("String", "API_KEY", providers.gradleProperty("API_KEY").get())
        }

        release {
            buildConfigField("String", "API_KEY", providers.gradleProperty("API_KEY").get())
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro",
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(libs.androidx.junit.ktx)
    testImplementation("org.junit.jupiter:junit-jupiter:5.8.1")
    val nav_version = "2.7.7"

    implementation("androidx.navigation:navigation-compose:$nav_version")

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.swipe.refresh)
    implementation(libs.lottie)

    testImplementation(libs.junit)
    testImplementation("com.google.dagger:hilt-android-testing:2.49")
    testImplementation("org.robolectric:robolectric:4.7.3")
    testImplementation(libs.mockito)
    testImplementation(libs.mockk)
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test-jvm:1.7.1")
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    // Hilt
    implementation(libs.hilt)
    implementation(libs.hilt.navigation)
    ksp(libs.hilt.compiler)

    // Retro
    implementation(libs.retrofit)
    implementation(libs.moshi)
    implementation(libs.moshi.kotlin)
    implementation(libs.converter.moshi)
    ksp("com.squareup.moshi:moshi-kotlin-codegen:1.14.0")

    // DB
    implementation(libs.room.ktx)
    implementation(libs.room)
    ksp(libs.room.compiler)
}
