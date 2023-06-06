package com.chylex.intellij.inspectionlens.config

import com.chylex.intellij.inspectionlens.InspectionLensBundle
import com.intellij.application.options.colors.*
import com.intellij.openapi.editor.colors.EditorSchemeAttributeDescriptor
import com.intellij.openapi.options.colors.AttributesDescriptor
import com.intellij.openapi.options.colors.ColorAndFontDescriptorsProvider
import com.intellij.openapi.options.colors.ColorDescriptor
import com.intellij.psi.codeStyle.DisplayPriority
import com.intellij.psi.codeStyle.DisplayPrioritySortable

class InspectionLensColorsPageFactory : ColorAndFontPanelFactory, ColorAndFontDescriptorsProvider, DisplayPrioritySortable {
    override fun createPanel(options: ColorAndFontOptions): NewColorAndFontPanel {
        val schemesPanel = SchemesPanel(options)
        val descriptionPanel = CompositeColorDescriptionPanel()
        descriptionPanel.addDescriptionPanel(ColorAndFontDescriptionPanel()) { 
            it: EditorSchemeAttributeDescriptor? -> it is ColorAndFontDescription 
        }

        val optionsPanel = OptionsPanelImpl(options, schemesPanel,getInspectionLensGroup(), descriptionPanel)
        val previewPanel = InspectionLensColorPreviewPanel()
        
        return NewColorAndFontPanel(schemesPanel, optionsPanel, previewPanel, getInspectionLensGroup(), null, null)
    }

    override fun getPanelDisplayName(): String {
        return getInspectionLensGroup()
    }

    override fun getAttributeDescriptors(): Array<AttributesDescriptor> {
        return arrayOf()
    }

    override fun getColorDescriptors(): Array<ColorDescriptor> {
        return ColorDescriptor.EMPTY_ARRAY
    }

    override fun getDisplayName(): String {
        return getInspectionLensGroup()
    }

    override fun getPriority(): DisplayPriority {
        return DisplayPriority.COMMON_SETTINGS
    }
    
    private fun getInspectionLensGroup(): String {
        return InspectionLensBundle.message("configurable.inspectionlens.name")
    }
}
