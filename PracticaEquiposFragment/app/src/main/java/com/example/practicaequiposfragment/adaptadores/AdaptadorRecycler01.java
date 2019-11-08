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
import com.example.practicaequiposfragment.fragments.Fragment02;
import com.example.practicaequiposfragment.utils.Ligas;

import java.util.ArrayList;

public class AdaptadorRecycler01 extends RecyclerView.Adapter<AdaptadorRecycler01.Holder>{


    Context context;
    ArrayList arrayList;
    LigasListener ligasListener;

    public AdaptadorRecycler01(Context context, ArrayList arrayList) {
        this.context = context;
        this.arrayList = arrayList;
        ligasListener = (LigasListener) context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_01, viewGroup, false);
        Holder holder = new Holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, final int i) {
        final Ligas ligas = (Ligas) arrayList.get(i);
        holder.getImageView().setImageResource(ligas.getImagen());
        holder.getTextView().setText(ligas.getTitulo());
        holder.getImageView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ligasListener.LigasSelected(i);
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

            imageView = itemView.findViewById(R.id.imagen01);
            textView = itemView.findViewById(R.id.texto01);
        }

        public ImageView getImageView() {
            return imageView;
        }

        public TextView getTextView() {
            return textView;
        }
    }


    public interface LigasListener {
        void LigasSelected (int i);
    }
}
