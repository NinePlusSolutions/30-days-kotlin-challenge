package com.midterm.recycleviewdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.midterm.recycleviewdemo.adapter.Adapter;
import com.midterm.recycleviewdemo.model.Comment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvComment;
    private List<Comment> mListComment;
    private Adapter Adapter;
    private boolean isLoading = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvComment = findViewById(R.id.rv_comment);
        FloatingActionButton mSubmit = findViewById(R.id.floatingActionButton);
        getSupportActionBar().hide();


        mListComment = new ArrayList<>();
        Comment cmt1 = new Comment("Amanda","@Amanda", "Just Now", getResources().getString(R.string.comment1));
        Comment cmt2 = new Comment("Panwa","@Panwa", "2h ago", getResources().getString(R.string.comment2));
        Comment cmt3 = new Comment("Suke","@Suke", "3h ago", getResources().getString(R.string.comment1));
        Comment cmt4 = new Comment("Eric","@Eric", "4h ago", getResources().getString(R.string.comment2));
        Comment cmt5 = new Comment("Lada","@Lada", "5h ago", getResources().getString(R.string.comment2));
        Comment cmt6 = new Comment("John","@John", "6h ago", getResources().getString(R.string.comment1));
        Comment cmt7 = new Comment("Mue","@Mue", "7h ago", getResources().getString(R.string.comment1));
        Comment cmt8 = new Comment("Messi","@Messi", "8h ago", getResources().getString(R.string.comment2));
        Comment cmt9 = new Comment("Ronaldo","@Ronaldo", "9h ago", getResources().getString(R.string.comment1));
        Comment cmt10 = new Comment("Marcelo","@Marcelo", "1d ago", getResources().getString(R.string.comment1));

        mListComment.add(cmt1);
        mListComment.add(cmt2);
        mListComment.add(cmt3);
        mListComment.add(cmt4);
        mListComment.add(cmt5);
        mListComment.add(cmt6);
        mListComment.add(cmt7);
        mListComment.add(cmt8);
        mListComment.add(cmt9);
        mListComment.add(cmt10);

        Adapter = new Adapter(mListComment);
        GridLayoutManager layoutManager = new GridLayoutManager(this,1);
        rvComment.setLayoutManager(layoutManager);
        rvComment.setAdapter(Adapter);

        rvComment .addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                //dx horizontal distance scrolled in pixels
                //dy vertical distance scrolled in pixels
                super.onScrolled(recyclerView, dx, dy);

                if (dy > 0 && mSubmit.getVisibility() == View.VISIBLE) {
                    mSubmit.setVisibility(View.GONE);
                } else if (dy < 0 && mSubmit.getVisibility() != View.VISIBLE) {
                    mSubmit.setVisibility(View.VISIBLE);
                }
                if (!isLoading) {
                    //Nếu item cuối cùng của layout = với giá trị cuối của recycleView thì ta gọi hàm LoadMore
                    if (layoutManager != null && layoutManager.findLastCompletelyVisibleItemPosition() == mListComment.size() - 1) {
                        //bottom of list!
                        loadMore();
                        isLoading = true;
                    }
                }
            }
        });
    }

    private void loadMore() {
        mListComment.add(null);
        Adapter.notifyItemInserted(mListComment.size() - 1);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mListComment.remove(mListComment.size() - 1);
                int scrollPosition = mListComment.size();
                Adapter.notifyItemRemoved(scrollPosition);
                int currentSize = scrollPosition;
                int nextLimit = currentSize;

                while (currentSize - 1 < nextLimit) {
//                    Comment cmt11 = new Comment("Marcelo","@Marcelo", "1d ago", getResources().getString(R.string.comment1));
                    mListComment.add(null);
                    currentSize++;
                }
                mListComment.remove(mListComment.size() - 1);

                Adapter.notifyDataSetChanged();
                isLoading = false;
            }
        }, 2000);
    }
}