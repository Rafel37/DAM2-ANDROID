package com.example.t5_volley;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.example.t5_volley.adaptadores.AdaptadorRecycler;
import com.example.t5_volley.fragments.FragmenDetalle;
import com.example.t5_volley.fragments.FragmentRecycler;
import com.example.t5_volley.utils.Equipo;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener,
        AdaptadorRecycler.OnEquipoRecyclerListener {

    NavigationView navigationView;
    DrawerLayout drawerLayout;
    FrameLayout sitio;

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
        sitio = findViewById(R.id.sitioFragment);
    }

    private void acciones() {
        navigationView.setNavigationItemSelectedListener(this);
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(sitio.getId(), FragmentRecycler.newInstance("Spanish La Liga"));
        ft.addToBackStack(FragmentRecycler.class.getName());
        ft.commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        switch (menuItem.getItemId()) {
            case R.id.menu_liga:
                ft.replace(sitio.getId(), FragmentRecycler.newInstance("Spanish La Liga"));
                ft.addToBackStack(FragmentRecycler.class.getName());
                ft.commit();
                drawerLayout.closeDrawers();
                return true;
            case R.id.menu_adelante:
                ft.replace(sitio.getId(), FragmentRecycler.newInstance("Spanish Adelante"));
                ft.addToBackStack(FragmentRecycler.class.getName());
                ft.commit();
                drawerLayout.closeDrawers();
                return true;
            case R.id.menu_sinLiga:
                ft.replace(sitio.getId(), FragmentRecycler.newInstance("_No League"));
                ft.addToBackStack(FragmentRecycler.class.getName());
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
        ft.add(sitio.getId(), FragmenDetalle.newInstance(equipo.getNombre(),equipo.getEscudo()));
        ft.addToBackStack(FragmenDetalle.class.getName());
        ft.commit();
    }
}
