package com.example.rafaelp.memorygame.dialogo;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.rafaelp.memorygame.adaptador.Adaptador;
import com.example.rafaelp.memorygame.utils.Peliculas;
import com.example.rafaelp.memorygame.R;

import java.util.ArrayList;

public class SpinnerDialogo extends DialogFragment  {

    Spinner spinner;
    View view;
    Pantalla pantalla;
    Peliculas peliculas;
    Context context;
    Adaptador adaptador;



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        view = LayoutInflater.from(context).inflate(R.layout.adaptador_spinner, null);
        try {
            pantalla = (Pantalla) context;
        }catch (ClassCastException e){
            Log.v("t","no se instancio");
        }
        this.context = context;    }

    @Override
    public void onDetach() {
        super.onDetach();
        pantalla = null;
    }


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builderDialogoSpinner = new AlertDialog.Builder(getActivity());


        instancias();
        acciones();
        builderDialogoSpinner.setView(view);
        builderDialogoSpinner.setNeutralButton("Empezar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                if (peliculas != null)
                    pantalla.pasarDificultad(peliculas);
                else
                    Toast.makeText(context,"Por favor seleccione una dificultad",Toast.LENGTH_SHORT).show();

            }
        });
        return builderDialogoSpinner.create();
    }



    private void acciones() {
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                peliculas = (Peliculas) parent.getSelectedItem();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void instancias() {
        adaptador = new Adaptador(getContext());
        spinner = view.findViewById(R.id.spinnerDificultad);
        spinner.setAdapter(adaptador);
    }

    public interface Pantalla {
        void pasarDificultad(Peliculas peliculas);

    }

}