package com.example.javier.dialogo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.javier.dialogo.R;
import com.example.javier.dialogo.dialogos.DialogoConfirmacion;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,DialogoConfirmacion.OnDialogoConfirmacionListener{
    Button bDialogoConfirmar;
    TextView textoConfirmar;
    final static String TAG_DCONFIR="confirmacion";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancia();
        accione();
    }

    private void accione() {
    }

    private void instancia() {
        bDialogoConfirmar=findViewById(R.id.dialogoConfirmacion);
        textoConfirmar=findViewById(R.id.repuestaConfirmacion);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.dialogoConfirmacion:
                DialogoConfirmacion d= new DialogoConfirmacion();
                d.show(getSupportFragmentManager(),TAG_DCONFIR);
                break;
        }
        
    }

    @Override
    public void onDialogoConfirmacionSelected() {
        textoConfirmar.setText("Confirmado");
    }
}
