package com.example.rpc_examen_1_2_19.adaptadores;

import com.example.rpc_examen_1_2_19.R;
import com.example.rpc_examen_1_2_19.utils.Clases;

import java.util.ArrayList;

public class DataSet {

    public static DataSet newInstance() {
        DataSet dataSet = new DataSet();
        return dataSet;
    }

    public static ArrayList<Clases> asir(){

        ArrayList<Clases> arrayList = new ArrayList<>();
        arrayList.add(new Clases(R.drawable.asir, "seguridad"));
        arrayList.add(new Clases(R.drawable.asir, "implantacion"));
        arrayList.add(new Clases(R.drawable.asir, "redes"));

        return arrayList;
    }

    public static ArrayList dam(){

        ArrayList<Clases> arrayList = new ArrayList<>();
        arrayList.add(new Clases(R.drawable.dam, "programacion"));
        arrayList.add(new Clases(R.drawable.dam, "interfaces"));
        arrayList.add(new Clases(R.drawable.dam, "android"));

        return arrayList;
    }

    public static ArrayList af(){

        ArrayList<Clases> arrayList = new ArrayList<>();
        arrayList.add(new Clases(R.drawable.af, "contabilidad"));
        arrayList.add(new Clases(R.drawable.af, "fiscal"));
        arrayList.add(new Clases(R.drawable.af, "blanqueo"));

        return arrayList;
    }
}
