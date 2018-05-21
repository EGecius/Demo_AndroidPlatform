package com.egecius.demo_androidplatform

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.ViewStub

class ViewStubActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_stub)

        inflateIntoViewStub()
    }

    private fun inflateIntoViewStub() {
        val viewStub = findViewById<ViewStub>(R.id.my_view_stub)
        viewStub.layoutResource = R.layout.layout_to_inject
        viewStub.inflate()
    }
}