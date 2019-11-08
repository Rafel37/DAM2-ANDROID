package com.example.rafaelp.clasemagistral;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class AdaptadorSpinner extends BaseAdapter {

    Context context;
    ArrayList arrayList;

    public AdaptadorSpinner(Context context, ArrayList arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.spinner_main, parent, false);
            holder = new Holder(convertView);
            convertView.setTag(holder);
        }
        else {
            holder = (Holder) convertView.getTag();
        }
        int numero = (int) arrayList.get(position);
        holder.getTextView().setText(String.valueOf(numero));
        return convertView;
    }

    class Holder {
        TextView textView;

        public Holder(View view) {
            textView = view.findViewById(R.id.textoSpinner);

        }

        public TextView getTextView() {
            return textView;
        }
    }
}
