enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
rootProject.name = "build-logic"

//Run Desktop: ./gradlew :desktop:run
//Run Web: ./gradlew wasmJsBrowserDevelopmentRun
//Generate AAR : ./gradlew :fusedLibrary:publishReleasePublicationToMavenLocal
//Generate Desktop-Jar :  ./gradlew :fusedLibrary-jvm:fatJar
//Generate Framework : ./gradlew :feature:login:assembleLoginDebugXCFramework /assembleLoginReleaseXCFramework
//./gradlew :IosKmpApp:assembleXCFramework
//tasks.register("makeSDK") {
//    dependsOn("assembleReleaseXCFramework", "assembleRelease")
//}

//#Xcode Setup:
//1.New Run Script Phase
// cd "$SRCROOT/.."
// ./gradlew :shared:embedAndSignAppleFrameworkForXcode
//2. Run Script phase higher & Disable Based on dependency analysis
//3. User Script Sandboxing : No

