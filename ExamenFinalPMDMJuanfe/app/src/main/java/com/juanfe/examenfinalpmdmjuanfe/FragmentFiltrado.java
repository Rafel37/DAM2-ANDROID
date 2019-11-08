package com.juanfe.examenfinalpmdmjuanfe;

import android.content.Context;
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
import android.widget.Button;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.juanfe.examenfinalpmdmjuanfe.db.Datos;
import com.juanfe.examenfinalpmdmjuanfe.db.Helper;
import com.juanfe.examenfinalpmdmjuanfe.utils.Pelicula;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class FragmentFiltrado extends Fragment {
    private static final String TAG_GEN = "genero";
    String genero;
    Helper helper;
    Context context;
    RecyclerView recycler;
    ArrayList lista;
    AdaptadorRecycler adaptador;
    Button importar;
    SQLiteDatabase baseDatos;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_filtrado,container,false);
        helper = new Helper(context, Datos.Tabla,null,1);
        recycler = v.findViewById(R.id.recyclerfiltrado);
        adaptador = new AdaptadorRecycler(context,lista);
        recycler.setAdapter(adaptador);
        recycler.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false));
        importar = v.findViewById(R.id.importar);

        importar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0 ; i<lista.size();i++){
                    Pelicula p = (Pelicula) lista.get(i);
                    impos( p.getTitulo(),p.getFecha(),p.getImagen(),p.getGenero());
                }
            }
        });




        return v;
    }

    public void impos(String tit, String fec,String im,String gen){
        baseDatos = helper.getWritableDatabase();
        String query ="INSERT INTO %s (%s,%s,%s,%s) values('%s','%s','%s','%s')";
        baseDatos.execSQL(String.format(query,
                Datos.Tabla,
                Datos.titulo,
                Datos.fecha,
                Datos.imagen,
                Datos.genero
        ,tit,fec,im,gen));
        baseDatos.close();
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
        helper = new Helper(context,Datos.Tabla,null,1);
        if (getArguments()!=null){
            genero = getArguments().getString(TAG_GEN);
            lista = new ArrayList();
            rellenarLista();

        }
    }

    private void rellenarLista() {
        String url = "http://developandsys.es/wp-content/films";
        JsonObjectRequest json = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    procesarRespuesta(response);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(json);
    }

    private void procesarRespuesta(JSONObject response) throws JSONException {
        JSONArray array = response.getJSONArray("results");
        for (int i = 0; i<array.length();i++){
            JSONObject obj = (JSONObject) array.get(i);
            if (obj.getString("genero").equals(genero)){
                lista.add(new Pelicula(obj.getString("title"),obj.getString("release_date"),"https://image.tmdb.org/t/p/w500/"+obj.getString("poster_path"),obj.getString("genero")));

            }
        }
        adaptador.notifyDataSetChanged();

    }

    public static FragmentFiltrado newInstance(String genero) {

        Bundle b = new Bundle();
        b.putString(TAG_GEN,genero);
        FragmentFiltrado fragment = new FragmentFiltrado();
        fragment.setArguments(b);
        return fragment;
    }
}
