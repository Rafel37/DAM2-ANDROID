package com.example.root.recyclerandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.TextView;

import com.example.root.recyclerandroid.adaptadores.AdaptadorRecycler;
import com.example.root.recyclerandroid.utils.Persona;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdaptadorRecycler.OnPersonaRecyclerListener{

    RecyclerView recyclerView;
    Button boton;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        construirRecycler();
        acciones();
        textView.setText("Ejemplo");
    }

    private void construirRecycler() {
        ArrayList<Persona> personas = new ArrayList<>();
        personas.add(new Persona("Nombre 1", R.drawable.banana));
        personas.add(new Persona("Nombre 2", R.drawable.apple_det));
        personas.add(new Persona("Nombre 3", R.drawable.gingerbread));
        personas.add(new Persona("Nombre 4", R.drawable.android_oreo));
        AdaptadorRecycler adaptadorRecycler = new AdaptadorRecycler(personas,this);
        recyclerView.setAdapter(adaptadorRecycler);
        //recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));
        //recyclerView.addItemDecoration();
    }

    private void acciones() {

    }

    private void instancias() {
        recyclerView = findViewById(R.id.recyclerNombres);
        boton = findViewById(R.id.boton);
        textView = findViewById(R.id.textoNombres);
    }

    @Override
    public void onPersonaRecyclerSelected(Persona persona) {
        textView.setText(persona.getNombre());
    }
}