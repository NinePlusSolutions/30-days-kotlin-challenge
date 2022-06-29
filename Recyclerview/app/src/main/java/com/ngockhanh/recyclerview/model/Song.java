package com.ngockhanh.recyclerview.model;

public class Song {
    private int idSong;
    private String nameSong;

    public Song(int idSong,String nameSong){
        this.idSong = idSong;
        this.nameSong = nameSong;
    }

    public Song(){
    }

    public int getIdSong() {
        return idSong;
    }

    public void setIdSong(int idSong) {
        this.idSong = idSong;
    }

    public String getNameSong() {
        return nameSong;
    }

    public void setNameSong(String nameSong) {
        this.nameSong = nameSong;
    }
}
