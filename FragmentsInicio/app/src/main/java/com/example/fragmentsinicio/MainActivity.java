package com.example.fragmentsinicio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button bEstatico, bDinamico;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bEstatico = findViewById(R.id.estatico);
        bEstatico.setOnClickListener(this);
        bDinamico = findViewById(R.id.dinamico);
        bDinamico.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        Intent intent = null;
        switch (v.getId()){
            case R.id.estatico:
                intent = new Intent(getApplicationContext(), Estatico.class);
                break;
            case R.id.dinamico:
                intent = new Intent(getApplicationContext(), Dinamico.class);
                break;
        }
        startActivity(intent);
    }
}
