package com.juanfe.t5_baseexterna;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class AdaptadorRecycler extends RecyclerView.Adapter<AdaptadorRecycler.Holder> {
    Context context;
    ArrayList listaU;

    public AdaptadorRecycler(Context context, ArrayList listaU) {
        this.context = context;
        this.listaU = listaU;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_recycler,viewGroup,false);
        Holder h = new Holder(v);
        return h;
    }
    ///Users/juanfe/AndroidStudioProjects/T5_BaseExterna/app/release

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int i) {
        Usuario u  = (Usuario) listaU.get(i);

        holder.getNombre().setText(u.getNombre());
        holder.getCorreo().setText(u.getCorreo());


    }

    @Override
    public int getItemCount() {
        return listaU.size();
    }

    class Holder extends RecyclerView.ViewHolder {
        TextView nombre, correo;

        public Holder(@NonNull View v) {
            super(v);
            nombre = v.findViewById(R.id.nombre);
            correo = v.findViewById(R.id.correo);

        }

        public TextView getNombre() {
            return nombre;
        }

        public TextView getCorreo() {
            return correo;
        }
    }
}
