package com.example.practicaequiposfragment.adaptadores;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.practicaequiposfragment.R;
import com.example.practicaequiposfragment.utils.Equipos;

import java.util.ArrayList;

public class AdaptadorRecycler03 extends RecyclerView.Adapter<AdaptadorRecycler03.Holder>{


    Context context;
    ArrayList arrayList;

    public AdaptadorRecycler03(Context context, ArrayList arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_03, viewGroup, false);
        Holder holder = new Holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int i) {
        final Equipos equipos = (Equipos) arrayList.get(i);
        holder.getImageView().setImageResource(equipos.getImagen());
        holder.getTextView().setText(equipos.getTitulo());
        holder.getDetalleView().setText(equipos.getDetalle());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class Holder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView textView, detalleView;

        public Holder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imagen03);
            textView = itemView.findViewById(R.id.texto03);
            detalleView = itemView.findViewById(R.id.detalle03);
        }

        public ImageView getImageView() {
            return imageView;
        }

        public TextView getTextView() {
            return textView;
        }

        public TextView getDetalleView() {
            return detalleView;
        }
    }

}
