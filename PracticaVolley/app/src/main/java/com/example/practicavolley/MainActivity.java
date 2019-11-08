package com.example.practicavolley;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.practicavolley.adaptadores.AdaptadorRecycler;
import com.example.practicavolley.fragments.FragmentDinamicoDetalle;
import com.example.practicavolley.fragments.FragmentDinamicoRecycler;
import com.example.practicavolley.utils.Equipo;


public class MainActivity extends AppCompatActivity implements
        NavigationView.OnNavigationItemSelectedListener,
        AdaptadorRecycler.OnEquipoRecyclerListener {

    NavigationView navigationView;
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        acciones();
    }

    private void instancias() {
        navigationView = findViewById(R.id.navigation);
        drawerLayout = findViewById(R.id.drawer);
    }

    private void acciones() {
        navigationView.setNavigationItemSelectedListener(this);
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
        ft.add(R.id.sitioFragments, FragmentDinamicoRecycler.newInstance("Spanish La Liga"));
        ft.addToBackStack(FragmentDinamicoRecycler.class.getName());
        ft.commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
        switch (menuItem.getItemId()) {
            case R.id.opc_liga:
                ft.replace(R.id.sitioFragments, FragmentDinamicoRecycler.newInstance("Spanish La Liga"));
                ft.addToBackStack(FragmentDinamicoRecycler.class.getName());
                ft.commit();
                drawerLayout.closeDrawers();
                return true;
            case R.id.opc_adelante:
                ft.replace(R.id.sitioFragments, FragmentDinamicoRecycler.newInstance("Spanish Adelante"));
                ft.addToBackStack(FragmentDinamicoRecycler.class.getName());
                ft.commit();
                drawerLayout.closeDrawers();
                return true;
            case R.id.opc_noLiga:
                ft.replace(R.id.sitioFragments, FragmentDinamicoRecycler.newInstance("_No League"));
                ft.addToBackStack(FragmentDinamicoRecycler.class.getName());
                ft.commit();
                drawerLayout.closeDrawers();
                return true;
            default:
                return false;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (getSupportFragmentManager().getBackStackEntryCount() == 0) {
            finish();
        }
    }

    @Override
    public void onEquipoRecyclerSelected(Equipo equipo) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
        ft.replace(R.id.sitioFragments, FragmentDinamicoDetalle.newInstance(equipo.getId()), "TAG_FDETALLE");
        ft.addToBackStack(FragmentDinamicoDetalle.class.getName());
        ft.commit();
    }

}