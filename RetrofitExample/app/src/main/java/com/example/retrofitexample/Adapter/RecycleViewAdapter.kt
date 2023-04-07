package com.example.retrofitexample.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitexample.Model.User
import com.example.retrofitexample.R
import kotlinx.android.synthetic.main.recycleview_list.view.*

class RecycleViewAdapter : RecyclerView.Adapter<RecycleViewAdapter.ItemViewholder>(){


    var userList = mutableListOf<User>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewholder {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.recycleview_list,parent,false);
        return ItemViewholder(inflater)
    }

    override fun onBindViewHolder(holder: ItemViewholder, position: Int) {
        holder.bind(userList[position])
    }

    override fun getItemCount(): Int {
       return userList.size
    }

    class ItemViewholder(view: View):RecyclerView.ViewHolder(view){
        val textViewName = view.tvName
        val tvEmail = view.tvEmail
        val tvStats = view.tvStart

        fun bind(data :User){
            textViewName.text=data.name
            tvEmail.text=data.email
            tvStats.text = data.status
        }
    }
}


