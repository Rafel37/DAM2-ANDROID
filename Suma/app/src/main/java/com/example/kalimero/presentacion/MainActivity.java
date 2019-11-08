package com.example.kalimero.presentacion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    // AQUI METEMOS LAS VARIABLES

    Button b1;
    TextView textView;
    EditText editText1, editText2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        acciones();
        Log.v("estados", "Pasado a onCreate()");
    }


    // ----------------------------------------------------------------------------
    // A PARTIR DE AQUI SE INSTANCIAN LOS ELEMENTOS (no antes del setContentView)
    // ----------------------------------------------------------------------------

    private void acciones() {
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (editText1.getText().toString().length() == 0 && editText2.getText().toString().length() == 0) {
                    Toast.makeText(getApplicationContext(), getResources().getString(R.string.mensaje), Toast.LENGTH_SHORT).show();
                } else if (editText1.getText().toString().length() == 0) {
                    Toast.makeText(getApplicationContext(), getResources().getString(R.string.mensaje1), Toast.LENGTH_SHORT).show();

                } else if (editText2.getText().toString().length() == 0) {
                    Toast.makeText(getApplicationContext(), getResources().getString(R.string.mensaje2), Toast.LENGTH_SHORT).show();

                } else {
                    int num1 = Integer.parseInt(editText1.getText().toString());
                    int num2 = Integer.parseInt(editText2.getText().toString());
                    int sum = (num1 + num2);
                    String suma = Integer.toString(sum);
                    Toast.makeText(getApplicationContext(), suma, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void instancias() {

        b1 = findViewById(R.id.boton);

        editText1 = findViewById(R.id.numero1);
        editText2 = findViewById(R.id.numero2);
        textView = findViewById(R.id.texto);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v("estados", "Pasado a onStart()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.v("estados", "Pasado a onRestart()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v("estados", "Pasado a onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v("estados", "Pasado a onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v("estados", "Pasado a onDestroy()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v("estados", "Pasado a onResume()");
    }
}
