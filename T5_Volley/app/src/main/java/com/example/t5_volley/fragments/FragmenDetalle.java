package com.example.t5_volley.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.example.t5_volley.R;
import com.example.t5_volley.adaptadores.AdaptadorDetalle;
import com.example.t5_volley.utils.Jugador;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class FragmenDetalle extends Fragment {

    private static final String TAG_NOM = "nequipo";
    private static final String TAG_ESC = "escudo";

    Context context;
    String nombre_equipo;
    ArrayList listaJ;
    RecyclerView recycler;
    ImageView imagen;
    String imagenequipo;
    AdaptadorDetalle adaptador;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_detalle,container,false);
        recycler = v.findViewById(R.id.recyclerDetalle);
        imagen = v.findViewById(R.id.detalle_escudo);
        Glide.with(context).load(imagenequipo).into(imagen);
        adaptador = new AdaptadorDetalle(context,listaJ);
        recycler.setAdapter(adaptador);
        recycler.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL,
                false));
        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
        listaJ = new ArrayList<Jugador>();
        if (getArguments()!=null){
            imagenequipo = getArguments().getString(TAG_ESC);
            nombre_equipo = getArguments().getString(TAG_NOM);

        }
        rellenarLista(nombre_equipo);

    }

    public static FragmenDetalle newInstance(String nombreEquipo, String imagen) {

        Bundle b = new Bundle();
        b.putString(TAG_NOM,nombreEquipo);
        b.putString(TAG_ESC,imagen);
        FragmenDetalle fragment = new FragmenDetalle();
        fragment.setArguments(b);
        return fragment;
    }
    public void rellenarLista(String equipo){
        String url = "https://www.thesportsdb.com/api/v1/json/1/searchplayers.php?t=";
        url = url+equipo;
        JsonObjectRequest json = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    procesarRespuerta(response);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context,error.toString(),Toast.LENGTH_SHORT).show();

            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(json);


    }
    private void procesarRespuerta(JSONObject response)throws JSONException {

        JSONArray array = response.getJSONArray("player");

        for (int i = 0;i<array.length();i++){

            JSONObject objeto = array.getJSONObject(i);
            String nombre = (String) objeto.get("strPlayer");
            String imagen = objeto.getString("strThumb");
            String posicion = objeto.getString("strPosition");
            listaJ.add(new Jugador(nombre,imagen,posicion));

        }
        adaptador.notifyDataSetChanged();
    }
}
