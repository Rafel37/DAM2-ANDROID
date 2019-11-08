package com.juanfe.equipos;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.juanfe.equipos.adaptadores.AdaptadorRecyclerFragment;
import com.juanfe.equipos.fragments.FragmenAlineacion;
import com.juanfe.equipos.fragments.FragmentRecycler;
import com.juanfe.equipos.utils.Equipo;

public class MainActivity extends AppCompatActivity  implements AdaptadorRecyclerFragment.OnRecyclerListener {
    FrameLayout sitio;
    Toolbar tool;
    NavigationView nav;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instacias();
        rellenarPrimerFragment();
        acciones();
    }

    private void rellenarPrimerFragment() {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(sitio.getId(),FragmentRecycler.newInstance("Spanish La Liga","https://www.thesportsdb.com/api/v1/json/1/search_all_teams.php?s=Soccer&c=Spain"));
        ft.commit();
    }

    private void acciones() {


        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                switch (menuItem.getItemId()){
                    case R.id.liga_1:
                        Toast.makeText(getApplicationContext(),"has pulsado 1",Toast.LENGTH_SHORT).show();
                        ft.add(sitio.getId(), FragmentRecycler.newInstance("Spanish La Liga","https://www.thesportsdb.com/api/v1/json/1/search_all_teams.php?s=Soccer&c=Spain"));
                        ft.commit();

                        break;
                    case R.id.liga_2:
                        Toast.makeText(getApplicationContext(),"has pulsado 2",Toast.LENGTH_SHORT).show();
                        ft.add(sitio.getId(), FragmentRecycler.newInstance("English Premier League","https://www.thesportsdb.com/api/v1/json/1/search_all_teams.php?s=Soccer&c=England"));
                        ft.commit();

                        break;
                    case R.id.liga_3:
                        Toast.makeText(getApplicationContext(),"has pulsado 3",Toast.LENGTH_SHORT).show();
                        ft.add(sitio.getId(), FragmentRecycler.newInstance("German Bundesliga","https://www.thesportsdb.com/api/v1/json/1/search_all_teams.php?s=Soccer&c=Germany"));
                        ft.commit();

                        break;
                    case R.id.liga_4:
                        Toast.makeText(getApplicationContext(),"has pulsado 4",Toast.LENGTH_SHORT).show();
                        ft.add(sitio.getId(), FragmentRecycler.newInstance("Italian Serie A","https://www.thesportsdb.com/api/v1/json/1/search_all_teams.php?s=Soccer&c=Italy"));
                        ft.commit();
                        break;
                }

                return true;
            }
        });
    }

    private void instacias() {
        tool = findViewById(R.id.tool);
        sitio = findViewById(R.id.sitio);
        nav = findViewById(R.id.navigation);
        setSupportActionBar(tool);
    }

    @Override
    public void onRecyclerSelected(Equipo e) {

        FragmentManager fm  =getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(sitio.getId(), FragmenAlineacion.newInstance(e.getNombre(),e.getEscudo()));
        ft.commit();
    }
}
