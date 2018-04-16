package com.egecius.demo_androidplatform

class SdkLevelChecker {

    fun isLevelAtLeat18(): Boolean {
        return android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN_MR2
    }
}