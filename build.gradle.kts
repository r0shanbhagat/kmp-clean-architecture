plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.compose.multiplatform) apply false
    alias(libs.plugins.kotlin.multiplatform) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.parcelize) apply false
    alias(libs.plugins.dependencyUpdates) apply false
    alias(libs.plugins.compose.compiler) apply false
    alias(libs.plugins.kotlinx.serialization) apply false
    alias(libs.plugins.compose.hot.reload) apply false
    id("com.google.devtools.ksp").version("2.2.20-2.0.3").apply(false)
    id("com.rickclephas.kmp.nativecoroutines").version("1.0.0-ALPHA-47").apply(false)
    alias(libs.plugins.android.fusedlibrary) apply false
}

allprojects {
    // ./gradlew dependencyUpdates
    // Report: build/dependencyUpdates/report.txt
    apply(plugin = "com.github.ben-manes.versions")
}