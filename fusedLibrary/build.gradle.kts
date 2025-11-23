plugins {
    alias(libs.plugins.android.fusedlibrary)
    `maven-publish`
}

androidFusedLibrary {
    namespace = "com.roshan.fusedLibrary"
    minSdk = libs.versions.android.minSdk.get().toInt()
}

publishing {
    publications {
        register<MavenPublication>("release") {
            groupId = "kmm-demo"
            artifactId = "fused-library"
            version = "1.0"
            from(components["fusedLibraryComponent"])
        }
    }
}


dependencies {
    include(project(":core:network"))
    include(project(":core:ui"))
    include(project(":data"))
    include(project(":feature:login"))
}