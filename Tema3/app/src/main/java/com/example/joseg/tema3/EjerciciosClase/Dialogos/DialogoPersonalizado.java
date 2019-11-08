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
import com.example.joseg.tema3.EjerciciosClase.Utils.Persona;
import com.example.joseg.tema3.R;

public class DialogoPersonalizado extends DialogFragment implements View.OnClickListener {

    OnDialogoPersoListener onDialogoPersoListener;
    Button bok, bcancelar;
    EditText nombre, apellido, edad;
    View v;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        v = LayoutInflater.from(context).inflate(R.layout.dialogo_personalizado, null);
        try {
            onDialogoPersoListener = (OnDialogoPersoListener) context;
        }catch (ClassCastException e){
            Log.v("test","no se ha podido instanciar");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        onDialogoPersoListener = null;
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
        bcancelar.setOnClickListener(this);
    }

    private void instancias() {
        bok = v.findViewById(R.id.btnOkDP);
        bcancelar = v.findViewById(R.id.btnCancelarDP);
        nombre = v.findViewById(R.id.inputNombre);
        apellido = v.findViewById(R.id.inputApellido);
        edad = v.findViewById(R.id.inputEdad);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnOkDP:
                if (nombre.getText().toString().isEmpty() || apellido.getText().toString().isEmpty() || edad.getText().toString().isEmpty())
                    Toast.makeText(getContext(),"Faltan datos", Toast.LENGTH_SHORT);
                else {
                    onDialogoPersoListener.onDialogoOkSelected(new Persona(nombre.getText().toString(), apellido.getText().toString(), Integer.parseInt(edad.getText().toString())));
                    dismiss();
                }
                break;
            case R.id.btnCancelarDP:
                nombre.setText("");
                apellido.setText("");
                edad.setText("");
                dismiss();
                break;
        }
    }

    public interface OnDialogoPersoListener{
        public void onDialogoOkSelected(Persona p);
    }
}
