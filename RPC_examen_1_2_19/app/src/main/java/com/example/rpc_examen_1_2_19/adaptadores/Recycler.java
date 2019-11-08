package com.example.rpc_examen_1_2_19.adaptadores;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rpc_examen_1_2_19.R;
import com.example.rpc_examen_1_2_19.utils.Clases;

import java.util.ArrayList;

public class Recycler extends RecyclerView.Adapter<Recycler.Holder> {

    Context context;
    ArrayList arrayList;
    Clases clases;

    public Recycler(Context context, ArrayList arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler, viewGroup, false);
        Holder holder = new Holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int i) {
        final Clases clases = (Clases) arrayList.get(i);
        holder.getImageView().setImageResource(clases.getImagen());
        holder.getTextView().setText(clases.getNombre());
    }


    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class Holder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;

        public Holder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.recycler_imagen);
            textView = itemView.findViewById(R.id.recycler_texto);
        }

        public ImageView getImageView() {
            return imageView;
        }

        public TextView getTextView() {
            return textView;
        }
    }
}
