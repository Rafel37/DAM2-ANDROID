package com.juanfe.t5_baseexterna;

public class Ciclo {

    int id;
    String nombre, siglas;

    public Ciclo(int id, String nombre, String siglas) {
        this.id = id;
        this.nombre = nombre;
        this.siglas = siglas;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getSiglas() {
        return siglas;
    }
}
