package com.example.root.streetfighter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements Adaptador.OnListener {

    RecyclerView recyclerView;
    Adaptador adapter;
    ArrayList<Luchador> arrayList;
    ImageButton imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        arrayList = new ArrayList<>();
        arrayList.add(new Luchador(R.drawable.blanka, "Blanka", "Electricidad", "Brasil"));
        arrayList.add(new Luchador(R.drawable.chunli, "Chun Li", "Karate", "China"));
        arrayList.add(new Luchador(R.drawable.dalsim, "Dalsim", "Elasticidad", "India"));
        arrayList.add(new Luchador(R.drawable.guile, "Guille", "Boomerang", "EEUU"));
        arrayList.add(new Luchador(R.drawable.honda, "Honda", "Sumo", "Japon"));
        arrayList.add(new Luchador(R.drawable.ken, "Key", "Judo", "Japon"));
        arrayList.add(new Luchador(R.drawable.ryu, "Ryu", "Karate", "Japon"));
        arrayList.add(new Luchador(R.drawable.vega, "Vega", "Garras", "España"));
        arrayList.add(new Luchador(R.drawable.vision, "Vision", "Psicopoderes", "Alemania"));
        arrayList.add(new Luchador(R.drawable.zang, "Zang", "Fuerza", "Rusia"));

        recyclerView = findViewById(R.id.recycler);
        adapter = new Adaptador(this, arrayList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 3,
                LinearLayout.VERTICAL, false));
        imageButton = findViewById(R.id.figth);
    }


    @Override
    public void OnCallBack(String nombre, String tipo, String pais, int imagen) {
        DialogoPersonaje d = DialogoPersonaje.newInstance(nombre,tipo,pais,imagen);
        d.show(getSupportFragmentManager(),"DIALOGO PERSONAJE");
    }


}
