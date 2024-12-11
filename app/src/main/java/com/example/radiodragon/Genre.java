package com.example.radiodragon;

import java.util.List;

public class Genre {
    private String name;
    private List<Song> songs;

    public Genre(String name, List<Song> songs) {
        this.name = name;
        this.songs = songs;
    }

    public String getName() {
        return name;
    }

    public List<Song> getSongs() {
        return songs;
    }
}


