package com.example.kalimero.aleatorios;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button boton;
    EditText editMaximo, editMinimo, editNumero;
    TextView textResultado;
    int numero, max, min;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boton = findViewById(R.id.botonGenerar);

        editMaximo = findViewById(R.id.editMaximo);
        editMinimo = findViewById(R.id.editMinimo);
        editNumero = findViewById(R.id.editNumero);

        textResultado = findViewById(R.id.textResultado);
        textResultado.setMovementMethod(new ScrollingMovementMethod());

        boton.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

        // NO INTRODUCE NINGUNO
        if (editMaximo.getText().toString().length() == 0
                && editMinimo.getText().toString().length() == 0
                && editNumero.getText().toString().length() == 0 ) {
            Toast.makeText(getApplicationContext(), getResources().getString(R.string.mensaje), Toast.LENGTH_SHORT).show();
        }

        //NO HAY RANGO
        else if (editMaximo.getText().toString().length() == 0
                && editMinimo.getText().toString().length() == 0) {
            Toast.makeText(getApplicationContext(), getResources().getString(R.string.mensajerango), Toast.LENGTH_SHORT).show();
        }

        //NO HAY NINGUNO
        else if (editMaximo.getText().toString().length() == 0) {
            Toast.makeText(getApplicationContext(), getResources().getString(R.string.mensajemax), Toast.LENGTH_SHORT).show();
        }
        else if (editMinimo.getText().toString().length() == 0) {
            Toast.makeText(getApplicationContext(), getResources().getString(R.string.mensajemin), Toast.LENGTH_SHORT).show();
        }
        else if (editNumero.getText().toString().length() == 0) {
            Toast.makeText(getApplicationContext(), getResources().getString(R.string.mensajenum), Toast.LENGTH_SHORT).show();
        }

        //RANGO MAL PUESTO
        else if (Integer.valueOf(String.valueOf(editMaximo.getText().toString())) < Integer.valueOf(String.valueOf(editMinimo.getText().toString()))) {
            Toast.makeText(getApplicationContext(), getResources().getString(R.string.mensajerangomal), Toast.LENGTH_SHORT).show();
        }


        //ALGORITMO FINAL
        else {
            numero = Integer.valueOf(String.valueOf(editNumero.getText().toString()));
            max = Integer.valueOf(String.valueOf(editMaximo.getText().toString()));
            min = Integer.valueOf(String.valueOf(editMinimo.getText().toString()));

            for (int i = 0 ; i < numero ; i++) {
                textResultado.append(String.valueOf((int)(Math.random() * (max - min + 1) + min)) + " ");

            }
        }
    }
}
