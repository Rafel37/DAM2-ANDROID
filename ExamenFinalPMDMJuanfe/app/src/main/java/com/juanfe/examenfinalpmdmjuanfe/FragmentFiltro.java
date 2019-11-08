package com.juanfe.examenfinalpmdmjuanfe;

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
import com.juanfe.examenfinalpmdmjuanfe.utils.Pelicula;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class FragmentFiltro extends Fragment {
    ArrayList <Pelicula> list;
    Context c;
    RecyclerView recycler;
    Spinner spinner;
    Button filtrar;
    OnButtonListener onButtonListener;
    AdaptadorRecycler adaptador;
    ArrayList generos;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragmentfiltro, container, false);
        recycler = v.findViewById(R.id.recyclerFiltro);
        rellenarLista();
        adaptador = new AdaptadorRecycler(c, list);
        recycler.setAdapter(adaptador);
        recycler.setLayoutManager(new LinearLayoutManager(c,LinearLayoutManager.VERTICAL,false));
        spinner = v.findViewById(R.id.spinnerfiltro);
        generos = new ArrayList();

        Log.v("test", String.valueOf(list.size()));

        filtrar = v.findViewById(R.id.filtro);
        filtrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId()==filtrar.getId()){
                    Pelicula p =  list.get( spinner.getSelectedItemPosition());

                    onButtonListener.onClick(p.getGenero());
                }
            }
        });


        return v;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        c = context;
        onButtonListener = (OnButtonListener) c;
        //listaP = new ArrayList();
        list = new ArrayList<>();


    }

    private void rellenarLista() {
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
        RequestQueue requestQueue = Volley.newRequestQueue(c);
        requestQueue.add(json);

    }

    private void procesarRespuesta(JSONObject response) throws JSONException {
        JSONArray array = response.getJSONArray("results");
        //generos = new String[array.length()];


        for (int i = 0; i < array.length(); i++) {

            JSONObject obj = (JSONObject) array.get(i);
            String titulo=obj.getString("title");
            String fecha=obj.getString("release_date");
            String imagen = obj.getString("poster_path");
            String genero = obj.getString("genero");
            //generos[i]=obj.getString("genero");
            list.add(new Pelicula(titulo,fecha,"https://image.tmdb.org/t/p/w500/"+imagen,genero));
            persoSpinner(list.get(i).getGenero());

        }

        Log.v("test", String.valueOf(list.size()));
        adaptador.notifyDataSetChanged();
    }

    private void persoSpinner(String genero) {
        generos.add(genero);

        ArrayAdapter<CharSequence> adaptadorSpinner = new ArrayAdapter<CharSequence>(c,android.R.layout.simple_spinner_item,generos);
        adaptadorSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adaptadorSpinner);
    }


    public interface OnButtonListener{
        void onClick(String genero);
    }


}
