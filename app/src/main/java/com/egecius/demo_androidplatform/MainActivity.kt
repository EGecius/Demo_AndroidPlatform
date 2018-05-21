package com.egecius.demo_androidplatform

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View

import com.egecius.demo_androidplatform.services.MyIntentService

class MainActivity : AppCompatActivity() {

    private val mNotificationSender = NotificationSender(
            MyApplication.appContext)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setOnClickListener()
    }

    private fun setOnClickListener() {
        findViewById<View>(R.id.start_intent_service).setOnClickListener { startIntentService() }
        findViewById<View>(R.id.send_notification).setOnClickListener { sendNotification() }
    }

    private fun sendNotification() {
        mNotificationSender.sendNotification()
    }

    private fun startIntentService() {
        val intent = Intent(applicationContext, MyIntentService::class.java)
        startService(intent)
    }
}