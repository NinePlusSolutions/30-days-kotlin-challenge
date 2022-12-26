package com.example.examplepermissioncamera

import android.Manifest
import android.app.Activity
import android.app.AlertDialog
import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.core.content.ContextCompat.checkSelfPermission

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {
    val CAMERA_PERISSION_CODE = 1000
    private val IMAGE_CAPTURE_CODE = 1001
    private var imageUri: Uri? = null
    private var imageView: ImageView? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        imageView = view.findViewById(R.id.imvPicture)

        view.findViewById<Button>(R.id.btnTakePicture).setOnClickListener {
            //Request permission
            val permissionGranted = requestCameraPermission()
            if(permissionGranted){
                openCameraInterface()
            }
        }
    }

    private fun requestCameraPermission(): Boolean {
        var permissionGranted = false
        //If system os is Marshmallow ov Above, we need to request runtime permission
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val cameraPermissionNotGrandted = checkSelfPermission(
                activity as Context,
                Manifest.permission.CAMERA
            ) == PackageManager.PERMISSION_DENIED
            if (cameraPermissionNotGrandted) {
                val permission = arrayOf(Manifest.permission.CAMERA)

                //Display permission Dialog
                requestPermissions(permission, CAMERA_PERISSION_CODE)
            } else {
                permissionGranted = true
            }
        }else{
            permissionGranted = true
        }
        return permissionGranted
    }

    // Handle Allow or Deny response from the permission dialog
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if(requestCode === CAMERA_PERISSION_CODE){
            if(grantResults.size === 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                openCameraInterface()
            }else{
                showAlter("Camera permission was denied. Unable to take a picture")
            }
        }
    }

    private fun openCameraInterface() {
        val values = ContentValues()
        values.put(MediaStore.Images.Media.TITLE,R.string.take_picture)
        values.put(MediaStore.Images.Media.DESCRIPTION,getString(R.string.take_picture_description))
        imageUri = activity?.contentResolver?.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values)

        //create camera intent
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri)

        //Launch intent
        startActivityForResult(intent,IMAGE_CAPTURE_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // CallBack from camera intent
        if (requestCode == Activity.RESULT_OK){
            //Set image captured to image view
            imageView?.setImageURI(imageUri)
        }else{
            //Failed to take picture
            showAlter("Failed to take camera picture")
        }
    }

    private fun showAlter(message: String) {
        val builder = AlertDialog.Builder(activity as Context)
        builder.setMessage(message)
        builder.setPositiveButton("OK", null)

        val dialog = builder.create()
        dialog.show()
    }
}