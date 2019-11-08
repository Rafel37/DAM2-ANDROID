package com.example.fragmentsinicio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.fragmentsinicio.fragments_estaticos.FragmentEstatico1;
import com.example.fragmentsinicio.fragments_estaticos.FragmentEstatico2;

public class Estatico extends AppCompatActivity  implements FragmentEstatico1.OnDataF1SelectedListener{

    FragmentEstatico1 f1;
    FragmentEstatico2 f2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.estatico);

    }


    @Override
    public void onDataF1Selected(String s) {
        f2 = (FragmentEstatico2) getSupportFragmentManager().findFragmentById(R.id.textoFragment2);

        f1 = (FragmentEstatico1) getSupportFragmentManager().findFragmentById(R.id.festatico1);
        f2 = (FragmentEstatico2) getSupportFragmentManager().findFragmentById(R.id.festatico2);
        f2.cambiarEtiqueta(s);
    }
}
