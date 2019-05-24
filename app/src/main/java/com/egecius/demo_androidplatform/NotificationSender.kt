package com.egecius.demo_androidplatform

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import android.util.Log

internal class NotificationSender(private val context: Context) {

    private val mNotificationManager: NotificationManager
            = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

    @SuppressLint("LongLogTag")
    fun sendNotification() {
    	Log.v("Eg:NotificationSender:15", "sendNotification")
        val activityIntent = Intent(context, DetailActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(context, REQUEST_CODE,
                activityIntent, PendingIntent.FLAG_UPDATE_CURRENT)

        val style = NotificationCompat.BigTextStyle()
        val title = context.getString(R.string.notification_title)
        val body = context.getString(R.string.notification_body)

        val notification = NotificationCompat.Builder(context, ID_CHANNEL)
                .setContentTitle(title)
                .setSmallIcon(R.drawable.notification_icon)
                .setContentText(body)
                .setStyle(style)
                .setContentIntent(pendingIntent)
                .build()

        createChannel()

        mNotificationManager.notify(ID_NOTIFICATION, notification)
    }

    private fun createChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val importance = NotificationManager.IMPORTANCE_HIGH
            val mChannel = NotificationChannel(ID_CHANNEL, CHANNEL_NAME, importance)
            mNotificationManager.createNotificationChannel(mChannel)
        }
    }

    companion object {

        private const val CHANNEL_NAME = "User-visible channel name"
        private const val REQUEST_CODE = 123
        private const val ID_NOTIFICATION = 42
        private const val ID_CHANNEL = "1"
    }
}
