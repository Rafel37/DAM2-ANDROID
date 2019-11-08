package com.example.practicaequiposfragment;

import com.example.practicaequiposfragment.utils.Equipos;
import com.example.practicaequiposfragment.utils.Ligas;

import java.util.ArrayList;

public class DataSet {

    public static DataSet newInstance() {
        DataSet dataSet = new DataSet();
        return dataSet;
    }

    public static ArrayList<Ligas> setLigas() {

        ArrayList<Ligas> arrayList = new ArrayList<>();
        arrayList.add(new Ligas(R.drawable.bundesliga, "bundesliga"));
        arrayList.add(new Ligas(R.drawable.premier, "premier"));
        arrayList.add(new Ligas(R.drawable.serie_a, "serie a"));
        arrayList.add(new Ligas(R.drawable.primera, "primera"));

        return arrayList;
    }


    public static ArrayList<Equipos> setEquiposBundesliga() {

        ArrayList<Equipos> arrayList = new ArrayList<>();
        arrayList.add(new Equipos(R.drawable.bundesliga, "equipo 1", "equipo 1 de la bundsliga"));
        arrayList.add(new Equipos(R.drawable.bundesliga, "equipo 2", "equipo 2 de la bundsliga"));
        arrayList.add(new Equipos(R.drawable.bundesliga, "equipo 3", "equipo 3 de la bundsliga"));
        return arrayList;
    }


    public static ArrayList<Equipos> setEquiposPremier() {

        ArrayList<Equipos> arrayList = new ArrayList<>();
        arrayList.add(new Equipos(R.drawable.premier, "equipo 1", "equipo 1 de la premier"));
        arrayList.add(new Equipos(R.drawable.premier, "equipo 2", "equipo 2 de la premier"));
        arrayList.add(new Equipos(R.drawable.premier, "equipo 3", "equipo 3 de la premier"));
        return arrayList;
    }


    public static ArrayList<Equipos> setEquiposSerie() {

        ArrayList<Equipos> arrayList = new ArrayList<>();
        arrayList.add(new Equipos(R.drawable.serie_a, "equipo 1", "equipo 1 de la serie a"));
        arrayList.add(new Equipos(R.drawable.serie_a, "equipo 2", "equipo 2 de la serie a"));
        arrayList.add(new Equipos(R.drawable.serie_a, "equipo 3", "equipo 3 de la serie a"));
        return arrayList;
    }


    public static ArrayList<Equipos> setEquiposPrimera() {

        ArrayList<Equipos> arrayList = new ArrayList<>();
        arrayList.add(new Equipos(R.drawable.primera, "equipo 1", "equipo 1 de primera"));
        arrayList.add(new Equipos(R.drawable.primera, "equipo 2", "equipo 2 de primera"));
        arrayList.add(new Equipos(R.drawable.primera, "equipo 3", "equipo 3 de primera"));
        return arrayList;
    }




}
