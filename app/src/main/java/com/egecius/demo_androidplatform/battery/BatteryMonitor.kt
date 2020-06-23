package com.egecius.demo_androidplatform.battery

interface BatteryMonitor {

    /** Returns a percentage or -1 when unknown  */
    fun getBatteryPercentage(): Float

    fun getBatteryUpdatesFlow(): kotlinx.coroutines.flow.Flow<BatteryUpdate>
}