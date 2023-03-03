package com.example.n9.login

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.n9.R
import com.example.n9.calculator2.CalculateActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        registerAccount()
    }

    private fun registerAccount() {
        val sharedPreference = getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE)
        val editor = sharedPreference.edit()

        username.setText(sharedPreference.getString("username", "").toString())
        password.setText(sharedPreference.getString("password", "").toString())
        Log.d("here", sharedPreference.getString("username", "").toString())
        Log.d("here", sharedPreference.getString("password", "").toString())

        btn_register.setOnClickListener {
            Log.d("here", sharedPreference.getString("username", "").toString())
            Log.d("here", sharedPreference.getString("password", "").toString())
            editor.putString("username", username.text.toString())// save
            editor.putString("password", password.text.toString())
            editor.commit() //
            Log.d("here", "dang ky thanh cong")

        }

        btn_login.setOnClickListener {
            Log.d("here", username.text.toString())
            Log.d("here", password.text.toString())
            Log.d("here1", sharedPreference.getString("username", "").toString())
            Log.d("here1", sharedPreference.getString("password", "").toString())
            if (username.text.toString() ==
                    sharedPreference.getString("username", "").toString()
                 && password.text.toString() == sharedPreference.getString("password", "").toString()
            ) {

                startActivity(Intent(this, CalculateActivity::class.java))
                finish()
                Log.d("here", "dang nhap thanh cong")
            } else
                Log.d("here", "dang nhap that bai")

        }
    }
}