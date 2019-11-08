package com.example.joseg.ejemplo.Elementos.Adaptadores;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.joseg.ejemplo.Intents.Util.Persona;
import com.example.joseg.ejemplo.R;
import java.util.List;

public class AdaptadorRecycler extends RecyclerView.Adapter<AdaptadorRecycler.MiHolder> {

    List list;
    Context context;
    OnPersonaRecyclerListener onPersonaRecyclerListener;

    public AdaptadorRecycler(List list, Context context) {
        this.list = list;
        this.context = context;
        onPersonaRecyclerListener = (OnPersonaRecyclerListener) context;
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
        final Persona P = (Persona) list.get(i);
        miHolder.getImagen().setImageResource(P.getImagen());
        miHolder.getNombre().setText(P.getNombre());
        miHolder.getCheckBox().setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    onPersonaRecyclerListener.addPersona(P);
                } else {
                    onPersonaRecyclerListener.removePersona(P);
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

    public interface OnPersonaRecyclerListener {
        void addPersona(Persona persona);
        void removePersona(Persona persona);
    }
}
