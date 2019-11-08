package com.example.root.rpc_19_11_2019.utils;

public class Restaurante {

    String nombre, localidad;
    int puntuacion, telefono;

    public Restaurante(String nombre, String localidad, int puntuacion, String italiano, int telefono) {
        this.nombre = nombre;
        this.localidad = localidad;
        this.puntuacion = puntuacion;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
}
