package com.example.n9.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.n9.R
import com.example.n9.model.AlbumArtist
import com.example.n9.recyclerview.SpotifyRecyclerviewActivity
import kotlinx.android.synthetic.main.item_album.view.*

class SpotifyListAdapter(
    var context: Context,
    var list: MutableList<AlbumArtist>
) : RecyclerView.Adapter<SpotifyListAdapter.MyViewHolder>() {
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_album, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemView.title_label.text = list[position].title
        if (position == SpotifyRecyclerviewActivity.SIX_PACK)
            holder.itemView.list_item_artist.layoutManager = GridLayoutManager(context, 2)
        else {
            holder.itemView.list_item_artist.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        }
        holder.itemView.list_item_artist.adapter = ArtistAdapter(position, list[position].listArtist) //
    }

    override fun getItemViewType(position: Int): Int {
        if (position == SpotifyRecyclerviewActivity.SIX_PACK) return SpotifyRecyclerviewActivity.SIX_PACK
        return 0
    }

    override fun getItemCount(): Int {
        return list.size
    }
}