package com.example.joseg.tema3.EjerciciosClase.Adaptadores;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.joseg.tema3.EjerciciosClase.Utils.DataSet;
import com.example.joseg.tema3.EjerciciosClase.Utils.Hobie;
import com.example.joseg.tema3.R;
import java.util.List;

public class AdaptadorPersoRecycler extends RecyclerView.Adapter<AdaptadorPersoRecycler.MiHolder> {

    List list;
    Context context;
    OnHobieRecyclerListener onPersonaRecyclerListener;

    public AdaptadorPersoRecycler(Context context) {
        this.context = context;
        list = DataSet.newInstance().devolverHobiesRecycler();
        onPersonaRecyclerListener = (OnHobieRecyclerListener) context;
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
        final Hobie H = (Hobie) list.get(i);
        miHolder.getImagen().setImageResource(H.getImagen());
        miHolder.getNombre().setText(H.getNombre());
        miHolder.getNombre().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPersonaRecyclerListener.onElementSelected(H);
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

        public MiHolder(@NonNull View itemView) {
            super(itemView);
            imagen = itemView.findViewById(R.id.imagenRecycler);
            nombre = itemView.findViewById(R.id.nombreRecycler);
        }

        public ImageView getImagen() {
            return imagen;
        }

        public TextView getNombre() {
            return nombre;
        }
    }

    public interface OnHobieRecyclerListener {
        void onElementSelected(Hobie hobie);
    }
}
