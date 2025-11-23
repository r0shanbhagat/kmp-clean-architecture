plugins {
    kotlin("jvm")
    `java`
    `maven-publish`
}

group = "kmm-demo"
version = "1.0"

repositories {
    mavenCentral()
    google()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation(project(":core:network"))
    implementation(project(":core:ui"))
    implementation(project(":data"))
    implementation(project(":feature:login"))
    // Add dependencies as needed
}

publishing {
    publications {
        create<MavenPublication>("release") {
            from(components["java"])
        }
    }
}

tasks.register<Jar>("fatJar") {
    archiveBaseName.set("fusedLibrary-jvm-all")
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    from(sourceSets.main.get().output)
    dependsOn(configurations.runtimeClasspath)
    from({
        configurations.runtimeClasspath.get().filter { it.name.endsWith(".jar") }
            .map { zipTree(it) }
    })
    manifest {
        attributes["Main-Class"] =
            "com.roshan.fusedLibrary.jvm.Example" // Change if you have a different entry point
    }
}
