package com.example.joseg.tema3.EjerciciosClase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import com.example.joseg.tema3.EjerciciosClase.Utils.Usuario;
import com.example.joseg.tema3.R;

public class UsuarioLogueado extends AppCompatActivity {

    TextView nombre, apellido, edad, correo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario_logueado);
        instancias();
        recuperarDatos();
    }

    private void instancias() {
        nombre = findViewById(R.id.outputNombreLR);
        apellido = findViewById(R.id.outputApellidoLR);
        edad = findViewById(R.id.outputEdadLR);
        correo = findViewById(R.id.outputCorreoLR);
    }

    private void recuperarDatos() {
        Usuario u = (Usuario) getIntent().getSerializableExtra("usuario");
        nombre.setText(u.getNombre());
        apellido.setText(u.getApellido());
        correo.setText(u.getCorreo());
        edad.setText(String.valueOf(u.getEdad()));
    }
}