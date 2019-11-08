package com.example.javier.practica_navigation.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.javier.practica_navigation.R;

public class FragmentDetalle extends Fragment {
    View v;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_detalle,container,false);
        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    public static FragmentDetalle newInstance() {

        Bundle args = new Bundle();

        FragmentDetalle fragment = new FragmentDetalle();
        fragment.setArguments(args);
        return fragment;
    }
}
