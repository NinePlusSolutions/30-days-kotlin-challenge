package com.example.mytablayout

import android.app.Activity
import android.app.Instrumentation
import android.content.Context
import android.content.pm.PackageManager
import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import java.util.jar.Manifest

class MainActivity : AppCompatActivity() {
    lateinit var viewPager: ViewPager2
    lateinit var tablayout: TabLayout
    private val M_requestCode : Int = 1208
    private lateinit var permissionLauncher: ActivityResultLauncher<Array<String>>
    private var isReadPermissionGranted = false
    private var isLocationPermissionGranted = false
    private var isRecordPermissionGranted = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        permissionLauncher =
            registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { permission ->
                isReadPermissionGranted =
                    permission[android.Manifest.permission.READ_EXTERNAL_STORAGE]
                        ?: isReadPermissionGranted
                isLocationPermissionGranted =
                    permission[android.Manifest.permission.ACCESS_FINE_LOCATION]
                        ?: isLocationPermissionGranted
                isRecordPermissionGranted = permission[android.Manifest.permission.RECORD_AUDIO]
                    ?: isRecordPermissionGranted


            }
        requestPermission()


        tablayout = findViewById(R.id.tabLayout1)
        viewPager = findViewById(R.id.viewPager1)

        viewPager.adapter = TabAdapter(this)
        TabLayoutMediator(tablayout, viewPager) { tab, index ->
            tab.text = when (index) {
                0 -> {
                    "First"
                }
                1 -> {
                    "Second"
                }
                2 -> {
                    "Third"
                }
                else -> {
                    throw Resources.NotFoundException("Position not found")
                }
            }

        }.attach()
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == M_requestCode && grantResults.isNotEmpty()){
            for (i in grantResults.indices){
                if (grantResults[i] == PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(this,"permission ${permissions[i]} is granted",Toast.LENGTH_LONG).show()
                } else{
                    requestPermission()
                }
            }
        }
    }
    private fun requestPermission() {
        isReadPermissionGranted = ContextCompat.checkSelfPermission(
            this, android.Manifest.permission.READ_EXTERNAL_STORAGE
        ) == PackageManager.PERMISSION_GRANTED

        isLocationPermissionGranted = ContextCompat.checkSelfPermission(
            this, android.Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED

        isRecordPermissionGranted = ContextCompat.checkSelfPermission(
            this, android.Manifest.permission.RECORD_AUDIO
        ) == PackageManager.PERMISSION_GRANTED

        val permissionRequest: MutableList<String> = ArrayList()
        if (!isReadPermissionGranted) {
            permissionRequest.add(android.Manifest.permission.READ_EXTERNAL_STORAGE)
        }

        if (!isLocationPermissionGranted) {
            permissionRequest.add(android.Manifest.permission.ACCESS_FINE_LOCATION)
        }

        if (!isRecordPermissionGranted) {
            permissionRequest.add(android.Manifest.permission.RECORD_AUDIO)
        }

        if (permissionRequest.isNotEmpty()) {
            permissionLauncher.launch(permissionRequest.toTypedArray())
        }
    }
}