package com.example.root.streetfighter;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DialogoPersonaje extends DialogFragment {

    View view;
    ImageView imageView;
    TextView nombre, tipo, pais;
    int imagen;
    String snombre, spais, stipo;


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder b = new AlertDialog.Builder(getActivity());
        b.setView(view);
        imageView = view.findViewById(R.id.imageView);
        tipo = view.findViewById(R.id.tipo);
        pais = view.findViewById(R.id.pais);
        nombre = view.findViewById(R.id.nombre);
        tipo.setText(stipo);
        pais.setText(spais);
        nombre.setText(snombre);
        imageView.setImageResource(imagen);


        return b.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        view  = LayoutInflater.from(context).inflate(R.layout.activity_dialogo,null);
        if (getArguments()!=null){
            snombre = getArguments().getString("nombre");
            spais = getArguments().getString("pais");
            stipo= getArguments().getString("tipo");
            imagen = getArguments().getInt("imagen");

        }

    }

    public static DialogoPersonaje newInstance(String nombre, String tipo, String pais, int imagen) {
        DialogoPersonaje p = new DialogoPersonaje();
        Bundle b = new Bundle();
        b.putString("nombre",nombre);
        b.putString("tipo", tipo);
        b.putString("pais",pais);
        b.putInt("imagen",imagen);
        p.setArguments(b);
        return p;
    }
}
