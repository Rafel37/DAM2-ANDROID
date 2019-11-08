package com.example.joseg.practica_final_tri1.Adaptadores;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.joseg.practica_final_tri1.R;
import com.example.joseg.practica_final_tri1.Utils.Jugador;

import java.util.List;

public class Adaptador_RecyclerView_Records extends RecyclerView.Adapter<Adaptador_RecyclerView_Records.MiHolderJugador> {

    List list;
    Context context;

    public Adaptador_RecyclerView_Records(List list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public MiHolderJugador onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_recycler_record, viewGroup, false);
        MiHolderJugador holder = new MiHolderJugador(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MiHolderJugador miHolder, int i) {
        final Jugador J = (Jugador) list.get(i);
        miHolder.getImagen().setImageResource(J.getIcono());
        miHolder.getNombre().setText(J.getNombre());
        miHolder.getPuntos().setText(String.valueOf(J.getPuntuacion()));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MiHolderJugador extends RecyclerView.ViewHolder {

        ImageView imagen;
        TextView nombre, puntos;

        public MiHolderJugador(@NonNull View itemView) {
            super(itemView);
            puntos = itemView.findViewById(R.id.puntos);
            nombre = itemView.findViewById(R.id.nombre);
            imagen = itemView.findViewById(R.id.icono);
        }

        public TextView getPuntos() {
            return puntos;
        }

        public ImageView getImagen() {
            return imagen;
        }

        public TextView getNombre() {
            return nombre;
        }
    }

}
