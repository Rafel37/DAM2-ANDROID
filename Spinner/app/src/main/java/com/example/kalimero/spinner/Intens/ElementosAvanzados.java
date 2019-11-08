package com.example.kalimero.spinner.Intens;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.kalimero.spinner.Intens.utils.Persona;
import com.example.kalimero.spinner.R;

import java.util.ArrayList;

public class ElementosAvanzados extends AppCompatActivity implements View.OnClickListener{

    Spinner spinner;
    EditText name,surname,number;
    Button button;
    ArrayAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elementos_avanzados);

        instancias();
        construirAsociar();
        mensajeAviso();

    }

    private void construirAsociar() {
        //datos a mostrar
        ArrayList<Persona> personas = new ArrayList();
        personas.add(new Persona("Nombre 1", "Apellido 1", 1234));
        personas.add(new Persona("Nombre 2", "Apellido 2", 2345));
        personas.add(new Persona("Nombre 3", "Apellido 3", 3456));


        //Crear un modelo de datos
        //this, layout, datos

        ArrayAdapter adaptador = new ArrayAdapter (this, android.R.layout.array.numeros);

        //Asociar el spinner con el modelo de datos
        spinner.setAdapter(adaptador);

        Toast.makeText(getApplicationContext(), spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();

//        spinner.getSelectedItem();
//        spinner.getAdapter().getItem(2);
//        adaptador.getItem(2);
//        adaptador.notifyDataSetChanged();
    }

    private void mensajeAviso() {//cuando pulse una opcion me saldra el nombre de esta en un toast
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), parent.getAdapter().toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


    private void instancias() {
        spinner = findViewById(R.id.spinner);
        name = findViewById(R.id.nombre);
        surname = findViewById(R.id.apellido);
        number = findViewById(R.id.telefono);
        button = findViewById(R.id.boton);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.boton) {
            adapter.add(new Persona(name.getText().toString(), surname.getText().toString(), Integer.valueOf(number.getText().toString())));
        }
    }
}
