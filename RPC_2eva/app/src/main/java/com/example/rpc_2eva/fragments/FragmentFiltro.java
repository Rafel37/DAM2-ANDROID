package com.example.rpc_2eva.fragments;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.solver.widgets.Helper;
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
import com.example.rpc_2eva.R;
import com.example.rpc_2eva.adaptadores.AdaptadorRecycler;
import com.example.rpc_2eva.json.DatosJSON;
import com.example.rpc_2eva.json.HelperDB;
import com.example.rpc_2eva.utils.Pelis;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class FragmentFiltro extends Fragment {
    private static final String TAG_GEN = "genero";
    String genero;
    HelperDB helper;
    Context context;
    RecyclerView recycler;
    ArrayList lista;
    AdaptadorRecycler adaptador;
    Button importar;
    SQLiteDatabase baseDatos;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_filtro,container,false);
        helper = new HelperDB(context, DatosJSON.JSON_NAME, null, 1);
        recycler = v.findViewById(R.id.recylerFiltro);
        adaptador = new AdaptadorRecycler(lista, context);
        recycler.setAdapter(adaptador);
        recycler.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false));
        importar = v.findViewById(R.id.botonFiltro);

        importar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0 ; i<lista.size();i++){
                    Pelis p = (Pelis) lista.get(i);
                    Insert( p.getCartel(),
                            p.getNombre(),
                            String.valueOf(getId()),
                            p.getGenero());
                }
            }
        });




        return v;
    }

    public void Insert(String titulo, String fecha,String imagen,String genero){
        baseDatos = helper.getWritableDatabase();
        String query ="INSERT INTO %s (%s,%s,%s,%s) values('%s','%s','%s','%s')";
        baseDatos.execSQL(String.format(query,
                DatosJSON.JSON_NAME,
                DatosJSON.TITULO,
                DatosJSON.ID,
                DatosJSON.CARTEL,
                DatosJSON.GENERO
                ,titulo,fecha,imagen,genero));
        baseDatos.close();
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
        helper = new HelperDB(context, DatosJSON.JSON_NAME, null, 1);
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
                lista.add(new Pelis(obj.getString("titulole"),obj.getString("release_date"),"https://image.tmdb.org/t/p/w500/"+obj.getString("poster_path"),obj.getString("genero")));

            }
        }
        adaptador.notifyDataSetChanged();

    }

    public static FragmentRecycler newInstance(String genero) {

        Bundle b = new Bundle();
        b.putString(TAG_GEN,genero);
        FragmentRecycler fragment = new FragmentRecycler();
        fragment.setArguments(b);
        return fragment;
    }
}
