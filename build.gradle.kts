import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.3.10"
    application
    id("org.openjfx.javafxplugin") version "0.0.5"
    id("org.beryx.jlink") version "2.4.0"
}

val compileKotlin: KotlinCompile by tasks
val compileJava: JavaCompile by tasks
compileJava.destinationDir = compileKotlin.destinationDir

application {
    mainClassName = "test.kotlin/org.beryx.jlink.test.kotlin.JavaFX"
}

repositories {
    mavenCentral()
}

javafx {
    modules = listOf("javafx.controls", "javafx.fxml", "javafx.web")
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.3.10")
}

jlink{
    launcher {
        name = "hello"
    }
    imageZip.set(project.file("${project.buildDir}/image-zip/hello-image.zip"))
}
