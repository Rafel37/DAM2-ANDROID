package com.example.joseg.ejemplo.Elementos.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.joseg.ejemplo.Intents.Util.Persona;
import com.example.joseg.ejemplo.R;

import java.util.List;

public class AdaptadorListaPerso extends BaseAdapter implements View.OnLongClickListener{

    private List lista;
    private Context context;

    public AdaptadorListaPerso(List lista, Context context) {
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
            convertView = LayoutInflater.from(context).inflate(R.layout.item_list_layout, parent,false);
            ha = new HolderAdicionalLista(convertView);
            convertView.setTag(ha);
        }
        else {
            ha = (HolderAdicionalLista) convertView.getTag();
        }

        ha.getNombre().setText(((Persona)lista.get(position)).getNombre());
        ha.getApellido().setText(((Persona)lista.get(position)).getApellido());
        ha.getNombre().setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                remove(position);
                return true;
            }
        });
        if (((Persona)lista.get(position)).getSexo() == 0)
            ha.getImagen().setImageResource(R.drawable.male_light);
        else
            ha.getImagen().setImageResource(R.drawable.famale_light);
        return convertView;
    }

    @Override
    public boolean onLongClick(View v) {


        return false;
    }

    class HolderAdicionalLista {
        TextView nombre, apellido;
        ImageView imagen;

        public TextView getNombre() {
            return nombre;
        }

        public TextView getApellido() {
            return apellido;
        }

        public ImageView getImagen() {
            return imagen;
        }

        public HolderAdicionalLista(View v) {
            this.nombre = v.findViewById(R.id.Nombrelista1);
            this.apellido = v.findViewById(R.id.Apellidolista1);
            this.imagen = v.findViewById(R.id.Imagenlista1);
        }
    }

}
