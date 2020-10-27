package com.egecius.demo_androidplatform.shared.extensions

import android.app.Activity
import android.text.SpannableString
import android.text.Spanned
import android.text.style.AbsoluteSizeSpan
import android.text.style.ForegroundColorSpan
import android.view.View
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import androidx.core.content.ContextCompat

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

fun TextView.highlightFirstWord(textSizeDp: Int? = null, highlightColor: Int? = null) {
    this.text = SpannableString(text).apply {
        val start = 0
        val end = text.indexOf(' ')
        textSizeDp?.also {
            setSpan(AbsoluteSizeSpan(textSizeDp, true), start, end, Spanned.SPAN_INCLUSIVE_INCLUSIVE)
        }
        highlightColor?.also {
            val color = ContextCompat.getColor(context, highlightColor)
            setSpan(ForegroundColorSpan(color), start, end, Spanned.SPAN_INCLUSIVE_INCLUSIVE)
        }
    }
}