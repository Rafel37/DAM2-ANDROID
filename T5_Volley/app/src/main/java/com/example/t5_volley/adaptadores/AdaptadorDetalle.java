package com.example.t5_volley.adaptadores;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.t5_volley.R;
import com.example.t5_volley.utils.Jugador;

import java.util.ArrayList;

public class AdaptadorDetalle extends RecyclerView.Adapter<AdaptadorDetalle.HolderDetalle>{
    Context context;
    ArrayList lista;

    public AdaptadorDetalle(Context context, ArrayList lista) {
        this.context = context;
        this.lista = lista;
    }

    @NonNull
    @Override
    public HolderDetalle onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_detalle,viewGroup,false);
        HolderDetalle holder = new HolderDetalle(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull HolderDetalle holderDetalle, int i) {
        Jugador jugador = (Jugador) lista.get(i);

        Glide.with(context).load(jugador.getImagen()).into(holderDetalle.getImagenJugador());
        holderDetalle.getNombreJ().setText(jugador.getNombre());
        holderDetalle.getPosicionJ().setText(jugador.getPosicion());


    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    class HolderDetalle extends RecyclerView.ViewHolder {
        ImageView imagenJugador;
        TextView nombreJ,posicionJ;

        public HolderDetalle(@NonNull View v) {
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
