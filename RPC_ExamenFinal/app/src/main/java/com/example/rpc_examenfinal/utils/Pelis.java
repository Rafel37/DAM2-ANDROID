package com.example.rpc_examenfinal.utils;

public class Pelis {

    String nombre;
    double puntuacion;

    public Pelis(String nombre, double puntuacion) {
        this.nombre = nombre;
        this.puntuacion = puntuacion;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPuntuacion() {
        return puntuacion;
    }
}
