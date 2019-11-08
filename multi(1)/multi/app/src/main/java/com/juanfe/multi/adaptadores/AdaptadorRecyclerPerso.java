package com.juanfe.multi.adaptadores;

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
import com.juanfe.multi.R;
import com.juanfe.multi.utils.Multimedia;

import java.util.ArrayList;

public class AdaptadorRecyclerPerso extends RecyclerView.Adapter<AdaptadorRecyclerPerso.Holder> {
    Context context;
    OnRecyclerClickListener onRecyclerClickListener;
    ArrayList<Multimedia> lista;

    public AdaptadorRecyclerPerso(Context context,  ArrayList lista) {
        this.context = context;
        this.lista=lista;

        onRecyclerClickListener = (OnRecyclerClickListener) context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.itemrecycler,viewGroup,false);
        Holder h = new Holder(v);
        return h;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, final int i) {
        Multimedia m = lista.get(i);
        Glide.with(context).load(m.getUrl()).into(holder.getImagen());
        holder.getTexto().setText(m.getNombre());
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
            imagen = v.findViewById(R.id.imagenrecycler);
            texto = v.findViewById(R.id.textorecycler);
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
