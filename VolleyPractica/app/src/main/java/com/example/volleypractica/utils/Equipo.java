package com.example.volleypractica.utils;

public class Equipo {

    int camiseta, escudo, estadio;

    public Equipo(int camiseta, int escudo, int estadio) {
        this.camiseta = camiseta;
        this.escudo = escudo;
        this.estadio = estadio;
    }

    public int getCamiseta() {
        return camiseta;
    }

    public int getEscudo() {
        return escudo;
    }

    public int getEstadio() {
        return estadio;
    }
}
