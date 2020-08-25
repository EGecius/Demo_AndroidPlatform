package com.egecius.demo_androidplatform.shared.extensions

import android.app.Activity
import android.view.View
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.TextView

fun TextView.setKeyboardDoneButtonClickListener(listener: () -> Unit) {

    setOnEditorActionListener { textView, actionId, event ->
        var isHandled = false
        if (actionId == EditorInfo.IME_ACTION_DONE) {
            listener.invoke()
            textView.hideKeyboard()
            isHandled = true
        }
        isHandled
    }
}

fun View.hideKeyboard() {
    val inputMethodManager = context.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(windowToken, 0)
}
