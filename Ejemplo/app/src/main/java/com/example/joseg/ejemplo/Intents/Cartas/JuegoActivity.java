package com.example.joseg.ejemplo.Intents.Cartas;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.joseg.ejemplo.R;

public class JuegoActivity extends AppCompatActivity implements View.OnClickListener{

    private TypedArray cartas;
    private ImageView imagen;
    private FrameLayout frameLayout;
    Intent intent;
    private int aleatorio, rec, puntos = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        instancias();
        acciones(frameLayout);
    }

    public void acciones(ViewGroup padre){
        View elemento;
        for (int i = 0; i<padre.getChildCount();i++){
            elemento = padre.getChildAt(i);
            if (elemento instanceof ImageButton)
                elemento.setOnClickListener(this);
            if (padre.getChildAt(i) instanceof ViewGroup)
                acciones((ViewGroup) padre.getChildAt(i));
        }
    }

    private void instancias() {
        cartas = getResources().obtainTypedArray(R.array.cartas);
        frameLayout  = findViewById(R.id.Flpadrejuego);
        imagen = findViewById(R.id.carta);
        aleatorio = (int) (Math.random() * 13);
        imagen.setImageResource(cartas.getResourceId(aleatorio, 0));
        rec = aleatorio;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bjalta:
                while (aleatorio == rec){
                    aleatorio = (int) (Math.random() * 13);
                }
                if (aleatorio > rec){
                    puntos++;
                    imagen.setImageResource(cartas.getResourceId(aleatorio, 0));
                    rec = aleatorio;
                }
                else {
                    intent = new Intent();
                    intent.putExtra(CartasActivity.TAG_KEY,puntos);
                    setResult(CartasActivity.COD_DEV_UNO,intent);
                    finish();
                }
                break;
            case R.id.bjbaja:
                while (aleatorio == rec){
                    aleatorio = (int) (Math.random() * 13);
                }
                if (aleatorio < rec){
                    puntos++;
                    imagen.setImageResource(cartas.getResourceId(aleatorio, 0));
                    rec = aleatorio;
                }
                else {
                    intent = new Intent();
                    intent.putExtra(CartasActivity.TAG_KEY,puntos);
                    setResult(CartasActivity.COD_DEV_UNO,intent);
                    finish();
                }
                break;
        }
    }
}
