package com.example.practicavolley.adaptadores;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.practicavolley.R;
import com.example.practicavolley.utils.Equipo;
import com.example.practicavolley.utils.Jugador;

import java.util.List;

public class AdaptadorRecyclerDetalle extends RecyclerView.Adapter<AdaptadorRecyclerDetalle.MiHolder> {

    private List lista;
    private Context context;

    public AdaptadorRecyclerDetalle(List lista, Context context) {
        this.lista = lista;
        this.context = context;
    }

    @NonNull
    @Override
    public MiHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_recycler_detalle, viewGroup, false);
        return new MiHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MiHolder miHolder, int i) {
        final Jugador jugador = (Jugador) lista.get(i);
        Glide.with(context).load(jugador.getImagen()).into(miHolder.getImagenJugador());
        miHolder.getNombreJugador().setText(jugador.getNombre());
        miHolder.getPosicionJugador().setText(jugador.getPosicion());
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    class MiHolder extends RecyclerView.ViewHolder {

        ImageView imagenJugador;
        TextView nombreJugador, posicionJugador;

        private MiHolder(@NonNull View itemView) {
            super(itemView);
            imagenJugador = itemView.findViewById(R.id.imagenJugador);
            nombreJugador = itemView.findViewById(R.id.nombreJugador);
            posicionJugador = itemView.findViewById(R.id.posicionJugador);
        }

        private ImageView getImagenJugador() {
            return imagenJugador;
        }

        private TextView getNombreJugador() {
            return nombreJugador;
        }

        private TextView getPosicionJugador() {
            return posicionJugador;
        }
    }
}