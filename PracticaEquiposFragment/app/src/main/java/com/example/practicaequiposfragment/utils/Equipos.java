package com.example.practicaequiposfragment.utils;

import java.io.Serializable;
import java.util.ArrayList;

public class Equipos implements Serializable {

    int imagen;
    String titulo, detalle;


    public Equipos(int imagen, String titulo, String detalle) {
        this.imagen = imagen;
        this.titulo = titulo;
        this.detalle = detalle;
    }

    public int getImagen() {
        return imagen;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDetalle() {
        return detalle;
    }
}

