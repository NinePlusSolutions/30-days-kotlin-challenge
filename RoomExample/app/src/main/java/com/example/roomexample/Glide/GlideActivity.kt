package com.example.roomexample.Glide

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.Glide.with
import com.example.roomexample.R
import com.example.roomexample.databinding.ActivityGlideBinding
import com.squareup.picasso.Picasso

class GlideActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGlideBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityGlideBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setOnClick()


    }
    fun setOnClick(){
        binding.btnLoad.setOnClickListener {
            var url="https://haycafe.vn/wp-content/uploads/2022/02/anh-meo-cute-hinh-cute-meo.jpg"
//            Glide.with(this)
//                .load(url)
//                .into(binding.imGlide)


            Picasso.get().load(url).into(binding.imGlide)/// load ảnh lâu hơn glide
        }
    }
}