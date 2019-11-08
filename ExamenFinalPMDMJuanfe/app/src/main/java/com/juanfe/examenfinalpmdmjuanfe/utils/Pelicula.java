package com.juanfe.examenfinalpmdmjuanfe.utils;

public class Pelicula {
    int id;
    String titulo, fecha,imagen,genero;

    public Pelicula(int id, String titulo, String fecha, String imagen, String genero) {
        this.id = id;
        this.titulo = titulo;
        this.fecha = fecha;
        this.imagen = imagen;
        this.genero = genero;
    }
    public Pelicula( String titulo, String fecha, String imagen, String genero) {
        this.titulo = titulo;
        this.fecha = fecha;
        this.imagen = imagen;
        this.genero = genero;
    }


    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getFecha() {
        return fecha;
    }

    public String getImagen() {
        return imagen;
    }

    public String getGenero() {
        return genero;
    }
}
