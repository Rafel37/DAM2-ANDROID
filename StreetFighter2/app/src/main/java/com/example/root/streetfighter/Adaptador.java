package com.example.root.streetfighter;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class Adaptador extends RecyclerView.Adapter<Adaptador.Holder>{

    Context context;
    List<Luchador> arrayList;
    OnListener onlistener;

    public Adaptador(Context context, List<Luchador> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
        onlistener = (OnListener) context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_card, viewGroup, false);
        Holder holder = new Holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int i) {
        final Luchador l = (Luchador) arrayList.get(i);
        holder.imageView.setImageResource(arrayList.get(i).getImagen());
        holder.textView.setText(arrayList.get(i).getNombre());
        holder.checkBox.isChecked();
        holder.getImageView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onlistener.OnCallBack(l.getNombre(),l.getTipo(), l.getPais(), l.getImagen());
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class Holder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView textView;
        CheckBox checkBox;

        public Holder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.nombre);
            checkBox = itemView.findViewById(R.id.checkBox);


        }

        public ImageView getImageView() {
            return imageView;
        }

        public TextView getTextView() {
            return textView;
        }

        public CheckBox getCheckBox() {
            return checkBox;
        }


    }

    public interface OnListener{
        void OnCallBack(String nombre, String tipo,String pais, int imagen);
    }
}
