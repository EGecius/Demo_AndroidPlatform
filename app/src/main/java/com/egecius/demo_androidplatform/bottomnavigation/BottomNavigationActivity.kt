package com.egecius.demo_androidplatform.bottomnavigation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.egecius.demo_androidplatform.R
import kotlinx.android.synthetic.main.activity_bottom_navigation.*

class BottomNavigationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_navigation)

        BottomNavigationHelper.disableShiftMode(bottomNavigationView)
    }

}