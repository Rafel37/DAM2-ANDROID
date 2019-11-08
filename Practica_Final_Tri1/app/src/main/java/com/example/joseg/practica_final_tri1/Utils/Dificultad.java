package com.example.joseg.practica_final_tri1.Utils;

import java.io.Serializable;

public class Dificultad implements Serializable {

    private String nombre;
    private int imagen;

    public Dificultad(String nombre, int imagen) {
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
