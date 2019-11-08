package com.example.joseg.practica_final_tri1.Dialogos;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;

public class DialogResultado extends android.support.v4.app.DialogFragment {

    private OnDialogoResultadoListener onDialogoResultadoListener;
    private final static String TAG_ARG1 = "argumento1";
    private String resultado = "";

    public static DialogResultado newInstance(String resultado){

        DialogResultado dialogoSiNo = new DialogResultado();
        Bundle b = new Bundle();
        b.putString(TAG_ARG1,resultado);
        dialogoSiNo.setArguments(b);
        return dialogoSiNo;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            onDialogoResultadoListener = (OnDialogoResultadoListener) context;
        }catch (ClassCastException e){
            Log.v("test","no se ha podido instanciar");
        }
        if (this.getArguments() != null){
            resultado = this.getArguments().getString(TAG_ARG1);
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        onDialogoResultadoListener = null;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(Objects.requireNonNull(getActivity()));
        switch (resultado){
            case "g":
                builder.setTitle("Enhorabuena");
                builder.setMessage("Ingresa tu nombre para recordarte");
                final EditText nombre = new EditText(getContext());
                builder.setView(nombre);
                builder.setNeutralButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (nombre.getText().toString().isEmpty())
                            Toast.makeText(getContext(),"No has introducido tu nombre :(",Toast.LENGTH_SHORT).show();
                        else if (!nombre.getText().toString().matches("[a-zñáéíóúüA-ZÑÁÉÍÓÚ]{0,20}(\\s[a-zñáéíóúüA-ZÑÁÉÍÓÚ]{0,20})?")){
                            Toast.makeText(getContext(),"Nombre no valido :(",Toast.LENGTH_SHORT).show();
                        }else {
                            onDialogoResultadoListener.onNombreIngresed(nombre.getText().toString());
                        }
                    }
                });
                break;
            case "e":
                builder.setTitle("Que lastima");
                builder.setMessage("Has terminado el juego sin puntuacion");
                break;
            case "p":
                builder.setTitle("Es un pena");
                builder.setMessage("Se acabó el tiempo, suerte la proxima vez");
                break;
        }

        return builder.create();
    }

    public interface OnDialogoResultadoListener {
        void onNombreIngresed(String nombre);
    }

}
