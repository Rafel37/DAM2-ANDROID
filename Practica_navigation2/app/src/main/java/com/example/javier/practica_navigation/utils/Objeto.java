package com.example.javier.practica_navigation.utils;

public class Objeto {
    String tipo,url,nombre,descripcion;
    int id;

    public Objeto(String tipo, String url, String nombre, String descripcion) {
        this.tipo = tipo;
        this.url = url;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Objeto(String tipo, String url, String nombre, String descripcion, int id) {
        this.tipo = tipo;
        this.url = url;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public String getUrl() {
        return url;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
