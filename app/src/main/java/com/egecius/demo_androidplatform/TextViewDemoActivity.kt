package com.egecius.demo_androidplatform

import android.graphics.Paint
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.egecius.demo_androidplatform.shared.extensions.highlightFirstWord

class TextViewDemoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text_view_demo)
        doStrikeDemo()
    }

    private fun doStrikeDemo() {
        val textView = findViewById<TextView>(R.id.strikeDemo)!!
        textView.highlightFirstWord(20)
        textView.apply {
            paintFlags = paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        }
    }
}
