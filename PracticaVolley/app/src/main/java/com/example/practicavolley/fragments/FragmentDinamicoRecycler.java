package com.example.practicavolley.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
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
import com.example.practicavolley.adaptadores.AdaptadorRecycler;
import com.example.practicavolley.json.DatosJSON;
import com.example.practicavolley.utils.Equipo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class FragmentDinamicoRecycler extends Fragment {

    View v;
    RecyclerView recyclerView;
    ArrayList equipos;

    public static final String TAG_ARG = "liga";

    public static FragmentDinamicoRecycler newInstance(String liga) {
        FragmentDinamicoRecycler fragment = new FragmentDinamicoRecycler();
        Bundle b = new Bundle();
        b.putString(TAG_ARG, liga);
        fragment.setArguments(b);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_dinamico_recycler, container, false);
        instancias();
        acciones();
        return v;
    }

    private void acciones() {
        String url = "https://www.thesportsdb.com/api/v1/json/1/search_all_teams.php?s=Soccer&c=Spain";
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

    private void instancias() {
        recyclerView = v.findViewById(R.id.recyclerView);
    }

    private void rellenarRecycler(JSONObject response) {
        try {
            if (getArguments() != null) {
                String ligaPasada = this.getArguments().getString(TAG_ARG);

                equipos = new ArrayList();
                JSONArray array = response.getJSONArray(DatosJSON.JSON_NAME_T);
                for (int i = 0; i < array.length(); i++) {
                    JSONObject jsonObject = array.getJSONObject(i);
                    if (jsonObject.get(DatosJSON.LEAGUE_T).equals(ligaPasada)) {
                        String id = jsonObject.getString(DatosJSON.ID_TEAM_T);
                        String nombre = jsonObject.getString(DatosJSON.NOMBRE_T);
                        String imCamiseta = jsonObject.getString(DatosJSON.IMAGEN_CAMISETA_T);
                        String imEscudo = jsonObject.getString(DatosJSON.IMAGEN_ESCUDO_T);
                        String imEstadio = jsonObject.getString(DatosJSON.IMAGEN_ESTADIO_T);
                        equipos.add(new Equipo(id, nombre, imCamiseta, imEscudo, imEstadio));
                    }
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        AdaptadorRecycler adaptadorRecycler = new AdaptadorRecycler(equipos, getContext());
        adaptadorRecycler.notifyDataSetChanged();
        recyclerView.setAdapter(adaptadorRecycler);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2,
                LinearLayoutManager.VERTICAL, false));
    }
}
