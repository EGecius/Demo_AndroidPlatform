package com.egecius.demo_androidplatform.battery

import kotlinx.coroutines.flow.Flow


interface BatteryMonitor {

    fun getPercentageFlow(): Flow<Int>
}