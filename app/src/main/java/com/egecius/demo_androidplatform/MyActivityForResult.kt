package com.egecius.demo_androidplatform

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MyActivityForResult : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_for_result)
    }

    companion object {

        const val REQUEST_CODE = 631
    }
}