package com.example.joseg.tema3.EjerciciosClase.Dialogos;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.widget.Toast;

public class DialogoLista extends DialogFragment {

    OnDialogoListaListener onDialogoListaListener;
    Context context;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
        try {
            onDialogoListaListener = (OnDialogoListaListener) context;
        }catch (ClassCastException e){
            Log.v("test","no se ha podido instanciar");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        onDialogoListaListener = null;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        final String[] opciones = {"Opcion1","Opcion2","Opcion3"};

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Titulo lista");
        //Multiple
        builder.setMultiChoiceItems(opciones, null, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {

            }
        });
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        //Simple
        /*builder.setItems(opciones, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(context,opciones[which]+" seleccionado",Toast.LENGTH_SHORT);
                   onDialogoListaListener.onDialogoElementoSelected(opciones[which]);
            }
        });*/
        return builder.create();
    }

    public interface OnDialogoListaListener{
        public void onDialogoElementoSelected(String opcion);
    }

}
