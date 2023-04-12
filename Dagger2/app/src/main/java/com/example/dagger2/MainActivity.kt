package com.example.dagger2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dagger2.databinding.ActivityMainBinding
import com.example.dagger2.model.RecyclerList

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var recycleViewAdapter: RecycleViewAdapter
    private lateinit var mainActivityViewModel: MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
        initModel()
    }


   private fun initRecyclerView(){
       binding.rcvDagger.layoutManager = LinearLayoutManager(this)
       recycleViewAdapter = RecycleViewAdapter()
       binding.rcvDagger.adapter = recycleViewAdapter
   }


    private fun initModel(){
       mainActivityViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        mainActivityViewModel.getLiveDataObserve().observe(this,object :Observer<RecyclerList>{
            override fun onChanged(t: RecyclerList?) {
                if (t != null){
                    recycleViewAdapter.setUpData(t.items)
                    recycleViewAdapter.notifyDataSetChanged()
                }else{
                    Toast.makeText(this@MainActivity,"error in getting the date",Toast.LENGTH_SHORT).show()
                }
            }
        })
        mainActivityViewModel.makeApiCall()
    }
}