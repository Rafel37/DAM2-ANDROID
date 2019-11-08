package com.example.joseg.ejemplo.Intents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.joseg.ejemplo.Elementos.Adaptadores.AdaptadorListaBB;
import com.example.joseg.ejemplo.Intents.Util.BB;
import com.example.joseg.ejemplo.Intents.Util.DataSet;
import com.example.joseg.ejemplo.R;

public class PracticaLista extends AppCompatActivity implements ListView.OnItemClickListener{

    final static String TAG_KEY = "key";
    private ListView listabb;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practica_lista);
        instancias();
        rellenarLista();
        acciones();
    }

    private void acciones() {
        listabb.setOnItemClickListener(this);
    }

    private void rellenarLista() {
        AdaptadorListaBB adaptadorbb = new AdaptadorListaBB(DataSet.newInstance().darDatosBB(),getApplicationContext());
        listabb.setAdapter(adaptadorbb);
    }

    private void instancias() {
        listabb = findViewById(R.id.listaBB);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        intent = new Intent(getApplicationContext(), PracticaListaDatos.class);
        intent.putExtra(TAG_KEY,((BB)parent.getAdapter().getItem(position)));
        startActivity(intent);
    }
}
