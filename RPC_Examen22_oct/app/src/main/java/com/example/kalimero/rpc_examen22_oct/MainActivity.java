package com.example.kalimero.rpc_examen22_oct;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.kalimero.rpc_examen22_oct.Intens.SegundaActivity;
import com.example.kalimero.rpc_examen22_oct.Intens.utils.Persona;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText name, surname, number;
    RadioButton male, female;
    Button boton;

    public final static String TAG_KEY = "key";
    public final static int COD_REC = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.nombre);
        surname = findViewById(R.id.apellido);
        number = findViewById(R.id.numero);
        male = findViewById(R.id.masculino);
        female = findViewById(R.id.femenino);
        boton = findViewById(R.id.enviar);

        acciones();
    }

    @Override
    public void onClick(View v) {

        if (name.getText().toString().length() == 0 && surname.getText().toString().length() == 0 && number.getText().toString().length() == 0 ) {
            Toast.makeText(getApplicationContext(), getResources().getString(R.string.mensaje_todos), Toast.LENGTH_SHORT).show();
        }

        else {

            Intent intent = new Intent(getApplicationContext(), SegundaActivity.class);
            Persona p = new Persona(name.getText().toString());
            intent.putExtra(TAG_KEY, p);
            startActivityForResult(intent, COD_REC);
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        name.setText(savedInstanceState.getByte("nombre"));

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    private void acciones() {

        name.setOnClickListener(this);
        surname.setOnClickListener(this);
        number.setOnClickListener(this);
        male.setOnClickListener(this);
        female.setOnClickListener(this);
        boton.setOnClickListener(this);

    }

}
