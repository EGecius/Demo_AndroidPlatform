package com.egecius.demo_androidplatform.connectivity

import android.content.Context
import android.content.Context.CONNECTIVITY_SERVICE
import android.net.ConnectivityManager



const val TYPE_WIFI = "TYPE_WIFI"
const val TYPE_MOBILE = "TYPE_MOBILE"
const val TYPE_NOT_CONNECTED = "TYPE_NOT_CONNECTED"

fun getConnectivityStatus(context: Context): String {
    val connectivityManager = context.getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager

    val activeNetwork = connectivityManager.activeNetworkInfo
    if (null != activeNetwork) {
        if (activeNetwork.type == ConnectivityManager.TYPE_WIFI)
            return TYPE_WIFI

        if (activeNetwork.type == ConnectivityManager.TYPE_MOBILE)
            return TYPE_MOBILE
    }
    return TYPE_NOT_CONNECTED
}