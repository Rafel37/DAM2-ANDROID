package com.example.rafaelp.memorygame;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

import com.example.rafaelp.memorygame.dialogo.SpinnerDialogo;
import com.example.rafaelp.memorygame.utils.Peliculas;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, SpinnerDialogo.Pantalla {

    Button bJugar, bRecord;
    final static String TAG_INFO = "TAG_INFO";
    final static String TAG_KEY_DEV = "key_dev";
    final static String TAG_KEY_DEV2 = "key_dev2";
    final static int COD_REQ_UNO = 1;
    Intent intentplay;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instacias();
        acciones();
    }

    private void acciones() {
        bJugar.setOnClickListener(this);

    }


    private void instacias() {
        bJugar = findViewById(R.id.buttonPlay);
        bRecord = findViewById(R.id.buttonRecord);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.buttonPlay:
                SpinnerDialogo dialogoSpinner = new SpinnerDialogo();
                dialogoSpinner.show(getSupportFragmentManager(),"dificultadSpinner");
                break;

            case R.id.buttonRecord:
                break;
        }
    }

    @Override
    public void pasarDificultad(Peliculas peliculas) {
        intentplay = new Intent(getApplicationContext(), TableroActivity.class);
        intentplay.putExtra(TAG_INFO, peliculas);
        startActivityForResult(intentplay, COD_REQ_UNO);
    }
}