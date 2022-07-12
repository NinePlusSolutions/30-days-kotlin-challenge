package com.midterm.myapplication;
import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.normal.TedPermission;


public class TabPermission extends Fragment {

    public TabPermission() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tab_permission, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        AppCompatButton btnRequestPermission = view.findViewById(R.id.btn_request_permission);
        AppCompatButton btnOpenSetting = view.findViewById(R.id.btn_open_setting_permission);

        btnRequestPermission.setOnClickListener(v -> requestPermissionFromLibrary());
        btnOpenSetting.setOnClickListener(v -> openSettingPermission());
    }

    private void openSettingPermission() {
        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        Uri uri = Uri.fromParts("package", getActivity().getPackageName(), null);
        intent.setData(uri);
        startActivity(intent);
    }

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
