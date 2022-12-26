package com.example.exampleretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.exampleretrofit.adapter.AlbumAdapter
import com.example.exampleretrofit.databinding.ActivityMainBinding
import com.example.exampleretrofit.model.AlbumItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), Callback<List<AlbumItem>> {
    lateinit var recyclerView: RecyclerView
    var mPosts: MutableList<AlbumItem> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.rcvAlbum)
        recyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        recyclerView.adapter=AlbumAdapter(this,mPosts)
        initData()
    }

    fun initData(){
        API.apiService.posts.enqueue(this)
    }
    override fun onResponse(call: Call<List<AlbumItem>>, response: Response<List<AlbumItem>>) {
        if(response == null|| response.body() == null){
            return
        }
        mPosts.addAll(response.body()!!)
        recyclerView.adapter?.notifyDataSetChanged()
    }

    override fun onFailure(call: Call<List<AlbumItem>>, t: Throwable) {
        Toast.makeText(this,"Error",Toast.LENGTH_SHORT).show()
    }
}