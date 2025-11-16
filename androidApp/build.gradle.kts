import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.compose.compiler)
}
android {
    namespace = "com.roshan.myapplication.android"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    defaultConfig {
        applicationId = "com.roshan.myapplication.android"
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()
        versionCode = 2
        versionName = "1.1"
    }
    buildFeatures {
        buildConfig = true
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

//    signingConfigs {
//        create("release") {
//            storeFile = file("./key/key.jks")
//            gradleLocalProperties(rootDir, providers).apply {
//                storePassword = getProperty("storePwd")
//                keyAlias = getProperty("keyAlias")
//                keyPassword = getProperty("keyPwd")
//            }
//        }
//    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }  //TEM ADDED
//        create("debugPG") {
//            isDebuggable = false
//            isMinifyEnabled = true
//            versionNameSuffix = " debugPG"
//            matchingFallbacks.add("debug")
//
//            proguardFiles(
//                getDefaultProguardFile("proguard-android-optimize.txt"),
//                file("proguard-rules.pro")
//            )
//        }
//        release {
//            isMinifyEnabled = true
//            signingConfig = signingConfigs.getByName("release")
//
//            proguardFiles(
//                getDefaultProguardFile("proguard-android-optimize.txt"),
//                file("proguard-rules.pro")
//            )
//        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_24
        targetCompatibility = JavaVersion.VERSION_24
    }

    kotlin {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_24)
        }
    }
}

dependencies {
    implementation(projects.feature.login)
    implementation(libs.compose.ui)
    implementation(libs.compose.ui.tooling.preview)
    implementation(libs.compose.material3)
    implementation(libs.activity.compose)
    debugImplementation(libs.compose.ui.tooling)
}