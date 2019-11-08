package com.example.rpc_2eva.adaptadores;

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
import com.example.rpc_2eva.R;
import com.example.rpc_2eva.utils.Pelis;

import java.util.List;

public class AdaptadorFiltro extends RecyclerView.Adapter<AdaptadorRecycler.MiHolder>{

    private List list;
    private Context context;

    public AdaptadorFiltro(List list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public AdaptadorRecycler.MiHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_recycler, viewGroup, false);
        return new AdaptadorRecycler.MiHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorRecycler.MiHolder miHolder, int i) {
        final Pelis pelis = (Pelis) list.get(i);
        miHolder.getTitulo().setText(pelis.getNombre());
        Glide.with(context).load(pelis.getCartel()).into(miHolder.getCartel());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MiHolder extends RecyclerView.ViewHolder {

        LinearLayout linearLayout;
        ImageView cartel;
        TextView titulo;

        public MiHolder(@NonNull View itemView) {
            super(itemView);
            cartel = itemView.findViewById(R.id.imagenRecycler);
            titulo = itemView.findViewById(R.id.textRecycler);
        }

        public LinearLayout getLinearLayout() {
            return linearLayout;
        }

        public ImageView getCartel() {
            return cartel;
        }

        public TextView getTitulo() {
            return titulo;
        }
    }
}
