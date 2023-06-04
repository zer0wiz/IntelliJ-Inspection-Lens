package com.chylex.intellij.inspectionlens.config

import com.intellij.openapi.Disposable
import java.awt.BorderLayout
import javax.swing.JPanel

class ConfigPanel : Disposable {
    private val panel = JPanel(BorderLayout())
    override fun dispose() {
        TODO("Not yet implemented")
    }
    
    fun getComponent(): JPanel {
        return panel
    }
}
