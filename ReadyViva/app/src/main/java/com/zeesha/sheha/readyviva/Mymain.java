package com.zeesha.sheha.readyviva;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class Mymain extends AppCompatActivity {
    private ArrayList<Users> user_list;
    private static final String SP_KEY = "user_list_sp";
    private SharedPreferences sharedPreferences;
    private Button save, go;
    private ImageView delete;
    private EditText id, name, marks;
    private final Gson gson = new Gson();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mymain);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        user_list = getSharedPreferences();
        save = findViewById(R.id.btnSave);
        go = findViewById(R.id.btnGo);
        delete = findViewById(R.id.ivDelete);
        id = findViewById(R.id.edtId);
        name = findViewById(R.id.edtName);
        marks = findViewById(R.id.edtMark);

        Click();

    }

    public void Click() {
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!id.getText().toString().isEmpty() && !name.getText().toString().isEmpty() && !marks.getText().toString().isEmpty()) {

                    addData();

                    Toast.makeText(getApplicationContext(), "Saved", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(i);
                }
            }
        });

        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });
    }

    private void clear() {
        id.setText("");
        name.setText("");
        marks.setText("");
    }

    public void addData() {
        user_list.add(new Users(id.getText().toString(), name.getText().toString(), marks.getText().toString()));
        Gson gson = new Gson();
        String jsonString = gson.toJson(user_list);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(SP_KEY, jsonString);
        editor.apply();
        clear();
    }

    //dung khi tat app tao lai thi van giu lai data
    public ArrayList<Users> getSharedPreferences() {
        String json_String = sharedPreferences.getString(SP_KEY, null);
        TypeToken typeToken = new TypeToken<ArrayList<Users>>() {
        };
        return gson.fromJson(json_String, typeToken.getType());
    }

}

