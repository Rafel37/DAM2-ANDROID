package com.juanfe.t5_baseexterna;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class FragmentRegistro extends Fragment implements View.OnClickListener {
    EditText nombre, apellido, correo, confircorreo, contrasenia;
    Spinner asignaturas;
    CheckBox conocPrev;
    String[] adaptadorAsignaturas;
    Context context;
    Button registrar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_registro, container, false);
        nombre = v.findViewById(R.id.nombreReg);
        apellido = v.findViewById(R.id.apellidoReg);
        correo = v.findViewById(R.id.correoReg);
        confircorreo = v.findViewById(R.id.correoRegCongfir);
        contrasenia = v.findViewById(R.id.contrasenia);
        conocPrev = v.findViewById(R.id.conoPrevReg);
        asignaturas = v.findViewById(R.id.spinnerReg);
        registrar = v.findViewById(R.id.agregarReg);
        rellenarSpinner();
        acciones();

        return v;
    }

    private void acciones() {
        registrar.setOnClickListener(this);

    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;

    }


    private void rellenarSpinner() {
        String url = "http://192.168.1.101/school/SeleccionModulos.php";
        Volley.newRequestQueue(context).add(new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
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
        }));

    }

    private void procesarRespuesta(JSONObject response) throws JSONException {
        JSONArray array = response.getJSONArray("modulos");
        adaptadorAsignaturas = new String[array.length()];

        for (int i = 0; i < array.length(); i++) {
            JSONObject obj = (JSONObject) array.get(i);
            String nombre = obj.getString("nombre");
            adaptadorAsignaturas[i] = nombre;
        }

        ArrayAdapter<CharSequence> adaptadorSpinner = new ArrayAdapter<CharSequence>(context, android.R.layout.simple_spinner_item, adaptadorAsignaturas);
        adaptadorSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        asignaturas.setAdapter(adaptadorSpinner);
        adaptadorSpinner.notifyDataSetChanged();
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == registrar.getId()) {

            try {
                IntroducirABase();
            } catch (JSONException e) {
                e.printStackTrace();
            }


        }
    }

    private void IntroducirABase() throws JSONException{

        HashMap mapaDatos = new HashMap<>();

        mapaDatos.put("conocimientos_previos", "" + conocPrev.isChecked() + "");
        mapaDatos.put("nombre", nombre.getText().toString());
        mapaDatos.put("apellidos", apellido.getText().toString());
        mapaDatos.put("correo", correo.getText().toString());
        mapaDatos.put("contrasena", contrasenia.getText().toString());
        mapaDatos.put("id_ciclo", String.valueOf(asignaturas.getSelectedItemPosition() + 1));
        mapaDatos.put("tipo", String.valueOf(2));
        mapaDatos.put("id", "");


        JSONObject jsonObject = new JSONObject(mapaDatos);
        Log.v("test", jsonObject.toString());


        String api = "http://192.168.1.101/school/InsercionNuevo.php";

        VolleySingleton.getInstance(context).addToRequestQueue(new JsonObjectRequest(Request.Method.POST, api, jsonObject,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.v("test", response.toString());
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.v("test", error.getMessage());

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
        });



        /*Volley.newRequestQueue(context).add(new JsonObjectRequest(Request.Method.POST, api, jsonObject, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.v("test",response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.v("test",error.getMessage());
            }
        }));*/


    }


    private void comprobarCamposVacios() throws JSONException {
        //&&apellido.getText().toString().isEmpty()&&correo.getText().toString().isEmpty()
        //                &&confircorreo.getText().toString().isEmpty()&&contrasenia.getText().toString().isEmpty()&&!(asignaturas.isSelected()
        if (nombre.getText().toString().isEmpty() && correo.getText().toString().isEmpty() && confircorreo.toString().isEmpty()) {
            if (!(correo.getText().toString().equals(confircorreo.getText().toString()))) {
                Toast.makeText(context, "tienes algun campo vacio o los correos no concuerdan", Toast.LENGTH_SHORT).show();
            }

        } else {
            IntroducirABase();

        }

    }
}
