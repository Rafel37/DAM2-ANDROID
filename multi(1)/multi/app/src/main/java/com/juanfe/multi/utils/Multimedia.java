package com.juanfe.multi.utils;

public class Multimedia {
    int id;
    String tipo,subtipo,url,nombre,descripcion;

    public Multimedia(int id, String tipo, String subtipo, String nombre, String url, String descripcion) {
        this.id = id;
        this.tipo = tipo;
        this.subtipo = subtipo;
        this.url = url;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Multimedia(String tipo, String subtipo, String nombre, String url,String descripcion) {
        this.tipo = tipo;
        this.subtipo = subtipo;
        this.url = url;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public String getSubtipo() {
        return subtipo;
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
