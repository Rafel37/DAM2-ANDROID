package com.example.root.rpc_19_11_2019;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.root.rpc_19_11_2019.utils.Restaurante;

import java.util.ArrayList;

public class que MainActivity extends AppCompatActivity implements View.OnClickListener{

    Spinner spinnerLocalidad, spinnerTipo, spinnerPuntuacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        instancias();
        construirSpinner();
    }

    @Override
    public void onClick(View v) {

    }

    private void construirSpinner() {
        ArrayList<Restaurante> lista = new ArrayList();
        lista.add(new Restaurante("Italiano1","Madrid",4,"Italiano",9111));
        lista.add(new Restaurante("Italiano2","Alcobendas",7,"Italiano",9222));
        lista.add(new Restaurante("Italiano3","Pozuelo",9,"Italiano",9333));
        lista.add(new Restaurante("Italiano4","Majadahonda",3,"Italiano",9444));
        lista.add(new Restaurante("Italiano5","Madrid",9,"Italiano",9555));
        lista.add(new Restaurante("Mediterraneo1","Madrid",6,"Mediterranea",9666));
        lista.add(new Restaurante("Mediterraneo2","Alcobendas",7,"Mediterranea",9777));
        lista.add(new Restaurante("Mediterraneo3","Pozuelo",5,"Mediterranea",9123));
        lista.add(new Restaurante("Mediterraneo4","Majadahonda",2,"Mediterranea",9234));
        lista.add(new Restaurante("Chino1","Madrid",10,"Chino",9345));
        lista.add(new Restaurante("Chino2","Alcobendas",5,"Chino",9456));
        lista.add(new Restaurante("Chino3","Pozuelo",6,"Chino",9567));
        lista.add(new Restaurante("Japones1","Getafe",10,"Japones",8123));
        lista.add(new Restaurante("Japones2","Alcobendas",5,"Japones",7123));
        lista.add(new Restaurante("Japones3","Alcorcon",6,"Japones",6234));




    }

    private void instancias() {

        spinnerLocalidad = findViewById(R.id.SpinnerLocalidad);
        spinnerTipo = findViewById(R.id.SpinnerTipo);
        spinnerPuntuacion = findViewById(R.id.SpinnerPuntuacion);
    }
}
