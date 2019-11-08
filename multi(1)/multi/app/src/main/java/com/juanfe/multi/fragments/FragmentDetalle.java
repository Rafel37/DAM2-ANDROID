package com.juanfe.multi.fragments;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.juanfe.multi.R;
import com.juanfe.multi.db.Datos;
import com.juanfe.multi.db.HelperDataBase;
import com.juanfe.multi.utils.Multimedia;

import java.util.ArrayList;

public class FragmentDetalle extends Fragment {
    private static final String TAG_PAL = "palabra";
    private static final String TAG_POS = "posicion";
    private static final String TAGPALABRA2 = "palabra 2";
    View v;
    TextView nombreDetalle,descDetalle;
    ImageView imagenDetalle;
    Context context;
    SQLiteOpenHelper helper;
    String palabra;
    ArrayList lista;
    SQLiteDatabase baseDatos;
    int pos;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragmentdetalle,container,false);
        instancias(v);
        rellenarDetalle();
        return v;
    }

    private void rellenarDetalle() {
        Multimedia m = (Multimedia) lista.get(pos);
        Glide.with(context).load(m.getUrl()).into(imagenDetalle);
        nombreDetalle.setText(m.getNombre());
        descDetalle.setText(m.getDescripcion());
    }

    private void instancias(View v) {
        nombreDetalle = v.findViewById(R.id.nombreDetalle);
        descDetalle = v.findViewById(R.id.descDetalle);
        imagenDetalle = v.findViewById(R.id.imagenDetalle);

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        helper = new HelperDataBase(context, Datos.DB_NAME,null,1);
        this.context = context;
        if (getArguments()!=null){
            this.pos = getArguments().getInt(TAG_POS);
            this.palabra= (String) getArguments().get(TAG_PAL);
            if (palabra.equals("juegos")){
                rellenarLista(palabra);
            }else if (palabra.equals("principal")){
                rellenarTodos();
            }else if (palabra.equals("multimedia")){
                rellenarLista(palabra);
            }else if (palabra.equals("futbol")){
                rellenarLista(palabra);
            }else if (palabra.equals("pc")){
                rellenarLista(palabra);
            }else if (palabra.equals("xbox")){
                rellenarLista(palabra);
            }else if (palabra.equals("ps4")){
                rellenarLista(palabra);
            }else if (palabra.equals("musica")){
                rellenarLista(palabra);
            }else if (palabra.equals("series")){
                rellenarLista(palabra);
            }else if (palabra.equals("peliculas")){
                rellenarLista(palabra);
            }else if (palabra.equals("la liga")){
                rellenarLista(palabra);
            }else if (palabra.equals("champions")){
                rellenarLista(palabra);
            }else if (palabra.equals("mundial")){
                rellenarLista(palabra);
            }else if (getArguments().get(TAGPALABRA2)!=null){
                rellenarDetalleBusqueda((String) getArguments().get(TAGPALABRA2));
            }
        }

    }

    private void rellenarDetalleBusqueda(String s) {
        baseDatos = helper.getReadableDatabase();
        String query = "SELECT * FROM %s where %s='%s' limit 1";
        Cursor cursor=baseDatos.rawQuery(String.format(query,Datos.TABLA_SEC,Datos.TABLA_SEC_SUB_TIP,palabra),null);
        while (cursor.moveToNext()){
            int id = cursor.getInt(cursor.getColumnIndex(Datos._ID));
            String tipo = cursor.getString(cursor.getColumnIndex(Datos.TABLA_SEC_TIP));
            String subtipo = cursor.getString(cursor.getColumnIndex(Datos.TABLA_SEC_SUB_TIP));
            String nombre = cursor.getString(cursor.getColumnIndex(Datos.TABLA_SEC_NOM));
            String url = cursor.getString(cursor.getColumnIndex(Datos.TABLA_SEC_URL));
            String desc = cursor.getString(cursor.getColumnIndex(Datos.TABLA_SEC_DESC));

        }


    }

    private void rellenarLista(String palabra) {
        lista = new ArrayList();
        baseDatos = helper.getReadableDatabase();
        String query = "SELECT * FROM %s where %s='%s'";
        Cursor cursor=baseDatos.rawQuery(String.format(query,Datos.TABLA_SEC,Datos.TABLA_SEC_SUB_TIP,palabra),null);
        while (cursor.moveToNext()){
            int id = cursor.getInt(cursor.getColumnIndex(Datos._ID));
            String tipo = cursor.getString(cursor.getColumnIndex(Datos.TABLA_SEC_TIP));
            String subtipo = cursor.getString(cursor.getColumnIndex(Datos.TABLA_SEC_SUB_TIP));
            String nombre = cursor.getString(cursor.getColumnIndex(Datos.TABLA_SEC_NOM));
            String url = cursor.getString(cursor.getColumnIndex(Datos.TABLA_SEC_URL));
            String desc = cursor.getString(cursor.getColumnIndex(Datos.TABLA_SEC_DESC));
            lista.add(new Multimedia(id,tipo,subtipo,nombre,url,desc));
        }
        baseDatos.close();

    }

    private void rellenarTodos() {
        lista = new ArrayList();
        baseDatos = helper.getReadableDatabase();
        String query = "SELECT * FROM %s";
        Cursor cursor=baseDatos.rawQuery(String.format(query,Datos.TABLA_SEC),null);
        while (cursor.moveToNext()){
            int id = cursor.getInt(cursor.getColumnIndex(Datos._ID));
            String tipo = cursor.getString(cursor.getColumnIndex(Datos.TABLA_SEC_TIP));
            String subtipo = cursor.getString(cursor.getColumnIndex(Datos.TABLA_SEC_SUB_TIP));
            String nombre = cursor.getString(cursor.getColumnIndex(Datos.TABLA_SEC_NOM));
            String url = cursor.getString(cursor.getColumnIndex(Datos.TABLA_SEC_URL));
            String desc = cursor.getString(cursor.getColumnIndex(Datos.TABLA_SEC_DESC));
            lista.add(new Multimedia(id,tipo,subtipo,nombre,url,desc));
        }
        baseDatos.close();
    }

    public static FragmentDetalle newInstance(String palabra,int pos) {

        Bundle args = new Bundle();
        args.putString(TAG_PAL,palabra);
        args.putInt(TAG_POS,pos);
        FragmentDetalle fragment = new FragmentDetalle();
        fragment.setArguments(args);
        return fragment;
    }

    public static FragmentDetalle newInstance(String palabra) {

        Bundle args = new Bundle();
        args.putString(TAGPALABRA2,palabra);
        FragmentDetalle fragment = new FragmentDetalle();
        fragment.setArguments(args);
        return fragment;
    }
}
