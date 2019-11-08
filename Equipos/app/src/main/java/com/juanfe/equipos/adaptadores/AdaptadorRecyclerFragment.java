package com.juanfe.equipos.adaptadores;

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
import com.juanfe.equipos.R;
import com.juanfe.equipos.utils.Equipo;

import java.util.ArrayList;

public class AdaptadorRecyclerFragment extends RecyclerView.Adapter<AdaptadorRecyclerFragment.Holder> {
    Context context;
    ArrayList lista;
    OnRecyclerListener onRecyclerListener;


    public AdaptadorRecyclerFragment(Context context, ArrayList lista) {
        this.context = context;
        this.lista = lista;
        onRecyclerListener = (OnRecyclerListener) context;
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
        final Equipo e = (Equipo) lista.get(i);
        Glide.with(context).load(e.getCamiseta()).into(holder.getCamiseta());
        Glide.with(context).load(e.getEscudo()).into(holder.getEscudo());
        Glide.with(context).load(e.getEstadio()).into(holder.getEstadio());
        holder.getNombre().setText(e.getNombre());
        holder.getLinear().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onRecyclerListener.onRecyclerSelected(e);
            }
        });



    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    class Holder extends RecyclerView.ViewHolder {
        ImageView camiseta, estadio,escudo;
        TextView nombre;
        LinearLayout linear;

        public Holder(@NonNull View v) {
            super(v);
            camiseta = v.findViewById(R.id.camisetaRecycler);
            estadio = v.findViewById(R.id.ImagenStadio);
            escudo = v.findViewById(R.id.imagenEscudo);
            nombre = v.findViewById(R.id.nombreRecycler);
            linear = v.findViewById(R.id.layoutlinear);
        }

        public ImageView getCamiseta() {
            return camiseta;
        }

        public ImageView getEstadio() {
            return estadio;
        }

        public ImageView getEscudo() {
            return escudo;
        }

        public TextView getNombre() {
            return nombre;
        }

        public LinearLayout getLinear() {
            return linear;
        }
    }

    public interface OnRecyclerListener{
        void onRecyclerSelected(Equipo e);
    }
}
