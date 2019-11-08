package com.example.joseg.joseangelgarciaoya.Util;

import com.example.joseg.joseangelgarciaoya.R;
import java.util.ArrayList;

public class DataSet {

    private static ArrayList<Elemento> datos;

    public static DataSet newInstance(){

        DataSet dataSet = new DataSet();

        return dataSet;
    }

    public static ArrayList<Elemento> darDatos() {
        datos = new ArrayList<>();
        datos.add(new Elemento("Películas","peliculas", R.drawable.film));
        datos.add(new Elemento("Videojuegos", "juegos",R.drawable.videogame));
        datos.add(new Elemento("Fútbol", "deporte", R.drawable.soccer));
        return datos;
    }
    public static ArrayList<Elemento> darDatosP() {
        datos = new ArrayList<>();
        datos.add(new Elemento("El cabo del miedo","Sony" , R.drawable.cabo));
        datos.add(new Elemento("Harry Potter", "Paramount",R.drawable.harry));
        datos.add(new Elemento("El gran lebosky", "Filmac", R.drawable.levo));
        datos.add(new Elemento("Scream", "Filmac",R.drawable.scream));
        datos.add(new Elemento("Taxi", "Sony",R.drawable.taxi));
        datos.add(new Elemento("Start Wars", "Lucas Film",R.drawable.star));
        return datos;
    }
    public static ArrayList<Elemento> darDatosJ() {
        datos = new ArrayList<>();
        datos.add(new Elemento("Donky Kong", "Nintendo",R.drawable.donk));
        datos.add(new Elemento("God of War", "Sony",R.drawable.kratos));
        datos.add(new Elemento("Sonic", "Sega",R.drawable.sonic));
        datos.add(new Elemento("Street Fighter", "Konami",R.drawable.street));
        datos.add(new Elemento("Zelda", "Nintendo",R.drawable.zelda));
        return datos;
    }
    public static ArrayList<Elemento> darDatosF() {
        datos = new ArrayList<>();
        datos.add(new Elemento("Arturo Vidal", "Chile",R.drawable.arturo));
        datos.add(new Elemento("Karim Benzema", "Francia",R.drawable.benzema));
        datos.add(new Elemento("Leo Messi", "Argentina", R.drawable.leo));
        datos.add(new Elemento("Luka Modric", "Croacia",R.drawable.luka));
        return datos;
    }

    public static ArrayList<Elemento> getDatos() {
        return datos;
    }
}
