package com.example.rpc_examen_1_2_19;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.rpc_examen_1_2_19.adaptadores.AdaptadorPager;
import com.example.rpc_examen_1_2_19.fragments.Fragment01;
import com.example.rpc_examen_1_2_19.fragments.Fragment02;

public class MainActivity extends AppCompatActivity implements Fragment01.OnFragmen1Listener, Fragment02.OnFragmen2Listener {

    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;

    AdaptadorPager adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        tabLayout = findViewById(R.id.tab);
        viewPager = findViewById(R.id.view);

        adaptador = new AdaptadorPager(getSupportFragmentManager());
        viewPager.setAdapter(adaptador);
        setSupportActionBar(toolbar);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public void onFragment1Selected() {

    }

    @Override
    public void onFragment2Selected() {

    }
}
