package com.example.sociallogin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth;

import com.example.sociallogin.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private lateinit var auth : FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setClick()
    }

    fun setClick(){
        auth = FirebaseAuth.getInstance()


        binding.btnLogout.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            val i  = Intent(this,MainActivity::class.java)
            startActivity(i)
        }
    }
}