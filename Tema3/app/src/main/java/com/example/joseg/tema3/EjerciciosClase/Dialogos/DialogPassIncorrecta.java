package com.example.joseg.tema3.EjerciciosClase.Dialogos;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

public class DialogPassIncorrecta extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("¡Error!");
        builder.setMessage("Contraseña incorrecta.");
        return builder.create();
    }
}
