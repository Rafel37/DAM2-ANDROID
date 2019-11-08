package com.example.rafaelp.listas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class Adaptador extends BaseAdapter {

    List list;
    Context context;

    public Adaptador(List list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        HolderLista holderLista;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_list_view, parent, false);
            holderLista = new HolderLista(convertView);
            convertView.setTag(holderLista);
        }
        else {
            holderLista = (HolderLista) convertView.getTag();
        }

        holderLista.getImageView().setImageResource(((Version) list.get(position)).getImagen());
        holderLista.getTextView().setText(((Version) list.get(position)).getNombre());
        return convertView;
    }

    public class HolderLista{
        ImageView imageView;
        TextView textView;

        public HolderLista(View v) {
            this.imageView = v.findViewById(R.id.imagenLista);
            this.textView = v.findViewById(R.id.textoLista);
        }

        public ImageView getImageView() {
            return imageView;
        }

        public TextView getTextView() {
            return textView;
        }
    }
}
