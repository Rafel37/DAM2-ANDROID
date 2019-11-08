package com.example.joseg.practica_final_tri1;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.example.joseg.practica_final_tri1.Adaptadores.Adaptador_RecyclerView_Records;
import com.example.joseg.practica_final_tri1.Utils.Jugador;
import java.util.ArrayList;

public class Pantalla_Puntuaciones extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla__puntuaciones);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        instancias();
        rellenarLista();

    }

    private void instancias() {
        recyclerView = findViewById(R.id.recyclreJugador);
    }

    private void rellenarLista() {
        Adaptador_RecyclerView_Records adaptadorbb = new Adaptador_RecyclerView_Records((ArrayList<Jugador>) getIntent().getSerializableExtra(Pantalla_Principal.TAG_KEY2),this);
        recyclerView.setAdapter(adaptadorbb);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));
    }



}
