package com.example.n9.spotify.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.n9.R
import kotlinx.android.synthetic.main.item_category.view.*

class CategoryAdapter(
    var icon: MutableList<Int>,
    var title: MutableList<String>


): RecyclerView.Adapter<CategoryAdapter.MyViewHolder>() {
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return CategoryAdapter.MyViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_category, parent, false)
        )

    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val itemIcon = icon[position]
        val itemTitle  = title[position]
        holder.itemView.text_content.text = itemTitle
        holder.itemView.icon_download.setImageResource(itemIcon)

    }

    override fun getItemCount(): Int {
        return icon.size
    }


}