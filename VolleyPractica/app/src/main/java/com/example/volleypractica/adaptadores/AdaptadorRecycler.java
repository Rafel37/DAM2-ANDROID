package com.example.volleypractica.adaptadores;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.volleypractica.R;
import com.example.volleypractica.fragments.FragmentDetalle;
import com.example.volleypractica.utils.Equipo;
import com.example.volleypractica.utils.Jugador;

import java.util.ArrayList;

public class AdaptadorRecycler extends RecyclerView.Adapter<AdaptadorRecycler.HolderAdaptador> {

    Context c;
    ArrayList<Equipo> equipos;
    OnAdaptadorListener listener;

    public AdaptadorRecycler(Context c) {

        equipos = new ArrayList();
        equipos.add(new Equipo(R.drawable.hombre, R.drawable.hombre, R.drawable.hombre));
        equipos.add(new Equipo(R.drawable.mujer, R.drawable.mujer, R.drawable.mujer));
        equipos.add(new Equipo(R.drawable.registrar, R.drawable.registrar, R.drawable.registrar));
        equipos.add(new Equipo(R.drawable.hombre, R.drawable.hombre, R.drawable.hombre));
        equipos.add(new Equipo(R.drawable.mujer, R.drawable.mujer, R.drawable.mujer));
        equipos.add(new Equipo(R.drawable.registrar, R.drawable.registrar, R.drawable.registrar));
        this.c = c;
        listener = (OnAdaptadorListener) c;
    }

    @NonNull
    @Override
    public HolderAdaptador onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(c).inflate(R.layout.item_recycler, viewGroup, false);
        return new HolderAdaptador(v);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderAdaptador holder, int i) {
        final Equipo e = equipos.get(i);
        holder.getImgCamiseta().setImageResource(e.getCamiseta());
        holder.getImgEscudo().setImageResource(e.getEscudo());
        holder.getImgEstadio().setImageResource(e.getEstadio());
        holder.getImgCamiseta().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onAdaptadorSelected(e);

            }
        });
    }

    @Override
    public int getItemCount() {
        return equipos.size();
    }

    public interface OnAdaptadorListener {
        void onAdaptadorSelected(Equipo equipo);
        //void onAdaptadorSelected(Jugador equipo);
    }

    class HolderAdaptador extends RecyclerView.ViewHolder {

        ImageView imgCamiseta, imgEstadio, imgEscudo;

        public HolderAdaptador(@NonNull View itemView) {
            super(itemView);

            imgCamiseta = itemView.findViewById(R.id.eqCamiseta);
            imgEstadio = itemView.findViewById(R.id.eqEstadio);
            imgEscudo = itemView.findViewById(R.id.eqEscudo);

        }

        public ImageView getImgCamiseta() {
            return imgCamiseta;
        }

        public ImageView getImgEstadio() {
            return imgEstadio;
        }

        public ImageView getImgEscudo() {
            return imgEscudo;
        }
    }
}
