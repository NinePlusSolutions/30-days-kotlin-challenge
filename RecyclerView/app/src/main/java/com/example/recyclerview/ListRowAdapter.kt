package com.example.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.model.User

class ListRowAdapter(private val newlist: ArrayList<User>) :
    RecyclerView.Adapter<ListRowAdapter.MyViewHolder>() {

    private var item: List<User> = ArrayList();

    var mItemList: List<String>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

            val itemView = LayoutInflater.from(parent?.context)
                .inflate(R.layout.list_row, parent, false)

            return MyViewHolder(itemView)


    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var currentItem = newlist[position]
        holder.tName.text = currentItem.username
        holder.txtComment.text = currentItem.comment
        holder.ttimage.setImageResource(currentItem.image)

    }

    override fun getItemCount(): Int {
        return newlist.size
    }


    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ttimage: ImageView = itemView.findViewById(R.id.imgAvatar)
        val tName: TextView = itemView.findViewById(R.id.txtName)
        val txtComment: TextView = itemView.findViewById(R.id.txtComment)
    }

    private fun populateItemRows(viewHolder: MyViewHolder, position: Int) {
        var currentItem = newlist[position]
        viewHolder.tName.text = currentItem.username
        viewHolder.txtComment.text = currentItem.comment
        viewHolder.ttimage.setImageResource(currentItem.image)
    }
}


