package com.example.joseg.joseangelgarciaoya.Util;

public class Elemento {
    private String nombre, hobby;
    private int imagen;

    public Elemento(String nombre, String hobby, int imagen) {
        this.nombre = nombre;
        this.hobby = hobby;
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public String getHobby() {
        return hobby;
    }

    public int getImagen() {
        return imagen;
    }
}
