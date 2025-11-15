import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.compose.multiplatform)
}

// Use safe lookup for optional project properties. If they aren't provided, fall back to sensible defaults.
group =
    (project.findProperty("package") as? String)?.takeIf { it.isNotBlank() } ?: "com.roshan.desktop"
version = (project.findProperty("version") as? String)?.takeIf { it.isNotBlank() } ?: "1.0.0"

kotlin {
    jvm("desktop") {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_17)
        }
    }

    sourceSets {
        val desktopMain by getting {
            // include Java source dir which currently holds the Kotlin main.kt file
            kotlin.srcDir("src/main/java")
            dependencies {
                implementation(compose.desktop.currentOs)
                implementation(compose.runtime)
                implementation(compose.ui)
                implementation(compose.material3)
                implementation(projects.feature.login)
            }
        }
    }
}

compose.desktop {
    application {
        mainClass = "com.roshan.desktop.MainKt"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "com.roshan.desktop"
            packageVersion = "1.0.0"
        }
        jvmArgs += listOf("-Xmx2G", "-XX:+UseG1GC")
    }
}