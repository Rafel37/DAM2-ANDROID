package com.example.practicavolley.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.practicavolley.R;
import com.example.practicavolley.adaptadores.AdaptadorRecyclerDetalle;
import com.example.practicavolley.json.DatosJSON;
import com.example.practicavolley.utils.Jugador;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class FragmentDinamicoDetalle extends Fragment {

    View v;
    RecyclerView recyclerView;
    ArrayList jugadores;

    public static final String TAG_ARG = "idEquipo";

    public static FragmentDinamicoDetalle newInstance(String idEquipo) {
        FragmentDinamicoDetalle fragment = new FragmentDinamicoDetalle();
        Bundle b = new Bundle();
        b.putString(TAG_ARG, idEquipo);
        fragment.setArguments(b);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_dinamico_detalle, container, false);
        instancias();
        acciones();
        return v;
    }

    private void acciones() {
        if (getArguments() != null) {
            String idPasado = this.getArguments().getString(TAG_ARG);
            String url = "https://www.thesportsdb.com/api/v1/json/1/lookup_all_players.php?id=" + idPasado;
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url,
                    null, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    rellenarRecycler(response);
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            });
            RequestQueue requestQueue = Volley.newRequestQueue(getContext());
            requestQueue.add(jsonObjectRequest);
        }
    }

    private void instancias() {
        recyclerView = v.findViewById(R.id.recyclerViewDetalle);
    }

    private void rellenarRecycler(JSONObject response) {
        try {
            jugadores = new ArrayList();
            JSONArray array = response.getJSONArray(DatosJSON.JSON_NAME_J);
            for (int i = 0; i < array.length(); i++) {
                JSONObject jsonObject = array.getJSONObject(i);
                String imagen = jsonObject.getString(DatosJSON.IMAGEN_J);
                String nombre = jsonObject.getString(DatosJSON.NOMBRE_J);
                String posicion = jsonObject.getString(DatosJSON.POSICION_J);
                jugadores.add(new Jugador(imagen, nombre, posicion));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        AdaptadorRecyclerDetalle adaptadorRecycler = new AdaptadorRecyclerDetalle(jugadores, getContext());
        adaptadorRecycler.notifyDataSetChanged();
        recyclerView.setAdapter(adaptadorRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
    }
}
