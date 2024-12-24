package com.example.crudapps.dataset;

public class ItemData {
    String title;
    String id;
    String images;
    int jumlah;
    public ItemData(String id, String title, int jumlah, String images){
        this.id = id;
        this.title = title;
        this.jumlah = jumlah;
        this.images = images;
    }

    public String getImages() {
        return images;
    }

    public String getTitle() {
        return title;
    }

    public String getId() {
        return id;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int i) {
        this.jumlah = i;
    }
}
