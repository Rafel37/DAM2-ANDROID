package com.example.joseg.tema3.EjerciciosClase.Dialogos;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;

public class DialogoSiNo extends DialogFragment {

    private OnDialogoSiNoListener onDialogoSiNoListener;
    private final static String TAG_ARG1 = "argumento1";
    private String titulo = "";

    public static DialogoSiNo newInstance(String titulo){

        DialogoSiNo dialogoSiNo = new DialogoSiNo();
        Bundle b = new Bundle();
        b.putString(TAG_ARG1,titulo);
        dialogoSiNo.setArguments(b);
        return dialogoSiNo;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            onDialogoSiNoListener = (OnDialogoSiNoListener) context;
        }catch (ClassCastException e){
            Log.v("test","no se ha podido instanciar");
        }
        if (this.getArguments() != null){
            titulo = this.getArguments().getString(TAG_ARG1);
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        onDialogoSiNoListener = null;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(titulo);
        builder.setMessage("¿Estas seguro de que quieres continuar?");
        builder.setPositiveButton("Si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                onDialogoSiNoListener.onDialogoSiSelected("Si pulsado");
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                onDialogoSiNoListener.onDialogoNoSelected("No pulsado");
            }
        });
        builder.setNeutralButton("Cerrar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                onDialogoSiNoListener.onDialogoNeutralSelected("Neutral pulsado");
            }
        });
        return builder.create();
    }

    public interface OnDialogoSiNoListener{
        public void onDialogoSiSelected(String s);
        public void onDialogoNeutralSelected(String s);
        public void onDialogoNoSelected(String s);
    }
}
