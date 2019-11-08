package com.example.root.examen_1eva_rpc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Spinner nota1, nota2, nota3, notaFinal;
    CheckBox aleatorios, primos, recycler, cartas, vista, fin;
    ImageView aprovado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nota1 = findViewById(R.id.nota1Spinner);
        nota2 = findViewById(R.id.nota2Spinner);
        nota3 = findViewById(R.id.nota3Spinner);
        notaFinal = findViewById(R.id.notaFinalSpinner);

        aleatorios = findViewById(R.id.checkAleatorios);
        primos = findViewById(R.id.checkPrimos);
        recycler = findViewById(R.id.checkRecycler);
        cartas = findViewById(R.id.checkCartas);
        vista = findViewById(R.id.checkVista);
        fin = findViewById(R.id.checkFinal);


        ArrayList arrayList = new ArrayList();
        arrayList.add("1");
        arrayList.add("2");
        arrayList.add("3");
        arrayList.add("4");
        arrayList.add("5");
        arrayList.add("6");
        arrayList.add("7");
        arrayList.add("8");
        arrayList.add("9");
        arrayList.add("10");


        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, arrayList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        nota1.setAdapter(adapter);
        nota2.setAdapter(adapter);
        nota3.setAdapter(adapter);
        notaFinal.setAdapter(adapter);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_validar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.validar) {
            int n1 = nota1.getSelectedItemPosition() + 1;
            int n2 = nota2.getSelectedItemPosition() + 1;
            int n3 = nota3.getSelectedItemPosition() + 1;
            int nF = notaFinal.getSelectedItemPosition() + 1;
            int media = (n1+n2+n3+nF)/4;
            if (media >= 5 && aleatorios.isChecked() && primos.isChecked() && recycler.isChecked() && cartas.isChecked() /*&& vista.isChecked() && fin.isChecked()*/)
            {
                //todo cambiar pantalla
                Toast.makeText(getApplicationContext(), "aprovado", Toast.LENGTH_SHORT).show();
            }
            else {
                //todo cambiar pantalla
                Toast.makeText(getApplicationContext(), "suspenso", Toast.LENGTH_SHORT).show();
            }
        }
        return true;
    }
}
