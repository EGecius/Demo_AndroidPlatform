package com.egecius.demo_androidplatform.services;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

import android.app.Application;
import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.egecius.demo_androidplatform.DetailActivity;

public class MyIntentService extends IntentService {

    public static final String TAG = MyIntentService.class.getSimpleName();

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor - crashes if not provided
     */
    @SuppressWarnings("unused")
    public MyIntentService() {
        super(TAG);
        Log.i("Eg:MyIntentService:23", "MyIntentService ");
        print();
    }

    private void print() {
        Context context = getBaseContext();
        Log.i("Eg:MyIntentService:28", "print context " + context);
        Application application = getApplication();
        Log.i("Eg:MyIntentService:31", "print application " + application);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.i("Eg:MyIntentService:24", "onHandleIntent ");
        print();

        startActivity();
    }

    private void startActivity() {
        Intent intentActivity = new Intent(this, DetailActivity.class);
        intentActivity.addFlags(FLAG_ACTIVITY_NEW_TASK);
        startActivity(intentActivity);
    }
}
