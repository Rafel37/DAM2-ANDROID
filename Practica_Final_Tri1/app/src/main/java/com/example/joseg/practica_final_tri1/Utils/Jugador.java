package com.example.joseg.practica_final_tri1.Utils;

import java.io.Serializable;

public class Jugador implements Serializable {

    private String nombre;
    private int puntuacion , icono;

    public String getNombre() {
        return nombre;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public int getIcono() {
        return icono;
    }

    public Jugador(String nombre, int puntuacion, int icono) {
        this.nombre = nombre;
        this.puntuacion = puntuacion;
        this.icono = icono;
    }
}
