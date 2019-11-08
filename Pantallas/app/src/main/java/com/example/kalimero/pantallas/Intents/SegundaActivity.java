package com.example.kalimero.pantallas.Intents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.kalimero.pantallas.Intents.utils.Persona;
import com.example.kalimero.pantallas.MainActivity;
import com.example.kalimero.pantallas.R;

public class SegundaActivity extends AppCompatActivity {

    TextView textNombre, textApellido, textTelefono;
    EditText editNota;
    Button boton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        textNombre = findViewById(R.id.textoNombre);
        textApellido = findViewById(R.id.textoApellido);
        textTelefono = findViewById(R.id.textoTelefono);
        editNota = findViewById(R.id.editNota);
        boton = findViewById(R.id.botonVolver);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra(MainActivity.TAG_KEY_DEV, editNota.getText().toString());
                finish();
            }
        });
        recuperarDatos();
    }



    private void recuperarDatos() {
        //String dato = getIntent().getStringExtra(MainActivity.TAG_KEY);
        //texto.setText(dato);
        Persona p = (Persona) getIntent().getSerializableExtra(MainActivity.TAG_KEY);
        textNombre.setText(p.getNombre());
        textApellido.setText(p.getApellido());
        textTelefono.setText(String.valueOf(p.getTelefono()));
    }
}
