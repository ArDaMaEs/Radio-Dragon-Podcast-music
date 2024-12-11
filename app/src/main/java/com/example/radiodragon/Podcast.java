package com.example.radiodragon;

import java.util.List;

public class Podcast {
    private int imageResId; // ID del recurso de imagen
    private String title; // Título del podcast
    private List<String> audioUrls; // URLs de los audios

    public Podcast(int imageResId, String title, List<String> audioUrls) {
        this.imageResId = imageResId;
        this.title = title;
        this.audioUrls = audioUrls; // Cambiado de audioTitles a audioUrls
    }

    public int getImageResId() {
        return imageResId;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getAudioUrls() { // Cambiado de getAudioTitles a getAudioUrls
        return audioUrls;
    }
}
