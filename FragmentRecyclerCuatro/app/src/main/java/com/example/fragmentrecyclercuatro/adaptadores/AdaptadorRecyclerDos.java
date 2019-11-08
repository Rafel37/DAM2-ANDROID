package com.example.fragmentrecyclercuatro.adaptadores;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fragmentrecyclercuatro.R;
import com.example.fragmentrecyclercuatro.utils.Lugar;

import java.util.ArrayList;

public class AdaptadorRecyclerDos extends RecyclerView.Adapter<AdaptadorRecyclerDos.HolderDos> {

    Context c;
    ArrayList<Lugar> listaDos;
    OnElementoAdaptadorDosListener listenerDos;

    public AdaptadorRecyclerDos(Context c) {
        this.c = c;
        listaDos = new ArrayList<>();

        listaDos.add(new Lugar("Fondo Blanka", R.drawable.fondo_blanka));
        listaDos.add(new Lugar("Fondo Chunly", R.drawable.fondo_chunly));
        listaDos.add(new Lugar("Fondo Dalsim", R.drawable.fondo_dalsim));
        listaDos.add(new Lugar("Fondo Guille", R.drawable.fondo_guille));
        listaDos.add(new Lugar("Fondo Honda", R.drawable.fondo_honda));
        listaDos.add(new Lugar("Fondo Ken", R.drawable.fondo_ken));
        listaDos.add(new Lugar("Fondo Ryu", R.drawable.fondo_ryu));
        listaDos.add(new Lugar("Fondo Zang", R.drawable.fondo_zang));

        listenerDos = (OnElementoAdaptadorDosListener) c;
    }

    @NonNull
    @Override
    public HolderDos onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(c).inflate(R.layout.item_recycler_dos, viewGroup, false);

        return new HolderDos(v);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderDos holderUno, int i) {
        final Lugar lugar = listaDos.get(i);
        holderUno.getTextoNombre().setText(lugar.getNombre());
        holderUno.getImagenPersonaje().setImageResource(lugar.getImagen());
        holderUno.getTextoNombre().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listenerDos.onElementoDosSelected();
            }
        });
    }

    @Override
    public int getItemCount() {
        return listaDos.size();
    }

    public interface OnElementoAdaptadorDosListener {
        public void onElementoDosSelected();
    }

    class HolderDos extends RecyclerView.ViewHolder {

        TextView textoNombre;
        ImageView imagenFondo;

        public HolderDos(@NonNull View itemView) {
            super(itemView);
            textoNombre = itemView.findViewById(R.id.nombreItemDos);
            imagenFondo = itemView.findViewById(R.id.imagenItemDos);
        }

        public TextView getTextoNombre() {
            return textoNombre;
        }

        public ImageView getImagenPersonaje() {
            return imagenFondo;
        }
    }
}
