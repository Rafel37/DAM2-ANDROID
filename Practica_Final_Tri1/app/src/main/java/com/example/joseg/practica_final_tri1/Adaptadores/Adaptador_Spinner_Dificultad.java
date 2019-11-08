package com.example.joseg.practica_final_tri1.Adaptadores;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.joseg.practica_final_tri1.R;
import com.example.joseg.practica_final_tri1.Utils.DataSet;
import com.example.joseg.practica_final_tri1.Utils.Dificultad;
import java.util.List;

public class Adaptador_Spinner_Dificultad extends BaseAdapter {

    private List lista;
    private Context context;

    public Adaptador_Spinner_Dificultad(Context context) {
        this.context = context;
        lista = DataSet.newInstance().setDificultades();
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @SuppressLint("ViewHolder")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        HolderSpinner ha;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_spinner_dificultad, parent,false);
            ha = new HolderSpinner(convertView);
            convertView.setTag(ha);
        }
        else {
            ha = (HolderSpinner) convertView.getTag();
        }

        ha.getNombre().setText(((Dificultad)lista.get(position)).getNombre());
        ha.getImagen().setImageResource(((Dificultad)lista.get(position)).getImagen());

        return convertView;
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    class HolderSpinner {
        TextView nombre;
        ImageView imagen;

        public TextView getNombre() {
            return nombre;
        }

        public ImageView getImagen() {
            return imagen;
        }

        public HolderSpinner(View v) {
            this.nombre = v.findViewById(R.id.textoItemSpinner);
            this.imagen = v.findViewById(R.id.imagenItemSpinner);
        }
    }
}
