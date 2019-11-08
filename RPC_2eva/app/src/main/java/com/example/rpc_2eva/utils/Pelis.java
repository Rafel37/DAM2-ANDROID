package com.example.rpc_2eva.utils;

public class Pelis {

    String cartel, nombre, id, genero;

    public Pelis(String cartel, String nombre, String id, String genero) {
        this.cartel = cartel;
        this.nombre = nombre;
        this.id = id;
        this.genero = genero;
    }

    public Pelis(String cartel, String nombre, String id) {
        this.cartel = cartel;
        this.nombre = nombre;
        this.id = id;
    }

    public String getGenero() {
        return genero;
    }

    public String getCartel() {
        return cartel;
    }

    public String getNombre() {
        return nombre;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return getId();
    }
}
