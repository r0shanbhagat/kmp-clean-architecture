@file:OptIn(org.jetbrains.kotlin.gradle.targets.js.dsl.ExperimentalWasmDsl::class)

import org.jetbrains.kotlin.gradle.plugin.mpp.apple.XCFramework

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlinx.serialization)
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.compose.multiplatform)
    alias(libs.plugins.compose.compiler)
    id("build-logic")
}
val packageName = "com.roshan.data"

kotlin {
    val xcframework = XCFramework()
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "DataApp"
            isStatic = true
            xcframework.add(this)
        }
    }

    jvm("desktop")

    wasmJs {
        browser()
    }

    sourceSets {
        val desktopMain by getting
        androidMain.dependencies {
            implementation(libs.ktor.client.okhttp)
        }

        commonMain.dependencies {
            //Key-Value storage
            implementation(libs.multiplatform.settings)
            // DI
            api(libs.koin.core)
            api(projects.core.ui)
        }

        iosMain.dependencies {
            implementation(libs.ktor.client.ios)
        }

        desktopMain.dependencies { }

        wasmJsMain.dependencies { }
    }
}

android {
    namespace = packageName
    compileSdk = libs.versions.android.compileSdk.get().toInt()
    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
    }
}