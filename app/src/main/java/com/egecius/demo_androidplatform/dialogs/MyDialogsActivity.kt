package com.egecius.demo_androidplatform.dialogs

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.egecius.demo_androidplatform.R

class MyDialogsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_dialogs)
    }

    fun showDatePickerDialog(view: View) {
        val newFragment = DatePickerFragment()
        newFragment.show(supportFragmentManager, "datePicker")
    }

}