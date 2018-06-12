package com.egecius.demo_androidplatform.services

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import android.widget.Toast
import com.egecius.demo_androidplatform.printThreadName

class MyService : Service() {

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        print()
        Toast.makeText(this, "MyService started", Toast.LENGTH_SHORT).show()

        return super.onStartCommand(intent, flags, startId)
    }

    private fun print() {
        Log.v("Eg:MyService:12", "onStartCommand ")
        printThreadName(this, "print")
    }

    override fun onBind(intent: Intent?): IBinder? {
        // not to be implemented
        return null
    }

}
