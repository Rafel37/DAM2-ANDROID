package com.example.volleypractica.utils;

import android.widget.ImageView;
import android.widget.TextView;

public class Jugador {

    ImageView imgCaraJug;
    TextView nombreJug, posicionJug;

    public Jugador(ImageView imgCaraJug, TextView nombreJug, TextView posicionJug) {
        this.imgCaraJug = imgCaraJug;
        this.nombreJug = nombreJug;
        this.posicionJug = posicionJug;
    }

    public ImageView getImgCaraJug() {
        return imgCaraJug;
    }

    public TextView getNombreJug() {
        return nombreJug;
    }

    public TextView getPosicionJug() {
        return posicionJug;
    }
}

