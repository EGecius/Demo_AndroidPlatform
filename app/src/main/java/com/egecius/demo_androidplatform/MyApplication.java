package com.egecius.demo_androidplatform;

import android.app.Application;
import android.content.Context;

public class MyApplication extends Application {

    public static Context appContext;

    @Override
    public void onCreate() {
        super.onCreate();
        appContext = getApplicationContext();
    }
}
