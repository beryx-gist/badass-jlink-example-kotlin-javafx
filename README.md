[![PRs Welcome](https://img.shields.io/badge/PRs-welcome-brightgreen.svg?style=flat-square)](http://makeapullrequest.com)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://github.com/beryx-gist/badass-jlink-example-kotlin-javafx/blob/master/LICENSE)
[![Build Status](https://img.shields.io/travis/beryx-gist/badass-jlink-example-kotlin-javafx/master.svg?label=Build)](https://travis-ci.org/beryx-gist/badass-jlink-example-kotlin-javafx)

## Example of using the badass-jlink plugin with Kotlin and JavaFX ##

This project demonstrates the capabilities of the [Badass JLink Plugin](https://github.com/beryx/badass-jlink-plugin/)
by creating a custom runtime image of a JavaFX application written in Kotlin.

### Quick start
From the [releases page](https://github.com/beryx-gist/badass-jlink-example-kotlin-javafx/releases) download the archived custom runtime image for your operating system.
Unpack the archive and execute the `hello` script found in the `hello-image/bin` directory.  

### Creating a custom runtime image

Gradle must use Java 11 in order to be able to build the project.
To create the custom runtime image execute:

```
./gradlew jlinkZip
```

This command creates the runtime image in the `build/hello-image` directory and a zip file of it in `build/image-zip`.

The start scripts are found in the `build/hello-image/bin` directory.

