package com.example.root.rpc_dialogos_11_12_18;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.root.rpc_dialogos_11_12_18.dialogos.DialogoNombre;
import com.example.root.rpc_dialogos_11_12_18.dialogos.DialogoSiNo;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, DialogoSiNo.onDialogSINOListener{

    Button button;
    String opcion;

    final static String TAG_SINO = "sino";
    final static String TAG_NOMBRE = "nombre";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.botonEmpezar);
        button.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
            DialogoSiNo dialogoSiNo = new DialogoSiNo();
            dialogoSiNo.show(getSupportFragmentManager(), TAG_SINO);
    }

    @Override
    public void onDialogSiSelected(String s) {
            DialogoNombre dialogoNombre = new DialogoNombre();
            dialogoNombre.show(getSupportFragmentManager(), TAG_NOMBRE);
    }


}
