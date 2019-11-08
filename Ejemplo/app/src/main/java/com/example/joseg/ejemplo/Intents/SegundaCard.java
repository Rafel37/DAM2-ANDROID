package com.example.joseg.ejemplo.Intents;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.joseg.ejemplo.Intents.Util.Juego;
import com.example.joseg.ejemplo.R;

public class SegundaCard extends AppCompatActivity {

    ImageView imageView;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_card);
        instancias();
        recuperarDatos();
    }

    private void recuperarDatos() {
        Juego j = (Juego) getIntent().getSerializableExtra("tag");
        imageView.setImageResource(j.getImagen());
        textView.setText(j.getTexto());
    }

    private void instancias() {
        imageView = findViewById(R.id.imagensegundaCard);
        textView = findViewById(R.id.textosegundacard);
    }
}
