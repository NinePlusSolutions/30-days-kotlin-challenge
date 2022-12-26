package com.example.livedataexample

import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.livedataexample.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {

    private var loginViewModel: LoginUserViewModel? = null
    private var activityMainBinding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = DataBindingUtil.setContentView(this@MainActivity, R.layout.activity_main)

        loginViewModel = ViewModelProviders.of(this)[LoginUserViewModel::class.java]

        activityMainBinding?.lifecycleOwner = this

        activityMainBinding?.loginUserViewModel = loginViewModel

        loginViewModel?.userDetail?.observe(this
        ) { user ->
            if (TextUtils.isEmpty(Objects.requireNonNull(user)?.email)) {
                activityMainBinding?.tvEmail?.error = "Please Enter Email"
                activityMainBinding?.tvEmail?.requestFocus()
            } else if (!user?.isEmailValid!!) {
                activityMainBinding?.tvEmail?.error = "Please Enter a valid email"
                activityMainBinding?.tvEmail?.requestFocus()
            } else if (TextUtils.isEmpty(Objects.requireNonNull(user).password)) {
                activityMainBinding?.tvPassword?.error = "Please Enter Password"
                activityMainBinding?.tvPassword?.requestFocus()
            } else if (!user.isPasswordLenGreaterThan8) {
                activityMainBinding?.tvPassword?.error = "Please Enter Password Greater Than 8"
                activityMainBinding?.tvPassword?.requestFocus()
            } else {
                Toast.makeText(this@MainActivity, user.email, Toast.LENGTH_LONG).show()
                Toast.makeText(this@MainActivity, user.password, Toast.LENGTH_LONG).show()
            }
        }
    }
}



