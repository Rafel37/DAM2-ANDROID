package com.example.juanc_u6n5ng2.adaptadorlista.utils;

public class Persona {

    String nombre, apellido;
    int telefono, sexo;

    public Persona(String nombre, String apellido, int telefono, int sexo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.sexo = sexo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getTelefono() {
        return telefono;
    }

    public int getSexo() {
        return sexo;
    }
}
