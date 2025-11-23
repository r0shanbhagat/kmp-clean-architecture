@file:OptIn(org.jetbrains.kotlin.gradle.targets.js.dsl.ExperimentalWasmDsl::class)

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlinx.serialization)
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.compose.multiplatform)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.compose.hot.reload)
    id("build-logic")
}
val packageName = "com.roshan.core.ui"

kotlin {
    val xcfName = "CoreUIApp"
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
        all {
            languageSettings {
                optIn("kotlin.time.ExperimentalTime")
            }
        }

        commonMain.dependencies {
            // Compose BOM
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material3)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)
            // Other dependencies
            api(libs.androidx.lifecycle.viewmodel)
            api(libs.androidx.lifecycle.runtime.compose)
            api(libs.kotlinx.datetime)
            api(projects.core.network)
        }
        androidMain.dependencies {
            implementation(compose.preview)
            api(libs.activity.compose)
        }
        iosMain.dependencies {

        }
        desktopMain.dependencies { }
        wasmJsMain.dependencies {
            api(npm("@js-joda/timezone", "2.22.0"))
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

compose.resources {
    publicResClass = true
    packageOfResClass = packageName
    generateResClass = auto
}
