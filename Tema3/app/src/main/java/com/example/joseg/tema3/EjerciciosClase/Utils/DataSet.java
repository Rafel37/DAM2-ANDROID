package com.example.joseg.tema3.EjerciciosClase.Utils;



import com.example.joseg.tema3.R;

import java.util.ArrayList;

public class DataSet {

    ArrayList lista;

    public static DataSet newInstance () {
        DataSet dataset = new DataSet();
        return dataset;
    }

    public ArrayList devolverHobiesSpinner(){

        lista = new ArrayList();
        lista.add(new Hobie("Hobie 1", R.drawable.ic_launcher_background));
        lista.add(new Hobie("Hobie 2", R.drawable.ic_launcher_background));
        lista.add(new Hobie("Hobie 3", R.drawable.ic_launcher_background));
        lista.add(new Hobie("Hobie 4", R.drawable.ic_launcher_background));
        lista.add(new Hobie("Hobie 5", R.drawable.ic_launcher_background));
        return lista;
    }

    public ArrayList devolverHobiesRecycler(){

        lista = new ArrayList();
        lista.add(new Hobie("Hobie 6", R.drawable.ic_launcher_background));
        lista.add(new Hobie("Hobie 7", R.drawable.ic_launcher_background));
        lista.add(new Hobie("Hobie 8", R.drawable.ic_launcher_background));
        lista.add(new Hobie("Hobie 9", R.drawable.ic_launcher_background));
        lista.add(new Hobie("Hobie 10", R.drawable.ic_launcher_background));
        return lista;
    }

}
