package com.example.joseg.ejemplo.Intents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.joseg.ejemplo.MenuActivity;
import com.example.joseg.ejemplo.R;

public class EAEjemplo extends AppCompatActivity {

    Button b1 , b2;
    EditText editText1 ,editText2;
    TextView textView;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eaejemplo);
        instancias();
        acciones();
    }

    private void acciones() {

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Log.v("milog",editText.getText().toString());

                if (editText1.getText().toString().length()==0 || editText2.getText().toString().length()==0)
                    Toast.makeText(getApplicationContext(),getResources().getString(R.string.mensaje1),Toast.LENGTH_SHORT).show();
                else {
                    int n1 = Integer.parseInt(editText1.getText().toString()),n2 = Integer.parseInt(editText2.getText().toString());
                    //Toast.makeText(getApplicationContext(), "El resultado de la suma es: " + (n1 + n2), Toast.LENGTH_SHORT).show();
                    textView.setText("El resultado es: "+(n1 + n2));
                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(),MenuActivity.class);

                startActivity(intent);
            }
        });

    }

    private void instancias() {

        b1 = findViewById(R.id.boton);
        b2 = findViewById(R.id.botonmenu0);
        editText1 = findViewById(R.id.edit1);
        editText2 = findViewById(R.id.edit2);
        textView = findViewById(R.id.texto);

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v("estados","Pasado a modo onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.v("estados","Pasado a modo onRestart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v("estados","Pasado a modo onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v("estados","Pasado a modo onDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v("estados","Pasado a modo onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v("estados","Pasado a modo onResume");
    }
}
