package com.example.test_duration_4h

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.test_duration_4h.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var pageAdapter: PageAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.rootView)

        // Setup adapter and fetch data on screen
        pageAdapter = PageAdapter()
        viewBinding.rvPage.adapter = pageAdapter
        pageAdapter.addData(this.mockUserData())
    }

    private fun mockUserData(): MutableList<UserModel> {
        val users = mutableListOf<UserModel>()
        users.add(UserModel(username = "Johnny", location = "Da Nang", time = "Today"))
        users.add(UserModel(username = "Johnny2", location = "Da Nang", time = "Today"))
        users.add(UserModel(username = "Johnny3", location = "Da Nang", time = "Today"))
        users.add(UserModel(username = "Johnny4", location = "Da Nang", time = "Today"))
        users.add(UserModel(username = "Johnny5", location = "Da Nang", time = "Today"))
        users.add(UserModel(username = "Johnny6", location = "Da Nang", time = "Today"))
        users.add(UserModel(username = "Johnny7", location = "Da Nang", time = "Today"))

        return users
    }
}