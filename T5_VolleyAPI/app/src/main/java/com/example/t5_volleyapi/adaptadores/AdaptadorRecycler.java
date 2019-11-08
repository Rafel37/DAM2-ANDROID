package com.example.t5_volleyapi.adaptadores;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.example.t5_volleyapi.R;
import com.example.t5_volleyapi.utils.Usuario;

import java.util.List;

public class AdaptadorRecycler extends RecyclerView.Adapter<AdaptadorRecycler.MiHolder> {


    private List lista;
    private Context context;

    public AdaptadorRecycler(List lista, Context context) {
        this.lista = lista;
        this.context = context;
    }

    @NonNull
    @Override
    public MiHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_recycler, viewGroup, false);
        return new MiHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MiHolder miHolder, int i) {
        final Usuario usuario = (Usuario) lista.get(i);
        miHolder.getNombre().setText(usuario.getNombre());
        miHolder.getApellidos().setText(usuario.getApellidos());
        miHolder.getCorreo().setText(usuario.getCorreo());
        miHolder.getCurso().setText(usuario.getCurso());
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    class MiHolder extends RecyclerView.ViewHolder {

        TextView nombre, apellidos, correo, curso;

        private MiHolder(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.nombre);
            apellidos = itemView.findViewById(R.id.apellidos);
            correo = itemView.findViewById(R.id.correo);
            curso = itemView.findViewById(R.id.curso);
        }

        private TextView getNombre() {
            return nombre;
        }

        private TextView getApellidos() {
            return apellidos;
        }

        private TextView getCorreo() {
            return correo;
        }

        private TextView getCurso() {
            return curso;
        }
    }

}