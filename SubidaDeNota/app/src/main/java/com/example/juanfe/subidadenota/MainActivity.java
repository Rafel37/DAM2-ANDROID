package com.example.juanfe.subidadenota;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdaptadorRe.Callback,Dialogo.CallbackDialogo {
    RecyclerView recycler;
    AdaptadorRe adaptador;
    ArrayList numeros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        numeros = new ArrayList<>();
        numeros.add(1);
        numeros.add(222222);
        numeros.add(232323);
        recycler  =findViewById(R.id.recycler);
        adaptador = new AdaptadorRe(numeros,this);
        recycler.setAdapter(adaptador);
        recycler.setLayoutManager(new GridLayoutManager(this,2,LinearLayoutManager.VERTICAL,false));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.generar:
                int aleatorio = (int) (Math.random()*99999-1);
                Dialogo d = Dialogo.newInstance(aleatorio);
                d.show(getSupportFragmentManager(),"tag");
                break;
            case R.id.salir:
                finish();
                break;
        }
        return true;
    }




    @Override
    public void onPulsacion(int numero) {
        DialogoRecycler d = DialogoRecycler.newInstance(String.valueOf(numero));
        d.show(getSupportFragmentManager(),"tag2");

    }

    @Override
    public void Oncreado(int numero) {
        numeros.add(numero);
        adaptador.notifyDataSetChanged();

    }
}
