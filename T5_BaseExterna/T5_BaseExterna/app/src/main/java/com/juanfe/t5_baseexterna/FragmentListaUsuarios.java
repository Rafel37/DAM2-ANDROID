package com.juanfe.t5_baseexterna;

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

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class FragmentListaUsuarios extends Fragment {
    Context context;
    ArrayList<Usuario> lista;
    RecyclerView recycler;
    AdaptadorRecycler adaptador;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_recycler,container,false);
        recycler = v.findViewById(R.id.recycler);
        adaptador = new AdaptadorRecycler(context,lista);
        recycler.setAdapter(adaptador);
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
        hacerSelect();
    }

    public void hacerSelect(){
        String url = "http://192.168.1.101/school/SeleccionUsuarios.php";
        Volley.newRequestQueue(context).add(new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                //hace las llamadas pertinentes y registro de los datos
                try {
                    procesarRespuesta(response);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
               // Log.i("Volley", error.getMessage());

            }
        }));
    }

    private void procesarRespuesta(JSONObject response) throws JSONException {
        JSONArray array = response.getJSONArray("usuarios");
        for (int i = 0; i<array.length();i++){
            JSONObject obj = array.getJSONObject(i);
            String nombre =  obj.getString("NOMBRE");
            String correo =  obj.getString("CORREO");

            lista.add(new Usuario(nombre,correo));

        }
        adaptador.notifyDataSetChanged();

    }

}
