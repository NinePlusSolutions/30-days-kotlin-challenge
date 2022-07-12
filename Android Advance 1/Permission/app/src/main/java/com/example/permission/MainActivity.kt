package com.example.permission

import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat

class MainActivity : AppCompatActivity() {

    private val requestCode = 1083

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        checkPermission()
    }

    private fun checkPermission() {

        val listPermissionNeed: ArrayList<String> = ArrayList()

        val checkInternetPermission =
            ActivityCompat.checkSelfPermission(this, android.Manifest.permission.INTERNET)
        val checkLocationPermission = ActivityCompat.checkSelfPermission(
            this,
            android.Manifest.permission.ACCESS_FINE_LOCATION
        )
        val checkReadPermission = ActivityCompat.checkSelfPermission(
            this,
            android.Manifest.permission.READ_EXTERNAL_STORAGE
        )
        val checkWritePermission = ActivityCompat.checkSelfPermission(
            this,
            android.Manifest.permission.WRITE_EXTERNAL_STORAGE
        )

        if (checkInternetPermission != PackageManager.PERMISSION_GRANTED
        ) {
            listPermissionNeed.add(android.Manifest.permission.INTERNET)
        }

        if (checkLocationPermission != PackageManager.PERMISSION_GRANTED
        ) {
            listPermissionNeed.add(android.Manifest.permission.ACCESS_FINE_LOCATION)
        }

        if (checkReadPermission != PackageManager.PERMISSION_GRANTED
        ) {
            listPermissionNeed.add(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
        }

        if (checkWritePermission != PackageManager.PERMISSION_GRANTED
        ) {
            listPermissionNeed.add(android.Manifest.permission.READ_EXTERNAL_STORAGE)
        }

        if (listPermissionNeed.isNotEmpty()) {
            ActivityCompat.requestPermissions(this, listPermissionNeed.toTypedArray(), requestCode)
        } else {
            Toast.makeText(this, "All permissions is granted", Toast.LENGTH_LONG).show()
        }

    }
}