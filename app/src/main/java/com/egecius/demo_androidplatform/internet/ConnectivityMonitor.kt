package com.egecius.demo_androidplatform.internet

import io.reactivex.Observable

interface ConnectivityMonitor {

    fun isInternetConnectedObservable(): Observable<Boolean>

    fun isWifiConnectedObservable(): Observable<Boolean>
}
