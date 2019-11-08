package com.juanfe.t5_baseexterna;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class AdaptadorPager extends FragmentPagerAdapter {
    ArrayList<Fragment> lista;
    public AdaptadorPager(FragmentManager fm) {
        super(fm);
        this.lista = new ArrayList<>();
        lista.add(new FragmentListaUsuarios());
        lista.add(new FragmentRegistro());


    }

    @Override
    public Fragment getItem(int i) {
        return  lista.get(i);
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String[] nombres = {"Lista usuarios", "Agregar Usuarios"};

        return nombres[position];
    }
}
