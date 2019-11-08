package com.example.fragmentsinicio.fragments_dinamicos;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fragmentsinicio.R;

public class FragmentDinamico2 extends Fragment {

    View v;

    public static FragmentDinamico2 newInstance() {

        Bundle args = new Bundle();

        FragmentDinamico2 fragment = new FragmentDinamico2();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_dinamico_2 , container, false);
        return v;
    }
}
