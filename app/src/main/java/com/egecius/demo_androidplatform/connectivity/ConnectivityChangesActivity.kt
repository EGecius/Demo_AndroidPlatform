package com.egecius.demo_androidplatform.connectivity

import android.content.IntentFilter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


class ConnectivityChangesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.egecius.demo_androidplatform.R.layout.activity_connectivity_changes)
        registerForConnectivityChanges()
    }

    private fun registerForConnectivityChanges() {
        val action = "android.net.conn.CONNECTIVITY_CHANGE"
        val intentFilter = IntentFilter(action)
        registerReceiver(NetworkBroadcastReceiver(), intentFilter)
    }
}