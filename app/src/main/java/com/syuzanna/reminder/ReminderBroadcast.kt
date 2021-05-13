package com.syuzanna.reminder

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class ReminderBroadcast : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
       // val user = UserDb.getInstance(context).userDao().getAllUsers()
        val builder: NotificationCompat.Builder = NotificationCompat.Builder(context, "channelid")
        builder
                .setSmallIcon(R.drawable.ic_baseline_circle_notifications_24)
                .setContentTitle("S-RemindMe")
                .setContentText("hyyy")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        val notificationManager: NotificationManagerCompat = NotificationManagerCompat.from(context)
        notificationManager.notify(100, builder.build())
    }

}