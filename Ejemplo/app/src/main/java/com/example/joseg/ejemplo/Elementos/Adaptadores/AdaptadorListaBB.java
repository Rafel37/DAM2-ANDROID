package com.example.joseg.ejemplo.Elementos.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.joseg.ejemplo.Intents.Util.BB;
import com.example.joseg.ejemplo.Intents.Util.Persona;
import com.example.joseg.ejemplo.R;

import java.util.List;

public class AdaptadorListaBB extends BaseAdapter {

    private List lista;
    private Context context;

    public AdaptadorListaBB(List lista, Context context) {
        this.lista = lista;
        this.context = context;

    }

    public void add(Persona p){
        lista.add(p);
        notifyDataSetChanged();
    }
    public void remove(int position){
        lista.remove(position);
        notifyDataSetChanged();
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        HolderAdicionalLista ha;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_list_bb, parent,false);
            ha = new HolderAdicionalLista(convertView);
            convertView.setTag(ha);
        }
        else {
            ha = (HolderAdicionalLista) convertView.getTag();
        }

        ha.getNombre().setText(((BB)lista.get(position)).getNombre());
        ha.getImagen().setImageResource(((BB)lista.get(position)).getImagen());
        return convertView;
    }

    class HolderAdicionalLista {
        TextView nombre;
        ImageView imagen;

        public TextView getNombre() {
            return nombre;
        }

        public ImageView getImagen() {
            return imagen;
        }

        public HolderAdicionalLista(View v) {
            this.nombre = v.findViewById(R.id.NombrelistaBB);
            this.imagen = v.findViewById(R.id.ImagenlistaBB);
        }
    }

}
