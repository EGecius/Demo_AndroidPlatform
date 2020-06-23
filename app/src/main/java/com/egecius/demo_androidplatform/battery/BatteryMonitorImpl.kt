package com.egecius.demo_androidplatform.battery

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager
import io.reactivex.Observable
import io.reactivex.subjects.BehaviorSubject
import io.reactivex.subjects.Subject

class BatteryMonitorImpl(private val context: Context) : BatteryMonitor {

    override fun getPercentageObservable(): Observable<Float> {
        val subject: Subject<Float> = BehaviorSubject.createDefault(getBatteryPercentageCurrent())
        val receiver = createReceiver(subject)
        registerReceiver(receiver)

        return subject.distinctUntilChanged().doOnDispose {
            unregisterReceiver(receiver)
        }
    }

    fun getBatteryPercentageCurrent(): Float {
        val batteryStatus: Intent? = IntentFilter(Intent.ACTION_BATTERY_CHANGED).let {
            context.registerReceiver(null, it)
        }
        return batteryStatus?.let {
            getBatteryPercentage(it)
        } ?: -1f
    }

    private fun getBatteryPercentage(batteryStatus: Intent): Float {
        return batteryStatus.let { intent ->
            val level: Int = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1)
            val scale: Int = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1)
            level * 100 / scale.toFloat()
        }
    }

    private fun createReceiver(subjectIsConnectedToWifi: Subject<Float>): BroadcastReceiver {
        return object : BroadcastReceiver() {
            override fun onReceive(context: Context, intent: Intent) {
                subjectIsConnectedToWifi.onNext(getBatteryPercentage(intent))
            }
        }
    }

    private fun registerReceiver(receiver: BroadcastReceiver) {
        val intentFilter = IntentFilter(Intent.ACTION_BATTERY_CHANGED)
        context.registerReceiver(receiver, intentFilter)
    }

    private fun unregisterReceiver(receiver: BroadcastReceiver) {
        context.unregisterReceiver(receiver)
    }
}