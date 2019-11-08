package com.example.rafaelp.listas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MostrarVersionActivity extends AppCompatActivity {

    ImageView imagenVersion;
    TextView nombreVersion, fechaVersion, numeroVersion, descripcionVersion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_version);

        nombreVersion = findViewById(R.id.textoNombreVersion);
        fechaVersion = findViewById(R.id.textoFechaVersion);
        numeroVersion = findViewById(R.id.textoNumeroVersion);
        descripcionVersion = findViewById(R.id.textoDescripcionVersion);
        imagenVersion = findViewById(R.id.imagenLogoVersion);

        RecuperarDatos();

    }

    public void RecuperarDatos() {
        Version version = (Version) getIntent().getSerializableExtra("TAG");
        nombreVersion.setText(version.getNombre());
        fechaVersion.setText(version.getFecha());
        numeroVersion.setText(version.getVersion());
        descripcionVersion.setText(version.getDescripcion());
        imagenVersion.setImageResource(version.getImagen());
    }
}
