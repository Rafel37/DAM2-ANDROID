package com.example.joseg.ejemplo.Elementos.Adaptadores;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.joseg.ejemplo.Intents.Util.BB;
import com.example.joseg.ejemplo.R;

import java.util.List;

public class AdaptadorRecyclerBB extends RecyclerView.Adapter<AdaptadorRecyclerBB.MiHolderBB> {

    List list;
    Context context;
    OnBBRecyclerListener onBBRecyclerListener;

    public AdaptadorRecyclerBB(List list, Context context) {
        this.list = list;
        this.context = context;
        onBBRecyclerListener = (OnBBRecyclerListener) context;
    }

    @NonNull
    @Override
    public MiHolderBB onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_list_bb, viewGroup, false);
        MiHolderBB holder = new MiHolderBB(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MiHolderBB miHolder, int i) {
        final BB B = (BB) list.get(i);
        miHolder.getImagen().setImageResource(B.getImagen());
        miHolder.getNombre().setText(B.getNombre());
        miHolder.getPadre().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBBRecyclerListener.acceder(B);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MiHolderBB extends RecyclerView.ViewHolder {

        ImageView imagen;
        TextView nombre;
        LinearLayout padre;

        public MiHolderBB(@NonNull View itemView) {
            super(itemView);
            padre = itemView.findViewById(R.id.padreBB);
            nombre = itemView.findViewById(R.id.NombrelistaBB);
            imagen = itemView.findViewById(R.id.ImagenlistaBB);
        }

        public LinearLayout getPadre() {
            return padre;
        }

        public ImageView getImagen() {
            return imagen;
        }

        public TextView getNombre() {
            return nombre;
        }
    }

    public interface OnBBRecyclerListener {
        void acceder(BB bb);
    }
}
