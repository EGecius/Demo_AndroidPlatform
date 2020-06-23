package com.egecius.demo_androidplatform.extensions

import android.content.Context
import android.widget.Toast


fun Context?.showToast(message: String) {
    if (this != null) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}