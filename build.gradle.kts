import org.jetbrains.kotlin.gradle.tasks.KotlinCompile


plugins {
    kotlin("jvm") version "1.2.70"
    application
    id("com.zyxist.chainsaw") version "0.3.1"
    id("org.beryx.jlink") version "1.4.4"
}

val currentOS = org.gradle.internal.os.OperatingSystem.current()
val platform = when {
        currentOS.isWindows() -> "win"
        currentOS.isLinux() -> "linux"
        currentOS.isMacOsX() -> "mac"
        else -> throw GradleException("Unsupported operating system: $currentOS")
}
val javaFxVersion = 11

//Fixes module compilation for Kotlin in "com.zyxist.chainsaw"
val compileKotlin: KotlinCompile by tasks
val compileJava: JavaCompile by tasks
compileJava.destinationDir = compileKotlin.destinationDir

application {
    mainClassName = "org.beryx.jlink.test.kotlin.JavaFX"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.2.70")
    implementation("org.openjfx:javafx-base:${javaFxVersion}:${platform}")
    implementation("org.openjfx:javafx-controls:${javaFxVersion}:${platform}")
    implementation("org.openjfx:javafx-fxml:${javaFxVersion}:${platform}")
    implementation("org.openjfx:javafx-graphics:${javaFxVersion}:${platform}")
}

jlink {
    launcherName.set("hello")
    imageZip.set(project.file("${project.buildDir}/image-zip/hello-image.zip"))
}
