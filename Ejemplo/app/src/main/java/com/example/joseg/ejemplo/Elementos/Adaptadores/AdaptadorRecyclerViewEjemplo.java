package com.example.joseg.ejemplo.Elementos.Adaptadores;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.joseg.ejemplo.Intents.Util.Persona;
import com.example.joseg.ejemplo.R;
import java.util.ArrayList;
import java.util.List;

public class AdaptadorRecyclerViewEjemplo extends RecyclerView.Adapter<AdaptadorRecyclerViewEjemplo.HolderPropio> {

    private List<Persona> lista;
    private Context contexto;
    OnAdaptadorPersoListener adaptadorPersoListener;

    public AdaptadorRecyclerViewEjemplo(Context contexto) {
        lista = new ArrayList<Persona>();
        this.contexto = contexto;
        adaptadorPersoListener = (OnAdaptadorPersoListener) contexto;
    }

    @NonNull
    @Override
    public HolderPropio onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        HolderPropio hp;

        View v = LayoutInflater.from(contexto).inflate(R.layout.item_spinner_layout, parent,false);

        hp = new HolderPropio(v);

        return hp;
    }

    @Override
    public void onBindViewHolder(@NonNull HolderPropio holder, int position) {
        holder.getNombre().setText(((Persona)lista.get(position)).getNombre());
        holder.getApellido().setText(((Persona)lista.get(position)).getApellido());
        holder.getTelefono().setText(((Persona)lista.get(position)).getTelefono());
        holder.getPadre().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //adaptadorPersoListener.onAdaptadorPersoSelected(((Persona)lista.get(position)));
            }
        });
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public interface OnAdaptadorPersoListener{
        public void onAdaptadorPersoSelected(Persona persona);
    }

    class HolderPropio extends RecyclerView.ViewHolder{

        private TextView nombre, apellido, telefono;
        private LinearLayout padre;

        public TextView getNombre() {
            return nombre;
        }

        public TextView getApellido() {
            return apellido;
        }

        public TextView getTelefono() {
            return telefono;
        }

        public LinearLayout getPadre() {
            return padre;
        }

        public HolderPropio(View itemView) {
            super(itemView);
            padre = itemView.findViewById(R.id.LLRVEjemplo);
            nombre = itemView.findViewById(R.id.nombreRVEjemplo);
            apellido = itemView.findViewById(R.id.apellidoRVEjemplo);
            telefono = itemView.findViewById(R.id.telefonoRVEjemplo);
        }
    }
}
