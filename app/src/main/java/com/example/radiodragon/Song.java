package com.example.radiodragon;

public class Song {
    private String title;
    private String url;
    private int albumImageResId; // Nueva propiedad para la imagen del álbum

    public Song(String title, String url, int albumImageResId) {
        this.title = title;
        this.url = url;
        this.albumImageResId = albumImageResId;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public int getAlbumImageResId() {
        return albumImageResId;
    }
}
