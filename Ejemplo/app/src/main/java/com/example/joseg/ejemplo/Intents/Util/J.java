package com.example.joseg.ejemplo.Intents.Util;

public class J {

    private String nombre;
    private int imagen;

    public String getNombre() {
        return nombre;
    }

    public int getImagen() {
        return imagen;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public J(String nombre, int imagen) {
        setNombre(nombre);
        setImagen(imagen);
    }
}
