package com.chylex.intellij.inspectionlens.config

import com.chylex.intellij.inspectionlens.InspectionLensBundle
import com.intellij.openapi.options.SearchableConfigurable
import com.intellij.openapi.util.NotNullLazyValue
import javax.swing.JComponent

class InspectionLensConfigurable : SearchableConfigurable {
    private val configPanelInstance = NotNullLazyValue.lazy { ConfigPanel() }
    
    override fun createComponent(): JComponent {
        return getConfigPanel().getComponent()
    }

    override fun isModified(): Boolean {
        return false
    }

    override fun apply() {
        TODO("Not yet implemented")
    }

    override fun getDisplayName(): String {
        return InspectionLensBundle.message("configurable.inspectionlens.name")
    }

    override fun getId(): String {
        return ID
    }
    
    companion object {
        const val ID = "inspectionlens.config.fonts.default"
    }
    
    private fun getConfigPanel(): ConfigPanel {
        return configPanelInstance.value
    }
}
