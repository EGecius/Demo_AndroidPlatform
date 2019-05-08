package com.egecius.demo_androidplatform.services

import android.content.Context
import android.content.Intent
import android.os.Handler
import androidx.core.app.JobIntentService
import android.widget.Toast.LENGTH_SHORT
import android.widget.Toast.makeText
import com.egecius.demo_androidplatform.printThreadName

class MyJobIntentService : JobIntentService() {

    private val mHandler = Handler()

    override fun onHandleWork(intent: Intent) {
        printThreadName(this, "onHandleWork")
        sendToast("onHandleWork. Will sleep for 3s")
        sleepFor3Secs()
    }

    private fun sleepFor3Secs() {
        try {
            Thread.sleep(3000)
        } catch (e: InterruptedException) {
        }
    }

    // Helper for showing tests
    private fun sendToast(text: CharSequence) {
        mHandler.post { makeText(this@MyJobIntentService, text, LENGTH_SHORT).show() }
    }

    override fun onDestroy() {
        super.onDestroy()
        sendToast("onDestroy")
    }

    companion object {

        private const val JOB_ID = 1000

        /**
         * Convenience method for enqueuing work in to this service.
         */
        fun enqueueWork(context: Context, work: Intent) {
            JobIntentService.enqueueWork(context, MyJobIntentService::class.java, JOB_ID, work)
        }
    }
}
