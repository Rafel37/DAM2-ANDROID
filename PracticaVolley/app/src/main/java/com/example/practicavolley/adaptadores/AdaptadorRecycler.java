package com.example.practicavolley.adaptadores;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.practicavolley.R;
import com.example.practicavolley.utils.Equipo;

import java.util.List;

public class AdaptadorRecycler extends RecyclerView.Adapter<AdaptadorRecycler.MiHolder> {

    private List lista;
    private Context context;
    private OnEquipoRecyclerListener onEquipoRecyclerListener;

    public AdaptadorRecycler(List lista, Context context) {
        this.lista = lista;
        this.context = context;
        onEquipoRecyclerListener = (OnEquipoRecyclerListener) context;
    }

    @NonNull
    @Override
    public MiHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_recycler, viewGroup, false);
        return new MiHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MiHolder miHolder, int i) {
        final Equipo equipo = (Equipo) lista.get(i);
        miHolder.getNombre().setText(equipo.getNombre());
        Glide.with(context).load(equipo.getImCamiseta()).into(miHolder.getImagenCamiseta());
        Glide.with(context).load(equipo.getImEscudo()).into(miHolder.getImagenEscudo());
        Glide.with(context).load(equipo.getImEstadio()).into(miHolder.getImagenEstadio());
        miHolder.getLinearLayout().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onEquipoRecyclerListener.onEquipoRecyclerSelected(equipo);
            }
        });
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    class MiHolder extends RecyclerView.ViewHolder {

        LinearLayout linearLayout;
        ImageView imagenCamiseta, imagenEscudo, imagenEstadio;
        TextView nombre;

        private MiHolder(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.nombre);
            imagenCamiseta = itemView.findViewById(R.id.imagenCamiseta);
            imagenEscudo = itemView.findViewById(R.id.imagenEscudo);
            imagenEstadio = itemView.findViewById(R.id.imagenEstadio);
            linearLayout = itemView.findViewById(R.id.linearVersion);
        }

        public TextView getNombre() {
            return nombre;
        }

        private ImageView getImagenCamiseta() {
            return imagenCamiseta;
        }

        private ImageView getImagenEscudo() {
            return imagenEscudo;
        }

        private ImageView getImagenEstadio() {
            return imagenEstadio;
        }

        private LinearLayout getLinearLayout() {
            return linearLayout;
        }

    }

    public interface OnEquipoRecyclerListener {
        void onEquipoRecyclerSelected(Equipo equipo);
    }
}