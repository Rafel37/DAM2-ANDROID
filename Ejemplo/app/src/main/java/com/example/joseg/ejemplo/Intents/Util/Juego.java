package com.example.joseg.ejemplo.Intents.Util;

import java.io.Serializable;

public class Juego implements Serializable {

    String texto;
    int imagen;

    public String getTexto() {
        return texto;
    }

    public int getImagen() {
        return imagen;
    }

    public Juego(String texto, int imagen) {
        this.texto = texto;
        this.imagen = imagen;
    }
}
