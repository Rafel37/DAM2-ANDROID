package com.example.rafaelp.memorygame.adaptador;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rafaelp.memorygame.R;
import com.example.rafaelp.memorygame.dataset.DataSet;
import com.example.rafaelp.memorygame.utils.Peliculas;

import java.util.List;

public class Adaptador extends BaseAdapter {

    private Context context;
    private List listaDatos;

    public Adaptador(Context context) {
        this.context = context;
        listaDatos = DataSet.newInstance().setDificultades();
    }

    @SuppressLint("ViewHolder")
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;

        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.spinner,parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else {
            viewHolder= (ViewHolder) convertView.getTag();

        }
        viewHolder.getImagen().setImageResource(((Peliculas) listaDatos.get(position)).getImagen());
        viewHolder.getDificultad().setText(((Peliculas)listaDatos.get(position)).getNombre());

        return convertView;
    }

    class ViewHolder{

        TextView dificultad;
        ImageView imagen;

        public ViewHolder(View v) {

            imagen = v.findViewById(R.id.imageSpinner);
            dificultad = v.findViewById(R.id.textoSpinner);
        }

        public TextView getDificultad() {
            return dificultad;
        }

        public ImageView getImagen() {
            return imagen;
        }

    }


    @Override
    public int getCount() {
        return listaDatos.size();
    }

    @Override
    public Object getItem(int position) {
        return listaDatos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

}
