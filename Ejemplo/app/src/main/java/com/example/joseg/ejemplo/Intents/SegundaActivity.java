package com.example.joseg.ejemplo.Intents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.joseg.ejemplo.Intents.Util.Persona;
import com.example.joseg.ejemplo.MenuActivity;
import com.example.joseg.ejemplo.R;

public class SegundaActivity extends AppCompatActivity {

    Button boton, boton2;
    final static String TAG_KEY = "key";
    final static String TAG_KEY_DEV = "key_dev";
    final static int COD_REQ_UNO = 1;
    final static int COD_DEV_UNO = 1;
    EditText et, et1, et2;
    TextView tv;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);
        boton = findViewById(R.id.botonArrancar);
        boton2 = findViewById(R.id.botonmenu1);
        tv = findViewById(R.id.viewnota);
        et = findViewById(R.id.nombre);
        et1 = findViewById(R.id.apellido);
        et2 = findViewById(R.id.telefono);

        /*if (savedInstanceState!=null){
            et.setText(savedInstanceState.getString("dato1"));
            et1.setText(savedInstanceState.getString("dato2"));
            et2.setText(savedInstanceState.getString("dato3"));
        }*/

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (et.getText().toString().isEmpty() && et1.getText().toString().isEmpty() && et2.getText().toString().isEmpty())
                    Toast.makeText(getApplicationContext(),getResources().getString(R.string.mensaje),Toast.LENGTH_SHORT).show();
                else if (et.getText().toString().isEmpty() || et1.getText().toString().isEmpty() || et2.getText().toString().isEmpty())
                    Toast.makeText(getApplicationContext(),getResources().getString(R.string.mensaje2),Toast.LENGTH_SHORT).show();
                else {
                    Persona p = new Persona(et.getText().toString(),et1.getText().toString(),Integer.valueOf(et2.getText().toString()));
                    intent = new Intent(getApplicationContext(), TerceraActivity.class);
                    intent.putExtra(TAG_KEY, p);
                    startActivityForResult(intent,COD_REQ_UNO);
                    startActivity(intent);
                }
            }
        });
        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(),MenuActivity.class);

                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == COD_REQ_UNO){
            if (resultCode == COD_DEV_UNO){
                if (data!=null){
                    String nota = data.getStringExtra(TAG_KEY_DEV);
                    tv.setText("Nota: "+nota);
                }
            }
        }
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        et.setText(savedInstanceState.getString("dato1"));
        et1.setText(savedInstanceState.getString("dato2"));
        et2.setText(savedInstanceState.getString("dato3"));
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("dato1",et.getText().toString());
        outState.putString("dato2",et1.getText().toString());
        outState.putString("dato3",et2.getText().toString());
    }
}