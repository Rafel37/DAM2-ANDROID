package com.example.rafaelp.memorygame.dataset;
import com.example.rafaelp.memorygame.R;
import com.example.rafaelp.memorygame.utils.Peliculas;

import java.util.ArrayList;

public class DataSet {

    public static DataSet newInstance(){

        return new DataSet();

    }

    public ArrayList<Peliculas> setDificultades(){

        ArrayList<Peliculas> listaD = new ArrayList<>();
        listaD.add(new Peliculas("Aficionado", R.drawable.seat));
        listaD.add(new Peliculas("Principiante", R.drawable.popcorn));
        listaD.add(new Peliculas("Cinefilo", R.drawable.ticket));
        listaD.add(new Peliculas("Director", R.drawable.film));

        return listaD;

    }
}
