package com.example.rpc_2eva.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.rpc_2eva.R;
import com.example.rpc_2eva.adaptadores.AdaptadorRecycler;
import com.example.rpc_2eva.utils.Pelis;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class FragmentRecycler extends Fragment {

    ArrayList <Pelis> list;
    Context context;
    View view;
    RecyclerView recycler;
    Spinner spinner;
    Button bFiltrar;
    AdaptadorRecycler adaptador;
    OnButtonListener onButtonListener;
    ArrayList generos;

    public static final String TAG_FILM = "film";

    public static Fragment newInstance(String peli) {
        FragmentRecycler fragmentRecycler = new FragmentRecycler();
        Bundle bundle = new Bundle();
        bundle.putString(TAG_FILM, peli);
        fragmentRecycler.setArguments(bundle);
        return fragmentRecycler;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_recycler, container, false);
        recycler = view.findViewById(R.id.recylerFiltro);
        rellenarRacycler();
        adaptador = new AdaptadorRecycler(list, context);
        recycler.setAdapter(adaptador);
        recycler.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false));
        spinner = view.findViewById(R.id.spinner);
        generos = new ArrayList();

        Log.v("test", String.valueOf(list.size()));

        bFiltrar = view.findViewById(R.id.botonFiltro);
        bFiltrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId()==bFiltrar.getId()){
                    Pelis p =  list.get( spinner.getSelectedItemPosition());

                    onButtonListener.onClick(p.getGenero());
                }
            }
        });
        return view;
    }

    private void rellenarRacycler() {
        String url = "https://api.themoviedb.org/3/movie/now_playing?api_key=4ef66e12cddbb8fe9d4fd03ac9632f6e&language=en-US&page=1";
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
        //generos = new String[array.length()];


        for (int i = 0; i < array.length(); i++) {

            JSONObject obj = (JSONObject) array.get(i);
            String titulo = obj.getString("title");
            String id = obj.getString("id");
            String imagen = obj.getString("poster_path");
            String genero = obj.getString("genero");
            //generos[i]=obj.getString("genero");
            list.add(new Pelis(titulo,id,"https://image.tmdb.org/t/p/w500/"+imagen,genero));
            persoSpinner(list.get(i).getGenero());

        }

        Log.v("test", String.valueOf(list.size()));
        adaptador.notifyDataSetChanged();
    }
    private void persoSpinner(String genero) {
        generos.add(genero);

        ArrayAdapter<CharSequence> adaptadorSpinner = new ArrayAdapter<CharSequence>(context,android.R.layout.simple_spinner_item,generos);
        adaptadorSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adaptadorSpinner);
    }


    public interface OnButtonListener{
        void onClick(String genero);
    }
}
