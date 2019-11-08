package com.example.joseg.tema3.EjerciciosClase.Dialogos;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.joseg.tema3.EjerciciosClase.Utils.Usuario;
import com.example.joseg.tema3.R;

import java.util.Hashtable;

public class DialogLogin extends DialogFragment implements View.OnClickListener {

    final static String TAG_ARG1 = "arg1", TAG_ARG2 = "arg2";
    OnDialogoLoginListener onDialogoLoginListener;
    Button blogin;
    EditText correo, pass;
    View v;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        v = LayoutInflater.from(context).inflate(R.layout.dialog_login, null);

        try {
            onDialogoLoginListener = (OnDialogoLoginListener) context;
        }catch (ClassCastException e){
            Log.v("test","no se ha podido instanciar");
        }

    }

    @Override
    public void onDetach() {
        super.onDetach();
        onDialogoLoginListener = null;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        instancias();
        acciones();
        builder.setView(v);
        return builder.create();
    }

    private void acciones() {
        blogin.setOnClickListener(this);
    }

    private void instancias() {
        blogin = v.findViewById(R.id.btnLoginLR);
        correo = v.findViewById(R.id.inputCLoginLR);
        pass = v.findViewById(R.id.inputPLoginLR);
    }

    @Override
    public void onClick(View v) {

        if (correo.getText().toString().isEmpty() || pass.getText().toString().isEmpty())
            Toast.makeText(getContext(), "Faltan datos", Toast.LENGTH_SHORT);
        else {
            onDialogoLoginListener.onDialogoLoginSelected(correo.getText().toString(),pass.getText().toString());
            dismiss();
        }
    }
    public interface OnDialogoLoginListener{
        public void onDialogoLoginSelected(String correo, String pass);
    }
}
