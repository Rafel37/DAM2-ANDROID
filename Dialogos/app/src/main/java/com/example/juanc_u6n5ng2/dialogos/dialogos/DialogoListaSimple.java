package com.example.juanc_u6n5ng2.dialogos.dialogos;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.widget.Toast;

public class DialogoListaSimple extends DialogFragment {

    OnDialogoListaListener listener;
    Context context;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
        try {
            listener = (OnDialogoListaListener) context;
        }catch (ClassCastException e){
            Log.v("error","error en el casteo");
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        final String[] opciones = {"Opcion1","Opcion2","Opcion3"};

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("TITULO LISTA");
        //builder.setMessage("asdasd");
        builder.setItems(opciones, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getContext(),"Pulsado: "+ String.valueOf(which),Toast.LENGTH_SHORT).show();
                listener.onElementoListaSelected(opciones[which]);
            }
        });
        //builder.setMultiChoiceItems();
        return builder.create();
    }

    public interface OnDialogoListaListener{
        public void onElementoListaSelected(String s);
    }
}
