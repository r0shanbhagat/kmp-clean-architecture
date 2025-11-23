@file:OptIn(org.jetbrains.kotlin.gradle.targets.js.dsl.ExperimentalWasmDsl::class)

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlinx.serialization)
    alias(libs.plugins.kotlin.multiplatform)
    id("build-logic")
}
val packageName = "com.roshan.core.network"

kotlin {
    val xcfName = "CoreNetworkApp"
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = xcfName
            isStatic = true
        }
    }

    jvm("desktop")

    wasmJs {
        browser()
    }

    sourceSets {
        val desktopMain by getting
        commonMain.dependencies {
            //Network
            implementation(libs.ktor.core)
            implementation(libs.ktor.logging)
            implementation(libs.ktor.client.content.negotiation)
            implementation(libs.ktor.xml)
            //Coroutines
            api(libs.kotlinx.coroutines.core)
            //Logger
            api(libs.napier)
            //JSON
            api(libs.kotlinx.serialization.json)
        }
        androidMain.dependencies {
            implementation(libs.ktor.client.okhttp)
        }
        iosMain.dependencies {
            implementation(libs.ktor.client.ios)
        }
        desktopMain.dependencies { }

        wasmJsMain.dependencies {
        }
    }
}

android {
    namespace = packageName
    compileSdk = libs.versions.android.compileSdk.get().toInt()
    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
    }
}