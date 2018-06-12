package com.egecius.demo_androidplatform

import android.util.Log


fun printThreadName(callerClass: Any, callerMethod: String) {
    val callerClassName = callerClass.javaClass.simpleName
    val threadName = Thread.currentThread().name
    Log.i("Eg:$callerClassName", "$callerMethod threadName $threadName")
}