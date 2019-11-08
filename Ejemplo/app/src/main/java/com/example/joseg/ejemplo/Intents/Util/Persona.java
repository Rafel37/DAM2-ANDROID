package com.example.joseg.ejemplo.Intents.Util;

import java.io.Serializable;

public class Persona implements Serializable {

    String nombre, apellido;
    int telefono, sexo, imagen;

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

    public int getImagen() {
        return imagen;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public void setSexo(int sexo) {
        this.sexo = sexo;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public Persona(String nombre, String apellido, int telefono, int sexo, int imagen) {
        setNombre(nombre);
        setApellido(apellido);
        setTelefono(telefono);
        setSexo(sexo);
        setImagen(imagen);
    }

    public Persona(String nombre, String apellido, int telefono) {
        this(nombre,apellido,telefono,0,0);
    }
    public Persona(String nombre, String apellido, int telefono, int sexo) {
        this(nombre,apellido,telefono,sexo,0);
    }

    public Persona(String nombre, int imagen) {
        this(nombre,"",0,0,imagen);
    }

    @Override
    public String toString() {
        return getNombre();
    }
}
