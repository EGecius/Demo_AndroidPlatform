package com.egecius.demo_androidplatform.services

import android.app.Service
import android.content.Intent
import android.os.Handler
import android.os.IBinder
import android.util.Log
import android.widget.Toast
import com.egecius.demo_androidplatform.printThreadName

class MyService : Service() {

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        print()
        Toast.makeText(this, "MyService started", Toast.LENGTH_SHORT).show()

        scheduleStopping()

        return super.onStartCommand(intent, flags, startId)
    }

    private fun scheduleStopping() {
        Handler().postDelayed({
            Log.w("Eg:MyService:25", "about to call stopSelf ")
            stopSelf()
        }, 3000)
    }

    private fun print() {
        Log.v("Eg:MyService:12", "onStartCommand ")
        printThreadName(this, "print")
    }

    override fun onBind(intent: Intent?): IBinder? {
        Log.v("Eg:MyService:26", "onBind ")
        // not to be implemented
        return null
    }

    override fun onCreate() {
        Log.d("Eg:MyService:32", "onCreate ")
        super.onCreate()
    }

    override fun onDestroy() {
        Log.w("Eg:MyService:37", "onDestroy ")
        super.onDestroy()
    }

}
