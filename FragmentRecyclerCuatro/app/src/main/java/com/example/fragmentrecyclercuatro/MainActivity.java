package com.example.fragmentrecyclercuatro;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.fragmentrecyclercuatro.adaptadores.AdaptadorRecyclerDos;
import com.example.fragmentrecyclercuatro.adaptadores.AdaptadorRecyclerUno;
import com.example.fragmentrecyclercuatro.fragments.FragmentDos;
import com.example.fragmentrecyclercuatro.fragments.FragmentTres;
import com.example.fragmentrecyclercuatro.fragments.FragmentUno;

public class MainActivity extends AppCompatActivity implements AdaptadorRecyclerUno.OnElementoAdaptadorUnoListener, AdaptadorRecyclerDos.OnElementoAdaptadorDosListener, FragmentTres.OnFragmentTresListener {

    FrameLayout sitioUno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sitioUno = findViewById(R.id.sitioUno);

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.sitioUno, new FragmentUno());
        //mirar porque si se pone ft.replace(R.id.sitioUno, new FragmentUno());
        //te lo duplica
        //ft.add(R.id.sitioDos, new FragmentDos());
        ft.addToBackStack(null);
        ft.commit();
    }

    @Override
    public void onElementoUnoSelected() {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
        ft.replace(sitioUno.getId(), new FragmentDos(), FragmentDos.class.getName());
        //addToBackStack es para meter los estados en la pila
        ft.addToBackStack(FragmentUno.class.getName());
        ft.commit();

    }

    @Override
    public void onElementoDosSelected() {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
        ft.replace(sitioUno.getId(), new FragmentTres(), FragmentTres.class.getName());
        ft.addToBackStack(FragmentTres.class.getName());
        ft.commit();
    }

    @Override
    public void onFragmentTresSelected() {
    }
}
