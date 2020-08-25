package com.egecius.demo_androidplatform.shared.extensions

import android.view.inputmethod.EditorInfo
import android.widget.TextView

fun TextView.setKeyboardDoneButtonClickListener(listener: () -> Unit) {

    setOnEditorActionListener { _, actionId, event ->
        var isHandled = false
        if (actionId == EditorInfo.IME_ACTION_DONE) {
            listener.invoke()
            isHandled = true
        }
        isHandled
    }
}