package com.example.root.listaandroid.utils;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class Versiones extends BaseAdapter {
    String nombre, desc;
    int api;

    public Versiones(String nombre, String desc, int api) {
        this.nombre = nombre;
        this.desc = desc;
        this.api = api;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDesc() {
        return desc;
    }

    public int getApi() {
        return api;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}