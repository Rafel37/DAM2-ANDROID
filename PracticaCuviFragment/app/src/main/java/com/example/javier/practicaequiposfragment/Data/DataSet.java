package com.example.javier.practicaequiposfragment.Data;

import com.example.javier.practicaequiposfragment.R;
import com.example.javier.practicaequiposfragment.utils.Juegos;

import java.util.ArrayList;

public class DataSet {
    public static DataSet newInstance() {
        return new DataSet();
    }

    public ArrayList<Juegos> setJuegos(){

        ArrayList<Juegos> arrayList = new ArrayList<>();
        arrayList.add(new Juegos(R.drawable.image_kh_birth_by_sleep, "Kingdom Heart Birth by Sleep"));
        arrayList.add(new Juegos(R.drawable.image_kh_birth_by_sleep_a_fragmentary_passage, "Kingdom Heart Birth by Sleep A Fragmentary Passage"));
        arrayList.add(new Juegos(R.drawable.image_kh, "Kingdom Heart"));
        arrayList.add(new Juegos(R.drawable.image_kh_358, "Kingdom Heart 358/2 Days"));
        arrayList.add(new Juegos(R.drawable.image_kh_recoded, "Kingdom Heart Recode"));
        arrayList.add(new Juegos(R.drawable.image_kh_ii, "Kingdom Heart II"));
        arrayList.add(new Juegos(R.drawable.image_kh_dream_drop_distance, "Kingdom Heart Dream Drop Distance"));
        arrayList.add(new Juegos(R.drawable.image_kh_iii, "Kingdom Heart III"));

        return arrayList;

    }
}
