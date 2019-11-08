package com.example.rafaelp.listas;

import java.util.ArrayList;

public class DataSet {

    public static DataSet newInstance() {
        DataSet dataSet = new DataSet();
        return dataSet;
    }

    public ArrayList<Version> darDatos() {
        ArrayList<Version> versions = new ArrayList();
        versions.add(new Version("BETA", "moco", "5 de noviembre de 2007", 0, R.drawable.beta));
        return versions;
    }
}
