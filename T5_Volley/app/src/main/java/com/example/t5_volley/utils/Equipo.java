package com.example.t5_volley.utils;

import java.io.Serializable;

public class Equipo implements Serializable {

    String id, nombre, equipacion, escudo, estadio;

    public Equipo(String id, String nombre,  String equipacion, String escudo, String estadio) {
        this.id = id;
        this.nombre = nombre;
        this.equipacion = equipacion;
        this.escudo = escudo;
        this.estadio = estadio;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEquipacion() {
        return equipacion;
    }

    public String getEscudo() {
        return escudo;
    }

    public String getEstadio() {
        return estadio;
    }
}