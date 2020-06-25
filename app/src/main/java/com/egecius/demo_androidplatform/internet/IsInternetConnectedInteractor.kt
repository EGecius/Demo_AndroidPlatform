package com.egecius.demo_androidplatform.internet

import io.reactivex.BackpressureStrategy.LATEST
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.reactive.asFlow

class IsInternetConnectedInteractor constructor(
        private val connectivityMonitor: ConnectivityMonitor
) {

    fun getFlow(): Flow<Boolean> {
        return connectivityMonitor.isInternetConnectedObservable().toFlowable(LATEST).asFlow()
    }
}
