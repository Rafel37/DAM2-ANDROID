package com.example.root.listaandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.example.root.listaandroid.utils.DataSet;
import com.example.root.listaandroid.utils.Versiones;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    DataSet recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        construirRecycler();
        acciones();
    }

    private void construirRecycler() {
        ArrayList<Versiones> Versioness = new ArrayList<>();
        Versioness.add(new Versiones("Nombre 1", R.drawable.banana));
        Versioness.add(new Versiones("Nombre 2", R.drawable.apple_det));
        Versioness.add(new Versiones("Nombre 3", R.drawable.gingerbread));
        Versioness.add(new Versiones("Nombre 4", R.drawable.android_oreo));
        AdaptadorRecycler adaptadorRecycler = new AdaptadorRecycler(Versioness,this);
        recyclerView.setAdapter(adaptadorRecycler);
        //recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));
        //recyclerView.addItemDecoration();
    }

    private void acciones() {

    }

    private void instancias() {
        recyclerView = findViewById(R.id.recyclerNombres);
    }

}