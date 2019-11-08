package com.example.javier.practicaequiposfragment;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.example.javier.practicaequiposfragment.Fragment.FragmentJuegos;

public class MainActivity extends AppCompatActivity {

    FrameLayout sitioFMaster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sitioFMaster=findViewById(R.id.sitioFMaster);

        FragmentManager fm= getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.sitioFMaster,new FragmentJuegos(),FragmentJuegos.class.getName());
        ft.addToBackStack(FragmentJuegos.class.getName());
        ft.commit();

    }
}