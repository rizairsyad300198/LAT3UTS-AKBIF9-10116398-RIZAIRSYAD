package com.example.hafidz.myselfapp.Item;

public class FriendlistItem {
    String namaTeman, infoTeman;
    int fotoTeman;

    public String getNamaTeman() {return namaTeman;}
    public String getInfoTeman() {return infoTeman;}
    public int getFotoTeman() {return fotoTeman;}

    public FriendlistItem(String namaTeman, String infoTeman, int fotoTeman) {
        this.namaTeman = namaTeman;
        this.infoTeman = infoTeman;
        this.fotoTeman = fotoTeman;
    }
}
