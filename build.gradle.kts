import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.beryx.jlink.data.*

plugins {
    kotlin("jvm") version "1.3.0"
    application
    id("org.javamodularity.moduleplugin") version "1.1.1"
    id("org.beryx.jlink") version "2.1.3"
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
    mainClassName = "test.kotlin/org.beryx.jlink.test.kotlin.JavaFX"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.3.0")
    implementation("org.openjfx:javafx-base:${javaFxVersion}:${platform}")
    implementation("org.openjfx:javafx-controls:${javaFxVersion}:${platform}")
    implementation("org.openjfx:javafx-fxml:${javaFxVersion}:${platform}")
    implementation("org.openjfx:javafx-graphics:${javaFxVersion}:${platform}")
}

jlink{
    launcher (delegateClosureOf<LauncherData> {
        name = "hello"
    })
    imageZip.set(project.file("${project.buildDir}/image-zip/hello-image.zip"))
}
