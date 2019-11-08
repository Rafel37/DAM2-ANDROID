package com.example.practicawebapijson.utils;

import java.io.Serializable;

public class Usuario implements Serializable {

    private String nombre, apellidos, correo, curso, contrasena;
    private int conocimientos;

    public Usuario(String nombre, String apellidos, String correo, String curso, String contrasena, int conocimientos) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.curso = curso;
        this.contrasena = contrasena;
        this.conocimientos = conocimientos;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public String getCurso() {
        return curso;
    }

    public String getContrasena() {
        return contrasena;
    }

    public int getConocimientos() {
        return conocimientos;
    }
}