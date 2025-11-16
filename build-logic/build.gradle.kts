plugins {
    `kotlin-dsl`
}

repositories {
    google()
    mavenCentral()
}

dependencies {
    implementation("com.android.tools.build:gradle:8.13.1") // Use your AGP version
    implementation(kotlin("gradle-plugin", version = "2.0.0")) // or your Kotlin version
}