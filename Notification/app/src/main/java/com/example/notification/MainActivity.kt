package com.example.notification

import android.app.PendingIntent
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnOne = findViewById<Button>(R.id.btn_1)
        val btnTwo = findViewById<Button>(R.id.btn_2)

        val channelId = "My_Channel_ID"

        val intent = Intent(this, MainActivity::class.java)
        intent.apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }

        val pendingIntent = PendingIntent.getActivity(this, 0, intent, 0)

        val buttonIntent = Intent(this, MyBroadcastReceiver::class.java)
        buttonIntent.apply {
            action = "Do Pending Task"
            putExtra("My Favorite Color", "Red Color")
        }

        val buttonPendingIntent = PendingIntent.getBroadcast(this, 0, buttonIntent, 0)

        btnOne.setOnClickListener {
            val notificationBuilder = NotificationCompat.Builder(this, channelId)
                .setSmallIcon(R.drawable.ic_noti)
                .setContentTitle("Title: A small Notification")
                .setContentText("Bảo Công đẹp troai zl")
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setContentIntent(pendingIntent)
                .addAction(R.drawable.ic_home, "Do Task", buttonPendingIntent)

            with(NotificationManagerCompat.from(this)) {
                notify(1, notificationBuilder.build())
            }
        }

        btnTwo.setOnClickListener {
            val notificationBuilder = NotificationCompat.Builder(this, channelId)
                .setSmallIcon(R.drawable.ic_noti)
                .setContentTitle("Title: A small Notification")
                .setContentText("Low priority")
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .setContentIntent(pendingIntent)
                .addAction(R.drawable.ic_home, "Do Task", buttonPendingIntent)

            with(NotificationManagerCompat.from(this)) {
                notify(1, notificationBuilder.build())
            }
        }
    }

}