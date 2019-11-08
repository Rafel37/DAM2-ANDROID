package com.example.joseg.ejemplo.Elementos.Adaptadores;

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
import android.widget.Toast;
import com.example.joseg.ejemplo.Intents.Util.Persona;
import com.example.joseg.ejemplo.R;
import java.util.List;

public class AdaptadorSpinnerPerso extends BaseAdapter  implements View.OnClickListener {

    private List lista;
    private Context context;

    public AdaptadorSpinnerPerso(List lista, Context context) {
        this.lista = lista;
        this.context = context;

    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @SuppressLint("ViewHolder")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        HolderAdicionalSpinner ha;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_spinner_layout, parent,false);
            ha = new HolderAdicionalSpinner(convertView);
            ha.getImagen().setOnClickListener(this);
            ha.getNombre().setOnClickListener(this);
            convertView.setTag(ha);
        }
        else {
            ha = (HolderAdicionalSpinner) convertView.getTag();
        }

        ha.getNombre().setText(((Persona)lista.get(position)).getNombre());
        if (((Persona)lista.get(position)).getSexo() == 0)
            ha.getImagen().setImageResource(R.drawable.male_light);
        else
            ha.getImagen().setImageResource(R.drawable.famale_light);;
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

    protected void addpersona(Persona p){
        lista.add(p);
        notifyDataSetChanged();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.EjemploNombreSpinner:
                Toast.makeText(context,"Has pulsado el texto",Toast.LENGTH_SHORT).show();

                break;
            case R.id.ImagenEjemploSpinner:
                Toast.makeText(context,"Has pulsado la imagen",Toast.LENGTH_SHORT).show();
                break;
        }
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
            this.nombre = v.findViewById(R.id.EjemploNombreSpinner);
            this.imagen = v.findViewById(R.id.ImagenEjemploSpinner);
        }
    }

}
