package com.example.joseg.tema3.EjerciciosClase.Utils;

public class Persona {

    private String nombre, apellido;
    private int edad;

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }

    public Persona(String nombre, String apellido, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    @Override
    public String toString() {
        return getNombre()+" "+getApellido()+", "+getEdad();
    }
}
