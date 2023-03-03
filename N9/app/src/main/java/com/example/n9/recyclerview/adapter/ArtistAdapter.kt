package com.example.n9.recyclerview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.n9.R
import com.example.n9.model.Artist
import com.example.n9.recyclerview.SpotifyRecyclerviewActivity
import kotlinx.android.synthetic.main.item_artist.view.*
import kotlinx.android.synthetic.main.item_category.view.*
import kotlinx.android.synthetic.main.item_category.view.icon_download
import kotlinx.android.synthetic.main.item_category.view.text_content

class ArtistAdapter(
    var indexPack: Int,
    var list: MutableList<Artist>
) : RecyclerView.Adapter<ArtistAdapter.MyViewHolder>() {
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return if (indexPack == SpotifyRecyclerviewActivity.SIX_PACK)
            MyViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_category, parent, false)
            )
        else
            MyViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_artist, parent, false)
            )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = list[position]
        if (indexPack == SpotifyRecyclerviewActivity.SIX_PACK) {
            holder.itemView.icon_download.setImageResource(item.img)
            holder.itemView.text_content.text = item.name
        } else {
            holder.itemView.icon_download_square.setImageResource(item.img)
            holder.itemView.text_content_square.text = item.name
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}