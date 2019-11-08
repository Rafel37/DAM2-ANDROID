package com.juanfe.equipos.adaptadores;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.juanfe.equipos.R;
import com.juanfe.equipos.utils.Jugador;

import java.util.ArrayList;

public class AdaptadorRecyclerAlineacion extends RecyclerView.Adapter<AdaptadorRecyclerAlineacion.HolderAlineacion>{
    Context context;
    ArrayList lista;

    public AdaptadorRecyclerAlineacion(Context context, ArrayList lista) {
        this.context = context;
        this.lista = lista;
    }

    @NonNull
    @Override
    public HolderAlineacion onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_recycler_alineacion,viewGroup,false);
        HolderAlineacion h = new HolderAlineacion(v);
        return h;
    }

    @Override
    public void onBindViewHolder(@NonNull HolderAlineacion holderAlineacion, int i) {
        Jugador j = (Jugador) lista.get(i);

        Glide.with(context).load(j.getImagen()).into(holderAlineacion.getImagenJugador());
        holderAlineacion.getNombreJ().setText(j.getNombre());
        holderAlineacion.getPosicionJ().setText(j.getPsicion());


    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    class HolderAlineacion extends RecyclerView.ViewHolder {
        ImageView imagenJugador;
        TextView nombreJ,posicionJ;

        public HolderAlineacion(@NonNull View v) {
            super(v);
            imagenJugador = v.findViewById(R.id.jugador);
            nombreJ = v.findViewById(R.id.nombre);
            posicionJ = v.findViewById(R.id.posicion);
        }

        public ImageView getImagenJugador() {
            return imagenJugador;
        }

        public TextView getNombreJ() {
            return nombreJ;
        }

        public TextView getPosicionJ() {
            return posicionJ;
        }
    }
}
