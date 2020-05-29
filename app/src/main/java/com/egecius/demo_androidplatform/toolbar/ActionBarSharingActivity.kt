package com.egecius.demo_androidplatform.toolbar

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.egecius.demo_androidplatform.R

/** Shows how to share same ActionBar between Activity & its fragments */
class ActionBarSharingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actionbar_sharing)

        // TODO: 29/05/2020 add a fragment container where fragments share action bar with Activity
    }
}