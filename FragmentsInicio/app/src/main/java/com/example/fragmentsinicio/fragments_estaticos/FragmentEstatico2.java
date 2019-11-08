package com.example.fragmentsinicio.fragments_estaticos;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.fragmentsinicio.R;

public class FragmentEstatico2 extends Fragment {

    TextView etiqueta;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_estatico_2 , container, false);
        etiqueta = v.findViewById(R.id.textoFragment2);
        return v;
    }

    public void cambiarEtiqueta (String texto){
        etiqueta.setText(texto);
    }
}
