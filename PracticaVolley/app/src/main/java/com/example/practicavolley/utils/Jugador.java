package com.example.practicavolley.utils;

import java.io.Serializable;

public class Jugador implements Serializable {

    private String imagen, nombre, posicion;

    public Jugador(String imagen, String nombre, String posicion) {
        this.imagen = imagen;
        this.nombre = nombre;
        this.posicion = posicion;
    }

    public String getImagen() {
        return imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPosicion() {
        return posicion;
    }
}