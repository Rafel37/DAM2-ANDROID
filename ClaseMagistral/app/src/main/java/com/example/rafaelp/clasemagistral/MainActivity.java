package com.example.rafaelp.clasemagistral;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button boton1, boton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boton1 = findViewById(R.id.boton1);
        boton1.setText("recycler");
        boton2 = findViewById(R.id.boton2);
        boton2.setText("spinner");

        acciones();
    }

    private void acciones() {
        boton1.setOnClickListener(this);
        boton2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.boton1:
                Intent intent1 = new Intent(this, Main2Activity.class);
                startActivity(intent1);
                finish();
                break;
            case R.id.boton2:
                Intent intent2 = new Intent(this, Main3Activity.class);
                startActivity(intent2);
                finish();
                break;
        }
    }
}
