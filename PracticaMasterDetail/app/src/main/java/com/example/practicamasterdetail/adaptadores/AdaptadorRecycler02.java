package com.example.practicamasterdetail.adaptadores;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.practicamasterdetail.R;
import com.example.practicamasterdetail.utils.Equipos;

import java.util.ArrayList;

public class AdaptadorRecycler02 extends RecyclerView.Adapter<AdaptadorRecycler02.Holder>{


    Context context;
    ArrayList arrayList;
    EquipoListener equipoListener;
    int posicion;

    public AdaptadorRecycler02(Context context, ArrayList arrayList, int i) {
        this.context = context;
        this.arrayList = arrayList;
        posicion = i;
        equipoListener = (EquipoListener) context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_02, viewGroup, false);
        Holder holder = new Holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, final int i) {
        final Equipos equipos = (Equipos) arrayList.get(i);
        holder.getImageView().setImageResource(equipos.getImagen());
        holder.getTextView().setText(equipos.getTitulo());
        holder.getImageView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                equipoListener.EquipoSelected(posicion, i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class Holder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView textView;

        public Holder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imagen02);
            textView = itemView.findViewById(R.id.texto02);
        }

        public ImageView getImageView() {
            return imageView;
        }

        public TextView getTextView() {
            return textView;
        }
    }

    public interface EquipoListener {
        void EquipoSelected(int i, int posicion);
    }
}
