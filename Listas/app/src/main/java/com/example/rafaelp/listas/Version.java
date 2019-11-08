package com.example.rafaelp.listas;

import java.io.Serializable;

public class Version implements Serializable {

    String nombre, descripcion, fecha;
    int version, imagen;

    public Version(String nombre, String descripcion, String fecha, int version, int imagen) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.version = version;
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public int getVersion() {
        return version;
    }

    public int getImagen() {
        return imagen;
    }
}
