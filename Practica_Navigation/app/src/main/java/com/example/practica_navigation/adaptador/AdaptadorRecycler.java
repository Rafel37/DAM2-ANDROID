package com.example.practica_navigation.adaptador;

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
import com.example.practica_navigation.R;
import com.example.practica_navigation.utils.Objeto;

import java.util.ArrayList;

public class AdaptadorRecycler extends RecyclerView.Adapter<AdaptadorRecycler.Holder>{

    Context context;
    OnRecyclerClickListener onRecyclerClickListener;
    ArrayList<Objeto> lista;


    public AdaptadorRecycler(Context context, ArrayList lista) {
        this.context = context;
        this.lista = lista;
        onRecyclerClickListener = (OnRecyclerClickListener) context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_recycler,viewGroup,false);
        Holder holder = new Holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, final int i) {
        Objeto o = lista.get(i);
        Glide.with(context).load(o.getUrl()).into(holder.getImagen());
        holder.getTexto().setText(o.getNombre());
        holder.getLinear().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onRecyclerClickListener.onRecyclerClick(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    class Holder extends RecyclerView.ViewHolder {
        ImageView imagen;
        TextView texto;
        LinearLayout linear;


        public Holder(@NonNull View v) {
            super(v);
            imagen = v.findViewById(R.id.imagenRecycler);
            texto = v.findViewById(R.id.textRecycler);
            linear = v.findViewById(R.id.linear);

        }
        public ImageView getImagen() {
            return imagen;
        }

        public TextView getTexto() {
            return texto;
        }

        public LinearLayout getLinear() {
            return linear;
        }
    }
    public interface OnRecyclerClickListener{
        void onRecyclerClick(int pos);
    }
}
