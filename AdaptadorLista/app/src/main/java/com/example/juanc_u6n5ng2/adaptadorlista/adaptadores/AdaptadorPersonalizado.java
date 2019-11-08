package com.example.juanc_u6n5ng2.adaptadorlista.adaptadores;

import android.content.Context;
import android.os.PersistableBundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.juanc_u6n5ng2.adaptadorlista.R;
import com.example.juanc_u6n5ng2.adaptadorlista.utils.Persona;

import java.util.List;

public class AdaptadorPersonalizado extends BaseAdapter {

    //list y context es para pasar los datos de ArrayList<Persona> personas = new ArrayList<>();

    List<Persona> listaDatos;
    Context context;

    // y creamos el constructor
    public AdaptadorPersonalizado(List<Persona> listaDatos, Context context) {
        this.listaDatos = listaDatos;
        this.context = context;
    }

    @Override
    public int getCount() {
        //numero de filas que quiero pintar
        return listaDatos.size();
    }

    @Override
    public Object getItem(int position) {
        //accedo al objeto que esta en una
        //posicion determinada
        //de la lista obtenemos la posicion
        return listaDatos.get(position);
    }

    @Override
    public long getItemId(int position) {
        //devuelve el id del elemento
        //de una posicion concreta
        return position;
    }

    public void agregarPersona(Persona persona){
        //se agrega
        listaDatos.add(persona);
        //se actualiza
        notifyDataSetChanged();
    }

    public void borrarPersona(int posicion){
        listaDatos.remove(posicion);

    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        //pinta y configura cada una de las filas de la lista
        //converViev donde lo pegas, es el xml
        //parent conjunto de elementos que quiero representar

        //cojo el xml y lo meto en la vista
        //from porque necesito una base que es el contexto
        //inflate para meter el xml

        HolderPropio holder;


        // la primera vez que entras instancias la vista y el holder
        // el resto de veces recuperar datos y asi no gastas memoria en el dispositivo
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_lista, parent, false);
            //esto vale para que se ejecute solo una vez ya que mas seria innecesario
            holder = new HolderPropio(convertView);
            // poner un tag sirve para indexarlo para poder utilizarlo
            convertView.setTag(holder);
        } else {
            holder = (HolderPropio) convertView.getTag();
        }


        /*
        Con el holder ya no hace falta estos textView
        TextView nombre = convertView.findViewById(R.id.nombrePersona);
        TextView apellido = convertView.findViewById(R.id.apellidoPersona);
        */
        Persona p = listaDatos.get(position);
        holder.getNombreHolder().setText(p.getNombre());
        holder.getApellidoHolder().setText(p.getApellido());
        holder.getNombreHolder().setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                borrarPersona(position);
                return true;
            }
        });

        return convertView;
    }

    class HolderPropio {

        TextView nombreHolder, apellidoHolder;

        public HolderPropio(View view) {
            nombreHolder = view.findViewById(R.id.nombrePersona);
            apellidoHolder = view.findViewById(R.id.apellidoPersona);
        }

        public TextView getNombreHolder() {
            return nombreHolder;
        }

        public void setNombreHolder(TextView nombreHolder) {
            this.nombreHolder = nombreHolder;
        }

        public TextView getApellidoHolder() {
            return apellidoHolder;
        }

        public void setApellidoHolder(TextView apellidoHolder) {
            this.apellidoHolder = apellidoHolder;
        }
    }
}
