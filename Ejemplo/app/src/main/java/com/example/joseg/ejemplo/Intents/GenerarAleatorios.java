package com.example.joseg.ejemplo.Intents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.joseg.ejemplo.MenuActivity;
import com.example.joseg.ejemplo.R;

public class GenerarAleatorios extends AppCompatActivity {

    TextView tv;
    EditText et0, et1, et2;
    Button b0, b1;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aleatorios);
        instancias();
        acciones();
    }

    private void acciones() {


            b0.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (et0.getText().toString().isEmpty() && et1.getText().toString().isEmpty() && et2.getText().toString().isEmpty()){
                        Toast.makeText(getApplicationContext(),getResources().getString(R.string.mensaje),Toast.LENGTH_SHORT).show();
                    }
                    else if (et0.getText().toString().isEmpty() || et1.getText().toString().isEmpty() || et2.getText().toString().isEmpty()){
                        Toast.makeText(getApplicationContext(),getResources().getString(R.string.mensaje2),Toast.LENGTH_SHORT).show();
                    }
                    else {
                        tv.setText(generar(Integer.valueOf(et0.getText().toString()), Integer.valueOf(et1.getText().toString()), Integer.valueOf(et2.getText().toString())));
                    }
                }
            });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(),MenuActivity.class);

                startActivity(intent);
            }
        });
    }

    private void instancias() {

        tv = findViewById(R.id.resram);
        et0 = findViewById(R.id.minram);
        et1 = findViewById(R.id.maxram);
        et2 = findViewById(R.id.nram);
        b0 = findViewById(R.id.genram);
        b1 = findViewById(R.id.botonmenu2);

    }

    private String generar(int min, int max, int lon){
        String numeros = "";
        int numero;

        if (min > max){
            numero = min;
            min = max;
            et0.setText(String.valueOf(min));
            max = numero;
            et1.setText(String.valueOf(max));
            Toast.makeText(getApplicationContext(),getResources().getString(R.string.mensaje3),Toast.LENGTH_SHORT).show();
        }

        for (int i = 0; i < lon; i++){
            numero = (int)Math.floor(Math.random()*(max-min+1)+min);
            if (i == lon-1)
                numeros += numero;
            else
                numeros += numero+", ";
        }
        return numeros;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("random",tv.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        tv.setText(savedInstanceState.getString("random"));
    }
}
