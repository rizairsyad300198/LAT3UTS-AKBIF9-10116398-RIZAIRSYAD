package com.example.hafidz.myselfapp.Item;

public class MusicItem {
    String title, artist, assets_title;
    int fotoMusic;

    public String getTitle() {return title;}
    public String getArtist() {return artist;}
    public String getAssets_title() {return assets_title;}
    public int getFotoMusic() {return fotoMusic;}

    public MusicItem(String title, String artist, String assets_title, int fotoMusic) {
        this.title = title;
        this.artist = artist;
        this.assets_title = assets_title;
        this.fotoMusic = fotoMusic;
    }
}
