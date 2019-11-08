package com.example.joseg.practica_final_tri1.Dialogos;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.joseg.practica_final_tri1.Adaptadores.Adaptador_Spinner_Dificultad;
import com.example.joseg.practica_final_tri1.R;
import com.example.joseg.practica_final_tri1.Utils.Dificultad;

import java.util.Objects;

public class DialogoSpinner extends DialogFragment {

    View v;
    Spinner spinner;
    Adaptador_Spinner_Dificultad adaptadorspinner;
    Context context;
    OnDialogoSpinnerListener onDialogoSpinnerListener;
    Dificultad d;


    @SuppressLint("InflateParams")
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        v = LayoutInflater.from(context).inflate(R.layout.dialog_spinner, null);
        try {
            onDialogoSpinnerListener = (OnDialogoSpinnerListener) context;
        }catch (ClassCastException e){
            Log.v("t","no se instancio");
        }
        this.context = context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        onDialogoSpinnerListener = null;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(Objects.requireNonNull(getActivity()));
        instancias();
        acciones();
        builder.setView(v);
        builder.setNeutralButton("Empezar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                if (d != null)
                    onDialogoSpinnerListener.onDificultadSeleccionada(d);
                else Toast.makeText(context,"Dificultad no seleccionada",Toast.LENGTH_SHORT).show();

            }
        });
        return builder.create();
    }

    private void acciones() {
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                d = (Dificultad) parent.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void instancias() {
        adaptadorspinner = new Adaptador_Spinner_Dificultad(getContext());
        spinner = v.findViewById(R.id.spinnerDialog);
        spinner.setAdapter(adaptadorspinner);
    }

    public interface OnDialogoSpinnerListener {

        void onDificultadSeleccionada(Dificultad d);

    }
}
