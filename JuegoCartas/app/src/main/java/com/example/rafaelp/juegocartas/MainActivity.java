package com.example.rafaelp.juegocartas;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    Button empezarButon;
    CheckBox practicarCheck;
    TextView copasText;
    Boolean verificar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        empezarButon = findViewById(R.id.empezarButon);
        practicarCheck = findViewById(R.id.practicarCheck);
        copasText = findViewById(R.id.copasText);
        verificar = false;

        acciones();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        int puntos = Integer.parseInt(copasText.getText().toString());

        if (requestCode == 1) {
            if (resultCode == 1) {
                if (puntos < data.getIntExtra("TAG", 0) && !verificar) {
                    copasText.setText(String.valueOf(data.getIntExtra("TAG", 0)));
                }

            }
        }
    }

    @Override
    public void onClick(View v) {

        Intent intent = new Intent(getApplicationContext(), JuegoActivity.class);
        startActivityForResult(intent, 1);
    }

    private void acciones() {
        empezarButon.setOnClickListener(this);
        practicarCheck.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

        verificar = isChecked;//guardar el estado del checkBox fuera del listener
    }
}
