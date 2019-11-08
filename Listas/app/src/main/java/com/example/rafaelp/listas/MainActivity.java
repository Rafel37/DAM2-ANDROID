package com.example.rafaelp.listas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements ListView.OnItemClickListener {

    ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        instancias();
        rellenarLista();
        acciones();
    }

    private void rellenarLista() {
        Adaptador adaptador = new Adaptador(DataSet.newInstance().darDatos(), getApplicationContext());
        lista.setAdapter(adaptador);
    }

    private void acciones() {
        lista.setOnItemClickListener(this);
    }

    private void instancias() {
        lista = findViewById(R.id.lista);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(getApplicationContext(), MostrarVersionActivity.class);
        intent.putExtra("TAG", ((Version) parent.getAdapter().getItem(position)));
        startActivity(intent);
    }
}
