package com.example.loadmore

import android.graphics.BlendMode
import android.graphics.BlendModeColorFilter
import android.graphics.Color
import android.graphics.PorterDuff
import android.os.Build
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.loadmore.ViewType.VIEW_TYPE_ITEM
import com.example.loadmore.ViewType.VIEW_TYPE_LOADING
import com.example.loadmore.databinding.ItemLoadBinding
import com.example.loadmore.databinding.ItemRowBinding

object ViewType {
    val VIEW_TYPE_ITEM = 0
    val VIEW_TYPE_LOADING = 1
}

class LoadingAdapter(private var itemsCells: ArrayList<String?>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == VIEW_TYPE_ITEM) {
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.item_row, parent, false)
            ItemViewHolder(view)
        } else {
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.item_load, parent, false)

            LoadingViewHolder(view)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder.itemViewType == VIEW_TYPE_ITEM) {
            val binding = ItemRowBinding.bind(holder.itemView)
            binding.tvItem.text = itemsCells[position]
        }
    }

    override fun getItemCount(): Int = itemsCells.size

    override fun getItemViewType(position: Int): Int {
        return if (itemsCells[position] == null) {
            VIEW_TYPE_LOADING
        } else {
            VIEW_TYPE_ITEM
        }
    }

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    class LoadingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    fun addData(dataViews: ArrayList<String?>) {
        this.itemsCells.addAll(dataViews)
        notifyDataSetChanged()
    }

    fun getItemAtPosition(position: Int): String? = itemsCells[position]

    fun addLoadingView() {
        //add loading item
        Handler().post {
            itemsCells.add(null)
            notifyItemInserted(itemsCells.size)
        }
    }

    fun removeLoadingView() {
        //remove loading item
        if (itemsCells.size != 0) {
            itemsCells.removeAt(itemsCells.size - 1)
            notifyItemRemoved(itemsCells.size)
        }
    }
}