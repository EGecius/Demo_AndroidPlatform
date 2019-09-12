package com.egecius.demo_androidplatform

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_for_result.*

class MyActivityForResult : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_for_result)

        deliver_result.setOnClickListener {
            closeActivityWithResult()
        }
    }

    private fun closeActivityWithResult() {
        val resultText = edit_text.text.toString()
        val data = Intent()
        data.putExtra(KEY_RESULT, resultText)
        setResult(RESULT_CODE_SUCCESS, data)
        finish()
    }

    override fun onBackPressed() {
        closeActivityWithResult()
    }

    companion object {

        const val REQUEST_CODE = 631
        const val RESULT_CODE_SUCCESS = 200
        const val KEY_RESULT = "key_result"
    }
}