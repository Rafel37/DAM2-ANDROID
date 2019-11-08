package com.example.practicawebapijson;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.practicawebapijson.fragments.FragmentDinamicoInsertar;
import com.example.practicawebapijson.fragments.FragmentDinamicoUsuario;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

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
        ft.add(R.id.sitioFragments, new FragmentDinamicoUsuario());
        ft.addToBackStack(FragmentDinamicoUsuario.class.getName());
        ft.commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
        switch (menuItem.getItemId()) {
            case R.id.opc_ver:
                ft.replace(R.id.sitioFragments, new FragmentDinamicoUsuario());
                ft.addToBackStack(FragmentDinamicoUsuario.class.getName());
                ft.commit();
                drawerLayout.closeDrawers();
                return true;
            case R.id.opc_insertar:
                ft.replace(R.id.sitioFragments, new FragmentDinamicoInsertar());
                ft.addToBackStack(FragmentDinamicoInsertar.class.getName());
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
}