package com.example.joseg.joseangelgarciaoya.Adaptadores;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.joseg.joseangelgarciaoya.R;
import com.example.joseg.joseangelgarciaoya.Util.Elemento;
import java.util.List;

public class AdaptadorRecycler extends RecyclerView.Adapter<AdaptadorRecycler.HolderElementos> {

    List list;
    Context context;
    OnElementoRecyclerListener onElementoRecyclerListener;

    public AdaptadorRecycler(List list, Context context) {
        this.list = list;
        this.context = context;
        onElementoRecyclerListener = (OnElementoRecyclerListener) context;
    }

    @NonNull
    @Override
    public HolderElementos onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_recycler, viewGroup, false);
        HolderElementos holder = new HolderElementos(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull HolderElementos holderElementos, int i) {
        final Elemento E = (Elemento) list.get(i);
        holderElementos.getImagen().setImageResource(E.getImagen());
        holderElementos.getNombre().setText(E.getNombre());
        holderElementos.getLinearLayout().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onElementoRecyclerListener.sacarDatos(E);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class HolderElementos extends RecyclerView.ViewHolder {

        LinearLayout linearLayout;
        ImageView imagen;
        TextView nombre;

        public HolderElementos(@NonNull View itemView) {
            super(itemView);
            linearLayout = itemView.findViewById(R.id.RecyclerView);
            imagen = itemView.findViewById(R.id.imagenRecycler);
            nombre = itemView.findViewById(R.id.textoRecycler);
        }

        public ImageView getImagen() {
            return imagen;
        }

        public TextView getNombre() {
            return nombre;
        }

        public LinearLayout getLinearLayout() {
            return linearLayout;
        }
    }

    public interface OnElementoRecyclerListener {
        public void sacarDatos(Elemento e);
    }
}
