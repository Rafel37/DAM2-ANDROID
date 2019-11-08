package com.example.practicamasterdetail.fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.practicamasterdetail.DataSet;
import com.example.practicamasterdetail.R;
import com.example.practicamasterdetail.adaptadores.AdaptadorRecycler02;

import java.util.ArrayList;


public class Fragment02 extends Fragment {

    RecyclerView recyclerView;
    View view;
    Context c;
    ArrayList arrayList;
    int i;

    public static Fragment02 newInstance(int i) {
        Fragment02 f2 = new Fragment02();
        Bundle b = new Bundle();
        b.putSerializable("ligas",i);
        f2.setArguments(b);
        return f2;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        c = context;
        i = getArguments().getInt("ligas");
        if (getArguments() != null) {
            switch (i){
                case 0:
                    arrayList = DataSet.newInstance().setEquiposBundesliga();
                    break;
                case 1:
                    arrayList = DataSet.newInstance().setEquiposPremier();
                    break;
                case 2:
                    arrayList = DataSet.newInstance().setEquiposSerie();
                    break;
                case 3:
                    arrayList = DataSet.newInstance().setEquiposPrimera();
                    break;
            }
        }
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment02, container, false);
        recyclerView = view.findViewById(R.id.recycler02);
        recyclerView.setAdapter(new AdaptadorRecycler02(c, arrayList, i));
        recyclerView.setLayoutManager(new LinearLayoutManager(c, LinearLayoutManager.VERTICAL, false));
        return view;
    }
}
