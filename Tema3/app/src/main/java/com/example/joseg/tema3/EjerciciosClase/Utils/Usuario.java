package com.example.joseg.tema3.EjerciciosClase.Utils;

import java.io.Serializable;

public class Usuario implements Serializable {

    private String nombre, apellido, pass, correo;
    private int edad;

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getPass() {
        return pass;
    }

    public String getCorreo() {
        return correo;
    }

    public int getEdad() {
        return edad;
    }

    public Usuario(String nombre, String apellido, String pass, String correo, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.pass = pass;
        this.correo = correo;
        this.edad = edad;
    }
}
