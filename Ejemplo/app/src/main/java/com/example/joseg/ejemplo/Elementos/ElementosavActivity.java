package com.example.joseg.ejemplo.Elementos;

import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.joseg.ejemplo.Elementos.Adaptadores.AdaptadorSpinnerPerso;
import com.example.joseg.ejemplo.Intents.Util.Persona;
import com.example.joseg.ejemplo.R;

import java.util.ArrayList;

public class ElementosavActivity extends AppCompatActivity implements View.OnClickListener {

    Spinner spinner, spinneranidado;
    ArrayList<Persona> listaDatos;
    EditText et, et1, et2;
    Button boton;
    ArrayAdapter adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elementosav);
        spinner = findViewById(R.id.SEjemplo);
        spinneranidado = findViewById(R.id.SEjemploAnidado);
        et = findViewById(R.id.nombreEA);
        et1 = findViewById(R.id.apellidoEA);
        et2 = findViewById(R.id.telefonoEA);
        boton = findViewById(R.id.botongregar);
        boton.setOnClickListener(this);
        listaDatos = new ArrayList();
        listaDatos.add(new Persona("Nombre 1","Apellido 1", 1234));
        listaDatos.add(new Persona("Nombre 2","Apellido 2", 123));
        listaDatos.add(new Persona("Nombre 3","Apellido 3", 12));
        adaptador = new ArrayAdapter(this,android.R.layout.simple_expandable_list_item_1,listaDatos);

        //adaptador = ArrayAdapter.createFromResource(this,R.array.Ligas,R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(adaptador);


        AdaptadorSpinnerPerso adaptadorSpinnerPerso = new AdaptadorSpinnerPerso(listaDatos, getApplicationContext());
        //Toast.makeText(getApplicationContext(),spinner.getSelectedItem().toString(),Toast.LENGTH_SHORT).show();
        spinneranidado.setAdapter(adaptadorSpinnerPerso);
        //spinner.getAdapter().getItem(2);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),String.valueOf(((Persona)parent.getAdapter().getItem(position)).getTelefono()),Toast.LENGTH_SHORT).show();
                //Toast.makeText(getApplicationContext(),parent.getAdapter().getItem(position).toString(),Toast.LENGTH_SHORT).show();
                /*ArrayAdapter adaptadoranidado = null;
                switch (position){
                    case 0:
                        adaptadoranidado = ArrayAdapter.createFromResource(getApplicationContext(),R.array.España,R.layout.support_simple_spinner_dropdown_item);
                        break;
                    case 1:
                        adaptadoranidado = ArrayAdapter.createFromResource(getApplicationContext(),R.array.Inglaterra,R.layout.support_simple_spinner_dropdown_item);
                        break;
                    case 2:
                        adaptadoranidado = ArrayAdapter.createFromResource(getApplicationContext(),R.array.Italia,R.layout.support_simple_spinner_dropdown_item);
                        break;
                }*/
                /*TypedArray arrayligaequipos = getResources().obtainTypedArray(R.array.EquiposLigas);
                String[] arrayEquipo = (String[]) arrayligaequipos.getTextArray(position);
                ArrayAdapter adaptadoranidado = new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,arrayEquipo);*/
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinneranidado.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.botongregar){
            if (et.getText().toString().isEmpty() && et1.getText().toString().isEmpty() && et2.getText().toString().isEmpty())
                Toast.makeText(getApplicationContext(),getResources().getString(R.string.mensaje),Toast.LENGTH_SHORT).show();
            else if (et.getText().toString().isEmpty() || et1.getText().toString().isEmpty() || et2.getText().toString().isEmpty())
                Toast.makeText(getApplicationContext(),getResources().getString(R.string.mensaje2),Toast.LENGTH_SHORT).show();
            else {
                adaptador.add(new Persona(et.getText().toString(), et1.getText().toString(), Integer.valueOf(et2.getText().toString())));
                Toast.makeText(getApplicationContext(), "Persona agregada", Toast.LENGTH_SHORT).show();
                et.setText("");
                et1.setText("");
                et2.setText("");
            }
        }
    }
}
