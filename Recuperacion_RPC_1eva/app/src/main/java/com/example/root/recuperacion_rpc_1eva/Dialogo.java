package com.example.root.recuperacion_rpc_1eva;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.widget.Toast;

import java.util.List;

public class Dialogo  extends DialogFragment {

    List list;
    String number;
    CallbackNumero callbackNumero;


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Generar numero de la loteria");

        int min = 0;
        int max = 99999;
        final int numero;
        numero = (int) (Math.random() * (max - min + 1) + min);

        builder.setMessage("El numero generado es: " + numero);
        builder.setPositiveButton("ENVIAR A LA LISTA", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                Toast.makeText(getContext(), "pulsado", Toast.LENGTH_SHORT).show();
            }
        });
        return builder.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        callbackNumero = (CallbackNumero) context;

    }

    public List getList() {
        return list;
    }
    interface CallbackNumero{
        void Oncreado (int numero);
    }
}
