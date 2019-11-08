package com.example.joseg.ejemplo.Intents.Util;

import java.io.Serializable;

public class BB implements Serializable {
    private String nombre, descripcion, tipo;
    private int imagen;

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public int getImagen() {
        return imagen;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public BB(String nombre, String descripcion, String tipo, int imagen) {
        setNombre(nombre);
        setDescripcion(descripcion);
        setTipo(tipo);
        setImagen(imagen);
    }
}
