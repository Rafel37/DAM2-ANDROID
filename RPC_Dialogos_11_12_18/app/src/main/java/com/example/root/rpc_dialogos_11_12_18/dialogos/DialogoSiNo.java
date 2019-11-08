package com.example.root.rpc_dialogos_11_12_18.dialogos;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.util.Log;

import com.example.root.rpc_dialogos_11_12_18.R;

public class DialogoSiNo extends DialogFragment {

    onDialogSINOListener listener;

    public static DialogoSiNo newInstance(String titulo) {

        DialogoSiNo dialogoSiNo = new DialogoSiNo();
        return dialogoSiNo;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Examen PMDM");
        builder.setMessage("Bienvenido al examen de PMDM, ¿estas seguro que quieres continuar?");

        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dismiss();
            }
        });
        builder.setPositiveButton("SI", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                listener.onDialogSiSelected("si");
                dismiss();
            }
        });
        return builder.create();
    }

    public interface onDialogSINOListener {
        public void onDialogSiSelected(String s);
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            listener = (onDialogSINOListener) context;
        }
        catch (ClassCastException e) {
            Log.v("error", "error al castear");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

}
