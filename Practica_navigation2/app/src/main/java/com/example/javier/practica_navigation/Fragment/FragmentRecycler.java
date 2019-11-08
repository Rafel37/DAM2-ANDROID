package com.example.javier.practica_navigation.Fragment;

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

import com.example.javier.practica_navigation.DatosBD.DatosBD;
import com.example.javier.practica_navigation.DatosBD.HelperDatabase;
import com.example.javier.practica_navigation.R;
import com.example.javier.practica_navigation.adaptador.AdaptadorRecycler;
import com.example.javier.practica_navigation.utils.Objeto;

import java.util.ArrayList;

public class FragmentRecycler extends Fragment {
    private static final String TAG_POS = "posicion";
    View v;
    RecyclerView recycler;
    AdaptadorRecycler adaptador;
    Context context;
    ArrayList lista;
    SQLiteOpenHelper helper;
    SQLiteDatabase base;
    int pos;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v= inflater.inflate(R.layout.fragment_main,container,false);

        recycler = v.findViewById(R.id.recycler);
        adaptador = new AdaptadorRecycler(context,pos,lista);
        recycler.setAdapter(adaptador);
        recycler.setLayoutManager(new LinearLayoutManager(context,1,false));

        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        helper=new HelperDatabase(context, DatosBD.DB_NAME,null,1);
        this.context = context;
        if (getArguments()!=null){
            this.pos=getArguments().getInt(TAG_POS);
            switch (pos){
                case 0: lista=rellenarTodos(); break;
                case 1: rellenarJuegos();break;
                case 2: rellenarMultimedia();break;
                case 3: lista=rellenarFutbol("football");break;
            }
        }

    }

    private ArrayList rellenarTodos() {
        ArrayList listatodo= new ArrayList();
        base=helper.getReadableDatabase();
        String qry="Select * from %s";
        Cursor cursor= base.rawQuery(String.format(qry,DatosBD.TABLA_SEC),null);
        while (cursor.moveToNext())
        {
            String tipo=cursor.getColumnName(cursor.getColumnIndex(DatosBD.TABLA_SEC_TIP));
            String url=cursor.getColumnName(cursor.getColumnIndex(DatosBD.TABLA_SEC_URL));
            String nombre=cursor.getColumnName(cursor.getColumnIndex(DatosBD.TABLA_SEC_NOM));
            String des=cursor.getColumnName(cursor.getColumnIndex(DatosBD.TABLA_SEC_DESC));

            listatodo.add(new Objeto(tipo,url,nombre,des));

        }

        return listatodo;

    }

    private ArrayList rellenarFutbol(String s) {
        ArrayList listatodo= new ArrayList();
        base=helper.getReadableDatabase();
        String qry="Select * from %s where %s = '%s'";
        Cursor cursor= base.rawQuery(String.format(qry,DatosBD.TABLA_SEC,DatosBD.TABLA_SEC_NOM,s),null);
        while (cursor.moveToNext())
        {
            String tipo=cursor.getColumnName(cursor.getColumnIndex(DatosBD.TABLA_SEC_TIP));
            String url=cursor.getColumnName(cursor.getColumnIndex(DatosBD.TABLA_SEC_URL));
            String nombre=cursor.getColumnName(cursor.getColumnIndex(DatosBD.TABLA_SEC_NOM));
            String des=cursor.getColumnName(cursor.getColumnIndex(DatosBD.TABLA_SEC_DESC));

            listatodo.add(new Objeto(tipo,url,nombre,des));

        }

        return listatodo;
    }

    private void rellenarMultimedia() {
        lista = new ArrayList();

    }

    private void rellenarJuegos() {
        lista = new ArrayList();

    }

    public static FragmentRecycler newInstance(int pos) {
        FragmentRecycler fragment = new FragmentRecycler();
        Bundle b = new Bundle();
        b.putInt(TAG_POS,pos);
        fragment.setArguments(b);
        return fragment;
    }
}
