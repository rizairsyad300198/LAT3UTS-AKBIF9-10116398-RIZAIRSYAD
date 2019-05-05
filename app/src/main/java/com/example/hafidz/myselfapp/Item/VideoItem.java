package com.example.hafidz.myselfapp.Item;

public class VideoItem {
    String title, info, assets_title;
    int fotoVideo;

    public String getTitle() {return title;}
    public String getInfo() {return info;}
    public String getAssets_title() {return assets_title;}
    public int getFotoVideo() {return fotoVideo;}

    public VideoItem(String title, String info, String assets_title, int fotoVideo) {
        this.title = title;
        this.info = info;
        this.assets_title = assets_title;
        this.fotoVideo = fotoVideo;
    }
}
