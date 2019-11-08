package com.example.kalimero.pantallas;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kalimero.pantallas.Intents.SegundaActivity;
import com.example.kalimero.pantallas.Intents.utils.Persona;

public class MainActivity extends AppCompatActivity {

    Button boton;
    EditText editNombre, editApellido, editTelefono;
    TextView textNota;

    public final static String TAG_KEY = "key";
    public final static String TAG_KEY_DEV = "key_dev";
    public final static int COD_REC_UNO = 1;
    public final static int COD_DEV_UNO = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boton = findViewById(R.id.botonArrancar);
        editNombre = findViewById(R.id.editNombre);
        editApellido = findViewById(R.id.editApellido);
        editTelefono = findViewById(R.id.editTelefono);
        textNota = findViewById(R.id.textNota);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //ACCION DE PULSAR

                //FALTAN TODOS
                if (editNombre.getText().toString().length() == 0 &&
                        editApellido.getText().toString().length() == 0 &&
                        editTelefono.getText().toString().length() == 0 ) {

                    Toast.makeText(getApplicationContext(), getResources().getString(R.string.mensaje), Toast.LENGTH_SHORT).show();
                }

                //FALTAN 2
                else if (editNombre.getText().toString().length() == 0 &&
                        editApellido.getText().toString().length() == 0) {

                    Toast.makeText(getApplicationContext(), getResources().getString(R.string.mensajeNombreApellido), Toast.LENGTH_SHORT).show();
                }
                else if (editNombre.getText().toString().length() == 0 &&
                        editTelefono.getText().toString().length() == 0) {

                    Toast.makeText(getApplicationContext(), getResources().getString(R.string.mensajeNombreTelefono), Toast.LENGTH_SHORT).show();
                }
                else if (editApellido.getText().toString().length() == 0 &&
                        editTelefono.getText().toString().length() == 0) {

                    Toast.makeText(getApplicationContext(), getResources().getString(R.string.mensajeApellidoTelefono), Toast.LENGTH_SHORT).show();
                }

                //FALTA 1
                else if (editNombre.getText().toString().length() == 0) {

                    Toast.makeText(getApplicationContext(), getResources().getString(R.string.mensajeNombre), Toast.LENGTH_SHORT).show();
                }
                else if (editApellido.getText().toString().length() == 0) {

                    Toast.makeText(getApplicationContext(), getResources().getString(R.string.mensajeApellido), Toast.LENGTH_SHORT).show();
                }
                else if (editTelefono.getText().toString().length() == 0) {

                    Toast.makeText(getApplicationContext(), getResources().getString(R.string.mensajeTelefono), Toast.LENGTH_SHORT).show();
                }

                //NO FALTA NINGUNO
                else {
                    Intent intent = new Intent(getApplicationContext(), SegundaActivity.class);
                    Persona p = new Persona(editNombre.getText().toString(),editApellido.getText().toString(),Integer.valueOf(editTelefono.getText().toString()));
                    intent.putExtra(TAG_KEY, p);
                    //startActivity(intent);
                    startActivityForResult(intent, COD_REC_UNO);
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == COD_REC_UNO) {
            if (requestCode == COD_DEV_UNO) {
                if (data != null) {
                    textNota.setText(data.getStringExtra(TAG_KEY_DEV));
                }
            }
        }
    }

    //METODO PARA RECUPERAR LOS DATOS PREVIAMENTE GUARDADOS, LO MISMO QUE EL BUNDLE DEL onCreate()
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        editNombre.setText(savedInstanceState.getByte("dato1"));
        editApellido.setText(savedInstanceState.getByte("dato2"));
        editTelefono.setText(savedInstanceState.getByte("dato3"));
    }

    //METODO PARA GUARDAR LOS DATOS CUANDO UNA ACTIVIDAD SE PAUSA
    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        outState.putString("dato1", editNombre.getText().toString());
        outState.putString("dato2", editApellido.getText().toString());
        outState.putString("dato3", editTelefono.getText().toString());
    }
}
