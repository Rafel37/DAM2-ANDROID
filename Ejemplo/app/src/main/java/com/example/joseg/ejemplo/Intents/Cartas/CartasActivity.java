package com.example.joseg.ejemplo.Intents.Cartas;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.example.joseg.ejemplo.R;

public class CartasActivity extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    private Button button;
    private boolean practicar;
    private CheckBox checkBox;
    private TextView copas;
    final static String TAG_KEY = "key";
    final static int COD_REQ_UNO = 1;
    final static int COD_DEV_UNO = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cartas);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        istancias();
        acciones();
    }

    public void acciones(){
        button.setOnClickListener(this);
        checkBox.setOnCheckedChangeListener(this);
    }

    private void istancias() {
        copas = findViewById(R.id.tvcopascartas);
        practicar = false;
        checkBox = findViewById(R.id.cbpracticarcartas);
        button = findViewById(R.id.bempezarcartas);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.bempezarcartas){
            Intent intent = new Intent(getApplicationContext(), JuegoActivity.class);
            startActivityForResult(intent,COD_REQ_UNO);
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (buttonView.getId() == R.id.cbpracticarcartas){
            practicar = isChecked;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        int cop = Integer.parseInt(copas.getText().toString());
        if (requestCode == COD_REQ_UNO){
            if (resultCode == COD_DEV_UNO){
                if (cop < data.getIntExtra(TAG_KEY,0) && !practicar){
                    String nota = String.valueOf(data.getIntExtra(TAG_KEY,0));
                    copas.setText(nota);
                }
            }
        }
    }
}
