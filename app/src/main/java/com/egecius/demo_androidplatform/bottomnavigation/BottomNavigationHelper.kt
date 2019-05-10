package com.egecius.demo_androidplatform.bottomnavigation

import android.annotation.SuppressLint
import android.util.Log
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationMenuView
import com.google.android.material.bottomnavigation.BottomNavigationView


object BottomNavigationHelper {

    @SuppressLint("RestrictedApi", "LongLogTag")
    fun disableShiftMode(view: BottomNavigationView) {
        Log.v("Eg:BottomNavigationHelper:17", "disableShiftMode")

        val menuView = view.getChildAt(0) as BottomNavigationMenuView
        try {
            for (i in 0 until menuView.childCount) {
                val item = menuView.getChildAt(i) as BottomNavigationItemView

                val shiftAmount = item.javaClass.getDeclaredField("shiftAmount")
                shiftAmount.isAccessible = true
                shiftAmount.setInt(item, 0)
                shiftAmount.isAccessible = false

                item.setChecked(item.itemData.isChecked)
            }
        } catch (e: NoSuchFieldException) {
            Log.i("Eg:BottomNavigationHelper:35", "disableShiftMode e $e")
        } catch (e: IllegalAccessException) {
            Log.i("Eg:BottomNavigationHelper:37", "disableShiftMode e $e")
        }

    }
}
