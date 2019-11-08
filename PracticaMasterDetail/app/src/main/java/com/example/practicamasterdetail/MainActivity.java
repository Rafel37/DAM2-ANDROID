package com.example.practicamasterdetail;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.example.practicamasterdetail.adaptadores.AdaptadorRecycler01;
import com.example.practicamasterdetail.adaptadores.AdaptadorRecycler02;
import com.example.practicamasterdetail.fragments.Fragment01;
import com.example.practicamasterdetail.fragments.Fragment02;
import com.example.practicamasterdetail.fragments.Fragment03;

public class MainActivity extends AppCompatActivity implements AdaptadorRecycler01.LigasListener, AdaptadorRecycler02.EquipoListener{

    FrameLayout fragmentMaster;
    FrameLayout fragmentDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentMaster = findViewById(R.id.fragmentMain);
        fragmentDetail = findViewById(R.id.fragmentDetail);

        FragmentManager fm1= getSupportFragmentManager();
        FragmentTransaction ft1 = fm1.beginTransaction();
        ft1.replace(fragmentMaster.getId(),new Fragment01(),Fragment01.class.getName());
        ft1.addToBackStack(Fragment01.class.getName());
        ft1.commit();

        if (fragmentDetail == null) {

        }
        else {
            FragmentManager fm2 = getSupportFragmentManager();
            FragmentTransaction ft2 = fm2.beginTransaction();
            ft2.replace(fragmentDetail.getId(), Fragment02.newInstance(0), Fragment02.class.getName());
            ft2.addToBackStack(Fragment02.class.getName());
            ft2.commit();
        }


    }

    @Override
    public void LigasSelected(int i) {

        if (fragmentDetail == null) {
            FragmentManager fm= getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragmentMain, Fragment02.newInstance(i),Fragment01.class.getName());
            ft.addToBackStack(Fragment02.class.getName());
            ft.commit();
        }
        else {
            FragmentManager fm2 = getSupportFragmentManager();
            FragmentTransaction ft2 = fm2.beginTransaction();
            ft2.replace(fragmentDetail.getId(), Fragment02.newInstance(i), Fragment02.class.getName());
            ft2.addToBackStack(Fragment02.class.getName());
            ft2.commit();
        }
    }


    @Override
    public void EquipoSelected(int i, int posicion) {

        if (fragmentDetail == null) {
            FragmentManager fm= getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragmentMain, Fragment03.newInstance(i, posicion), Fragment02.class.getName());
            ft.addToBackStack(Fragment03.class.getName());
            ft.commit();
        }
        else {
            FragmentManager fm2 = getSupportFragmentManager();
            FragmentTransaction ft2 = fm2.beginTransaction();
            ft2.replace(fragmentDetail.getId(), Fragment03.newInstance(i, posicion), Fragment02.class.getName());
            ft2.addToBackStack(Fragment03.class.getName());
            ft2.commit();
        }

    }

}
