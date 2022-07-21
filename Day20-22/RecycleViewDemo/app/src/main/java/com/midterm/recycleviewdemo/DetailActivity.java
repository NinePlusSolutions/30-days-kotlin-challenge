package com.midterm.recycleviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import com.midterm.recycleviewdemo.adapter.RecycleViewAdapter;
import com.midterm.recycleviewdemo.databinding.ActivityDetailBinding;
import com.midterm.recycleviewdemo.model.Comment;

import java.util.Objects;

public class DetailActivity extends AppCompatActivity {
    TextView tvCommentDetailUserName, tvCommentDetailUserTagName, tvCommentDetailContent, tvDetailCommentTime;
    ImageButton btnLike;
    private ActivityDetailBinding binding;
    public static final String EXTRA_DATA = "EXTRA_DATA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        Bundle bundle = getIntent().getExtras();
        if(bundle == null){
            return;
        }
        Comment comment = (Comment) bundle.get("comment");
        getData(comment);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    @Override
    public void onBackPressed() {
        finish();
    }



    private void getData(Comment comment){
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        tvCommentDetailUserName = binding.tvCommentDetailUserName;
        tvCommentDetailUserTagName = binding.tvCommentDetailUserTagName;
        tvDetailCommentTime = binding.tvDetailCommentTime;
        tvCommentDetailContent = binding.tvCommentDetailContent;
        btnLike = binding.btnLikeDetail;

        tvCommentDetailUserName.setText(comment.getCommentUserName());
        tvCommentDetailUserTagName.setText(comment.getCommentUserTagName());
        tvDetailCommentTime.setText(comment.getCommentTime());
        tvCommentDetailContent.setText(comment.getCommentContent());
        
        if(!comment.getLike()){
            btnLike.setImageResource(R.drawable.ic_baseline_favorite_border_24);
        }
        else{
            btnLike.setImageResource(R.drawable.ic_baseline_favorite_24);
        }
        btnLike.setOnClickListener(view -> {
            onLikeClick(comment);
        });
    }

    private void onLikeClick(Comment comment){
        if(!comment.getLike()){
            comment.setLike(true);
            btnLike.setImageResource(
                    R.drawable.ic_baseline_favorite_24
            );
        }
        else{
            comment.setLike(false);
            btnLike.setImageResource(
                    R.drawable.ic_baseline_favorite_border_24
            );
        }

        Intent data = new Intent();
        data.putExtra(EXTRA_DATA, comment);
        setResult(Activity.RESULT_OK, data);
    }
}