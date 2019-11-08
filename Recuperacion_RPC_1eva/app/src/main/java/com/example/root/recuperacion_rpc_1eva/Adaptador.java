package com.example.root.recuperacion_rpc_1eva;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class Adaptador extends RecyclerView.Adapter<Adaptador.HolderAdapter> {

    Context context;
    ArrayList list;
    Callback callback;


    public Adaptador(ArrayList arrayList, Context applicationContext) {

        this.context = context;
        this.list = list;
        callback = (Callback) context;
    }

    @NonNull
    @Override
    public HolderAdapter onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adaptador_recycler, viewGroup, false);
        HolderAdapter holder = new HolderAdapter(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull HolderAdapter holderAdapter, final int i) {
        int num = (int) list.get(i);
        holderAdapter.getTextView().setText(String.valueOf(num));
        holderAdapter.getLinearLayout().setOnClickListener(new View.OnClickListener() {
            int numero  = (int) list.get(i);
            @Override
            public void onClick(View v) {
                callback.onPulsacion(numero);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class HolderAdapter extends RecyclerView.ViewHolder{

        TextView textView;
        LinearLayout linearLayout;

        public HolderAdapter(@NonNull View itemView) {
            super(itemView);
            linearLayout = itemView.findViewById(R.id.layout);
            textView = itemView.findViewById(R.id.numero);
        }

        public TextView getTextView() {
            return textView;
        }

        public LinearLayout getLinearLayout() {
            return linearLayout;
        }
    }

    public interface Callback {
        void onPulsacion(int list);
    }

}
