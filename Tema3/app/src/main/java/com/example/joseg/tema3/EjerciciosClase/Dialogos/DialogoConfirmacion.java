package com.example.joseg.tema3.EjerciciosClase.Dialogos;

import android.support.v7.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.util.Log;

public class DialogoConfirmacion extends DialogFragment implements DialogInterface.OnClickListener {

    OnDialogoConfirmacionListener onDialogoConfirmacionListener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            onDialogoConfirmacionListener = (OnDialogoConfirmacionListener) context;
        }catch (ClassCastException e){
            Log.v("test","no se ha podido instanciar");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        onDialogoConfirmacionListener = null;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Dialogo confirmación");
        builder.setMessage("Mensaje del dialogo confirmación");
        builder.setNeutralButton("Confirmar", this);
        return builder.create();
    }

    @Override
    public void onClick(final DialogInterface dialog, int which) {
        /*Handler h = new Handler();
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                onDialogoConfirmacionListener.onDialogoConfirmacionSelected();
                dismiss();
            }
        },2000);*/
        onDialogoConfirmacionListener.onDialogoConfirmacionSelected();
    }

    public interface OnDialogoConfirmacionListener{
        public void onDialogoConfirmacionSelected();
    }
}
