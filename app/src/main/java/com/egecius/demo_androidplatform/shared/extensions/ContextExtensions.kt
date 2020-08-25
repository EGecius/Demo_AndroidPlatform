package com.egecius.demo_androidplatform.shared.extensions

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast


fun Context?.showToast(message: String) {
    if (this != null) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}