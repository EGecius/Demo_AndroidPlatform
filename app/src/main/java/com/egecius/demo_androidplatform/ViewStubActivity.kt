package com.egecius.demo_androidplatform

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.view.ViewStub

class ViewStubActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_stub)

        inflateIntoViewStub()
        tryToFindViewStubByOldName()
    }

    private fun tryToFindViewStubByOldName() {
        val viewStubByOldId = findViewById<ViewStub>(R.id.my_view_stub)
        Log.v("Eg:ViewStubActivity:19", "tryToFindViewStubByOldName viewStubByOldId $viewStubByOldId")
        val inflatedId = findViewById<View>(R.id.id_of_injected_view)
        Log.v("Eg:ViewStubActivity:23", "tryToFindViewStubByOldName $inflatedId")
    }

    private fun inflateIntoViewStub() {
        val viewStub = findViewById<ViewStub>(R.id.my_view_stub)
        viewStub.layoutResource = R.layout.layout_to_inject
        viewStub.inflate()
    }
}
