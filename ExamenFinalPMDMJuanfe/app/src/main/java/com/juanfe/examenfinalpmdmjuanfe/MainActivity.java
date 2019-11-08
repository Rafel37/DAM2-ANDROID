package com.juanfe.examenfinalpmdmjuanfe;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity implements FragmentFiltro.OnButtonListener {
    FrameLayout sitio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sitio = findViewById(R.id.sitio);
        rellenarFragment();

    }

    private void rellenarFragment() {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(sitio.getId(),new FragmentFiltro(),FragmentFiltro.class.getName());
        ft.addToBackStack(FragmentFiltro.class.getName());
        ft.commit();
    }

    @Override
    public void onClick(String genero) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(sitio.getId(), FragmentFiltrado.newInstance(genero),FragmentFiltrado.class.getSimpleName());
        ft.addToBackStack(FragmentFiltrado.class.getName());
        ft.commit();
    }
}
