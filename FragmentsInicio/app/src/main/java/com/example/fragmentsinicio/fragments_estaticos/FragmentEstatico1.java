    package com.example.fragmentsinicio.fragments_estaticos;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.fragmentsinicio.R;

public class FragmentEstatico1 extends Fragment implements View.OnClickListener{

    OnDataF1SelectedListener onDataF1SelectedListener;
    Button boton;
    EditText editText;
    View v;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            onDataF1SelectedListener = (OnDataF1SelectedListener) context;
        } catch (Exception e) {
            Log.v("Error", "La comunicacion no ha podido llevarse a cabo");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        onDataF1SelectedListener = null;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_estatico_1 , container, false);
        return v;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        instancias();
        acciones();
    }

    private void instancias() {

        boton = v.findViewById(R.id.botonFragment1);
        editText = v.findViewById(R.id.editText);
    }

    private void acciones() {

        boton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        onDataF1SelectedListener.onDataF1Selected(editText.getText().toString());
    }

    public interface OnDataF1SelectedListener {
        public void onDataF1Selected(String texto);
    }
}
