package com.example.myapplication.adaptador;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.utils.Usuario;

import java.util.List;

public class AdaptadorRecycler  extends RecyclerView.Adapter<AdaptadorRecycler.HolderPropio> {

    Context context;
    List<Usuario> usuarios;

    public AdaptadorRecycler(Context context, List<Usuario> usuarios) {
        this.context = context;
        this.usuarios = usuarios;
    }

    @NonNull
    @Override
    public HolderPropio onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_recycler, viewGroup, false);
        return new HolderPropio(v);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderPropio holderPropio, int i) {
        Usuario u = usuarios.get(i);
        holderPropio.getNombre().setText(u.getNombre());
        holderPropio.getApellido().setText(u.getApellido());
    }

    @Override
    public int getItemCount() {
        return usuarios.size();
    }

    class HolderPropio extends RecyclerView.ViewHolder{

        TextView nombre, apellido;


        public HolderPropio(@NonNull View itemView) {
            super(itemView);

            nombre = itemView.findViewById(R.id.nombreItem);
            apellido = itemView.findViewById(R.id.apellidoItem);
        }

        public TextView getNombre() {
            return nombre;
        }

        public TextView getApellido() {
            return apellido;
        }
    }
}
