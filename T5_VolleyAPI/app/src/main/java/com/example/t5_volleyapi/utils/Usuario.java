package com.example.t5_volleyapi.utils;

import java.io.Serializable;

public class Usuario implements Serializable {

    private String nombre, apellidos, correo, curso, pass;
    private int conocimientos;

    public Usuario(String nombre, String apellidos, String correo, String curso, String pass, int conocimientos) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.curso = curso;
        this.pass = pass;
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

    public String getPass() {
        return pass;
    }

    public int getConocimientos() {
        return conocimientos;
    }
}