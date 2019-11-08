package com.example.volleypractica.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.volleypractica.R;
import com.example.volleypractica.utils.Equipo;
import com.example.volleypractica.utils.Jugador;

public class FragmentDetalle extends Fragment implements View.OnClickListener {

    View v;
    Context c;
    ImageView imgDet;
    TextView nombreDet, posicionDet;
    static String TAG_1 = "nomJugador";
    OnDetalleListener listener;


    public static FragmentDetalle newInstance(Equipo e) {

        Bundle args = new Bundle();
        args.putString(TAG_1, String.valueOf(e));
        FragmentDetalle fragment = new FragmentDetalle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        c = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_detalle, container, false);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        instancias();
        nombreDet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(c, nombreDet.getText(), Toast.LENGTH_SHORT).show();

            }
        });
        posicionDet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(c, posicionDet.getText(), Toast.LENGTH_SHORT).show();
            }
        });

    }


    private void instancias() {
        imgDet = v.findViewById(R.id.imgDetalle);
        nombreDet = v.findViewById(R.id.nameDetalle);
        posicionDet = v.findViewById(R.id.posDetalle);
    }

    @Override
    public void onClick(View v) {
        listener.onDetalleSelected(nombreDet.getText().toString());
        //Toast.makeText(c, "Se ha producido comunicación", Toast.LENGTH_SHORT).show();


    }

    public interface OnDetalleListener {
        public void onDetalleSelected(String nombre);
    }
}