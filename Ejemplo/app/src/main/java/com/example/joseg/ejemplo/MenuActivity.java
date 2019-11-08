package com.example.joseg.ejemplo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.joseg.ejemplo.Elementos.ElementosavActivity;
import com.example.joseg.ejemplo.Intents.Cartas.CartasActivity;
import com.example.joseg.ejemplo.Intents.EjemploRecycler;
import com.example.joseg.ejemplo.Intents.GenerarAleatorios;
import com.example.joseg.ejemplo.Intents.EAEjemplo;
import com.example.joseg.ejemplo.Intents.ListaActivity;
import com.example.joseg.ejemplo.Intents.MenuPractica;
import com.example.joseg.ejemplo.Intents.PracticaLista;
import com.example.joseg.ejemplo.Intents.SegundaActivity;
import com.example.joseg.ejemplo.Intents.Calculadora;
import com.example.joseg.ejemplo.Intents.PrimosActivity;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener{

    LinearLayout linearLayout;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        instancias();
        acciones(linearLayout);
    }

    private void instancias() {
        linearLayout = findViewById(R.id.Llpadremenuprincipal);
    }

    public void acciones(ViewGroup padre){
        View elemento;
        for (int i = 0; i<padre.getChildCount();i++){
            elemento = padre.getChildAt(i);
            if (elemento != null && elemento.isClickable())
                elemento.setOnClickListener(this);
            if (padre.getChildAt(i) instanceof ViewGroup)
                acciones((ViewGroup) padre.getChildAt(i));
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ircalcular:
                intent = new Intent(getApplicationContext(),EAEjemplo.class);
                startActivity(intent);
                break;
            case R.id.irformulario:
                intent = new Intent(getApplicationContext(),SegundaActivity.class);
                startActivity(intent);
                break;
            case R.id.irgenerador:
                intent = new Intent(getApplicationContext(),GenerarAleatorios.class);
                startActivity(intent);
                break;
            case R.id.ircalculadora:
                intent = new Intent(getApplicationContext(),Calculadora.class);
                startActivity(intent);
                break;
            case R.id.irprimos:
                intent = new Intent(getApplicationContext(),PrimosActivity.class);
                startActivity(intent);
                break;
            case R.id.ircartas:
                intent = new Intent(getApplicationContext(),CartasActivity.class);
                startActivity(intent);
                break;
            case R.id.irElementosav:
                intent = new Intent(getApplicationContext(),ElementosavActivity.class);
                startActivity(intent);
                break;
            case R.id.irLista:
                intent = new Intent(getApplicationContext(),ListaActivity.class);
                startActivity(intent);
                break;
            case R.id.irMenuPractica:
                intent = new Intent(getApplicationContext(),MenuPractica.class);
                startActivity(intent);
                break;
            case R.id.irEjemploRecycler:
                intent = new Intent(getApplicationContext(),EjemploRecycler.class);
                startActivity(intent);
                break;
        }
    }
}
