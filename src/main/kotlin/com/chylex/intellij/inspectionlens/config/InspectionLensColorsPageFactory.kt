package com.chylex.intellij.inspectionlens.config

import com.chylex.intellij.inspectionlens.InspectionLensBundle
import com.chylex.intellij.inspectionlens.colors.InspectionLensColors
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
        return arrayOf(
            AttributesDescriptor(
                InspectionLensBundle.message("configurable.inspectionlens.attribute.descriptor.error"),
                InspectionLensColors.ERROR_ATTRIBUTES
            ),
            AttributesDescriptor(
                InspectionLensBundle.message("configurable.inspectionlens.attribute.descriptor.warning"),
                InspectionLensColors.WARNING_ATTRIBUTES
            ),
            AttributesDescriptor(
                InspectionLensBundle.message("configurable.inspectionlens.attribute.descriptor.weak_warning"),
                InspectionLensColors.WEAK_WARNING_ATTRIBUTES
            ),
            AttributesDescriptor(
                InspectionLensBundle.message("configurable.inspectionlens.attribute.descriptor.server_problem"),
                InspectionLensColors.SERVER_PROBLEM_ATTRIBUTES
            ),
            AttributesDescriptor(
                InspectionLensBundle.message("configurable.inspectionlens.attribute.descriptor.grazie"),
                InspectionLensColors.GRAZIE_ATTRIBUTES
            ),
            AttributesDescriptor(
                InspectionLensBundle.message("configurable.inspectionlens.attribute.descriptor.typo"),
                InspectionLensColors.TYPO_ATTRIBUTES
            ),
            AttributesDescriptor(
                InspectionLensBundle.message("configurable.inspectionlens.attribute.descriptor.other"),
                InspectionLensColors.OTHER_ATTRIBUTES
            ),
        )
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
