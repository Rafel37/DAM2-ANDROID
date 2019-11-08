package com.example.rpc_2eva;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.example.rpc_2eva.fragments.FragmentFiltro;
import com.example.rpc_2eva.fragments.FragmentRecycler;

public class MainActivity extends AppCompatActivity {

    FrameLayout sitio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        instancias();
        acciones();
    }

    private void instancias() {
        sitio = findViewById(R.id.sitioFragment);
    }

    private void acciones() {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        ft.add(sitio.getId(), FragmentRecycler.newInstance("results"));
        ft.addToBackStack(FragmentRecycler.class.getName());
        ft.commit();
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (getSupportFragmentManager().getBackStackEntryCount() == 0) {
            finish();
        }
    }

}
