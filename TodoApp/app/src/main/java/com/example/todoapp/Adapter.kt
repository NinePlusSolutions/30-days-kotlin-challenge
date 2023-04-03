package com.example.todoapp

import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.view.view.*


class Adapter(var data:List<TaskInfo>) : RecyclerView.Adapter<Adapter.ViewHoler>() {

    class ViewHoler(itemview: View):RecyclerView.ViewHolder(itemview){
        var title = itemview.tvTitle
        var priority = itemview.tvPriority
        var layout= itemview.myLayout
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHoler {
            val viewItem = LayoutInflater.from(parent.context).inflate(R.layout.view,parent,false)
        return ViewHoler(viewItem)
    }

    override fun onBindViewHolder(holder: ViewHoler, position: Int) {
        when(data[position].priority.lowercase()){
            "hight" -> holder.layout.setBackgroundColor(Color.parseColor("#FF0000"))
            "medium" ->holder.layout.setBackgroundColor(Color.parseColor("#0000FF"))
            else ->holder.layout.setBackgroundColor(Color.parseColor("#33CC33"))
        }
        holder.title.text =  data[position].title
        holder.priority.text =  data[position].priority
        holder.itemView.setOnClickListener{
            val intent = Intent(holder.itemView.context,UpdateCardActivity::class.java )
            intent.putExtra("id",position)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }
}