package com.example.javier.practicaequiposfragment.Fragment;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.example.javier.practicaequiposfragment.Adaptator.AdaptadorRecycler;
import com.example.javier.practicaequiposfragment.R;
import com.example.javier.practicaequiposfragment.utils.Juegos;

import java.util.ArrayList;

public class FragmentJuegos extends Fragment implements AdaptadorRecycler.OnListener {

    Context context;
    View view;
    RecyclerView recyclerView;
    AdaptadorRecycler adapter;
    ArrayList<Juegos> arrayList;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view=inflater.inflate(R.layout.fragmentos_juegos,container,false);

        arrayList = new ArrayList<>();
        ArrayList<Juegos> arrayList = new ArrayList<>();
        arrayList.add(new Juegos(R.drawable.image_kh_birth_by_sleep, "Kingdom Heart Birth by Sleep"));
        arrayList.add(new Juegos(R.drawable.image_kh_birth_by_sleep_a_fragmentary_passage, "Kingdom Heart Birth by Sleep A Fragmentary Passage"));
        arrayList.add(new Juegos(R.drawable.image_kh, "Kingdom Heart"));
        arrayList.add(new Juegos(R.drawable.image_kh_358, "Kingdom Heart 358/2 Days"));
        arrayList.add(new Juegos(R.drawable.image_kh_recoded, "Kingdom Heart Recode"));
        arrayList.add(new Juegos(R.drawable.image_kh_ii, "Kingdom Heart II"));
        arrayList.add(new Juegos(R.drawable.image_kh_dream_drop_distance, "Kingdom Heart Dream Drop Distance"));
        arrayList.add(new Juegos(R.drawable.image_kh_iii, "Kingdom Heart III"));

        recyclerView = this.view.findViewById(R.id.recycler);
        adapter = new AdaptadorRecycler(context, arrayList);
        recyclerView.setAdapter(adapter);
        return this.view;
    }

    @Override
    public void OnCallBack(String nombre, int imagen) {

    }
}