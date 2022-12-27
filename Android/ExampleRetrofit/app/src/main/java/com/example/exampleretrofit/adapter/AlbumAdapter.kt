package com.example.exampleretrofit.adapter

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup


import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.exampleretrofit.databinding.AlbumItemBinding
import com.example.exampleretrofit.model.AlbumItem


class AlbumAdapter(private val context: Context, val albumList: List<AlbumItem>):
    RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder>() {

    inner class AlbumViewHolder(val itemBinding: AlbumItemBinding): RecyclerView.ViewHolder(itemBinding.root) {
        fun bindItem(album: AlbumItem){
            itemBinding.tvId.text = album.id.toString()
            itemBinding.tvTitle.text = album.title
            itemBinding.tvUrl.text = album.url
            Glide.with(context).load(Uri.parse(album.thumbnailUrl +".jpg")).into(itemBinding.imvThumbnail)

        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        return AlbumViewHolder(AlbumItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        val album = albumList[position]
        holder.bindItem(album)
    }

    override fun getItemCount(): Int {
        return albumList.size
    }
}
