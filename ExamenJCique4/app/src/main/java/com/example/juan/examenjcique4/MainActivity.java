package com.example.juan.examenjcique4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.juan.examenjcique4.adaptadores.AdaptadorRecycler;
import com.example.juan.examenjcique4.utils.Dataset;
import com.example.juan.examenjcique4.utils.Practica;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdaptadorRecycler.OnPracticaRecyclerListener {

    final static String TAG_KEY = "key";
    boolean aprobado = false;
    Spinner examen1, examen2, examen3, examen4;
    int contador = 0;
    double media = 0;
    RecyclerView recyclerView;
    AdaptadorRecycler adaptadorRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        acciones();
    }

    private void instancias() {
        recyclerView = findViewById(R.id.recyclerView);
        examen1 = findViewById(R.id.examen1);
        examen2 = findViewById(R.id.examen2);
        examen3 = findViewById(R.id.examen3);
        examen4 = findViewById(R.id.examen4);
    }

    private void acciones() {
        rellenarSpinner();
        construirRecycler();
    }

    private void rellenarSpinner() {
        String[] numeros = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        examen1.setAdapter(new ArrayAdapter<CharSequence>(this, android.R.layout.simple_spinner_item, numeros));
        examen2.setAdapter(new ArrayAdapter<CharSequence>(this, android.R.layout.simple_spinner_item, numeros));
        examen3.setAdapter(new ArrayAdapter<CharSequence>(this, android.R.layout.simple_spinner_item, numeros));
        examen4.setAdapter(new ArrayAdapter<CharSequence>(this, android.R.layout.simple_spinner_item, numeros));
    }

    private void construirRecycler() {
        AdaptadorRecycler adaptadorRecycler = new AdaptadorRecycler(Dataset.newInstance().datosPracticas(), this);
        recyclerView.setAdapter(adaptadorRecycler);
        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2, LinearLayoutManager.VERTICAL, false));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int n1 = examen1.getSelectedItemPosition();
        int n2 = examen2.getSelectedItemPosition();
        int n3 = examen3.getSelectedItemPosition();
        int n4 = examen4.getSelectedItemPosition();
        media = n1 * n2 * n3 * n4 / 4;
        if (contador == 6 && media > 4) {
            aprobado = true;
        }else
            aprobado = false;
        Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
        intent.putExtra(TAG_KEY, aprobado);
        startActivity(intent);
        return true;
    }

    @Override
    public void onPracticaRecyclerSelected(Practica practica) {
        contador++;
    }

    @Override
    public void onPracticaRecyclerDeselected(Practica practica) {
        contador--;
    }
}