package com.ngockhanh.recyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.ngockhanh.recyclerview.model.User;

import java.util.Objects;

public class DetailActivity extends AppCompatActivity {

    @Override
    public void onBackPressed() {
        finish();
    }
    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

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
        btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!user.getLike()){
                    user.setLike(true);
                    btnLike.setImageResource(R.drawable.ic_baseline_favorite_24_red);
                } else {
                    user.setLike(false);
                    btnLike.setImageResource(R.drawable.ic_outline_favorite_border_24);
                }
                Intent resultIntent = new Intent();
                resultIntent.putExtra("user",user);
                setResult(Activity.RESULT_OK,resultIntent);
            }
        });

    }
}