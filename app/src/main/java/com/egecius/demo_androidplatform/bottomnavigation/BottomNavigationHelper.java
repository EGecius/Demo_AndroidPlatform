package com.egecius.demo_androidplatform.bottomnavigation;

import android.annotation.SuppressLint;
import android.util.Log;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationMenuView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.lang.reflect.Field;


public class BottomNavigationHelper {

    @SuppressLint({"RestrictedApi", "LongLogTag"})
    public static void disableShiftMode(BottomNavigationView view) {
        Log.v("Eg:BottomNavigationHelper:17", "disableShiftMode");

        BottomNavigationMenuView menuView = (BottomNavigationMenuView) view.getChildAt(0);
        try {
            for (int i = 0; i < menuView.getChildCount(); i++) {
                BottomNavigationItemView item = (BottomNavigationItemView) menuView.getChildAt(i);

                Field shiftAmount = item.getClass().getDeclaredField("shiftAmount");
                shiftAmount.setAccessible(true);
                shiftAmount.setInt(item, 0);
                shiftAmount.setAccessible(false);

                item.setChecked(item.getItemData().isChecked());
            }
        } catch (NoSuchFieldException e) {
            Log.i("Eg:BottomNavigationHelper:35", "disableShiftMode e " + e);
        } catch (IllegalAccessException e) {
            Log.i("Eg:BottomNavigationHelper:37", "disableShiftMode e " + e);
        }
    }
}
