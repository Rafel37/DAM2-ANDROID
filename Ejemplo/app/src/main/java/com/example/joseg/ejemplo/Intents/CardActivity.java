package com.example.joseg.ejemplo.Intents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.joseg.ejemplo.Elementos.Adaptadores.AdaptadorRecyclerCards;
import com.example.joseg.ejemplo.Intents.Util.Juego;
import com.example.joseg.ejemplo.R;

import java.util.ArrayList;

public class CardActivity extends AppCompatActivity implements AdaptadorRecyclerCards.OnCardRecycler {

    public final String TAG_JUEGO = "tag";
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);
        instancias();
        rellenarRecycler();
    }

    private void rellenarRecycler() {
        AdaptadorRecyclerCards adapter = new AdaptadorRecyclerCards(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.INVALID_OFFSET,false));
    }

    private void instancias() {
        recyclerView = findViewById(R.id.RVcards);
    }

    @Override
    public void onJuegoListener(Juego j) {
        Intent i = new Intent(getApplicationContext(), SegundaCard.class);
        i.putExtra(TAG_JUEGO,j);
        startActivity(i);
    }
}
