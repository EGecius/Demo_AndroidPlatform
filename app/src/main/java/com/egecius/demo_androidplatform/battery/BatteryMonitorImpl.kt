package com.egecius.demo_androidplatform.battery

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager
import com.egecius.demo_androidplatform.shared.UNKNOWN_INT
import io.reactivex.BackpressureStrategy
import io.reactivex.subjects.BehaviorSubject
import io.reactivex.subjects.Subject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.reactive.asFlow

class BatteryMonitorImpl(private val context: Context) : BatteryMonitor {

    override fun getPercentageFlow(): Flow<Int> {
        val subject: Subject<Int> = BehaviorSubject.createDefault(getBatteryPercentage())
        val receiver = createReceiver(subject)
        registerReceiver(receiver)

        return subject.distinctUntilChanged().doOnDispose {
            unregisterReceiver(receiver)
        }.toFlowable(BackpressureStrategy.LATEST).asFlow()
    }

    fun getBatteryPercentage(): Int {
        val batteryStatusIntent = IntentFilter(Intent.ACTION_BATTERY_CHANGED).let {
            context.registerReceiver(null, it)
        }
        return batteryStatusIntent?.let {
            getBatteryPercentage(it)
        } ?: UNKNOWN_INT
    }

    private fun getBatteryPercentage(batteryStatus: Intent): Int {
        return batteryStatus.let { intent ->
            val level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, UNKNOWN_INT)
            val max = intent.getIntExtra(BatteryManager.EXTRA_SCALE, UNKNOWN_INT)
            (level * PERCENT / max)
        }
    }

    private fun createReceiver(subject: Subject<Int>): BroadcastReceiver {
        return object : BroadcastReceiver() {
            override fun onReceive(context: Context, intent: Intent) {
                subject.onNext(getBatteryPercentage(intent))
            }
        }
    }

    private fun registerReceiver(receiver: BroadcastReceiver) {
        context.registerReceiver(receiver, IntentFilter(Intent.ACTION_BATTERY_CHANGED))
    }

    private fun unregisterReceiver(receiver: BroadcastReceiver) {
        context.unregisterReceiver(receiver)
    }

    companion object {
        private const val PERCENT = 100
    }
}