package com.example.researchaboutrecycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView mrecyclerView;
    LinearLayoutManager layoutManager;
    List<ItemDesignModel> userList;
    RecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initRecyclerView();
    }
    private void initRecyclerView() {
        mrecyclerView = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        mrecyclerView.setLayoutManager(layoutManager);
        adapter = new RecyclerViewAdapter(userList);
        mrecyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }


    private void initData() {
        userList = new ArrayList<ItemDesignModel>();

        userList.add(new ItemDesignModel(R.drawable.c_plus_plus, "C++", "Basic Language"));

        userList.add(new ItemDesignModel(R.drawable.c_plus_plus, "C++", "Basic Language"));

        userList.add(new ItemDesignModel(R.drawable.c_plus_plus, "C++", "Basic Language"));

        userList.add(new ItemDesignModel(R.drawable.c_plus_plus, "C++", "Basic Language"));

        userList.add(new ItemDesignModel(R.drawable.c_plus_plus, "C++", "Basic Language"));

        userList.add(new ItemDesignModel(R.drawable.c_plus_plus, "C++", "Basic Language"));

        userList.add(new ItemDesignModel(R.drawable.c_plus_plus, "C++", "Basic Language"));
    }
}