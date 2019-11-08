package com.example.rafaelp.memorygame;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.rafaelp.memorygame.utils.Peliculas;

import java.util.ArrayList;
import java.util.Collections;

public class TableroActivity extends AppCompatActivity implements View.OnClickListener {

    GridLayout gridLayout;
    int decremento, reveladas, elementos, ancho, alto, restante;

    TextView tiempo, puntos;
    LinearLayout linearLayout;
    ProgressBar progress;
    CountDownTimer countDownTimer;
    long tiempoRes;
    boolean comparar;
    TypedArray cartas;

    ImageView primer ,segun;
    boolean comprobar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tablero);

        instancias();
        rellenar();
        countDownTimer.start();

    }

    private void rellenar(){

        elementos = 0;
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x - (int)Math.floor(size.x*0.4);
        int height = size.y - (int)Math.floor(size.y*0.15);

        switch (((Peliculas) getIntent().getSerializableExtra(MainActivity.TAG_INFO)).getNombre()){

            case "Aficionado":
                elementos = 8;
                cartas = getResources().obtainTypedArray(R.array.principiante);
                gridLayout.setColumnCount(4);
                crearTimer(20000);
                ancho = width / 4;
                alto = height / 2;
                progress.setMax(2000);
                progress.setProgress(2000);
                decremento = 1;
                break;

            case "Principiante":
                elementos = 12;
                cartas = getResources().obtainTypedArray(R.array.aficionado);
                gridLayout.setColumnCount(4);
                crearTimer(30000);
                ancho = width / 4;
                alto = height / 3;
                progress.setMax(3000);
                progress.setProgress(3000);
                decremento = 2;
                break;

            case "Cinefilo":
                elementos = 16;
                cartas = getResources().obtainTypedArray(R.array.cinefilo);
                gridLayout.setColumnCount(4);
                crearTimer(40000);
                ancho = width / 4;
                alto = height / 4;
                progress.setMax(4000);
                progress.setProgress(4000);
                decremento = 3;
                break;

            case "Director":
                elementos = 20;
                cartas = getResources().obtainTypedArray(R.array.director);
                gridLayout.setColumnCount(5);
                crearTimer(60000);
                ancho = width / 5;
                alto = height / 4;
                progress.setMax(6000);
                progress.setProgress(6000);
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
        progress = findViewById(R.id.barra);
        gridLayout = findViewById(R.id.cartas);
        puntos = findViewById(R.id.puntuacion);
        reveladas = 0;
        linearLayout = findViewById(R.id.tablero);
        comparar = false;
        restante = 0;
    }

    @Override
    public void onClick(final View v) {
        if (primer == null) {
            primer = (ImageView) v;
            primer.setImageResource(0);
            primer.setOnClickListener(null);
            comprobar = true;
        } else{

            if (comprobar) {

                comprobar = false;

                if (primer.getBackground().getConstantState() == v.getBackground().getConstantState()) {
                    puntos.setText(String.valueOf(Integer.parseInt(puntos.getText().toString()) + 3));
                    v.setOnClickListener(null);
                    ((ImageView) v).setImageResource(0);
                    reveladas += 2;
                    primer = null;
                } else {

                    segun = (ImageView) v;
                    segun.setImageResource(0);

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            segun.setImageResource(R.drawable.trasera_carta);
                            primer.setImageResource(R.drawable.trasera_carta);
                            puntos.setText(String.valueOf(Integer.parseInt(puntos.getText().toString()) - decremento));
                            segun = null;
                            primer = null;
                        }
                    }, 1000);
                    primer.setOnClickListener(this);

                }
            }
        }
        if (reveladas == elementos){

            Intent intent = new Intent();
            intent.putExtra(MainActivity.TAG_KEY_DEV,Integer.parseInt(puntos.getText().toString())+restante);
            if (Integer.parseInt(puntos.getText().toString())>0)
                intent.putExtra(MainActivity.TAG_KEY_DEV2,"g");
            else intent.putExtra(MainActivity.TAG_KEY_DEV2,"e");
            setResult(1,intent);
            finish();

        }
    }

    public void crearTimer(long rest) {
        countDownTimer = new CountDownTimer(rest, 100) {
            @Override
            public void onTick(long millisUntilFinished) {
                tiempoRes = millisUntilFinished;
                progress.setProgress(progress.getProgress() - 10);
                traducirMilisegundos(millisUntilFinished);
            }

            @Override
            public void onFinish() {
                Intent intent = new Intent();
                intent.putExtra(MainActivity.TAG_KEY_DEV2,"p");
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