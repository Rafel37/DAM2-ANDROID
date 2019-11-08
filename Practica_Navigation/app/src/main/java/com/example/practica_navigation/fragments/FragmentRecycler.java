package com.example.practica_navigation.fragments;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.practica_navigation.R;
import com.example.practica_navigation.adaptador.AdaptadorRecycler;
import com.example.practica_navigation.basedatos.DatosBD;
import com.example.practica_navigation.basedatos.HelperDB;
import com.example.practica_navigation.utils.Objeto;

import java.util.ArrayList;

public class FragmentRecycler extends Fragment {
    private static final String TAG_POS = "posicion";
    private static final String TAG_PAL = "palabra";
    View v;
    RecyclerView recycler;
    AdaptadorRecycler adaptador;
    Context context;
    ArrayList lista;
    SQLiteOpenHelper helper;
    SQLiteDatabase baseDatos;
    String palabra;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_recycler, container, false);
        recycler = v.findViewById(R.id.recyclerFragment);
        adaptador = new AdaptadorRecycler(context, lista);
        recycler.setAdapter(adaptador);
        recycler.setLayoutManager(new LinearLayoutManager(context, 1, false));

        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        helper = new HelperDB(context, DatosBD.DB_NAME, null, 1);
        this.context = context;
        if (getArguments() != null) {
            this.palabra = getArguments().getString(TAG_PAL);
            if (getArguments().getInt(TAG_POS) == 0) {
                rellenarTodos();
            } else if (palabra.equals("juegos")) {
                rellenarLista(palabra);
                adaptador.notifyDataSetChanged();
            } else if (palabra.equals("principal")) {
                rellenarTodos();
            } else if (palabra.equals("multimedia")) {
                rellenarLista(palabra);
            } else if (palabra.equals("futbol")) {
                rellenarLista(palabra);
            } else if (palabra.equals("pc")) {
                rellenarLista(palabra);
            } else if (palabra.equals("xbox")) {
                rellenarLista(palabra);
            } else if (palabra.equals("ps4")) {
                rellenarLista(palabra);
            } else if (palabra.equals("musica")) {
                rellenarLista(palabra);
            } else if (palabra.equals("series")) {
                rellenarLista(palabra);
            } else if (palabra.equals("peliculas")) {
                rellenarLista(palabra);
            } else if (palabra.equals("la liga")) {
                rellenarLista(palabra);
            } else if (palabra.equals("champions")) {
                rellenarLista(palabra);
            } else if (palabra.equals("mundial")) {
                rellenarLista(palabra);
            }
        }
    }



    private void rellenarLista(String palabra) {
        lista.clear();
        adaptador.notifyDataSetChanged();
        lista = new ArrayList();
        baseDatos = helper.getReadableDatabase();
        String query = "SELECT * FROM %s where %s='%s'";
        Cursor cursor = baseDatos.rawQuery(String.format(query, DatosBD.TABLA_SEC, DatosBD.TABLA_SEC_SUB_TIP, palabra), null);
        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndex(DatosBD._ID));
            String tipo = cursor.getString(cursor.getColumnIndex(DatosBD.TABLA_SEC_TIP));
            String subtipo = cursor.getString(cursor.getColumnIndex(DatosBD.TABLA_SEC_SUB_TIP));
            String nombre = cursor.getString(cursor.getColumnIndex(DatosBD.TABLA_SEC_NOM));
            String url = cursor.getString(cursor.getColumnIndex(DatosBD.TABLA_SEC_URL));
            String desc = cursor.getString(cursor.getColumnIndex(DatosBD.TABLA_SEC_DES));
            lista.add(new Objeto(id, tipo, subtipo, nombre, url, desc));
        }
        baseDatos.close();

    }

    private void rellenarTodos() {
        lista = new ArrayList();
        baseDatos = helper.getReadableDatabase();
        String query = "SELECT * FROM %s";
        Cursor cursor = baseDatos.rawQuery(String.format(query, DatosBD.TABLA_SEC), null);
        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndex(DatosBD._ID));
            String tipo = cursor.getString(cursor.getColumnIndex(DatosBD.TABLA_SEC_TIP));
            String subtipo = cursor.getString(cursor.getColumnIndex(DatosBD.TABLA_SEC_SUB_TIP));
            String nombre = cursor.getString(cursor.getColumnIndex(DatosBD.TABLA_SEC_NOM));
            String url = cursor.getString(cursor.getColumnIndex(DatosBD.TABLA_SEC_URL));
            String desc = cursor.getString(cursor.getColumnIndex(DatosBD.TABLA_SEC_DES));
            lista.add(new Objeto(id, tipo, subtipo, nombre, url, desc));
        }
        baseDatos.close();
    }

    public static FragmentRecycler newInstance(String palabra) {
        FragmentRecycler fragment = new FragmentRecycler();
        Bundle b = new Bundle();
        b.putString(TAG_PAL, palabra);
        fragment.setArguments(b);
        return fragment;
    }

    public static FragmentRecycler newInstance(int pos) {

        Bundle args = new Bundle();
        args.putInt(TAG_POS, pos);
        FragmentRecycler fragment = new FragmentRecycler();
        fragment.setArguments(args);
        return fragment;
    }

}