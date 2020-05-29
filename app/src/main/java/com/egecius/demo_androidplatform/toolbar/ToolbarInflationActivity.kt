package com.egecius.demo_androidplatform.toolbar

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.egecius.demo_androidplatform.R
import kotlinx.android.synthetic.main.activity_toolbar_inflation.*

class ToolbarInflationActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toolbar_inflation)
        setToolbar()
    }

    private fun setToolbar() {
//        setSupportActionBar(toolbar)
        // toolbar.inflateMenu() works only if Toolbar is not used as an ActionBar
        toolbar.inflateMenu(R.menu.toolbar_inflation_menu)
    }

}