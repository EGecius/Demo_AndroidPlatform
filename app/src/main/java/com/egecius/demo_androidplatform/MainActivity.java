package com.egecius.demo_androidplatform;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.egecius.demo_androidplatform.services.MyIntentService;

public class MainActivity extends AppCompatActivity {

    private final NotificationSender mNotificationSender = new NotificationSender(
            MyApplication.appContext);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setOnClickListener();
    }

    private void setOnClickListener() {
        findViewById(R.id.start_intent_service).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startIntentService();
            }
        });
        findViewById(R.id.send_notification).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mNotificationSender.sendNotification();
            }
        });
    }

    private void startIntentService() {
        Intent intent = new Intent(getApplicationContext(), MyIntentService.class);
        startService(intent);
    }
}
