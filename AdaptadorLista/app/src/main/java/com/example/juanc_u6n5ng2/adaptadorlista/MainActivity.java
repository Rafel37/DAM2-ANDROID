package com.example.juanc_u6n5ng2.adaptadorlista;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.juanc_u6n5ng2.adaptadorlista.adaptadores.AdaptadorPersonalizado;
import com.example.juanc_u6n5ng2.adaptadorlista.utils.Persona;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {

    ListView lista;
    AdaptadorPersonalizado adaptadorPersonalizado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        acciones();
        personalizarLista();
        agregarPersona();
    }

    private void agregarPersona() {
        adaptadorPersonalizado.agregarPersona(new Persona("NombreIntro","ApellidoIntro",2345,0));
    }


    private void personalizarLista() {
        //nunca añadimos datos al arrayList que es la parte grafica
        ArrayList<Persona> personas = new ArrayList<>();
        personas.add(new Persona("Nombre","Apellido",123,1));

        //un adaptadore se declara en el metodo donde se va a utilizar
        //el contexto es la base donde se ejecuta cada una de las cosas
        //la base de la pantalla es el activity

        //siempre añado datos al adaptador
        adaptadorPersonalizado = new AdaptadorPersonalizado(personas,getApplicationContext());
        lista.setAdapter(adaptadorPersonalizado);
    }

    private void instancias() {

        lista = findViewById(R.id.lista);
    }

    private void acciones() {
        lista.setOnItemClickListener(this);
        lista.setOnItemLongClickListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //esto es la persona correspondiente a la que he pulsado
       Persona p = (Persona) parent.getAdapter().getItem(position);
       //Toast.makeText(getApplicationContext(),String.valueOf(p.getTelefono()),Toast.LENGTH_SHORT).show();

    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        adaptadorPersonalizado.borrarPersona(position);
        return false;
    }
}
