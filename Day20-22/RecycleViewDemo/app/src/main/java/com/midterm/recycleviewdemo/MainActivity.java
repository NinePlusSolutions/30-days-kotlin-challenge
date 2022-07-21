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
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvComment;
    private List<Comment> listComment;
    private RecycleViewAdapter recycleviewAdapter;
    private FloatingActionButton fabAdd;
    private boolean isLoading = false;

    private static final int REQUEST_CODE_EXAMPLE = 0x9345;
    private int CURRENT_POSITION = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setData();

        GridLayoutManager layoutManager = new GridLayoutManager(this,1);
        recycleviewAdapter = new RecycleViewAdapter(this::onClickDetail);
        recycleviewAdapter.setData(listComment);
        rvComment.setLayoutManager(layoutManager);
        rvComment.setAdapter(recycleviewAdapter);
        rvComment.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                if (dy > 0 && fabAdd.getVisibility() == View.VISIBLE) {
                    fabAdd.setVisibility(View.GONE);
                } else if (dy < 0 && fabAdd.getVisibility() != View.VISIBLE) {
                    fabAdd.setVisibility(View.VISIBLE);
                }
                if (!isLoading) {
                    if (layoutManager.findLastCompletelyVisibleItemPosition() == listComment.size() - 1) {
                        loadMore();
                        isLoading = true;
                    }
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_EXAMPLE) {
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
        com.midterm.recycleviewdemo.databinding.ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        fabAdd = binding.fabAdd;
        rvComment = binding.rvComment;

        listComment = new ArrayList<>();
        Comment cmt1 = new Comment("Amanda","@Amanda", "Just Now", getResources().getString(R.string.comment1),false);
        Comment cmt2 = new Comment("Panwa","@Panwa", "2h ago", getResources().getString(R.string.comment2),false);
        Comment cmt3 = new Comment("Suke","@Suke", "3h ago", getResources().getString(R.string.comment1),false);
        Comment cmt4 = new Comment("Eric","@Eric", "4h ago", getResources().getString(R.string.comment2),false);
        Comment cmt5 = new Comment("Lada","@Lada", "5h ago", getResources().getString(R.string.comment2),false);
        Comment cmt6 = new Comment("John","@John", "6h ago", getResources().getString(R.string.comment1),false);
        Comment cmt7 = new Comment("Mue","@Mue", "7h ago", getResources().getString(R.string.comment1),false);
        Comment cmt8 = new Comment("Messi","@Messi", "8h ago", getResources().getString(R.string.comment2),false);
        Comment cmt9 = new Comment("Ronaldo","@Ronaldo", "9h ago", getResources().getString(R.string.comment1),false);
        Comment cmt10 = new Comment("Marcelo","@Marcelo", "1d ago", getResources().getString(R.string.comment1),false);

        listComment.add(cmt1);
        listComment.add(cmt2);
        listComment.add(cmt3);
        listComment.add(cmt4);
        listComment.add(cmt5);
        listComment.add(cmt6);
        listComment.add(cmt7);
        listComment.add(cmt8);
        listComment.add(cmt9);
        listComment.add(cmt10);
    }

    private void onClickDetail(Comment comment){
        CURRENT_POSITION = listComment.indexOf(comment);
        Intent intent = new Intent(this,DetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable("comment", comment);
        intent.putExtras(bundle);
        startActivityForResult(intent,REQUEST_CODE_EXAMPLE );
    }

    private void loadMore() {
        listComment.add(null);
        recycleviewAdapter.notifyItemInserted(listComment.size() - 1);
    }
}