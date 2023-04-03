package com.example.notification

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.notification.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private var CHANEL_ID="primary_notification_id"
    private var notificationID=0
    private var notify: NotificationManager?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        var view=binding.root
        setContentView(view)
        setonClick()
        createNotificationChanel()
    }

    fun setonClick(){
        binding.btnNotify.setOnClickListener { setNotification() }
    }
    fun setNotification(){
        var builder=NotificationCompat.Builder(this,CHANEL_ID)
            .setSmallIcon(R.drawable.ic_notifications)
            .setContentTitle("My notification")
            .setContentText("abcd ")
            .setStyle(NotificationCompat.BigTextStyle()
                .bigText("notification nè"))
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
        var notifyBuilder=getNotification()
        notify?.notify(notificationID,notifyBuilder.build())

    }

    private fun createNotificationChanel(){
        notify = getSystemService(NOTIFICATION_SERVICE) as NotificationManager

        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            var name=getString(R.string.chanel_name)
            var descriptionText=getString(R.string.description_text)
            var importance=NotificationManager.IMPORTANCE_DEFAULT
            var chanel=NotificationChannel(CHANEL_ID,name,importance).apply {
                description=descriptionText
            }
            var notificationManager:NotificationManager=
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(chanel)
        }
    }
    private fun getNotification(): NotificationCompat.Builder{
        var notificationIntent=Intent(this,MainActivity::class.java)
        var notificationPending=PendingIntent.getActivity(
            this,notificationID,notificationIntent,PendingIntent.FLAG_UPDATE_CURRENT
        )
        var notificationBuilder:NotificationCompat.Builder=NotificationCompat.Builder(this,CHANEL_ID)

        return NotificationCompat.Builder(this,CHANEL_ID)
            .setSmallIcon(R.drawable.ic_notifications)
            .setContentTitle("my notification")
            .setContentText("hello word")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setContentIntent(notificationPending)
            .setAutoCancel(true)
    }
}