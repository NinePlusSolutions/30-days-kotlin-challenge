package com.example.navigationdrawer

import android.content.ClipData
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.*
import com.google.android.material.imageview.ShapeableImageView
import kotlinx.android.synthetic.main.card_recycler.view.*
import java.sql.Time

class MyAdapter(private val newsList: ArrayList<News>) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.card_recycler, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = newsList[position]
        holder.tvHeading.text = currentItem.heading
        holder.tvName.text = currentItem.naming
        holder.tvAddress.text = currentItem.addressing
        holder.tvTime.text = currentItem.timing
    }

    override fun getItemCount(): Int {
        return newsList.size

    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvHeading: TextView = itemView.findViewById(R.id.textNd)
        val tvName : TextView = itemView.findViewById(R.id.textName)
        val tvAddress: TextView = itemView.findViewById(R.id.textAddress)
        val tvTime: TextView = itemView.findViewById(R.id.textTime)
    }


}