package com.juanfe.equipos.utils;

public class Jugador {
    String nombre, imagen,psicion;

    public Jugador(String nombre, String imagen, String psicion) {
        this.nombre = nombre;
        this.imagen = imagen;
        this.psicion = psicion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public String getPsicion() {
        return psicion;
    }
}
