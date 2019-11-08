package com.example.juan.examenjcique4;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

public class SecondActivity extends AppCompatActivity {

    boolean aprobado;
    ImageView imagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        imagen = findViewById(R.id.resultado);
        aprobado = getIntent().getBooleanExtra(MainActivity.TAG_KEY, true);
        if (aprobado) {
            imagen.setImageResource(R.drawable.aprobado);
        }else
            imagen.setImageResource(R.drawable.suspenso);
    }
}