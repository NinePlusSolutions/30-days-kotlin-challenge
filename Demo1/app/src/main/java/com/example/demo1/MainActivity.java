package com.example.demo1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rcvData;
    private DataAdapter dataAdapter;
    private FloatingActionButton btnFloating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.avtivity_main);
        rcvData = findViewById(R.id.rcv_data);
        btnFloating = findViewById(R.id.btn_floating);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcvData.setLayoutManager(linearLayoutManager);

        dataAdapter = new DataAdapter(getListUser());
        rcvData.setAdapter(dataAdapter);
        rcvData.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                if (dy>0){
                    btnFloating.hide();
                }else {
                    btnFloating.show();
                }
                super.onScrolled(recyclerView, dx, dy);
            }
        });
    }

    private List<Data> getListUser() {
        List<Data> list = new ArrayList<>();
        list.add(new Data(R.drawable.ic_avt_1,"Duong","@VietNam","10h ago","Lorem",R.drawable.ic_message,R.drawable.ic_repeat,R.drawable.ic_favorite,R.drawable.ic_share));
        list.add(new Data(R.drawable.ic_avt_1,"Duong","@VietNam","10h ago","Lorem",R.drawable.ic_message,R.drawable.ic_repeat,R.drawable.ic_favorite,R.drawable.ic_share));
        list.add(new Data(R.drawable.ic_avt_1,"Duong","@VietNam","10h ago","Lorem",R.drawable.ic_message,R.drawable.ic_repeat,R.drawable.ic_favorite,R.drawable.ic_share));
        list.add(new Data(R.drawable.ic_avt_1,"Duong","@VietNam","10h ago","Lorem",R.drawable.ic_message,R.drawable.ic_repeat,R.drawable.ic_favorite,R.drawable.ic_share));
        list.add(new Data(R.drawable.ic_avt_1,"Duong","@VietNam","10h ago","Lorem",R.drawable.ic_message,R.drawable.ic_repeat,R.drawable.ic_favorite,R.drawable.ic_share));
        list.add(new Data(R.drawable.ic_avt_1,"Duong","@VietNam","10h ago","Lorem",R.drawable.ic_message,R.drawable.ic_repeat,R.drawable.ic_favorite,R.drawable.ic_share));
        list.add(new Data(R.drawable.ic_avt_1,"Duong","@VietNam","10h ago","Lorem",R.drawable.ic_message,R.drawable.ic_repeat,R.drawable.ic_favorite,R.drawable.ic_share));
        list.add(new Data(R.drawable.ic_avt_1,"Duong","@VietNam","10h ago","Lorem",R.drawable.ic_message,R.drawable.ic_repeat,R.drawable.ic_favorite,R.drawable.ic_share));
        list.add(new Data(R.drawable.ic_avt_1,"Duong","@VietNam","10h ago","Lorem",R.drawable.ic_message,R.drawable.ic_repeat,R.drawable.ic_favorite,R.drawable.ic_share));
        list.add(new Data(R.drawable.ic_avt_1,"Duong","@VietNam","10h ago","Lorem",R.drawable.ic_message,R.drawable.ic_repeat,R.drawable.ic_favorite,R.drawable.ic_share));
        list.add(new Data(R.drawable.ic_avt_1,"Duong","@VietNam","10h ago","Lorem",R.drawable.ic_message,R.drawable.ic_repeat,R.drawable.ic_favorite,R.drawable.ic_share));


        return list;

    }

}