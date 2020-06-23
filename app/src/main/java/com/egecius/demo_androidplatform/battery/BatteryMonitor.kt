package com.egecius.demo_androidplatform.battery

import io.reactivex.Observable


interface BatteryMonitor {

    fun getPercentageObservable(): Observable<Float>
}