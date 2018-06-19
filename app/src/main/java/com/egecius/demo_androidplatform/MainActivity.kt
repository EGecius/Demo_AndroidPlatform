package com.egecius.demo_androidplatform

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View

import com.egecius.demo_androidplatform.services.MyIntentService
import com.egecius.demo_androidplatform.services.MyJobSchedulerHelper
import com.egecius.demo_androidplatform.services.MyService

class MainActivity : AppCompatActivity() {

    private val mNotificationSender = NotificationSender(
            MyApplication.appContext)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setOnClickListener()
    }

    private fun setOnClickListener() {
        findViewById<View>(R.id.start_job_scheduler).setOnClickListener { startJobScheduler() }
        findViewById<View>(R.id.start_service).setOnClickListener { startNormalService() }
        findViewById<View>(R.id.start_intent_service).setOnClickListener { startIntentService() }
        findViewById<View>(R.id.send_notification).setOnClickListener { sendNotification() }
    }

    private fun startJobScheduler() {
        MyJobSchedulerHelper(applicationContext).scheduleJob()
    }

    private fun startNormalService() {
        val intent = Intent(applicationContext, MyService::class.java)
        startService(intent)
    }

    private fun startIntentService() {
        val intent = Intent(applicationContext, MyIntentService::class.java)
        startService(intent)
    }

    private fun sendNotification() {
        mNotificationSender.sendNotification()
    }
}
