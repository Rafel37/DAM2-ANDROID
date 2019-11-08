package com.example.t5_volley.fragments;

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
import com.example.t5_volley.R;
import com.example.t5_volley.adaptadores.AdaptadorRecycler;
import com.example.t5_volley.json.DatosJSON;
import com.example.t5_volley.utils.Equipo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class FragmentRecycler extends Fragment {

    View v;
    RecyclerView recyclerView;
    ArrayList equipos;

    public static final String TAG_ARG = "liga";

    public static FragmentRecycler newInstance(String liga) {
        FragmentRecycler fragment = new FragmentRecycler();
        Bundle b = new Bundle();
        b.putString(TAG_ARG, liga);
        fragment.setArguments(b);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_recycler, container, false);
        instancias();
        acciones();
        return v;
    }

    private void acciones() {
        String url = "https://www.thesportsdb.com/api/v1/json/1/search_all_teams.php?s=Soccer&c=Spain";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url,null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    rellenarRecycler(response);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
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

    private void rellenarRecycler(JSONObject response) throws JSONException {

        String ligaPasada = this.getArguments().getString(TAG_ARG);

        equipos = new ArrayList();
        JSONArray array = response.getJSONArray(DatosJSON.JSON_NAME);
        for (int i = 0; i < array.length(); i++) {
            JSONObject jsonObject = array.getJSONObject(i);
            if (jsonObject.get(DatosJSON.LEAGUE).equals(ligaPasada)) {
                String id = jsonObject.getString(DatosJSON.ID_TEAM);
                String nombre = jsonObject.getString(DatosJSON.NOMBRE);
                String camiseta = jsonObject.getString(DatosJSON.EQUIPACION);
                String escudo = jsonObject.getString(DatosJSON.ESCUDO);
                String estadio = jsonObject.getString(DatosJSON.ESTADIO);
                equipos.add(new Equipo(id, nombre, camiseta, escudo, estadio));
            }
        }

        AdaptadorRecycler adaptadorRecycler = new AdaptadorRecycler(equipos, getContext());
        adaptadorRecycler.notifyDataSetChanged();
        recyclerView.setAdapter(adaptadorRecycler);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2, LinearLayoutManager.VERTICAL, false));
    }
}
