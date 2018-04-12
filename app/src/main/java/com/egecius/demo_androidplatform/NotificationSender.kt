package com.egecius.demo_androidplatform

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.support.v4.app.NotificationCompat

internal class NotificationSender(private val context: Context) {

    private val mNotificationManager: NotificationManager
            = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

    fun sendNotification() {
        val activityIntent = Intent(context, DetailActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(context, REQUEST_CODE,
                activityIntent, PendingIntent.FLAG_UPDATE_CURRENT)

        val style = NotificationCompat.BigTextStyle()
        val title = context.getString(R.string.notification_title)
        val body = context.getString(R.string.notification_body)

        val notification = NotificationCompat.Builder(context)
                .setContentTitle(title)
                .setSmallIcon(R.drawable.notification_icon)
                .setContentText(body)
                .setStyle(style)
                .setContentIntent(pendingIntent)
                .build()


        mNotificationManager.notify(ID_NOTIFICATION, notification)
    }

    companion object {

        private val REQUEST_CODE = 123
        private val ID_NOTIFICATION = 42
    }
}
