import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.compose.multiplatform)
}

val nameSpace = "com.roshan.desktop"
val appVersion = "1.0.0"
group = nameSpace
version = appVersion

kotlin {
    jvm("desktop")
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
            packageName = nameSpace
            packageVersion = appVersion
        }
        jvmArgs += listOf("-Xmx2G", "-XX:+UseG1GC")
    }
}