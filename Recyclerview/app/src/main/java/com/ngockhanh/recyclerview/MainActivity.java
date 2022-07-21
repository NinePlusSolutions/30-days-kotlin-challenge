package com.ngockhanh.recyclerview;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;

import com.ngockhanh.recyclerview.adapter.UserAdapter;
import com.ngockhanh.recyclerview.inter.IClickItemUserListener;
import com.ngockhanh.recyclerview.model.User;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements IClickItemUserListener {
    private List<User> mListUser = new ArrayList<>();
    private UserAdapter userAdapter;
    private boolean isLoading;
    private boolean isLastPage;
    private final int totalPage = 2;
    private int currentPage = 1;
    private int positionItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ColorDrawable colorDrawable
                = new ColorDrawable(Color.parseColor("#000000"));
        ActionBar actionBar;
        actionBar = getSupportActionBar();

        // Set BackgroundDrawable
        assert actionBar != null;
        actionBar.setBackgroundDrawable(colorDrawable);
        Drawable drawable = getResources().getDrawable(R.drawable.ic_baseline_table_rows_24);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(drawable);

        RecyclerView rvUser = findViewById(R.id.rvUser);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rvUser.setLayoutManager(linearLayoutManager);

        userAdapter = new UserAdapter(this);
        rvUser.setAdapter(userAdapter);
        DividerItemDecoration decoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        rvUser.addItemDecoration(decoration);

        setFirstData();

        rvUser.addOnScrollListener(new PaginaionScrollListener(linearLayoutManager) {
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
        mListUser = getListUser();
        userAdapter.setData(mListUser);
        if (currentPage < totalPage) {
            userAdapter.addFooterLoading();
        } else {
            isLastPage = true;
        }
    }

    private void loadNextPage() {
        new Handler().postDelayed(() -> {
            List<User> list = getNewListUser();

            userAdapter.removeFooterLoading();
            mListUser.addAll(list);
            isLoading = false;
            if (currentPage < totalPage) {
                userAdapter.addFooterLoading();
            } else {
                isLastPage = true;
            }
        }, 2000);

    }

    private List<User> getListUser() {
        List<User> list = new ArrayList<>();
        User user1 = new User("Amanda", "Canada", "5h ago", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry standard dummy text ever since the 1500s", true);
        User user2 = new User("Neha", "Puniabe", "2h ago", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry standard dummy text ever since the 1500s", false);
        User user3 = new User("Jack", "Callfonia", "5h ago", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry standard dummy text ever since the 1500s", false);
        User user4 = new User("Khanh", "VietNam", "10h ago", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry standard dummy text ever since the 1500s", false);
        User user5 = new User("Hai", "Malaysia", "10h ago", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry standard dummy text ever since the 1500s", false);
        User user6 = new User("Duong", "Canada", "5h ago", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry standard dummy text ever since the 1500s", false);

        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user4);
        list.add(user5);
        list.add(user6);

        return list;
    }

    private List<User> getNewListUser() {
        List<User> list = new ArrayList<>();
        User user7 = new User("Mam", "Canada", "5h ago", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry standard dummy text ever since the 1500s", false);
        User user8 = new User("Dung", "Puniabe", "2h ago", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry standard dummy text ever since the 1500s", false);
        User user9 = new User("Minh", "Callfonia", "5h ago", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry standard dummy text ever since the 1500s", false);
        User user10 = new User("Tan", "VietNam", "10h ago", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry standard dummy text ever since the 1500s", false);
        User user11 = new User("Hoang", "Malaysia", "10h ago", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry standard dummy text ever since the 1500s", false);
        User user12 = new User("Hai", "Canada", "5h ago", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry standard dummy text ever since the 1500s", false);

        list.add(user7);
        list.add(user8);
        list.add(user9);
        list.add(user10);
        list.add(user11);
        list.add(user12);

        return list;
    }


    @Override
    public void onClickItemUser(User user) {
        positionItem = mListUser.indexOf(user);
        Intent intent = new Intent(this, DetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("user", user);
        intent.putExtras(bundle);
        startActivityForResult(intent, 1);
    }

    @Override
    public void onLikedClickItemListener(User user, int position) {
        user.setLike(!user.getLike());
        mListUser.set(position, user);
        userAdapter.setData(mListUser);
        userAdapter.notifyItemChanged(position, "PAYLOAD_LIKE");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                if (data == null) {
                    return;
                }
                User user = (User) data.getExtras().get("user");
                mListUser.set(positionItem, user);
                userAdapter.notifyItemChanged(positionItem);
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}