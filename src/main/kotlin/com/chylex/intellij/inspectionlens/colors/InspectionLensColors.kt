package com.chylex.intellij.inspectionlens.colors

import com.intellij.openapi.editor.colors.TextAttributesKey
interface InspectionLensColors {
    companion object {
        val ERROR_ATTRIBUTES = TextAttributesKey.createTextAttributesKey("ERROR_ATTRIBUTES")
        val WARNING_ATTRIBUTES = TextAttributesKey.createTextAttributesKey("WARNING_ATTRIBUTES")
        val WEAK_WARNING_ATTRIBUTES = TextAttributesKey.createTextAttributesKey("WEAK_WARNING_ATTRIBUTES")
        val SERVER_PROBLEM_ATTRIBUTES = TextAttributesKey.createTextAttributesKey("SERVER_PROBLEM_ATTRIBUTES")
        val GRAZIE_ATTRIBUTES = TextAttributesKey.createTextAttributesKey("GRAZIE_ATTRIBUTES")
        val TYPO_ATTRIBUTES = TextAttributesKey.createTextAttributesKey("TYPO_ATTRIBUTES")
        val OTHER_ATTRIBUTES = TextAttributesKey.createTextAttributesKey("OTHER_ATTRIBUTES")
    }
}
