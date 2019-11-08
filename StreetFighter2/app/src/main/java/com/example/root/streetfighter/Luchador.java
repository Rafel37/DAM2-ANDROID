package com.example.root.streetfighter;

public class Luchador {

    int imagen;
    String nombre, tipo, pais;

    public Luchador(int imagen, String nombre, String tipo, String pais) {
        this.imagen = imagen;
        this.nombre = nombre;
        this.tipo = tipo;
        this.pais = pais;
    }

    public int getImagen() {
        return imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public String getPais() {
        return pais;
    }
}
