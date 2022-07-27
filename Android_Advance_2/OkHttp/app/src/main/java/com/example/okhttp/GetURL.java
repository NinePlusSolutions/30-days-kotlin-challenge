package com.example.okhttp;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class GetURL extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_url);

        Button btnGetIt = findViewById(R.id.btnGetIt);
        EditText edtURL = findViewById(R.id.edtURL);

        btnGetIt.setOnClickListener(view -> new GetThisURL().execute("http://"+edtURL.getText().toString().trim()));

        Button btnGetBack = findViewById(R.id.btnGetBack);

        btnGetBack.setOnClickListener(view -> {
            Intent intent = new Intent(GetURL.this, MainActivity.class);
            startActivity(intent);
        });
    }

    class GetThisURL extends AsyncTask<String, String, String> {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .build();
        TextView tvURL = findViewById(R.id.tvURL);

        @Override
        protected String doInBackground(String... strings) {

            Request.Builder builder = new Request.Builder();
            builder.url(strings[0]);

            Request request = builder.build();

            try {
                Response response = okHttpClient.newCall(request).execute();
                return Objects.requireNonNull(response.body()).string();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            if (!result.equals("")) {
                tvURL.append(result);
            } else {
                Toast.makeText(GetURL.this, "Error on your URL", Toast.LENGTH_LONG).show();
            }
            super.onPostExecute(result);
        }
    }
}