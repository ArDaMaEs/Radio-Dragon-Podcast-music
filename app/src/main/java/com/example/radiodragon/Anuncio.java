package com.example.radiodragon;

public class Anuncio {
    private int imageResId;
    private String description;
    private String date;  // Nueva propiedad para la fecha

    public Anuncio(int imageResId, String description, String date) {
        this.imageResId = imageResId;
        this.description = description;
        this.date = date;
    }

    public int getImageResId() {
        return imageResId;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }
}
