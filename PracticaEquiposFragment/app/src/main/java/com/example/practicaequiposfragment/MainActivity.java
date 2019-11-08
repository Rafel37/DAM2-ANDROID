package com.example.practicaequiposfragment;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.example.practicaequiposfragment.adaptadores.AdaptadorRecycler01;
import com.example.practicaequiposfragment.adaptadores.AdaptadorRecycler02;
import com.example.practicaequiposfragment.adaptadores.AdaptadorRecycler03;
import com.example.practicaequiposfragment.fragments.Fragment01;
import com.example.practicaequiposfragment.fragments.Fragment02;
import com.example.practicaequiposfragment.fragments.Fragment03;
import com.example.practicaequiposfragment.utils.Equipos;
import com.example.practicaequiposfragment.utils.Ligas;

public class MainActivity extends AppCompatActivity implements AdaptadorRecycler01.LigasListener, AdaptadorRecycler02.EquipoListener{

    FrameLayout fragment01;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragment01 = findViewById(R.id.fragmentMain);

        FragmentManager fm= getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragmentMain,new Fragment01(),MainActivity.class.getName());
        ft.addToBackStack(Fragment01.class.getName());
        ft.addToBackStack(null); //para el tag de la pila
        ft.commit();
    }

    @Override
    public void LigasSelected(int i) {

        FragmentManager fm= getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragmentMain, Fragment02.newInstance(i),Fragment01.class.getName());
        ft.addToBackStack(Fragment01.class.getName());
        ft.commit();
    }


    @Override
    public void EquipoSelected(int i, int posicion) {
        FragmentManager fm= getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragmentMain, Fragment03.newInstance(i, posicion),Fragment02.class.getName());
        ft.addToBackStack(Fragment02.class.getName());
        ft.commit();
    }

}
