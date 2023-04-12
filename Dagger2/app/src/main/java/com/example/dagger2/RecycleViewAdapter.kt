package com.example.dagger2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.dagger2.model.RecyclerData
import kotlinx.android.synthetic.main.recycle_view_list.view.*

class RecycleViewAdapter : RecyclerView.Adapter<RecycleViewAdapter.MyViewHolder>(){


    private var listData: List<RecyclerData>? = null

    fun setUpData(listData:List<RecyclerData>){
        this.listData = listData

    }
    class MyViewHolder(view:View):RecyclerView.ViewHolder(view){
        val image = view.imgView
        val name = view.txtName
        val description = view.txtMail
        fun bind(data: RecyclerData){
                name.setText(data.name)
            description.setText(data.description)
            Glide.with(image)
                .load(data.owner?.avatar_url)
                .apply(RequestOptions.centerCropTransform())
                .into(image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.recycle_view_list,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(listData?.get(position)!!)
    }

    override fun getItemCount(): Int {
        if (listData == null) return 0;
        else return listData?.size!!
    }
}