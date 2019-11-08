package com.example.rpc_examen_navigation_bbdd.utils;

public class Alumno {

    String nombre, apellido;

    public Alumno(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }
}
