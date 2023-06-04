package com.chylex.intellij.inspectionlens

import com.intellij.DynamicBundle
import org.jetbrains.annotations.PropertyKey

internal object InspectionLensBundle : DynamicBundle(BUNDLE) {
    fun message(@PropertyKey(resourceBundle = BUNDLE) key: String, vararg params: Any?): String {
        return getMessage(key, params)
    }
}

private const val BUNDLE = "messages.InspectionLensBundle"
