package com.example.retrofitexample

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.retrofitexample.Model.Database
import com.example.retrofitexample.Model.User
import com.example.retrofitexample.Model.UserList
import com.example.retrofitexample.Model.getClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class RecycleViewModel : ViewModel() {
    var listRecycle: MutableLiveData<List<User>> = MutableLiveData()

    fun getUser(): MutableLiveData<List<User>> {
        return listRecycle
    }

    fun getListUser() {
        val retroInstance = Database.getRetroInstance().create(getClient::class.java)
        val call =
            retroInstance.getUserList()
        call.enqueue(object : Callback<List<User>> {
            override fun onResponse(
                call: Call<List<User>>,
                response: Response<List<User>>
            ) {
                if (response.isSuccessful) {
                    listRecycle.postValue(response.body())
                } else {
                    listRecycle.postValue(null)
                }
            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                listRecycle.postValue(null)
            }
        })
    }

    fun searchUser(searchText: String) {
        val retroInstance = Database.getRetroInstance().create(getClient::class.java)
        val call = retroInstance.seacherUser(
            searchText
        )
        call.enqueue(object : Callback<List<User>> {

            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                listRecycle.postValue(null)

            }

            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                if (response.isSuccessful) {
                    listRecycle.postValue(response.body())
                } else {
                    listRecycle.postValue(null)
                }
            }

        })
    }
}