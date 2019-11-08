package com.example.t5_volley.utils;

public class Jugador {

    String nombre, imagen, posicion;

    public Jugador(String nombre, String imagen, String posicion) {
        this.nombre = nombre;
        this.imagen = imagen;
        this.posicion = posicion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public String getPosicion() {
        return posicion;
    }
}
