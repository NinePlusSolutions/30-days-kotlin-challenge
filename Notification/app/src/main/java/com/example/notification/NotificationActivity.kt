package com.example.notification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import kotlinx.android.synthetic.main.activity_notification.*

class NotificationActivity : AppCompatActivity() {
    private var chanel_Id="chanel_id_01"
    private var notificationID=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification)
        createNotificationChanel()
        btnNotification.setOnClickListener {
            sendNotification()
        }
    }


    private fun createNotificationChanel(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            var name ="Notification Title"
            var descriptionText="Notification description"
            var importtance=NotificationManager.IMPORTANCE_DEFAULT
            var chanel=NotificationChannel(chanel_Id,name,importtance).apply {
                description=descriptionText
            }
            var  notificationManager: NotificationManager= getSystemService(Context.NOTIFICATION_SERVICE)
            as NotificationManager
            notificationManager.createNotificationChannel(chanel)
        }
    }
    fun sendNotification(){
        var intent=Intent(this,NotificationActivity::class.java).apply {
            flags=Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        var pendingIntent: PendingIntent=PendingIntent.getActivity(this,0, intent,0)
        var map=BitmapFactory.decodeResource(applicationContext.resources,R.drawable.ic_notifications)


        var builder= NotificationCompat.Builder(this,chanel_Id)
            .setSmallIcon(R.drawable.ic_notifications)
            .setContentTitle("My notification")
            .setContentText("DEscription")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        with(NotificationManagerCompat.from(this)){
            notify(notificationID,builder.build())
        }
    }
}