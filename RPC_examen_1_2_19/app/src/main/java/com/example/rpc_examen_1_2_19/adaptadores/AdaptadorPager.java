package com.example.rpc_examen_1_2_19.adaptadores;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.rpc_examen_1_2_19.fragments.Fragment01;
import com.example.rpc_examen_1_2_19.fragments.Fragment02;

import java.util.ArrayList;

public class AdaptadorPager extends FragmentPagerAdapter {

    ArrayList<Fragment> arrayList;

    public AdaptadorPager(FragmentManager fm) {
        super(fm);
        arrayList = new ArrayList<>();
        arrayList.add(new Fragment01());
        arrayList.add(new Fragment02());
    }

    public void cambiarFragment() {
        Fragment01 f1 = (Fragment01) arrayList.get(0);
        Fragment02 f2 = (Fragment02) arrayList.get(1);
    }

    @Override
    public Fragment getItem(int i) {
        return arrayList.get(i);
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return arrayList.get(position).getTag();
    }
}
