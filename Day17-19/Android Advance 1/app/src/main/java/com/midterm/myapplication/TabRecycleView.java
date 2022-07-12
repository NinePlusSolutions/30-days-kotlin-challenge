package com.midterm.myapplication;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.midterm.myapplication.adapter.SongAdapter;
import com.midterm.myapplication.model.Song;

import java.util.ArrayList;
import java.util.List;


public class TabRecycleView extends Fragment {

    private Context thiscontext;

    public TabRecycleView() {
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        thiscontext=context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tab_recycleview,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        List<Song> mListSong = new ArrayList<>();
        Song song1 = new Song(1,"Happy");
        Song song2 = new Song(2,"Heat Waves");
        Song song3 = new Song(3,"I am not the only one");
        Song song4 = new Song(4,"Memories");
        Song song5 = new Song(5,"Vi ngay hom nay em cuoi roi");
        Song song6 = new Song(6,"1992");
        Song song7 = new Song(7,"Toi biet");
        Song song8 = new Song(8,"Pkl");
        Song song9 = new Song(9,"Quen em");
        Song song10 = new Song(10,"Vi toi con song");
        mListSong.add(song1);
        mListSong.add(song2);
        mListSong.add(song3);
        mListSong.add(song4);
        mListSong.add(song5);
        mListSong.add(song6);
        mListSong.add(song7);
        mListSong.add(song8);
        mListSong.add(song9);
        mListSong.add(song10);
        SongAdapter songAdapter = new SongAdapter(mListSong);

        RecyclerView rvSong = view.findViewById(R.id.rv_song);
        GridLayoutManager layoutManager = new GridLayoutManager(thiscontext,2);
        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if((position+1)% 5 *2 == 0){
                    return 2;
                } else {
                    return 1;
                }
            }
        });
        rvSong.setLayoutManager(layoutManager);
        rvSong.setAdapter(songAdapter);
    }
}
