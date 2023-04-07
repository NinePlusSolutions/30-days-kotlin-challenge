package com.example.retrofitexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofitexample.Adapter.RecycleViewAdapter
import com.example.retrofitexample.Model.User
import com.example.retrofitexample.Model.UserList
import com.example.retrofitexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var viewAdapter : RecycleViewAdapter
    private lateinit var binding : ActivityMainBinding
    lateinit var viewModel : RecycleViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecycleView()
        initViewModel()
        searchUser()
        setOnClick()
    }

    fun setOnClick(){
        binding.btnCreate.setOnClickListener {
            val intent =Intent(this,CreateUserActivity::class.java)
            startActivity(intent)
        }
    }
    fun searchUser(){
        val btnSearch = binding.edtView.text.toString()
        binding.btnSearch.setOnClickListener {
            if(!TextUtils.isEmpty(binding.edtView.text.toString())){
                viewModel.searchUser(binding.edtView.text.toString())
//                Toast.makeText(this,binding.edtView.text.toString(),Toast.LENGTH_SHORT).show()
            }else{
                viewModel.getListUser()
            }
        }
    }
    fun initRecycleView(){
        binding.rcvText.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            val decorration = DividerItemDecoration(this@MainActivity,DividerItemDecoration.HORIZONTAL)
            addItemDecoration(decorration)
            viewAdapter = RecycleViewAdapter()
            adapter = viewAdapter
        }

    }
    fun initViewModel(){
        viewModel = ViewModelProvider(this).get(RecycleViewModel::class.java)
        viewModel.getUser().observe(this, Observer<List<User>> {
            if (it == null){
                Toast.makeText(this,"no result ....",Toast.LENGTH_SHORT).show()

            }else{
                viewAdapter.userList= it as MutableList<User>
                viewAdapter.notifyDataSetChanged()
            }
        })
        viewModel.getListUser()
    }
}