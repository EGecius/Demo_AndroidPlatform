package com.egecius.demo_androidplatform.connectivity

import android.annotation.SuppressLint
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast


class NetworkBroadcastReceiver : BroadcastReceiver() {

    @SuppressLint("LongLogTag")
    override fun onReceive(context: Context, intent: Intent) {

        val status = getConnectivityStatus(context)

        Toast.makeText(context, "connection changed to $status", Toast.LENGTH_LONG).show()
        Log.i("Eg:NetworkBroadcastReceiver:14", "onReceive status: $status")
    }
}
