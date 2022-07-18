package com.example.test_duration_4h

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter(private val listUser: ArrayList<UserModel>) :
    RecyclerView.Adapter<Adapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val userView =
            LayoutInflater.from(parent.context).inflate(R.layout.user_comment, parent, false)
        return ViewHolder(userView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentUser = listUser[position]
        holder.textViewUsername.text = currentUser.textViewUsername
        holder.textViewLocation.text = currentUser.textViewLocation
        holder.textViewTime.text = currentUser.textViewTime
    }

    override fun getItemCount(): Int {
        return listUser.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewUsername: TextView = itemView.findViewById(R.id.textViewUsername)
        val textViewLocation: TextView = itemView.findViewById(R.id.textViewLocation)
        val textViewTime: TextView = itemView.findViewById(R.id.textViewTime)

    }
}