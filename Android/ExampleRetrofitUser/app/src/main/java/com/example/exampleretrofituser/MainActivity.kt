package com.example.exampleretrofituser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.exampleretrofituser.adapter.UserAdapter
import com.example.exampleretrofituser.model.UserModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), Callback<List<UserModel>> {
    private lateinit var recycleView: RecyclerView
    var mPost: MutableList<UserModel> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recycleView = findViewById(R.id.rcvUserList)
        recycleView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        recycleView.adapter = UserAdapter(this,mPost)
        initData()
    }

    private fun initData() {
        API.apiService.posts.enqueue(this)
    }

    override fun onResponse(call: Call<List<UserModel>>, response: Response<List<UserModel>>) {
        if (response == null || response.body() == null){
            return
        }
        mPost.addAll(response.body()!!)
        recycleView.adapter?.notifyDataSetChanged()
    }

    override fun onFailure(call: Call<List<UserModel>>, t: Throwable) {
        Toast.makeText(this,"Error",Toast.LENGTH_SHORT).show()
    }
}