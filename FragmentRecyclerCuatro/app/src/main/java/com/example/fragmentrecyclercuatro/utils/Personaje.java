package com.example.fragmentrecyclercuatro.utils;

public class Personaje {

    String nombre, tipo;
    int imagen;

    public Personaje(String nombre, String tipo, int imagen) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public int getImagen() {
        return imagen;
    }
}
