package com.example.juan.examenjcique4.utils;

import java.io.Serializable;

public class Practica implements Serializable {

    String nombre;

    public Practica(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

}
