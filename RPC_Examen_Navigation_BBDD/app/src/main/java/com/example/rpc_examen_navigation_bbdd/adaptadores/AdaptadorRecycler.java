package com.example.rpc_examen_navigation_bbdd.adaptadores;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.rpc_examen_navigation_bbdd.R;
import com.example.rpc_examen_navigation_bbdd.utils.Alumno;

import java.util.ArrayList;

public class AdaptadorRecycler extends RecyclerView.Adapter<AdaptadorRecycler.Holder> {

    Context context;
    ArrayList<Alumno> list;

    public AdaptadorRecycler(Context context, ArrayList<Alumno> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_recycler, viewGroup, false);
        Holder holder = new Holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int i) {
        Alumno alumno = list.get(i);
        holder.getNombre().setText(alumno.getNombre());
        holder.getApellido().setText(alumno.getApellido());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Holder extends RecyclerView.ViewHolder {

        TextView nombre, apellido;

        public Holder(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.nombreRecyler);
            apellido = itemView.findViewById(R.id.apellidoRecyler);
        }

        public TextView getNombre() {
            return nombre;
        }

        public TextView getApellido() {
            return apellido;
        }
    }
}
