package com.example.juanfe.subidadenota;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class AdaptadorRe extends RecyclerView.Adapter<AdaptadorRe.Holder> {
    ArrayList numeros;
    Context context;
    Callback callback;

    public AdaptadorRe(ArrayList numeros, Context context) {
        this.numeros = numeros;
        this.context = context;
        callback = (Callback) context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v  = LayoutInflater.from(context).inflate(R.layout.item_recycer,viewGroup,false);
        Holder h = new Holder(v);
        return h;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, final int i) {
        int num = (int) numeros.get(i);
        holder.getTexto().setText(String.valueOf(num));
        holder.getLinearLayout().setOnClickListener(new View.OnClickListener() {
            int numero= (int) numeros.get(i);
            @Override
            public void onClick(View v) {
                callback.onPulsacion(numero);

            }
        });
    }

    @Override
    public int getItemCount() {
        return numeros.size();
    }

    class Holder extends RecyclerView.ViewHolder {
        TextView texto;
        LinearLayout linearLayout;


        public Holder(@NonNull View itemView) {
            super(itemView);
            linearLayout = itemView.findViewById(R.id.layout);
            texto =itemView.findViewById(R.id.textoRecycler);
        }

        public TextView getTexto() {
            return texto;
        }

        public LinearLayout getLinearLayout() {
            return linearLayout;
        }
    }

    public interface Callback{
        void onPulsacion(int numero);
    }
}
