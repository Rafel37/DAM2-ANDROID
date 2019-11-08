package com.example.volleypractica;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.volleypractica.adaptadores.AdaptadorRecycler;
import com.example.volleypractica.fragments.FragmentDetalle;
import com.example.volleypractica.fragments.FragmentLista;
import com.example.volleypractica.utils.Equipo;
import com.example.volleypractica.utils.Jugador;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdaptadorRecycler.OnAdaptadorListener {

    RecyclerView recyclerView;
    FrameLayout sitioFragment;
    ImageView imgCam;
    Equipo e;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        sitioFragment = findViewById(R.id.fragmentLista);
        imgCam = findViewById(R.id.imgDetalle);
        recyclerView = findViewById(R.id.recycler);
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(sitioFragment.getId(), new FragmentLista(), FragmentLista.class.getName());
        ft.addToBackStack(FragmentLista.class.getName());
        ft.commit();

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (getSupportFragmentManager().getBackStackEntryCount() < 1) {
            finish();
        }
    }


    @Override
    public void onAdaptadorSelected(Equipo equipo) {
        e = equipo;
        //Toast.makeText(getApplicationContext(), "Receta en Activity" + e.getEstadio(), Toast.LENGTH_SHORT).show();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(sitioFragment.getId(), FragmentDetalle.newInstance(equipo), FragmentDetalle.class.getName());
        ft.addToBackStack(FragmentLista.class.getName());
        ft.commit();
    }
}
