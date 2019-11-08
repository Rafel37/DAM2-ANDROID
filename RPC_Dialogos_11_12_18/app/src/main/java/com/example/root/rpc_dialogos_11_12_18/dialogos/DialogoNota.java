package com.example.root.rpc_dialogos_11_12_18.dialogos;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import com.example.root.rpc_dialogos_11_12_18.R;

public class DialogoNota extends DialogFragment {

    EditText editText;
    View view;
//    OnNombreListener listener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        editText = view.findViewById(R.id.spinnerNota);
        view = LayoutInflater.from(context).inflate(R.layout.nota_layout, null);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Examen PMDM");
        builder.setMessage("");
        return builder.create();
    }



}
