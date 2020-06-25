package com.egecius.demo_androidplatform.internet

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.net.ConnectivityManager.TYPE_WIFI
import android.net.NetworkInfo
import com.egecius.demo_androidplatform.internet.ConnectivityMonitor
import io.reactivex.Observable
import io.reactivex.subjects.BehaviorSubject
import io.reactivex.subjects.Subject

class ConnectivityMonitorImpl(private val context: Context) : ConnectivityMonitor {

    private val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    override fun isInternetConnectedObservable(): Observable<Boolean> {
        val subject: Subject<Boolean> = BehaviorSubject.createDefault(isConnectedToInternet())
        val receiver = createInternetReceiver(subject)
        registerReceiver(receiver)
        return subject.distinctUntilChanged().doOnDispose {
            unregisterReceiver(receiver)
        }
    }

    private fun isConnectedToInternet(): Boolean {
        val activeNetwork: NetworkInfo? = connectivityManager.activeNetworkInfo
        return activeNetwork?.isConnectedOrConnecting ?: false
    }

    private fun createInternetReceiver(subjectIsConnectedToInternet: Subject<Boolean>): BroadcastReceiver {
        return object : BroadcastReceiver() {
            override fun onReceive(context: Context, intent: Intent) {
                subjectIsConnectedToInternet.onNext(isConnectedToWifi())
            }
        }
    }

    override fun isWifiConnectedObservable(): Observable<Boolean> {
        val subject: Subject<Boolean> = BehaviorSubject.createDefault(isConnectedToWifi())
        val receiver = createWifiReceiver(subject)
        registerReceiver(receiver)

        return subject.distinctUntilChanged().doOnDispose {
            unregisterReceiver(receiver)
        }
    }

    private fun isConnectedToWifi(): Boolean {
        val networkInfo = connectivityManager.getNetworkInfo(TYPE_WIFI) ?: return false
        return networkInfo.isConnected
    }

    private fun createWifiReceiver(subjectIsConnectedToWifi: Subject<Boolean>): BroadcastReceiver {
        return object : BroadcastReceiver() {
            override fun onReceive(context: Context, intent: Intent) {
                subjectIsConnectedToWifi.onNext(isConnectedToWifi())
            }
        }
    }

    private fun registerReceiver(receiver: BroadcastReceiver) {
        val intentFilter = IntentFilter("android.net.conn.CONNECTIVITY_CHANGE")
        context.registerReceiver(receiver, intentFilter)
    }

    private fun unregisterReceiver(receiver: BroadcastReceiver) {
        context.unregisterReceiver(receiver)
    }
}
