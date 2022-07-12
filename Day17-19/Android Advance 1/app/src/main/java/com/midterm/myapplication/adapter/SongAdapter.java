package com.midterm.myapplication.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.midterm.myapplication.R;
import com.midterm.myapplication.model.Song;

import java.util.List;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.SongViewHolder> {
    private List<Song> mSongList;

    public SongAdapter(List<Song> mSongList) {
        this.mSongList = mSongList;
    }

    @NonNull
    @Override
    public SongViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 2) {
            return new SongViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_song2, parent, false));
        }
        return new SongViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_song1, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull SongViewHolder holder, int position) {
        Song song = mSongList.get(position);
        if (song == null) {
            return;
        }
        holder.tvIdSong.setText(Integer.toString(song.getIdSong()));
        holder.tvNameSong.setText(song.getNameSong());
    }

    @Override
    public int getItemCount() {
        if (mSongList != null) {
            return mSongList.size();
        }
        return 0;
    }

    @Override
    public int getItemViewType(int position) {
        if ((position + 1) % 5 * 2 == 0) {

            return 2;
        }
        return 1;
    }

    public class SongViewHolder extends RecyclerView.ViewHolder {
        private TextView tvIdSong, tvNameSong;

        public SongViewHolder(@NonNull View itemView) {
            super(itemView);
            tvIdSong = itemView.findViewById(R.id.tv_song_id);
            tvNameSong = itemView.findViewById(R.id.tv_song_name);
        }
    }
}
