package com.example.root.listaandroid.utils;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.root.listaandroid.R;

import java.util.ArrayList;
import java.util.List;

public class DataSet extends RecyclerView.Adapter<AdaptadorRecycler.MiHolder> {

    List list;
    Context context;
    OnVersionesRecyclerListener onVersionesRecyclerListener;

    public AdaptadorRecycler(List list, Context context) {
        this.list = list;
        this.context = context;
        //p.getNombre();
        // igualar a la clase que implementa
        onVersionesRecyclerListener = (OnVersionesRecyclerListener) context;
    }

    @NonNull
    @Override
    public MiHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_recycler, viewGroup, false);
        MiHolder holder = new MiHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MiHolder miHolder, int i) {
        final Versiones p = (Versiones) list.get(i);
        miHolder.getImagen().setImageResource(p.getImagen());
        miHolder.getNombre().setText(p.getNombre());
        miHolder.getCheckBox().setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    onVersionesRecyclerListener.onVersionesRecyclerSelected(p);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MiHolder extends RecyclerView.ViewHolder {

        ImageView imagen;
        TextView nombre;
        CheckBox checkBox;

        public MiHolder(@NonNull View itemView) {
            super(itemView);
            imagen = itemView.findViewById(R.id.imagenRecycler);
            nombre = itemView.findViewById(R.id.textoRecycler);
            checkBox = itemView.findViewById(R.id.checkRecycler);
        }

        public ImageView getImagen() {
            return imagen;
        }

        public TextView getNombre() {
            return nombre;
        }

        public CheckBox getCheckBox() {
            return checkBox;
        }
    }

    public abstract interface OnVersionesRecyclerListener {
        public void onVersionesRecyclerSelected(Versiones Versiones);
    }


}