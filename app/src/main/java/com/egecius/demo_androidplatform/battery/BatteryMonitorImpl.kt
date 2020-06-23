package com.egecius.demo_androidplatform.battery

import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager
import com.egecius.demo_androidplatform.shared.UNKNOWN
import kotlinx.coroutines.flow.Flow

class BatteryMonitorImpl(private val context: Context) : BatteryMonitor {

    override fun getBatteryUpdatesFlow(): Flow<BatteryUpdate> {
        TODO("not implemented")
    }

    override fun getBatteryPercentage(): Float {
        return getBatteryStatusIntent()?.let { intent ->
            val level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1)
            val max = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1).toFloat()
            (level / max) * 100
        } ?: UNKNOWN
    }

    private fun getBatteryStatusIntent(): Intent? {
        return IntentFilter(Intent.ACTION_BATTERY_CHANGED).let { intentFilter ->
            context.registerReceiver(null, intentFilter)
        }
    }

}