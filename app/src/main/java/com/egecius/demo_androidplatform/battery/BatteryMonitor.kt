package com.egecius.demo_androidplatform.battery

interface BatteryMonitor {

    fun getBatteryUpdatesFlow(): kotlinx.coroutines.flow.Flow<BatteryUpdate>
    fun getBatteryPercentage(): Float?
}