package com.example.joseg.practica_final_tri1.Utils;

import com.example.joseg.practica_final_tri1.R;

import java.util.ArrayList;

public class DataSet {

    public static DataSet newInstance(){

        return new DataSet();

    }

    public ArrayList<Dificultad> setDificultades(){

        ArrayList<Dificultad> listaD = new ArrayList<>();
        listaD.add(new Dificultad("Aficionado", R.drawable.seat));
        listaD.add(new Dificultad("Principiante", R.drawable.popcorn));
        listaD.add(new Dificultad("Cinefilo", R.drawable.ticket));
        listaD.add(new Dificultad("Director", R.drawable.film));

        return listaD;

    }
}
