package com.example.smd_aftermid.CardViewExample;

public class my_model {
    public String Name;
    public int total_downloads;
    public int thumbnail;


    public my_model() {
    }

    public my_model(String name, int total_downloads, int thumbnail) {
        Name = name;
        this.total_downloads = total_downloads;
        this.thumbnail = thumbnail;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getTotal_downloads() {
        return total_downloads;
    }

    public void setTotal_downloads(int total_downloads) {
        this.total_downloads = total_downloads;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }
}
