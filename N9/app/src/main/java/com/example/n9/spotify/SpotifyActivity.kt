package com.example.n9.spotify

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.n9.R
import com.example.n9.spotify.adapter.CategoryAdapter
import kotlinx.android.synthetic.main.activity_spotify.*

class SpotifyActivity : AppCompatActivity() {
    var listIcon: ArrayList<Int> = arrayListOf(
        R.drawable.ic_download,
        R.drawable.ic_favorite,
        R.drawable.ic_download,
        R.drawable.ic_favorite,
        R.drawable.ic_download,
        R.drawable.ic_favorite,
        R.drawable.ic_download,
        R.drawable.ic_favorite,
        R.drawable.ic_download,
        R.drawable.ic_favorite,
        R.drawable.ic_download,
        R.drawable.ic_favorite,
        R.drawable.ic_download
    )
    var listTitle: ArrayList<String> = arrayListOf(
        "Download Song",
        "Download Song",
        "Download Song",
        "Download Song",
        "Download Song",
        "Download Song",
        "Download Song",
        "Download Song",
        "Download Song",
        "Download Song",
        "Download Song",
        "Download Song",
        "Download Song"


        )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spotify)
        list_item_category.adapter = CategoryAdapter(listIcon, listTitle)
    }
}