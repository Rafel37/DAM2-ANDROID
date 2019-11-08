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

public class DialogRegistrar extends DialogFragment implements View.OnClickListener {

    OnDialogoRegistrarListener onDialogoRegistrarListener;
    Button bok;
    EditText nombre, apellido, edad, correo, pass;
    View v;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        v = LayoutInflater.from(context).inflate(R.layout.dialog_registrar, null);
        try {
            onDialogoRegistrarListener = (OnDialogoRegistrarListener) context;
        }catch (ClassCastException e){
            Log.v("test","no se ha podido instanciar");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        onDialogoRegistrarListener = null;
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
        bok.setOnClickListener(this);
    }

    private void instancias() {
        bok = v.findViewById(R.id.btnOkLR);
        nombre = v.findViewById(R.id.inputNombreLR);
        apellido = v.findViewById(R.id.inputApellidoLR);
        edad = v.findViewById(R.id.inputEdadLR);
        correo = v.findViewById(R.id.inputCorreoLR);
        pass = v.findViewById(R.id.inputPassLR);
    }

    @Override
    public void onClick(View v) {

        if (nombre.getText().toString().isEmpty() || apellido.getText().toString().isEmpty() || edad.getText().toString().isEmpty() || correo.getText().toString().isEmpty() || pass.getText().toString().isEmpty())
            Toast.makeText(getContext(),"Faltan datos", Toast.LENGTH_SHORT);
        else {
            onDialogoRegistrarListener.onDialogoOkSelected(new Usuario(nombre.getText().toString(),apellido.getText().toString(), pass.getText().toString(), correo.getText().toString(), Integer.parseInt(edad.getText().toString())));
            dismiss();
        }
    }

    public interface OnDialogoRegistrarListener{
        public void onDialogoOkSelected(Usuario u);
    }
}
