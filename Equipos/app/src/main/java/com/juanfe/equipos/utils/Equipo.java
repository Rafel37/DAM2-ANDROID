package com.juanfe.equipos.utils;

import java.io.Serializable;

public class Equipo implements Serializable {
    String nombre, escudo,estadio,camiseta;

    public Equipo(String nombre, String escudo, String estadio, String camiseta) {
        this.nombre = nombre;
        this.escudo = escudo;
        this.estadio = estadio;
        this.camiseta = camiseta;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEscudo() {
        return escudo;
    }

    public String getEstadio() {
        return estadio;
    }

    public String getCamiseta() {
        return camiseta;
    }

    @Override
    public String toString() {
        return getNombre();
    }
}
