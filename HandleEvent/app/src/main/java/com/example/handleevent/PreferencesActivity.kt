package com.example.handleevent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.handleevent.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_preferences.*

class PreferencesActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPref=getSharedPreferences("myRef", MODE_PRIVATE)
        val editor=sharedPref.edit()

        binding.apply {
            btnSave.setOnClickListener {
                val username=edtUser.text.toString()
                val email=edtEmail.text.toString()
                editor.apply {
                    putString("username",username)
                    putString("email",email)
                    apply()
                }
            }
            btnLoad.setOnClickListener {
                val  username=sharedPref.getString("username",null)
                val  email=sharedPref.getString("email",null)

                tvUseName.text=username
                tvMail.text=email
            }
        }
    }
}