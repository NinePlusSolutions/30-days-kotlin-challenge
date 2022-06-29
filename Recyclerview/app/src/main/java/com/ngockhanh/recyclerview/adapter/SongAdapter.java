package com.ngockhanh.recyclerview.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ngockhanh.recyclerview.R;
import com.ngockhanh.recyclerview.model.Song;

import java.util.List;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.SongViewHolder> {

    private List<Song> mSongList;

    public SongAdapter(List<Song> mSongList){
        this.mSongList = mSongList;
    }

    @NonNull
    @Override
    public SongViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_song,parent,false);
        return new SongViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SongViewHolder holder, int position) {
        Song song = mSongList.get(position);
        if(song == null){
            return;
        }
        holder.tvIdSong.setText(Integer.toString(song.getIdSong()));
        holder.tvNameSong.setText(song.getNameSong());
    }

    @Override
    public int getItemCount() {
        if(mSongList != null){
            return mSongList.size();
        }
        return 0;
    }

    class SongViewHolder extends RecyclerView.ViewHolder{
        private TextView tvIdSong,tvNameSong;
        public SongViewHolder(@NonNull View itemView) {
            super(itemView);
            tvIdSong = itemView.findViewById(R.id.tv_song_id);
            tvNameSong = itemView.findViewById(R.id.tv_song_name);
        }
    }
}
