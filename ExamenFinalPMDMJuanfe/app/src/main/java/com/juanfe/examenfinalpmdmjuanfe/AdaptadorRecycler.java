package com.juanfe.examenfinalpmdmjuanfe;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.juanfe.examenfinalpmdmjuanfe.utils.Pelicula;

import java.util.ArrayList;

public class AdaptadorRecycler extends RecyclerView.Adapter<AdaptadorRecycler.Holder> {
    Context context;
    ArrayList lista;

    public AdaptadorRecycler(Context context, ArrayList lista) {
        this.context = context;
        this.lista = lista;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_recycler,viewGroup,false);
        Holder h = new Holder(v);
        return h;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int i) {
        Pelicula p = (Pelicula) lista.get(i);

        holder.getTexto().setText(p.getTitulo());
        Glide.with(context).load(p.getImagen()).into(holder.getImagen());
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    class Holder extends RecyclerView.ViewHolder {
        ImageView imagen;
        TextView texto;

        public Holder(@NonNull View v) {
            super(v);
            imagen = v.findViewById(R.id.imagenRecycler);
            texto = v.findViewById(R.id.textorecycler);
        }

        public ImageView getImagen() {
            return imagen;
        }

        public TextView getTexto() {
            return texto;
        }
    }
}
