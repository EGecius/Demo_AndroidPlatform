package com.egecius.demo_androidplatform.services;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v4.app.JobIntentService;
import android.widget.Toast;

public class MyJobIntentService extends JobIntentService {

    private static final int JOB_ID = 1000;

    /**
     * Convenience method for enqueuing work in to this service.
     */
    public static void enqueueWork(Context context, Intent work) {
        enqueueWork(context, MyJobIntentService.class, JOB_ID, work);
    }

    @Override
    protected void onHandleWork(Intent intent) {
        sendToast("onHandleWork. Will sleep for 3s");
        sleepFor3Secs();
    }

    private void sleepFor3Secs() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {}
    }

    // Helper for showing tests
    void sendToast(final CharSequence text) {
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MyJobIntentService.this, text, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        sendToast("onDestroy");
    }

    final Handler mHandler = new Handler();
}
