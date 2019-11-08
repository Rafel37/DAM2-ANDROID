package com.example.joseg.ejemplo.Intents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.example.joseg.ejemplo.Elementos.Adaptadores.AdaptadorRecyclerBB;
import com.example.joseg.ejemplo.Intents.Util.BB;
import com.example.joseg.ejemplo.Intents.Util.DataSet;
import com.example.joseg.ejemplo.R;

public class PracticaRecycler extends AppCompatActivity implements AdaptadorRecyclerBB.OnBBRecyclerListener {

    final static String TAG_KEY = "key";
    private RecyclerView listabb;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practica_recycler);
        instancias();
        rellenarLista();
    }

    private void rellenarLista() {
        AdaptadorRecyclerBB adaptadorbb = new AdaptadorRecyclerBB(DataSet.newInstance().darDatosBB(),this);
        listabb.setAdapter(adaptadorbb);
        listabb.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));
    }

    private void instancias() {
        listabb = findViewById(R.id.recyclreBB);
    }

    @Override
    public void acceder(BB bb) {
        intent = new Intent(getApplicationContext(), PracticaListaDatos.class);
        intent.putExtra(TAG_KEY,bb);
        startActivity(intent);
    }
}
