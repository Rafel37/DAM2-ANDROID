package com.example.practicavolley.utils;

import java.io.Serializable;

public class Equipo implements Serializable {

    private String id, nombre, imEscudo, imEstadio, imCamiseta;

    public Equipo(String id, String nombre, String imCamiseta, String imEscudo, String imEstadio) {
        this.id = id;
        this.nombre = nombre;
        this.imCamiseta = imCamiseta;
        this.imEscudo = imEscudo;
        this.imEstadio = imEstadio;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getImEscudo() {
        return imEscudo;
    }

    public String getImEstadio() {
        return imEstadio;
    }

    public String getImCamiseta() {
        return imCamiseta;
    }
}