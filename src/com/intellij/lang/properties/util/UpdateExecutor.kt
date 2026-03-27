package com.intellij.lang.properties.util

import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.progress.Cancellation
import com.intellij.util.ui.update.Update
import kotlin.use

class UpdateExecutor {
    companion object {
        @JvmStatic
        val executeInWriteActionField by lazy {
            Update::class.java.getDeclaredField("executeInWriteAction").apply {
                isAccessible = true
            }
        }

        private val executeMethod by lazy {
            Update::class.java.getDeclaredMethod("execute").apply {
                isAccessible = true
            }
        }

        @JvmStatic
        fun execute(delegate: Update) {
            executeMethod.invoke(delegate)
        }
    }
}
