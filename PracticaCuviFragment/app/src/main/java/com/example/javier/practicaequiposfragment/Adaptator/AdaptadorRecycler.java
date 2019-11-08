package com.example.javier.practicaequiposfragment.Adaptator;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.javier.practicaequiposfragment.Data.DataSet;
import com.example.javier.practicaequiposfragment.Fragment.FragmentJuegos;
import com.example.javier.practicaequiposfragment.R;
import com.example.javier.practicaequiposfragment.utils.Juegos;

import java.util.List;

public class AdaptadorRecycler extends RecyclerView.Adapter<AdaptadorRecycler.Holder>{

    Context context;
    List<Juegos> arrayList;

    public AdaptadorRecycler(Context context, List<Juegos> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.fragmentos_juegos, viewGroup, false);
        Holder holder = new Holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int i) {
        final Juegos l = (Juegos) arrayList.get(i);
        holder.imageView.setImageResource(arrayList.get(i).getImagen());
        holder.textView.setText(arrayList.get(i).getTitulo());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class Holder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView textView;

        public Holder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imagenAdaptador);
            textView = itemView.findViewById(R.id.textoAdaptador);


        }

        public ImageView getImageView() {
            return imageView;
        }

        public TextView getTextView() {
            return textView;
        }



    }

    public interface OnListener{
        void OnCallBack(String nombre, int imagen);
    }
}