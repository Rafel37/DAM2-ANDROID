package com.example.rpc_examenfinal;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.rpc_examenfinal.utils.Pelis;

import java.util.List;

public class AdaptadorRecycler extends RecyclerView.Adapter<AdaptadorRecycler.MiHolder> {

    List list;
    Context context;
    OnPeliculaRecyclerListener onPeliculaRecyclerListener;

    public AdaptadorRecycler(List list, Context context) {
        this.list = list;
        this.context = context;
        onPeliculaRecyclerListener = (OnPeliculaRecyclerListener) context;
    }

    @NonNull
    @Override
    public MiHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_recycler, viewGroup, false);
        return new MiHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MiHolder miHolder, int i) {
        final Pelis pelis = (Pelis) list.get(i);
        miHolder.getNombre().setText(pelis.getNombre());
        miHolder.getPuntos().setText((int) pelis.getPuntuacion());
        miHolder.getLinearLayout().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPeliculaRecyclerListener.onPeliculaRecyclerSelected(pelis);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MiHolder extends RecyclerView.ViewHolder {
        LinearLayout linearLayout;
        TextView nombre, puntos;

        public MiHolder(@NonNull View itemView) {
            super(itemView);

            nombre = itemView.findViewById(R.id.nombreRecycler);
            puntos = itemView.findViewById(R.id.puntosRecycler);
            linearLayout = itemView.findViewById(R.id.linearVersion);
        }

        public LinearLayout getLinearLayout() {
            return linearLayout;
        }

        public TextView getNombre() {
            return nombre;
        }

        public TextView getPuntos() {
            return puntos;
        }
    }

    public interface OnPeliculaRecyclerListener {
        void onPeliculaRecyclerSelected(Pelis pelis);
    }
}
