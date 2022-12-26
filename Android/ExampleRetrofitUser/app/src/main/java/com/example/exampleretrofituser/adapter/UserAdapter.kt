package com.example.exampleretrofituser.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.exampleretrofituser.databinding.UserItemBinding
import com.example.exampleretrofituser.model.UserModel

class UserAdapter(private val context: Context, val userList: List<UserModel>):
    RecyclerView.Adapter<UserAdapter.UserViewHolder>() {
    inner class UserViewHolder(val userBinding: UserItemBinding): RecyclerView.ViewHolder(userBinding.root) {
        fun bindingData(user: UserModel){
            userBinding.tvName.text = user.name
            userBinding.tvUserName.text = user.username
            userBinding.tvEmail.text = user.email
            userBinding.tvPhone.text = user.phone
            userBinding.tvWebsite.text = user.website
            userBinding.tvStreet.text = user.address.street
            userBinding.tvSuite.text = user.address.suite
            userBinding.tvCity.text = user.address.city
            userBinding.tvZipcode.text = user.address.zipcode
            userBinding.tvNameCompany.text = user.company.name
            userBinding.tvCatchPhrase.text = user.company.catchPhrase
            userBinding.tvBs.text = user.company.bs
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(UserItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bindingData(userList[position])
    }
}