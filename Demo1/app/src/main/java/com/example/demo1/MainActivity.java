package com.example.demo1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private DataAdapter dataAdapter;
    private List<Data> mListData;
    private boolean isLoading;
    private boolean isLastPage;
    private final int totalPage = 8;
    private int currentPage = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.avtivity_main);
        RecyclerView rcvData = findViewById(R.id.rcv_data);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcvData.setLayoutManager(linearLayoutManager);

        dataAdapter = new DataAdapter();
        rcvData.setAdapter(dataAdapter);
        setFirstData();
        rcvData.addOnScrollListener(new PaginationScrollListener(linearLayoutManager) {
            @Override
            public void loadMoreItems() {
                isLoading = true;
                currentPage += 1;
                loadNextPage();
            }

            @Override
            public boolean isLoading() {
                return isLoading;
            }

            @Override
            public boolean isLastPage() {
                return isLastPage;
            }
        });
    }

    private void setFirstData() {
        mListData = getListData();
        dataAdapter.setData(mListData);

        if (currentPage < totalPage) {
            dataAdapter.addFooterLoading();
        } else {
            isLastPage = true;
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private void loadNextPage() {
        new Handler().postDelayed(() -> {
            List<Data> list = getListData();
            dataAdapter.removeFooterLoading();
            mListData.addAll(list);
            dataAdapter.notifyDataSetChanged();
            isLoading = false;
            if (currentPage < totalPage) {
                dataAdapter.addFooterLoading();
            } else {
                isLastPage = true;
            }

        }, 2000);

    }

    private List<Data> getListData() {
        List<Data> list = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            list.add(new Data(R.drawable.ic_avt_1, "Dong", "VieteNam", "10h", "Lunar New Year Festival often falls between late January and early February; it is among the most important holidays in Vietnam.", R.drawable.ic_message, R.drawable.ic_repeat, R.drawable.ic_favorite, R.drawable.ic_share));

        }
        return list;
    }

}