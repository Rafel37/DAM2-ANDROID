package com.example.juan.examenjcique4.utils;

import java.util.ArrayList;

public class Dataset {

    ArrayList listaDatos;

    public static Dataset newInstance() {
        return new Dataset();
    }

    public ArrayList datosPracticas() {
        listaDatos = new ArrayList();
        listaDatos.add(new Practica("Aleatorios"));
        listaDatos.add(new Practica("Cartas"));
        listaDatos.add(new Practica("Primos"));
        listaDatos.add(new Practica("Recycler"));
        listaDatos.add(new Practica("Final"));
        listaDatos.add(new Practica("Lista"));
        //  listaDatos.add(new Practica("Zelda", "Nintendo", R.drawable.zelda));
        return listaDatos;
    }
}