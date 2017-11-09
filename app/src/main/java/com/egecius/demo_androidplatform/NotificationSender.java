package com.egecius.demo_androidplatform;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

class NotificationSender {

    private static final int REQUEST_CODE = 123;
    private static final int ID_NOTIFICATION = 42;
    private final Context context;
    private final NotificationManager mNotificationManager;

    NotificationSender(Context context) {
        this.context = context;
        mNotificationManager =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
    }

    void sendNotification() {
        Intent activityIntent = new Intent(context, DetailActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, REQUEST_CODE,
                activityIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.BigTextStyle style = new NotificationCompat.BigTextStyle();
        String title = context.getString(R.string.notification_title);
        String body = context.getString(R.string.notification_body);

        Notification notification = new NotificationCompat.Builder(context)
                .setContentTitle(title)
                .setSmallIcon(R.drawable.notification_icon)
                .setContentText(body)
                .setStyle(style)
                .setContentIntent(pendingIntent)
                .build();


        mNotificationManager.notify(ID_NOTIFICATION, notification);
    }
}
