package com.egecius.demo_androidplatform.connectivity

import android.content.Context
import android.content.Context.CONNECTIVITY_SERVICE
import android.net.ConnectivityManager


const val TYPE_WIFI = "TYPE_WIFI"
const val TYPE_MOBILE = "TYPE_MOBILE"
const val TYPE_NOT_CONNECTED = "TYPE_NOT_CONNECTED"

const val STATUS_CONNECTED = "STATUS_CONNECTED"
const val STATUS_NOT_CONNECTED = "STATUS_NOT_CONNECTED"

fun getConnectivityStatus(context: Context): String {
    val connectivityManager = context.getSystemService(CONNECTIVITY_SERVICE)
            as ConnectivityManager

    val activeNetworkInfo = connectivityManager.activeNetworkInfo ?: return STATUS_NOT_CONNECTED

    return if (activeNetworkInfo.isConnected) {
        STATUS_CONNECTED
    } else {
        STATUS_NOT_CONNECTED
    }
}