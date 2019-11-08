package com.example.javier.practica_navigation;

import android.support.v4.widget.DrawerLayout;
import android.support.design.widget.NavigationView;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    NavigationView navigationView;
    DrawerLayout drawerLayout;
    Spinner spinnerHeader;
    SearchView searchView;
    Toolbar toolbar;
    ActionBarDrawerToggle drawerToggle;
    ImageView imagen_fondo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        persoNavigation();
        persoSpinner();
        acciones();
    }

    private void acciones() {
        spinnerHeader.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if(position==0){
                    imagen_fondo.setImageResource(R.drawable.all_back);
                    navigationView.getMenu().clear();
                    navigationView.inflateMenu(R.menu.menu_nav);

                } else if(position==1){
                    imagen_fondo.setImageResource(R.drawable.game_back);
                    navigationView.getMenu().clear();
                    navigationView.inflateMenu(R.menu.menu_juegos);

                }else if(position==2){
                    imagen_fondo.setImageResource(R.drawable.cine_back);
                    navigationView.getMenu().clear();
                    navigationView.inflateMenu(R.menu.menu_multi);

                }else if(position==3){
                    imagen_fondo.setImageResource(R.drawable.footbal_back);
                    navigationView.getMenu().clear();
                    navigationView.inflateMenu(R.menu.menu_fot);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void persoSpinner() {
        String[]opcion = {"Todo","Juegos","Multimedia","Futball"};
        ArrayAdapter<CharSequence> adaptadorSpinner =
                new ArrayAdapter<CharSequence>(getApplicationContext(),android.R.layout.simple_spinner_item,opcion);
        adaptadorSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerHeader.setAdapter(adaptadorSpinner);
    }

    private void persoNavigation() {
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
    }

    private void instancias() {
        navigationView = findViewById(R.id.navigation);
        drawerLayout = findViewById(R.id.drawer);
        spinnerHeader = navigationView.getHeaderView(0).findViewById(R.id.spinnerHeader);
        imagen_fondo = navigationView.getHeaderView(0).findViewById(R.id.imagen_fondo);
        searchView = (SearchView) navigationView.getMenu().findItem(R.id.opcion5).getActionView();
        toolbar = findViewById(R.id.toolbar);
        drawerToggle = new ActionBarDrawerToggle(MainActivity.this
                ,drawerLayout
                ,toolbar
                ,R.string.abierto
                ,R.string.cerrado){
            @Override
            public void onDrawerClosed(View drawerView) {


            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
            }
        };
    }
}
