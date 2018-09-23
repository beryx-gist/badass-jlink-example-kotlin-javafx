package org.beryx.jlink.test.kotlin

import javafx.application.Application
import javafx.scene.Scene
import javafx.scene.control.Label
import javafx.scene.layout.FlowPane
import javafx.stage.Stage

class JavaFX : Application() {

    override fun start(stage: Stage) {
        val label = Label("Hello, world!").apply {
            style = "-fx-font-size: 64px; -fx-text-fill: blue;"
        }
        stage.scene = Scene(FlowPane(label), 480.0,200.0)
        stage.show()
    }
}

