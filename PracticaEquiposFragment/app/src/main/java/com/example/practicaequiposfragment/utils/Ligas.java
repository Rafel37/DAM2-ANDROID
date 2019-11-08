package com.example.practicaequiposfragment.utils;

import java.io.Serializable;
import java.util.ArrayList;

public class Ligas implements Serializable {

    int imagen;
    String titulo;

    ArrayList equipos;

    public Ligas(int imagen, String titulo) {
        this.imagen = imagen;
        this.titulo = titulo;
        equipos = new ArrayList();
    }

    public int getImagen() {
        return imagen;
    }

    public String getTitulo() {
        return titulo;
    }

    public ArrayList getEquipoLiga() {
        return equipos;
    }
}
