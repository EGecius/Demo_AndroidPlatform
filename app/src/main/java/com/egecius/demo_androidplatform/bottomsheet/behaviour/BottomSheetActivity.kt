package com.egecius.demo_androidplatform.bottomsheet.behaviour

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.egecius.demo_androidplatform.R
import com.google.android.material.bottomsheet.BottomSheetBehavior
import kotlinx.android.synthetic.main.activity_bottom_sheet_content.*
import kotlinx.android.synthetic.main.bottom_sheet.*

class BottomSheetActivity : AppCompatActivity() {

    lateinit var bottomSheetBehavior: BottomSheetBehavior<LinearLayout>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_sheet)

        setupBottomSheet()
        setupListeners()
    }

    private fun setupListeners() {
        setupClickListener()
        setupBottomSheetBehaviourListener()
    }

    private fun setupBottomSheetBehaviourListener() {
        bottomSheetBehavior.setBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
            override fun onStateChanged(bottomSheet: View, newState: Int) {
                Log.v("Eg:BottomSheetActivity:26", "onStateChanged ")
            }

            override fun onSlide(bottomSheet: View, slideOffset: Float) {
                Log.v("Eg:BottomSheetActivity:31", "onSlide ")
            }
        })
    }

    private fun setupClickListener() {
        open_bottom_sheet.setOnClickListener {
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
        }
        close_bottom_sheet.setOnClickListener {
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
        }
        hide_bottom_sheet.setOnClickListener {
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_HIDDEN
        }
    }

    private fun setupBottomSheet() {
        bottomSheetBehavior = BottomSheetBehavior.from(bottom_sheet)
    }
}