package com.egecius.demo_androidplatform.internet

import io.reactivex.BackpressureStrategy.LATEST
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.reactive.asFlow

class IsWifiConnectedInteractor constructor(
        private val connectivityMonitor: ConnectivityMonitor
) {

    fun getFlow(): Flow<Boolean> {
        return connectivityMonitor.isWifiConnectedObservable().toFlowable(LATEST).asFlow()
    }
}
