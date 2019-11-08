package com.example.fragmentrecyclercuatro.adaptadores;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fragmentrecyclercuatro.R;
import com.example.fragmentrecyclercuatro.utils.Personaje;

import java.util.ArrayList;


public class AdaptadorRecyclerUno extends RecyclerView.Adapter<AdaptadorRecyclerUno.HolderUno> {

    Context c;
    ArrayList<Personaje> listaUno;
    OnElementoAdaptadorUnoListener listenerUno;

    public AdaptadorRecyclerUno(Context c) {
        this.c = c;
        listaUno = new ArrayList<>();
        listaUno.add(new Personaje("Blanka", "Electricidad",R.drawable.blanka));
        listaUno.add(new Personaje("Chunli", "Karate",R.drawable.chunli));
        listaUno.add(new Personaje("Dalsim", "Elasticidad",R.drawable.dalsim));
        listaUno.add(new Personaje("Ryu", "Karate",R.drawable.ryu));
        listaUno.add(new Personaje("Vision", "Psicopoderes",R.drawable.vision));
        listaUno.add(new Personaje("Zangief", "Fuerza",R.drawable.zang));
        listaUno.add(new Personaje("Guile", "Boomerang",R.drawable.guile));
        listaUno.add(new Personaje("Honda", "Sumo",R.drawable.honda));
        listaUno.add(new Personaje("Ken", "Judo",R.drawable.ken));
        listaUno.add(new Personaje("Vega", "Garras",R.drawable.vega));

        listenerUno = (OnElementoAdaptadorUnoListener) c;
    }

    @NonNull
    @Override
    public HolderUno onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(c).inflate(R.layout.item_recycler_uno, viewGroup, false);

        return new HolderUno(v);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderUno holderUno, int i) {
        final Personaje p = listaUno.get(i);
        holderUno.getTextoNombre().setText(p.getNombre());
        holderUno.getTextoTipo().setText(p.getTipo());
        holderUno.getImagenPersonaje().setImageResource(p.getImagen());
        holderUno.getTextoNombre().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listenerUno.onElementoUnoSelected();
            }
        });
    }

    @Override
    public int getItemCount() {
        return listaUno.size();
    }

    public interface OnElementoAdaptadorUnoListener {
        public void onElementoUnoSelected();
    }

    class HolderUno extends RecyclerView.ViewHolder {

        TextView textoNombre, textoTipo;
        ImageView imagenPersonaje;

        public HolderUno(@NonNull View itemView) {
            super(itemView);
            textoNombre = itemView.findViewById(R.id.nombreItem);
            textoTipo = itemView.findViewById(R.id.tipoItem);
            imagenPersonaje = itemView.findViewById(R.id.imagenItem);
        }

        public TextView getTextoNombre() {
            return textoNombre;
        }

        public TextView getTextoTipo() {
            return textoTipo;
        }

        public ImageView getImagenPersonaje() {
            return imagenPersonaje;
        }
    }
}
