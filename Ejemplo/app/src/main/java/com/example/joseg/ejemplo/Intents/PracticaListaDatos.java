package com.example.joseg.ejemplo.Intents;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.joseg.ejemplo.Intents.Util.BB;
import com.example.joseg.ejemplo.R;

public class PracticaListaDatos extends AppCompatActivity {

    TextView nombre, tipo, descripcion;
    ImageView imagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practica_lista_datos);
        instancias();
        recuperarDatos();
    }

    private void recuperarDatos() {
        BB bb = (BB) getIntent().getSerializableExtra(SegundaActivity.TAG_KEY);
        nombre.setText(bb.getNombre());
        tipo.setText(bb.getTipo());
        descripcion.setText(bb.getDescripcion());
        imagen.setImageResource(bb.getImagen());
    }

    private void instancias() {
        nombre = findViewById(R.id.nombredatosBB);
        tipo = findViewById(R.id.tipodatosBB);
        descripcion = findViewById(R.id.descripciondatosBB);
        imagen = findViewById(R.id.imangendatosBB);
    }
}
