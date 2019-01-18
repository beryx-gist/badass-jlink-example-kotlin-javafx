package org.beryx.jlink.test.kotlin

import javafx.application.Application
import javafx.scene.Scene
import javafx.scene.web.WebView
import javafx.stage.Stage

class JavaFX : Application() {
    override fun start(stage: Stage) {
        val webView = WebView()
        val webEngine = webView.engine
        stage.scene = Scene(webView, 960.0,600.0)

        webEngine.loadContent("""
            <html>
                <h1>Hello, world!</h1>
                <a href="https://badass-jlink-plugin.beryx.org">Documentation</a>
            </html>
        """.trimIndent(), "text/html")
        stage.show()
    }
}
