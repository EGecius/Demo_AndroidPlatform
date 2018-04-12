package com.egecius.demo_androidplatform.services

import android.content.Intent.FLAG_ACTIVITY_NEW_TASK

import android.app.Application
import android.app.IntentService
import android.content.Context
import android.content.Intent
import android.util.Log

import com.egecius.demo_androidplatform.DetailActivity

class MyIntentService : IntentService(TAG) {
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor - crashes if not provided
     */
    init {
        Log.i("Eg:MyIntentService:23", "MyIntentService ")
        print()
    }

    private fun print() {
        val context = baseContext
        Log.i("Eg:MyIntentService:28", "print context $context")
        val application = application
        Log.i("Eg:MyIntentService:31", "print application $application")
    }

    override fun onHandleIntent(intent: Intent?) {
        Log.i("Eg:MyIntentService:24", "onHandleIntent ")
        print()

        startActivity()
    }

    private fun startActivity() {
        val intentActivity = Intent(this, DetailActivity::class.java)
        intentActivity.addFlags(FLAG_ACTIVITY_NEW_TASK)
        startActivity(intentActivity)
    }

    companion object {

        val TAG = MyIntentService::class.java.getSimpleName()
    }
}
