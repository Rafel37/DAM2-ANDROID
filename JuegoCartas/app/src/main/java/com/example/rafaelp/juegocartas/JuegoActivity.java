package com.example.rafaelp.juegocartas;

import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class JuegoActivity extends AppCompatActivity implements View.OnClickListener {

    TypedArray cartasArray;
    ImageView cartaImage;
    ImageButton downButon, upButon;
    int random, recuerdo, puntos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);

        cartasArray = getResources().obtainTypedArray(R.array.cartas);
        cartaImage = findViewById(R.id.carta);
        downButon = findViewById(R.id.downCard);
        upButon = findViewById(R.id.upCard);
        random = (int) (Math.random()*13);
        cartaImage.setImageResource(cartasArray.getResourceId(random, 0));
        recuerdo = random;
        puntos = 0;

        acciones();
    }

    private void acciones() {

        downButon.setOnClickListener(this);
        upButon.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {


            case R.id.downCard:
                while (random == recuerdo) {
                    random = (int) (Math.random()*13);
                }
                if (random < recuerdo) {
                    puntos++;
                    cartaImage.setImageResource(cartasArray.getResourceId(random, 0));
                    recuerdo = random;
                }
                else {
                    Intent intent = new Intent();
                    intent.putExtra("TAG", puntos);
                    setResult(1, intent);
                    finish();
                }
                break;

            case R.id.upCard:
                while (random == recuerdo) {
                    random = (int) (Math.random()*13);
                }
                if (random > recuerdo) {
                    puntos++;
                    cartaImage.setImageResource(cartasArray.getResourceId(random, 0));
                    recuerdo = random;
                }
                else {
                    Intent intent = new Intent();
                    intent.putExtra("TAG", puntos);
                    setResult(1, intent);
                    finish();
                }
                break;
        }
    }
}
