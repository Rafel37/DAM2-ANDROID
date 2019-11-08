package com.example.joseg.joseangelgarciaoya.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.joseg.joseangelgarciaoya.R;
import com.example.joseg.joseangelgarciaoya.Util.Elemento;
import java.util.List;

public class AdaptadorSpinner extends BaseAdapter {

    private List lista;
    private Context context;

    public AdaptadorSpinner(List lista, Context context) {
        this.lista = lista;
        this.context = context;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        HolderAdicionalSpinner ha;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_spinner, parent,false);
            ha = new HolderAdicionalSpinner(convertView);
            convertView.setTag(ha);
        }
        else {
            ha = (HolderAdicionalSpinner) convertView.getTag();
        }

        ha.getNombre().setText(((Elemento)lista.get(position)).getNombre());
        ha.getImagen().setImageResource(((Elemento)lista.get(position)).getImagen());
        return convertView;
    }

    class HolderAdicionalSpinner {
        TextView nombre;
        ImageView imagen;

        public TextView getNombre() {
            return nombre;
        }

        public ImageView getImagen() {
            return imagen;
        }

        public HolderAdicionalSpinner(View v) {
            this.nombre = v.findViewById(R.id.textoSpinner);
            this.imagen = v.findViewById(R.id.imagenSpinner);
        }
    }
}
