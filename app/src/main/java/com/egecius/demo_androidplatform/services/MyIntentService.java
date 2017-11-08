package com.egecius.demo_androidplatform.services;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

public class MyIntentService extends IntentService {

    public static final String TAG = MyIntentService.class.getSimpleName();

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     * @param name Used to name the worker thread, important only for debugging.
     */
    @SuppressWarnings("unused")
    public MyIntentService(String name) {
        super(TAG);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Toast.makeText(this, "MyIntentService.onHandleIntent", Toast.LENGTH_SHORT).show();
        Log.i("Eg:MyIntentService:24", "onHandleIntent ");
    }
}
