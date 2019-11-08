package com.example.joseg.practica_final_tri1;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.example.joseg.practica_final_tri1.Dialogos.DialogResultado;
import com.example.joseg.practica_final_tri1.Dialogos.DialogoSpinner;
import com.example.joseg.practica_final_tri1.Utils.DataSet;
import com.example.joseg.practica_final_tri1.Utils.Dificultad;
import com.example.joseg.practica_final_tri1.Utils.Jugador;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class Pantalla_Principal extends AppCompatActivity implements View.OnClickListener, DialogoSpinner.OnDialogoSpinnerListener , DialogResultado.OnDialogoResultadoListener {

    LinearLayout jugar, puntuaciones;
    final static String TAG_KEY = "key";
    final static String TAG_KEY2 = "key2";
    final static String TAG_KEY_DEV = "key_dev";
    final static String TAG_KEY_DEV2 = "key_dev2";
    final static int COD_REQ_UNO = 1;
    final static int COD_DEV_UNO = 1;
    int puntos;
    private ArrayList<Jugador> listaJ;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla__principal);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        instancias();
        acciones();
    }

    private void acciones() {
        jugar.setOnClickListener(this);
        puntuaciones.setOnClickListener(this);
    }

    private void instancias() {
        leerFicheros();
        jugar = findViewById(R.id.botonplay);
        puntuaciones = findViewById(R.id.botonrecords);
        if (listaJ == null)
            listaJ = new ArrayList<>();
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.botonplay:
                DialogoSpinner ds = new DialogoSpinner();
                ds.show(getSupportFragmentManager(),"Spinner");
                break;
            case R.id.botonrecords:
                intent = new Intent(getApplicationContext(),Pantalla_Puntuaciones.class);
                intent.putExtra(TAG_KEY2,listaJ);
                startActivity(intent);
                break;

        }

    }

    @Override
    public void onDificultadSeleccionada(Dificultad d) {

        intent = new Intent(getApplicationContext(),Pantalla_Juego.class);
        intent.putExtra(TAG_KEY, d);
        startActivityForResult(intent,COD_REQ_UNO);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == COD_REQ_UNO){
            if (resultCode == COD_DEV_UNO){
                if (data!=null){

                    puntos = data.getIntExtra(TAG_KEY_DEV, 0);
                    String ganado = data.getStringExtra(TAG_KEY_DEV2);

                    DialogResultado dr = DialogResultado.newInstance(ganado);
                    dr.show(getSupportFragmentManager(),"Resultado");

                }
            }
        }
    }

    private void guardarFicheros() {
        try {
            FileOutputStream fos = openFileOutput("jugadores.obj", Context.MODE_PRIVATE);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(listaJ);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void leerFicheros() {
        try {
            FileInputStream fis = openFileInput("jugadores.obj");
            ObjectInputStream ois = new ObjectInputStream(fis);
            listaJ = (ArrayList<Jugador>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        guardarFicheros();
    }

    @Override
    public void onNombreIngresed(String nombre) {

        @SuppressLint("Recycle") TypedArray iconos = getResources().obtainTypedArray(R.array.todas);

        int aleatorio = (int) (Math.random() * 100);

        listaJ.add(new Jugador(nombre,puntos,iconos.getResourceId(aleatorio,0)));

    }
}
