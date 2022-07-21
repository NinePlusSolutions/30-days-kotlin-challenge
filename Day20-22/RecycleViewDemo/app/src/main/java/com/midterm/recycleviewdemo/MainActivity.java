package com.midterm.recycleviewdemo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.midterm.recycleviewdemo.adapter.RecycleViewAdapter;
import com.midterm.recycleviewdemo.databinding.ActivityMainBinding;
import com.midterm.recycleviewdemo.model.Comment;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private List<Comment> listComment;
    private RecycleViewAdapter recycleviewAdapter;
    private ActivityMainBinding binding;
    private boolean isLoading = false;
    private int CURRENT_POSITION = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setData();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0x9345) {
            if (resultCode == Activity.RESULT_OK) {
                if(data == null){
                    return;
                }
                Comment comment = (Comment) data.getExtras().get(DetailActivity.EXTRA_DATA);
                listComment.set(CURRENT_POSITION, comment);
                recycleviewAdapter.notifyItemChanged(CURRENT_POSITION);
            }
        }
    }

    private void setData(){
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        listComment = new ArrayList<>();
        listComment.add(new Comment("Amanda","@Amanda", "Just Now", getResources().getString(R.string.comment1),false));
        listComment.add(new Comment("Panwa","@Panwa", "2h ago", getResources().getString(R.string.comment2),false));
        listComment.add(new Comment("Suke","@Suke", "3h ago", getResources().getString(R.string.comment1),false));
        listComment.add(new Comment("Eric","@Eric", "4h ago", getResources().getString(R.string.comment2),false));
        listComment.add(new Comment("Lada","@Lada", "5h ago", getResources().getString(R.string.comment2),false));
        listComment.add(new Comment("Amanda","@Amanda", "Just Now", getResources().getString(R.string.comment1),false));
        listComment.add(new Comment("Panwa","@Panwa", "2h ago", getResources().getString(R.string.comment2),false));
        listComment.add(new Comment("Suke","@Suke", "3h ago", getResources().getString(R.string.comment1),false));
        listComment.add(new Comment("Eric","@Eric", "4h ago", getResources().getString(R.string.comment2),false));
        listComment.add(new Comment("Lada","@Lada", "5h ago", getResources().getString(R.string.comment2),false));

        GridLayoutManager layoutManager = new GridLayoutManager(this,1);
        recycleviewAdapter = new RecycleViewAdapter(this::onClickDetail);
        recycleviewAdapter.setData(listComment);
        binding.rvComment.setLayoutManager(layoutManager);
        binding.rvComment.setAdapter(recycleviewAdapter);
        binding.rvComment.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                onScrollHiddenButton(dy);
                if (!isLoading) {
                    if (layoutManager.findLastCompletelyVisibleItemPosition() == listComment.size() - 1) {
                        loadMore();
                        isLoading = true;
                    }
                }
            }
        });
    }

    private void onClickDetail(Comment comment){
        CURRENT_POSITION = listComment.indexOf(comment);
        Intent intent = new Intent(this,DetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable("comment", comment);
        intent.putExtras(bundle);
        startActivityForResult(intent,0x9345 );
    }

    private void onScrollHiddenButton(int dy) {
        if (dy > 0 && binding.fabAdd.getVisibility() == View.VISIBLE) {
            binding.fabAdd.setVisibility(View.GONE);
        } else if (dy < 0 && binding.fabAdd.getVisibility() != View.VISIBLE) {
            binding.fabAdd.setVisibility(View.VISIBLE);
        }
    }

    private void loadMore() {
        listComment.add(null);
        recycleviewAdapter.notifyItemInserted(listComment.size() - 1);
    }

}