package com.example.notification

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class MyBroadcastReceiver: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val extra = intent?.getStringExtra("My Favorite Color")

        Toast.makeText(context,extra,Toast.LENGTH_SHORT).show()
    }
}