package com.example.joseg.ejemplo.Intents;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.TextView;

import com.example.joseg.ejemplo.Elementos.Adaptadores.AdaptadorRecycler;
import com.example.joseg.ejemplo.Intents.Util.Persona;
import com.example.joseg.ejemplo.R;

import java.util.ArrayList;

public class EjemploRecycler extends AppCompatActivity implements AdaptadorRecycler.OnPersonaRecyclerListener{

    RecyclerView recyclerView;
    Button boton;
    TextView textView;
    ArrayList<String> salida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejemplo_recycler);
        instancias();
        construirRecycler();
        acciones();
        textView.setText("Ejemplo");
    }

    private void construirRecycler() {
        ArrayList<Persona> personas = new ArrayList<>();
        personas.add(new Persona("Nombre 1", R.drawable.ic_launcher_background));
        personas.add(new Persona("Nombre 2", R.drawable.ic_launcher_background));
        personas.add(new Persona("Nombre 3", R.drawable.ic_launcher_background));
        personas.add(new Persona("Nombre 4", R.drawable.ic_launcher_background));
        AdaptadorRecycler adaptadorRecycler = new AdaptadorRecycler(personas,this);
        recyclerView.setAdapter(adaptadorRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));
    }

    private void acciones() {

    }

    private void instancias() {
        recyclerView = findViewById(R.id.recyclerNombres);
        boton = findViewById(R.id.boton);
        textView = findViewById(R.id.textoNombres);
        salida = new ArrayList<>();
    }

    private void actualizarSalida() {
        String sa = "";
        for (String s: salida) {
            sa+=s;
        }
        textView.setText(sa);
    }

    @Override
    public void addPersona(Persona persona) {
        salida.add(persona.getNombre());
        actualizarSalida();
    }

    @Override
    public void removePersona(Persona persona) {
        salida.remove(persona.getNombre());
        actualizarSalida();
    }

}
