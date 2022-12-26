package com.example.livedataexample

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginUserViewModel : ViewModel() {
    var Email = MutableLiveData<String>()
    var Password = MutableLiveData<String>()
    private var userModelMutableLiveData: MutableLiveData<User>? = null
    val userDetail: MutableLiveData<User>?
        get() {
            if (userModelMutableLiveData == null) {
                userModelMutableLiveData = MutableLiveData<User>()
            }
            return userModelMutableLiveData
        }

    fun onClick(view: View?) {
        val userModel = User(Email.value, Password.value)
        userModelMutableLiveData!!.value = userModel
    }
}