package com.example.practicawebapijson.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.practicawebapijson.R;
import com.example.practicawebapijson.utils.VolleySingleton;
import com.example.practicawebapijson.utils.Usuario;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class FragmentDinamicoInsertar extends Fragment {

    View v;
    TextView nombre, apellidos, correo, curso, contrasena;
    CheckBox conocimientos;
    Button btnInsertar, btnActualizar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_dinamico_insertar, container, false);
        instancias();
        acciones();
        return v;
    }

    private void instancias() {
        nombre = v.findViewById(R.id.nombre);
        apellidos = v.findViewById(R.id.apellidos);
        correo = v.findViewById(R.id.correo);
        curso = v.findViewById(R.id.curso);
        contrasena = v.findViewById(R.id.contrasena);
        conocimientos = v.findViewById(R.id.conocimientos);
        btnInsertar = v.findViewById(R.id.btnInsertar);
        btnActualizar = v.findViewById(R.id.btnActualizar);

        btnActualizar.setEnabled(false);
    }

    private void acciones() {
        btnInsertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HashMap mapaDatos = new HashMap();
                mapaDatos.put("nombre", nombre.getText().toString());
                mapaDatos.put("apellidos", apellidos.getText().toString());
                mapaDatos.put("correo", correo.getText().toString());
                mapaDatos.put("contrasena", contrasena.getText().toString());
                mapaDatos.put("curso", curso.getText().toString());
                if (conocimientos.isChecked() ){
                    mapaDatos.put("conocimiento_previo", 1);
                } else
                    mapaDatos.put("conocimiento_previo", 0);
                JSONObject jsonObject = new JSONObject(mapaDatos);

                //TODO: http://10.0.2.2:8080/ para conectarse al localhost desde el emulador
                String url = "http://10.0.2.2:8080/androidJSONPHP/insertar_alumno.php";
                //PARA HACERLO POR GET
                //String urlGet = "http://X.X.X.X/develop/insertar_alumno.php?nombre=Ejemplo&amp;apellido=apellido&amp;direccion=direccion&amp;telefono=1111";

                VolleySingleton.getInstance(getContext()).addToRequestQueue(
                        new JsonObjectRequest(Request.Method.POST,
                                url,
                                jsonObject,
                                new Response.Listener<JSONObject>() {
                                    @Override
                                    public void onResponse(JSONObject response) {
                                        // Procesar la respuesta Json
                                        try {
                                            Log.v("test", response.getString("mensaje"));
                                        } catch (JSONException e) {
                                            e.printStackTrace();
                                        }
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
        });
        //TODO: NO ESTA PROGRAMADO
        btnActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String urlGet = "http://10.0.2.2:8080/androidJSONPHP/actualizar_alumno.php?nombre=NombreCapturado&nombreNuevo=NombreNuevo";

                VolleySingleton.getInstance(getContext()).addToRequestQueue(
                        new JsonObjectRequest(Request.Method.GET,
                                urlGet,
                                null,
                                new Response.Listener<JSONObject>() {
                                    @Override
                                    public void
                                    onResponse(JSONObject response) {
                                        try {
                                            Log.v("test",
                                                    response.getString("mensaje"));
                                        } catch (JSONException
                                                e) {
                                            e.printStackTrace();
                                        }
                                    }
                                },
                                new Response.ErrorListener() {
                                    @Override
                                    public void
                                    onErrorResponse(VolleyError error) {
                                        Log.d("Volley", "Error Volley:" + error.getMessage());
                                    }
                                }) {
                            @Override
                            public Map<String, String>
                            getHeaders() {
                                Map<String, String>
                                        headers = new HashMap<>();
                                headers.put("Content-Type",
                                        "application/json; charset=utf-8");
                                headers.put("Accept",
                                        "application/json");
                                return headers;
                            }

                            @Override
                            public String getBodyContentType() {
                                return "application/json; charset = utf - 8 " + getParamsEncoding();
                            }
                        }
                );
            }
        });

    }
}