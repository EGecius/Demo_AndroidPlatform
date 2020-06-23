package com.egecius.demo_androidplatform

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.egecius.demo_androidplatform.battery.BatteryMonitorImpl
import com.egecius.demo_androidplatform.services.MyIntentService
import com.egecius.demo_androidplatform.services.MyJobIntentService
import com.egecius.demo_androidplatform.services.MyJobSchedulerHelper
import com.egecius.demo_androidplatform.services.MyService
import com.egecius.demo_androidplatform.shared.extensions.showToast
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val mNotificationSender = NotificationSender(
            MyApplication.appContext)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setOnClickListener()

        printBatteryPercentage()
    }

    private fun printBatteryPercentage() {
        val batteryMonitorImpl = BatteryMonitorImpl(this)
        val snapshot = batteryMonitorImpl.getBatteryPercentage()
        showToast(snapshot.toString())
        Log.v("Eg:MainActivity:33", "printBatteryPercentage() snapshot percentage: $snapshot")

        GlobalScope.launch {
            batteryMonitorImpl.getPercentageFlow().collect {
                Log.d("Eg:MainActivity:41", "printBatteryPercentage() updated percentage: $it")
            }
        }
    }

    private fun setOnClickListener() {
        findViewById<View>(R.id.start_job_intent_service).setOnClickListener { startJobIntentService() }
        findViewById<View>(R.id.start_job_scheduler).setOnClickListener { startJobScheduler() }
        findViewById<View>(R.id.start_service).setOnClickListener { startNormalService() }
        findViewById<View>(R.id.start_intent_service).setOnClickListener { startIntentService() }
        findViewById<View>(R.id.send_notification).setOnClickListener { sendNotification() }
        findViewById<View>(R.id.show_dialog).setOnClickListener { showDialog() }
        findViewById<View>(R.id.activity_for_result).setOnClickListener { startMyActivityForResult() }
    }

    private fun showDialog() {

        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        builder.setMessage("my message")
                .setPositiveButton("positive button") { _, _ -> }
                .setNegativeButton("negative button") { _, _ -> }

        builder.create().show()
    }

    private fun startJobIntentService() {
        MyJobIntentService.enqueueWork(applicationContext, Intent())
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

    private fun startMyActivityForResult() {
        val intent = Intent(this, MyActivityForResult::class.java)
        startActivityForResult(intent, MyActivityForResult.REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, intent: Intent?) {
        super.onActivityResult(requestCode, resultCode, intent)
        Log.i("Eg:MainActivity:74", "onActivityResult requestCode: $requestCode")
        Log.i("Eg:MainActivity:76", "onActivityResult resultCode: $resultCode")

        val result = intent?.extras?.getString(MyActivityForResult.KEY_RESULT)
        Log.d("Eg:MainActivity:81", "onActivityResult result: $result")
    }

}
