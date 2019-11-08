package com.example.rpc_examenfinal.fragments;

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
import com.example.rpc_examenfinal.AdaptadorRecycler;
import com.example.rpc_examenfinal.R;
import com.example.rpc_examenfinal.json.DatosJSON;
import com.example.rpc_examenfinal.utils.Pelis;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class FragmentRecycler extends Fragment {

    View v;
    RecyclerView recyclerView;
    ArrayList pelis;
    public static final String TAG_ARG = "peli";

    public static FragmentRecycler newInstance (String peli) {
        FragmentRecycler fragmentRecycler = new FragmentRecycler();
        Bundle bundle = new Bundle();
        bundle.putString(TAG_ARG, peli);
        fragmentRecycler.setArguments(bundle);
        return fragmentRecycler;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_recycler, container, false);
        recyclerView = v.findViewById(R.id.recyclerView);
        acciones();
        return v;
    }

    private void acciones() {
        String url = "https://api.themoviedb.org/3/movie/now_playing?api_key=4ef66e12cddbb8fe9d4fd03ac9632f6e&language=en-US&page=1";
        JsonObjectRequest jsonObjectRequest;
        jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url,
                null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                rellenarRecycler(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
                ;
    });
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        requestQueue.add(jsonObjectRequest);
    }

    private void rellenarRecycler(JSONObject response){
        try {
            if (getArguments() != null) {
                String peli = this.getArguments().getString(TAG_ARG);
                pelis = new ArrayList();
                JSONArray array = response.getJSONArray(DatosJSON.JSON_NAME);
                for (int i = 0; i < array.length(); i++){
                    JSONObject jsonObject = array.getJSONObject(i);
                    if (jsonObject.get(DatosJSON.TITULO).equals(peli)){
                        String nombre = jsonObject.getString(DatosJSON.TITULO);
                        double puntuacion = jsonObject.getDouble(DatosJSON.PUNTUACION);
                        pelis.add(new Pelis(nombre, puntuacion));
                    }
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        AdaptadorRecycler adaptadorRecycler = new AdaptadorRecycler(pelis, getContext());
        adaptadorRecycler.notifyDataSetChanged();
        recyclerView.setAdapter(adaptadorRecycler);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1, LinearLayoutManager.VERTICAL, false));
    }

}
