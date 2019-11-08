package com.example.joseg.ejemplo.Intents;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import com.example.joseg.ejemplo.Elementos.Adaptadores.AdaptadorListaPerso;
import com.example.joseg.ejemplo.Intents.Util.Persona;
import com.example.joseg.ejemplo.R;
import java.util.ArrayList;

public class ListaActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {

    ListView lista;
    Button boton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);
        instancias();
        rellenarLista();
        acciones();
        agregarPersona();
    }

    private void agregarPersona() {
        ((AdaptadorListaPerso)lista.getAdapter()).add(new Persona("Nombrein","Apellidoin",515348, 0));
    }

    private void acciones() {
        lista.setOnItemClickListener(this);
        lista.setOnItemClickListener(this);
    }

    private void rellenarLista() {
        //ArrayList listaOpciones = new ArrayList();
        /*for (int i = 0; i < 101; i++){
            listaOpciones.add("Opcion "+String.valueOf(i));
        }*/

        ArrayList<Persona> listaPersonas = new ArrayList<>();
        listaPersonas.add(new Persona("Hombre1","Apellido1",132,0));
        listaPersonas.add(new Persona("Mujer1","Apellido1",1322,1));
        listaPersonas.add(new Persona("Mujer2","Apellido2",1323,1));
        listaPersonas.add(new Persona("Hombre2","Apellido3",1324,0));
        listaPersonas.add(new Persona("Hombre3","Apellido5",1352,0));
        listaPersonas.add(new Persona("Hombre4","Apellido4",1326,0));

        //ArrayAdapter adapter = new ArrayAdapter(getApplicationContext(),android.R.layout.simple_list_item_1, listaOpciones);
        AdaptadorListaPerso adapter = new AdaptadorListaPerso(listaPersonas, getApplicationContext());
        lista.setAdapter(adapter);

    }

    private void instancias() {
        lista = findViewById(R.id.listaListView);
        boton = findViewById(R.id.botonButton);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getApplicationContext(), String.valueOf(((Persona)(parent.getAdapter().getItem(position))).getTelefono()),Toast.LENGTH_SHORT).show();

    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        ((AdaptadorListaPerso)lista.getAdapter()).remove(position);
        return true;
    }
}
