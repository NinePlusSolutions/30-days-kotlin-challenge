package com.ngockhanh.recyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import com.ngockhanh.recyclerview.model.User;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle bundle = getIntent().getExtras();
        if(bundle == null){
            return;
        }
        User  user = (User) bundle.get("user");
        TextView tvName = findViewById(R.id.tvNameDetail);
        TextView tvComment = findViewById(R.id.tvCommentDetail);
        ImageButton btnLike = findViewById(R.id.btnLikeDetail);
        tvName.setText(user.getName());
        tvComment.setText(user.getComment());
        if(user.getLike()){
            btnLike.setImageResource(R.drawable.ic_baseline_favorite_24_red);
        }

    }
}