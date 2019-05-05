package com.example.hafidz.myselfapp.Item;

public class GalleryItem {
    String namaFoto, infoFoto;
    int foto;

    public String getNamaFoto() {return namaFoto;}
    public String getInfoFoto() {return infoFoto;}
    public int getFoto() {return foto;}

    public GalleryItem(String namaFoto, String infoFoto, int foto) {
        this.namaFoto = namaFoto;
        this.infoFoto = infoFoto;
        this.foto = foto;
    }
}
