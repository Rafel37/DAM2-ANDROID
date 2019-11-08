package com.example.fragmentsinicio;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.example.fragmentsinicio.fragments_dinamicos.FragmentDinamico1;
import com.example.fragmentsinicio.fragments_dinamicos.FragmentDinamico2;

public class Dinamico extends AppCompatActivity implements View.OnClickListener, FragmentDinamico1.OnFragmentUnoListener {

    FrameLayout fragment;
    Button botonDi1, botonDi2, buscarfc;
    FragmentDinamico2 fragmentDinamico2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dinamico);

        fragment = findViewById(R.id.frameDinamico);
        botonDi1 = findViewById(R.id.botondinamico1);
        botonDi2 = findViewById(R.id.botondinamico2);
        buscarfc = findViewById(R.id.buscar);

        botonDi1.setOnClickListener(this);
        botonDi2.setOnClickListener(this);
        buscarfc.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);

        switch (v.getId()){
            case R.id.botondinamico1:
                ft.add(fragment.getId(), new FragmentDinamico1(), "TAG_F1");
                break;
            case R.id.botondinamico2:
                ft.add(fragment.getId(), new FragmentDinamico2(), "TAG_F2");
                break;

            case R.id.buscar:
                if (fm.findFragmentByTag("TAG_F2") != null){
                    Log.v("pila","ENCONTRADO" );
                }
                else {
                    Log.v("pila", "NO ENCONTRADO");
                }


                break;
        }
        ft.commit();

    }

    @Override
    public void onFragmentUnoSelected() {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
        ft.add(fragment.getId(), new FragmentDinamico2(), "TAG_F2");
        ft.commit();
    }

    @Override
    public void onFragmentUnoSelected(String s) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.setCustomAnimations(android.R.anim.fade_in, android.R.anim.
                fade_out);
        ft.add(fragment.getId(), new FragmentDinamico2().newInstance(), "TAG_F2");
        ft.commit();
    }
}
