package com.example.joseg.ejemplo.Intents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.joseg.ejemplo.Intents.Util.Persona;
import com.example.joseg.ejemplo.R;

public class TerceraActivity extends AppCompatActivity {

    Button boton;
    TextView texto, texto1, texto2;
    EditText et;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tercera);
        boton = findViewById(R.id.botonArrancar2);
        et = findViewById(R.id.editnota);
        texto = findViewById(R.id.textonombre);
        texto1 = findViewById(R.id.textoapellidos);
        texto2 = findViewById(R.id.textotelefono);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent();
                intent.putExtra(SegundaActivity.TAG_KEY_DEV,et.getText().toString());
                setResult(SegundaActivity.COD_DEV_UNO,intent);
                finish();
            }
        });
        recuperarDatos();
    }

    private void recuperarDatos() {
        //texto.setText(getIntent().getStringExtra(SegundaActivity.TAG_KEY));
        Persona p = (Persona) getIntent().getSerializableExtra(SegundaActivity.TAG_KEY);
        texto.setText(p.getNombre());
        texto1.setText(p.getApellido());
        texto2.setText(String.valueOf(p.getTelefono()));
    }
}