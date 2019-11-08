package com.example.joseg.joseangelgarciaoya;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import com.example.joseg.joseangelgarciaoya.Adaptadores.AdaptadorRecycler;
import com.example.joseg.joseangelgarciaoya.Adaptadores.AdaptadorSpinner;
import com.example.joseg.joseangelgarciaoya.Util.DataSet;
import com.example.joseg.joseangelgarciaoya.Util.Elemento;

import java.util.ArrayList;

public class ExamenActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, AdaptadorRecycler.OnElementoRecyclerListener {



    ImageView imagen;
    TextView nombre, hobby;
    Spinner spinner;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_examen);
        instancias();
        rellenarSpinner();
        rellenarRecycler(DataSet.darDatosP());
    }

    private void instancias() {
        imagen = findViewById(R.id.imagenSalida);
        nombre = findViewById(R.id.nombreSalida);
        hobby = findViewById(R.id.hobbySalida);
        spinner = findViewById(R.id.Spinner);
        recyclerView = findViewById(R.id.Recycler);
    }

    private void rellenarSpinner() {
        AdaptadorSpinner adaptadorSpinner = new AdaptadorSpinner(DataSet.newInstance().darDatos(),this);
        spinner.setAdapter(adaptadorSpinner);
        spinner.setOnItemSelectedListener(this);
    }

    private void rellenarRecycler(ArrayList<Elemento> datos) {
        AdaptadorRecycler adaptadorRecycler = new AdaptadorRecycler(datos,this);
        recyclerView.setAdapter(adaptadorRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        if (((Elemento)parent.getAdapter().getItem(position)).getHobby().equals("peliculas")){
            rellenarRecycler(DataSet.darDatosP());
        }else if (((Elemento)parent.getAdapter().getItem(position)).getHobby().equals("juegos")){
            rellenarRecycler(DataSet.darDatosJ());
        }else {
            rellenarRecycler(DataSet.darDatosF());
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void sacarDatos(Elemento e) {

        imagen.setImageResource(e.getImagen());
        nombre.setText(e.getNombre());
        hobby.setText(e.getHobby());

    }
}
