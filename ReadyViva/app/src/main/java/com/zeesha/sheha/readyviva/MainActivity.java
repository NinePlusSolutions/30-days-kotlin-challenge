package com.zeesha.sheha.readyviva;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<Users> user_list_local;
    private static final String SP_KEY = "user_list_sp";
    private SharedPreferences sharedPreferences;
    private final Gson gson = new Gson();
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setView();
        setData();
        setAdapter();
    }

    public void setView() {
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.list_view);
    }

    public void setAdapter() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(new UserViewAdapter(user_list_local));
    }

    public void setData() {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        editor = sharedPreferences.edit();
        user_list_local = getSharedPreferences();
    }

    public void setSharedPreferences(ArrayList<Users> listData) {
        String jsonString = gson.toJson(listData);
        editor.putString(SP_KEY, jsonString);
        editor.apply();
    }


    public ArrayList<Users> getSharedPreferences() {
        String json_String = sharedPreferences.getString(SP_KEY, null);
        TypeToken typeToken = new TypeToken<ArrayList<Users>>() {
        };
        return gson.fromJson(json_String, typeToken.getType());
    }


    static class UserViewHolder extends RecyclerView.ViewHolder {
        public TextView id;
        public TextView name;
        public TextView marks;
        private final ImageView delete;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.tvId);
            name = itemView.findViewById(R.id.tvName);
            marks = itemView.findViewById(R.id.tvAge);
            delete = itemView.findViewById(R.id.ivDelete);
        }
    }

    class UserViewAdapter extends RecyclerView.Adapter {
        private final ArrayList<Users> user_list;

        public UserViewAdapter(ArrayList<Users> user_list) {
            this.user_list = user_list;
        }

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
            View view = layoutInflater.inflate(R.layout.one_item_view, viewGroup, false);
            return new UserViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
            final Users u = user_list.get(i);
            final UserViewHolder userViewHolder = (UserViewHolder) viewHolder;
            userViewHolder.id.setText(u.getId());
            userViewHolder.name.setText(u.getName());
            userViewHolder.marks.setText(u.getMarks());
            userViewHolder.delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    user_list_local.remove(u);
                    setSharedPreferences(user_list_local);
                    recyclerView.setAdapter(new UserViewAdapter(user_list_local));
                }
            });

        }

        @Override
        public int getItemCount() {
            return user_list.size();
        }
    }
}

