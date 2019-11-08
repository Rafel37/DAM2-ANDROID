package com.example.joseg.ejemplo.Intents;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.joseg.ejemplo.Elementos.Adaptadores.AdaptadorRecyclerViewEjemplo;
import com.example.joseg.ejemplo.Intents.Util.Persona;
import com.example.joseg.ejemplo.R;

public class RecyclerViewActivity extends AppCompatActivity implements AdaptadorRecyclerViewEjemplo.OnAdaptadorPersoListener {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        instancias();
        configurarRecycler();
        acciones();
    }

    private void acciones() {

    }

    private void configurarRecycler() {
        recyclerView.setAdapter(new AdaptadorRecyclerViewEjemplo(this));
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
    }

    private void instancias() {
        recyclerView = findViewById(R.id.RVEjemplo);
    }

    @Override
    public void onAdaptadorPersoSelected(Persona persona) {
        persona.getNombre();
    }
}
