package com.example.juan.examenjcique4.adaptadores;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;


import com.example.juan.examenjcique4.R;
import com.example.juan.examenjcique4.utils.Practica;

import java.util.List;

public class AdaptadorRecycler extends RecyclerView.Adapter<AdaptadorRecycler.MiHolder> {

    List lista;
    Context context;
    OnPracticaRecyclerListener onPracticaRecyclerListener;

    public AdaptadorRecycler(List lista, Context context) {
        this.lista = lista;
        this.context = context;
        onPracticaRecyclerListener = (OnPracticaRecyclerListener) context;
    }

    @NonNull
    @Override
    public MiHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_recycler, viewGroup, false);
        MiHolder holder = new MiHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MiHolder miHolder, int i) {
        final Practica p = (Practica) lista.get(i);
        miHolder.getNombre().setText(p.getNombre());
        miHolder.getCheckBox().setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    onPracticaRecyclerListener.onPracticaRecyclerSelected(p);
                } else
                    onPracticaRecyclerListener.onPracticaRecyclerDeselected(p);
            }
        });
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    class MiHolder extends RecyclerView.ViewHolder {

        TextView nombre;
        CheckBox checkBox;

        public MiHolder(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.textoRecycler);
            checkBox = itemView.findViewById(R.id.checkbox);
        }

        public TextView getNombre() {
            return nombre;
        }

        public CheckBox getCheckBox() {
            return checkBox;
        }
    }

    public interface OnPracticaRecyclerListener {
        void onPracticaRecyclerSelected(Practica practica);

        void onPracticaRecyclerDeselected(Practica practica);
    }

}