package com.juanfe.equipos.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.juanfe.equipos.R;
import com.juanfe.equipos.adaptadores.AdaptadorRecyclerFragment;
import com.juanfe.equipos.utils.Equipo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class FragmentRecycler extends Fragment {
    private static final String KEY_EQUI = "liga";
    private static final String KEY_API = "API";
    RecyclerView recycler;
    String liga,url;
    AdaptadorRecyclerFragment adapter;
    Context context;
    ArrayList lista;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_recycler,container,false);
        recycler = v.findViewById(R.id.recycler);
        adapter = new AdaptadorRecyclerFragment(context,lista);
        recycler.setAdapter(adapter);
        recycler.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL,
                false));
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recycler.getContext(),
                ((LinearLayoutManager) recycler.getLayoutManager()).getOrientation());
        recycler.addItemDecoration(dividerItemDecoration);

        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context=context;
        lista = new ArrayList();
        if (getArguments()!=null){
            liga = (String) getArguments().get(KEY_EQUI);
            url = (String) getArguments().get(KEY_API);
        }
        rellenarLista(url);
    }



    public static FragmentRecycler newInstance(String liga,String api) {

        Bundle b = new Bundle();
        b.putString(KEY_EQUI,liga);
        b.putString(KEY_API,api);
        FragmentRecycler f = new FragmentRecycler();
        f.setArguments(b);
        return f;
    }

    private void rellenarLista(String url) {
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
        JSONArray array = response.getJSONArray("teams");

        for (int i = 0;i<array.length();i++){

            JSONObject objeto = array.getJSONObject(i);
            if (objeto.getString("strLeague").equals(liga)){
                String nombre = objeto.getString("strTeam");
                String estadio = objeto.getString("strStadiumThumb");
                String escudo = objeto.getString("strTeamBadge");
                String camiseta = objeto.getString("strTeamJersey");
                lista.add(new Equipo(nombre,escudo,estadio,camiseta));
            }


        }
        adapter.notifyDataSetChanged();


    }
}
