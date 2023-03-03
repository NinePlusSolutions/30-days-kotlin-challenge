package com.example.n9.model

import com.example.n9.R

data class Artist(
    val img: Int,
    val name: String
)

data class AlbumArtist(
    val title: String,
    val listArtist: MutableList<Artist>
)

var listAlbum = mutableListOf(
    AlbumArtist(
        "Good Evening",
        mutableListOf(
            Artist(R.drawable.img, "Ngoc Van"),
            Artist(R.drawable.img, "Ngoc Van"),
            Artist(R.drawable.img, "Ngoc Van"),
            Artist(R.drawable.img, "Ngoc Van"),
            Artist(R.drawable.img, "Ngoc Van"),
            Artist(R.drawable.img, "Ngoc Van"),
        )
    ),
    AlbumArtist(
        "Trending Music",
        mutableListOf(
            Artist(R.drawable.ic_download, "Ngoc Van"),
            Artist(R.drawable.ic_download, "Ngoc Van"),
            Artist(R.drawable.ic_download, "Ngoc Van"),
            Artist(R.drawable.ic_download, "Ngoc Van"),
            Artist(R.drawable.ic_download, "Ngoc Van"),
            Artist(R.drawable.ic_download, "Ngoc Van"),
        )
    ),
    AlbumArtist(
        "Your playlists",
        mutableListOf(
            Artist(R.drawable.ic_favorite, "Ngoc Van"),
            Artist(R.drawable.ic_favorite, "Ngoc Van"),
            Artist(R.drawable.ic_favorite, "Ngoc Van"),
            Artist(R.drawable.ic_favorite, "Ngoc Van"),
            Artist(R.drawable.ic_favorite, "Ngoc Van"),
            Artist(R.drawable.ic_favorite, "Ngoc Van"),
        )
    ),
    AlbumArtist(
        "Recently played",
        mutableListOf(
            Artist(R.drawable.ic_launcher_foreground, "Ngoc Van"),
            Artist(R.drawable.ic_launcher_foreground, "Ngoc Van"),
            Artist(R.drawable.ic_launcher_foreground, "Ngoc Van"),
            Artist(R.drawable.ic_launcher_foreground, "Ngoc Van"),
            Artist(R.drawable.ic_launcher_foreground, "Ngoc Van"),
            Artist(R.drawable.ic_launcher_foreground, "Ngoc Van"),
        )
    ),

)
