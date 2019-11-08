package com.example.root.recyclerandroid.utils;

public class Persona {

    String nombre;
    int imagen;

    public Persona(String nombre, int imagen) {
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