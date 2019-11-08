package com.example.practicawebapijson.fragments;

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

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.practicawebapijson.R;
import com.example.practicawebapijson.utils.VolleySingleton;
import com.example.practicawebapijson.adaptadores.AdaptadorRecycler;
import com.example.practicawebapijson.json.DatosJSON;
import com.example.practicawebapijson.utils.Usuario;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FragmentDinamicoUsuario extends Fragment {

    View v;
    RecyclerView recyclerView;
    ArrayList usuarios;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_dinamico_recycler, container, false);
        instancias();
        acciones();
        return v;
    }

    private void instancias() {
        recyclerView = v.findViewById(R.id.recyclerView);
    }

    private void acciones() {

        //String urlGet = "http://localhost:8080/androidJSONPHP/obtener_alumnos.php";
        //TODO: http://10.0.2.2:8080/ para conectarse al localhost desde el emulador
        String urlGet = "http://10.0.2.2:8080/androidJSONPHP/obtener_alumnos.php";

        VolleySingleton.getInstance(getContext())
                .addToRequestQueue(new JsonObjectRequest(Request.Method.GET,
                                           urlGet,
                                           null,
                                           new Response.Listener<JSONObject>() {
                                               @Override
                                               public void onResponse(JSONObject response) {

                                                   rellenarRecycler(response);
                                                   /*
                                                   JSONArray jsonArray = null;
                                                   try {
                                                       jsonArray = response.getJSONArray("usuarios");
                                                   } catch (JSONException e) {
                                                       e.printStackTrace();
                                                   }
                                                   Gson gson = new Gson();
                                                   Usuario[] users = gson.fromJson(jsonArray.toString(), Usuario[].class);
re
                                                   Log.v("test", users[0].getNombre());
                                                   */
                                               }
                                           },
                                           new Response.ErrorListener() {
                                               @Override
                                               public void onErrorResponse(VolleyError error) {
                                                   Log.d("Volley", "Error Volley: " + error.getMessage());
                                               }
                                           }) {
                                       @Override
                                       public Map<String, String> getHeaders() {
                                           Map<String, String> headers = new HashMap<>();
                                           headers.put("Content-Type", "application/json; charset=utf-8");
                                           headers.put("Accept", "application/json");
                                           return headers;
                                       }

                                       @Override
                                       public String getBodyContentType() {
                                           return "application/json; charset=utf-8" + getParamsEncoding();
                                       }
                                   }
                );
    }

    private void rellenarRecycler(JSONObject response) {
        try {
            usuarios = new ArrayList();
            JSONArray array = response.getJSONArray(DatosJSON.JSON_NAME);
            for (int i = 0; i < array.length(); i++) {
                JSONObject jsonObject = array.getJSONObject(i);
                String nombre = jsonObject.getString(DatosJSON.NOMBRE);
                String apellidos = jsonObject.getString(DatosJSON.APELLIDOS);
                String correo = jsonObject.getString(DatosJSON.CORREO);
                String contrasena = jsonObject.getString(DatosJSON.CONTRASENA);
                String curso = jsonObject.getString(DatosJSON.CURSO);
                int conocimiento = jsonObject.getInt(DatosJSON.CONOCIMIENTO);
                usuarios.add(new Usuario(nombre, apellidos, correo, contrasena, curso, conocimiento));
            }
        } catch (
                JSONException e) {
            e.printStackTrace();
        }
        AdaptadorRecycler adaptadorRecycler = new AdaptadorRecycler(usuarios, getContext());
        adaptadorRecycler.notifyDataSetChanged();
        recyclerView.setAdapter(adaptadorRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
    }
}