package com.juanfe.t5_baseexterna;

public class Usuario {
    int id;
    String nombre, apellidos, correo,contraseña;
    int id_ciclo,tipo;
    int conocimientos_previos;

    public Usuario(int id, String nombre, String apellidos, String correo, String contraseña, int id_ciclo, int tipo, int conocimientos_previos) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.contraseña = contraseña;
        this.id_ciclo = id_ciclo;
        this.tipo = tipo;
        this.conocimientos_previos = conocimientos_previos;
    }

    public Usuario(String nombre, String correo) {
        this.nombre = nombre;
        this.correo = correo;
    }

    public int getId() {
        return id;
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

    public String getContraseña() {
        return contraseña;
    }

    public int getId_ciclo() {
        return id_ciclo;
    }

    public int getTipo() {
        return tipo;
    }

    public int getConocimientos_previos() {
        return conocimientos_previos;
    }
}
