package com.ngockhanh.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.ngockhanh.recyclerview.adapter.SongAdapter;
import com.ngockhanh.recyclerview.model.Song;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rv_Song;
    private List<Song> mListSong;
    private SongAdapter songAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv_Song = findViewById(R.id.rv_song);
        mListSong = new ArrayList<>();
        Song song1 = new Song(1,"Happy");
        Song song2 = new Song(2,"Heat Waves");
        Song song3 = new Song(3,"I am not the only one");
        Song song4 = new Song(4,"Memories");
        Song song5 = new Song(5,"Vi ngay hom nay em cuoi roi");

        mListSong.add(song1);
        mListSong.add(song2);
        mListSong.add(song3);
        mListSong.add(song4);
        mListSong.add(song5);

        songAdapter = new SongAdapter(mListSong);
        rv_Song.setAdapter(songAdapter);
        DividerItemDecoration decoration = new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        rv_Song.addItemDecoration(decoration);
        rv_Song.setLayoutManager(new LinearLayoutManager(this));

    }
}