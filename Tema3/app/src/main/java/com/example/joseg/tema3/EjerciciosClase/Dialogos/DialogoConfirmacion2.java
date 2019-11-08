package com.example.joseg.tema3.EjerciciosClase.Dialogos;

import android.support.v7.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;

public class DialogoConfirmacion2 extends DialogFragment implements DialogInterface.OnClickListener {

    private final static String TAG_ARG1 = "argumento1";
    private String titulo = "";

    public static DialogoConfirmacion2 newInstance(String titulo){

        DialogoConfirmacion2 dialogoConfirmacion2 = new DialogoConfirmacion2();
        Bundle b = new Bundle();
        b.putString(TAG_ARG1,titulo);
        dialogoConfirmacion2.setArguments(b);
        return dialogoConfirmacion2;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (this.getArguments() != null){
            titulo = this.getArguments().getString(TAG_ARG1);
        }

    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(titulo);
        builder.setMessage("Dialogo con comunicacion");
        builder.setNeutralButton("Cerrar", this);
        return builder.create();
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {

    }
}
