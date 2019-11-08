package com.example.juanfe.subidadenota;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

public class DialogoRecycler extends DialogFragment {

    View v;
    TextView texto;
    String text;
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder b = new AlertDialog.Builder(getActivity());
        b.setView(v);
        texto = v.findViewById(R.id.textoRecycler);
        texto.setText(text);
        return b.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        v = LayoutInflater.from(context).inflate(R.layout.item_recycer,null);
        if (getArguments()!=null){
            text = getArguments().getString("texto");
        }
    }

    public static DialogoRecycler newInstance(String texto) {
        DialogoRecycler di = new DialogoRecycler();
        Bundle args = new Bundle();
        args.putString("texto",texto);


        di.setArguments(args);
        return di;
    }
}
