package com.example.juanfe.subidadenota;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

public class Dialogo extends DialogFragment {

    String number;
    TextView texto;
    View v;
    CallbackDialogo cbd;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder b = new AlertDialog.Builder(getActivity());
        b.setTitle("Generar numero de la loteria");
        b.setView(v);
        texto = v.findViewById(R.id.generado);
        texto.setText(number);
        b.setPositiveButton("ENVIAR A LA LISTA", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                cbd.Oncreado(Integer.valueOf(number));

            }
        });
        return b.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        v = LayoutInflater.from(context).inflate(R.layout.vista_dialogo,null);
        if (getArguments()!=null){
            number = getArguments().getString("valor");

        }
        cbd = (CallbackDialogo) context;
    }

    public static Dialogo newInstance(int numero){
        Dialogo d = new Dialogo();
        Bundle b = new Bundle();
        b.putString("valor", String.valueOf(numero));
        d.setArguments(b);
        return  d;

    }

    interface CallbackDialogo{
        void Oncreado(int numero);
    }


}
