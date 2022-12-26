package com.example.livedataexample

import android.util.Patterns

class User(var email: String?, var password: String?) {

    val isEmailValid: Boolean
        get() = Patterns.EMAIL_ADDRESS.matcher(email).matches()
    val isPasswordLenGreaterThan8: Boolean
        get() = password?.length!! > 8
}



