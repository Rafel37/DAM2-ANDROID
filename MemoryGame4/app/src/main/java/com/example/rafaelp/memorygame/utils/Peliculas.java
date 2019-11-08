package com.example.rafaelp.memorygame.utils;

import java.io.Serializable;

public class Peliculas implements Serializable {
    String nombre;
    int imagen;

    public Peliculas(String nombre, int imagen) {
        this.nombre = nombre;
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public int getImagen() {
        return imagen;
    }
}