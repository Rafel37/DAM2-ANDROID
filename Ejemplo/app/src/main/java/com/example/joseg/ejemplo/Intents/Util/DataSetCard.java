package com.example.joseg.ejemplo.Intents.Util;

import com.example.joseg.ejemplo.R;

import java.util.ArrayList;

public class DataSetCard {

    public static DataSetCard newInstance(){
        DataSetCard dataSetCard = new DataSetCard();
        return dataSetCard;
    }

    public ArrayList<Juego> darJuegos(){
        ArrayList<Juego> list = new ArrayList<Juego>();

        list.add(new Juego("Donk", R.drawable.donk));
        list.add(new Juego("Sonic", R.drawable.sonic));
        list.add(new Juego("Fox", R.drawable.startfox));
        list.add(new Juego("Zelda", R.drawable.zelda));
        list.add(new Juego("Street", R.drawable.street));

        return list;
    }
}
