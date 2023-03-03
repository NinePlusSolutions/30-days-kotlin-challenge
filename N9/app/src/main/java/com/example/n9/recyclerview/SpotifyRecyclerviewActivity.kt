package com.example.n9.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.n9.R
import com.example.n9.model.listAlbum
import com.example.n9.recyclerview.adapter.SpotifyListAdapter
import kotlinx.android.synthetic.main.activity_spotify_recyclerview.*

class SpotifyRecyclerviewActivity : AppCompatActivity() {

    companion object {
        const val SIX_PACK = 0
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spotify_recyclerview)
        rcvListItemAlbum.adapter = SpotifyListAdapter(this@SpotifyRecyclerviewActivity, listAlbum)
    }
}