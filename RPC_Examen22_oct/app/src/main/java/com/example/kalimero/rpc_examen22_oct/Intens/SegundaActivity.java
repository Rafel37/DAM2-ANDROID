package com.example.kalimero.rpc_examen22_oct.Intens;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.kalimero.rpc_examen22_oct.R;

public class SegundaActivity extends AppCompatActivity {

    TextView name2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        name2 = findViewById(R.id.nombre2);
    }


}
