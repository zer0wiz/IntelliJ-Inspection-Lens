package com.chylex.intellij.inspectionlens.colors

import com.intellij.openapi.editor.colors.TextAttributesKey
interface InspectionLensColors {
    companion object {
        val ERROR_ATTRIBUTES = TextAttributesKey.createTextAttributesKey("ERROR_ATTRIBUTES")
    }
}
