package com.example.rpc_examen_1_2_19.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rpc_examen_1_2_19.R;

public class Fragment02 extends Fragment {

    View view;
    RecyclerView recyclerView;
    OnFragmen2Listener fragmen2Listener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        fragmen2Listener = (OnFragmen2Listener) context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_02, container, false);
        recyclerView = view.findViewById(R.id.recycler02);
        return view;
    }

    public  interface OnFragmen2Listener {
        public void onFragment2Selected();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        fragmen2Listener = null;
    }
}
