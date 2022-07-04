package com.ngockhanh.permissions;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.Toast;

import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.normal.TedPermission;

import java.util.List;

public class MainActivity extends AppCompatActivity {

//    private static final int REQUEST_PERMISSION_CODE = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppCompatButton btnRequestPermission = findViewById(R.id.btn_request_permission);
        AppCompatButton btnOpenSetting = findViewById(R.id.btn_open_setting_permission);

        btnRequestPermission.setOnClickListener(view -> requestPermissionFromLibrary());
        btnOpenSetting.setOnClickListener(view -> openSettingPermission());
    }

    private void openSettingPermission() {
        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        Uri uri = Uri.fromParts("package", getPackageName(), null);
        intent.setData(uri);
        startActivity(intent);
    }

/*    private void clickRequestPermission() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            return;
        }
        if (checkSelfPermission(Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED &&
                checkSelfPermission(Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED
        ) {
            Toast.makeText(this, "Permissions granted", Toast.LENGTH_SHORT).show();
        } else {
            String[] permissions = {Manifest.permission.CAMERA,Manifest.permission.CALL_PHONE};
            requestPermissions(permissions, REQUEST_PERMISSION_CODE);
        }
    }*/

/*    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_PERMISSION_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED &&
                    grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show();
            }
        }
    }*/

    private void requestPermissionFromLibrary() {
        TedPermission.create()
                .setPermissionListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted() {

                    }
                    @Override
                    public void onPermissionDenied(List<String> deniedPermissions) {

                    }
                })
                .setPermissions(Manifest.permission.CAMERA, Manifest.permission.CALL_PHONE)
                .setDeniedTitle("Open setting permission")
                .setDeniedMessage("Please turn on permissions at [Setting] > [Permission]")
                .check();
    }
}