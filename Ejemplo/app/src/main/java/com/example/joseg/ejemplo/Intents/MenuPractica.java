package com.example.joseg.ejemplo.Intents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.joseg.ejemplo.R;

public class MenuPractica extends AppCompatActivity implements View.OnClickListener{

    private LinearLayout linearLayout;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_practica);
        instancias();
        acciones(linearLayout);
    }

    private void instancias() {
        linearLayout = findViewById(R.id.Llmenupractica);
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
            case R.id.irPracticaLista:
                intent = new Intent(getApplicationContext(),PracticaLista.class);
                startActivity(intent);
                break;
            case R.id.irPracticaRecycler:
                intent = new Intent(getApplicationContext(),PracticaRecycler.class);
                startActivity(intent);
                break;
        }
    }
}

