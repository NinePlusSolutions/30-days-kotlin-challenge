package com.example.clickitemrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rcvData;
    private UserAdapter userAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rcvData=findViewById(R.id.rcv_data);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        rcvData.setLayoutManager(linearLayoutManager);
        userAdapter=new UserAdapter(getListUser());
        rcvData.setAdapter(userAdapter);
    }

    private List<User> getListUser() {
        List<User> list=new ArrayList<>();
        list.add(new User(R.mipmap.ic_launcher,"duong1","300lvh"));
        list.add(new User(R.mipmap.ic_launcher,"duong2","300lvh"));
        list.add(new User(R.mipmap.ic_launcher,"duong3","300lvh"));
        list.add(new User(R.mipmap.ic_launcher,"duong4","300lvh"));


        return list;

    }
}