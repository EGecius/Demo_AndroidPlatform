package com.egecius.demo_androidplatform.bottomsheet.dialog

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.egecius.demo_androidplatform.R
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.activity_bottom_sheet_dialog.*
import kotlinx.android.synthetic.main.bottom_sheet.view.*


class BottomSheetDialogActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_sheet_dialog)
        setOnClickListeners()
    }

    private fun setOnClickListeners() {
        open.setOnClickListener {
            showBottomSheetDialog()
        }
    }

    @SuppressLint("LongLogTag", "InflateParams")
    private fun showBottomSheetDialog() {
        val dialog = BottomSheetDialog(this)
        @SuppressLint("InflateParams") // dialog does not need a root view here
        val sheetView = layoutInflater.inflate(R.layout.bottom_sheet, null)
        sheetView.take_action.setOnClickListener {
            Log.v("Eg:BottomSheetDialogActivity:32", "showBottomSheetDialog onClicked 'take action'")
        }
        dialog.setContentView(sheetView)
        dialog.show()
    }
}