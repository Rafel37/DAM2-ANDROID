package com.example.joseg.practica_final_tri1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.joseg.practica_final_tri1.Utils.Dificultad;

import java.util.ArrayList;
import java.util.Collections;

public class Pantalla_Juego extends AppCompatActivity implements View.OnClickListener {

    TextView tiempo, puntos;
    LinearLayout padre;
    ProgressBar progreso;
    CountDownTimer reloj;
    long tiempoRes;
    GridLayout gridLayout;
    ImageView uno ,dos;
    int decremento, reveladas, elementos, ancho, alto, restante;
    boolean com;
    private TypedArray cartas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla__juego);

        instancias();
        rellenar();
        reloj.start();

    }

    private void rellenar(){

        elementos = 0;
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x - (int)Math.floor(size.x*0.4);
        int height = size.y - (int)Math.floor(size.y*0.15);

        switch (((Dificultad) getIntent().getSerializableExtra(Pantalla_Principal.TAG_KEY)).getNombre()){

            case "Aficionado":
                elementos = 8;
                cartas = getResources().obtainTypedArray(R.array.d1);
                gridLayout.setColumnCount(4);
                crearTimer(20000);
                ancho = width / 4;
                alto = height / 2;
                progreso.setMax(2000);
                progreso.setProgress(2000);
                decremento = 1;
                break;
            case "Principiante":
                elementos = 12;
                cartas = getResources().obtainTypedArray(R.array.d2);
                gridLayout.setColumnCount(4);
                crearTimer(30000);
                ancho = width / 4;
                alto = height / 3;
                progreso.setMax(3000);
                progreso.setProgress(3000);
                decremento = 2;
                break;
            case "Cinefilo":
                elementos = 16;
                cartas = getResources().obtainTypedArray(R.array.d3);
                gridLayout.setColumnCount(4);
                crearTimer(40000);
                ancho = width / 4;
                alto = height / 4;
                progreso.setMax(4000);
                progreso.setProgress(4000);
                decremento = 3;
                break;
            case "Director":
                elementos = 20;
                cartas = getResources().obtainTypedArray(R.array.d4);
                gridLayout.setColumnCount(5);
                crearTimer(60000);
                ancho = width / 5;
                alto = height / 4;
                progreso.setMax(6000);
                progreso.setProgress(6000);
                decremento = 4;
                break;
        }

        ArrayList<Integer> fullcards = new ArrayList<>();

        for (int i = 0; i<2;i++){
            for (int t = 0; t<elementos/2;t++){
                fullcards.add(cartas.getResourceId(t, R.drawable.pelicula_01));
            }
        }

        Collections.shuffle(fullcards);

        for (int i = 0; i<elementos;i++) {
            GridLayout.LayoutParams params = new GridLayout.LayoutParams();
            ImageView imageView = new ImageView(getApplicationContext());
            imageView.setImageResource(R.drawable.trasera_carta);
            imageView.setOnClickListener(this);
            imageView.setBackgroundResource(fullcards.get(i));
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            params.width = ancho;
            params.height = alto;
            imageView.setLayoutParams(params);
            gridLayout.addView(imageView);

        }
    }

    private void instancias() {
        tiempo = findViewById(R.id.tiempo);
        progreso = findViewById(R.id.progreso);
        gridLayout = findViewById(R.id.cartas);
        puntos = findViewById(R.id.puntuacion);
        reveladas = 0;
        padre = findViewById(R.id.contenedor);
        com = false;
        restante = 0;
    }

    @Override
    public void onClick(final View v) {
        if (uno == null) {
            uno = (ImageView) v;
            uno.setImageResource(0);
            uno.setOnClickListener(null);
            com = true;
        } else{

            if (com) {

                com = false;

                if (uno.getBackground().getConstantState() == v.getBackground().getConstantState()) {
                    puntos.setText(String.valueOf(Integer.parseInt(puntos.getText().toString()) + 3));
                    v.setOnClickListener(null);
                    ((ImageView) v).setImageResource(0);
                    reveladas += 2;
                    uno = null;
                } else {

                    dos = (ImageView) v;
                    dos.setImageResource(0);

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            dos.setImageResource(R.drawable.trasera_carta);
                            uno.setImageResource(R.drawable.trasera_carta);
                            puntos.setText(String.valueOf(Integer.parseInt(puntos.getText().toString()) - decremento));
                            dos = null;
                            uno = null;
                        }
                    }, 1000);
                    uno.setOnClickListener(this);

                }
            }
        }
        if (reveladas == elementos){

            Intent intent = new Intent();
            intent.putExtra(Pantalla_Principal.TAG_KEY_DEV,Integer.parseInt(puntos.getText().toString())+restante);
            if (Integer.parseInt(puntos.getText().toString())>0)
            intent.putExtra(Pantalla_Principal.TAG_KEY_DEV2,"g");
            else intent.putExtra(Pantalla_Principal.TAG_KEY_DEV2,"e");
            setResult(1,intent);
            finish();

        }
    }

    public void crearTimer(long rest) {
        reloj = new CountDownTimer(rest, 100) {
            @Override
            public void onTick(long millisUntilFinished) {
                tiempoRes = millisUntilFinished;
                progreso.setProgress(progreso.getProgress() - 10);
                traducirMilisegundos(millisUntilFinished);
            }

            @Override
            public void onFinish() {

                Intent intent = new Intent();
                intent.putExtra(Pantalla_Principal.TAG_KEY_DEV2,"p");
                setResult(1,intent);
                finish();

            }
        };

    }

    @SuppressLint("DefaultLocale")
    public void traducirMilisegundos(long milis) {

        int minutos = (int) ((milis / 1000) / 60);
        int segundos = (int) ((milis / 1000) % 60);
        tiempo.setText(String.format("%02d:%02d", minutos, segundos));
        restante = (int) milis / 1000;
    }

}
