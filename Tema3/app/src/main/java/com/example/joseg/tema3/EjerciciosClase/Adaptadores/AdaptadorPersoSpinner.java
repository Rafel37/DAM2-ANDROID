package com.example.joseg.tema3.EjerciciosClase.Adaptadores;

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
import com.example.joseg.tema3.EjerciciosClase.Utils.DataSet;
import com.example.joseg.tema3.EjerciciosClase.Utils.Hobie;
import com.example.joseg.tema3.EjerciciosClase.Utils.Persona;
import com.example.joseg.tema3.R;

import java.util.List;

public class AdaptadorPersoSpinner extends BaseAdapter {
    private List lista;
    private Context context;

    public AdaptadorPersoSpinner(Context context) {
        this.context = context;
        lista = DataSet.newInstance().devolverHobiesSpinner();
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
            convertView = LayoutInflater.from(context).inflate(R.layout.item_spinner, parent,false);
            ha = new HolderAdicionalSpinner(convertView);
            convertView.setTag(ha);
        }
        else {
            ha = (HolderAdicionalSpinner) convertView.getTag();
        }

        ha.getNombre().setText(((Hobie)lista.get(position)).getNombre());
        ha.getImagen().setImageResource(((Hobie)lista.get(position)).getImagen());

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
            this.nombre = v.findViewById(R.id.textoItemSpinner);
            this.imagen = v.findViewById(R.id.imagenItemSpinner);
        }
    }
}
