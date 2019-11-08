package com.example.joseg.ejemplo.Intents;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.joseg.ejemplo.R;

public class PrimosActivity extends AppCompatActivity implements View.OnClickListener, SeekBar.OnSeekBarChangeListener{

    LinearLayout linearLayout;
    TextView tvsb, tvresultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primos);
        instancias();
        acciones(linearLayout);
    }

    public void acciones(ViewGroup padre){
        View elemento;
        for (int i = 0; i<padre.getChildCount();i++){
            elemento = padre.getChildAt(i);
            if (elemento instanceof Button)
                elemento.setOnClickListener(this);
            else if (elemento instanceof SeekBar) {
                ((SeekBar) elemento).setOnSeekBarChangeListener(this);
            }
            if (padre.getChildAt(i) instanceof ViewGroup)
                acciones((ViewGroup) padre.getChildAt(i));
        }
    }

    private void instancias() {
        linearLayout = findViewById(R.id.Llpadreprimos);
        tvsb = findViewById(R.id.tvsbprimos);
        tvsb.setText("1");
        tvresultado = findViewById(R.id.tvresultadoprimos);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.bpcalcular)
            generarPrimos(Integer.valueOf(tvsb.getText().toString()));
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        if (seekBar.getId() == R.id.Sbprimos)
            tvsb.setText(String.valueOf(progress));
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    private void generarPrimos(int integer) {
        tvresultado.setText("");
        int primo = 2;
        for (int i = 0; i<integer; i++){
            if (esPrimo(primo)) {
                if (i == integer - 1)
                    tvresultado.append(String.valueOf(primo));
                else
                    tvresultado.append(String.valueOf(primo) + ", ");
            }
            else
                i--;
            primo++;
        }

    }

    private boolean esPrimo(int numero){
        int cont = 2;
        boolean primo = true;
        while (primo && cont!=numero){
            if (numero % cont == 0)
                primo = false;
            cont++;
        }
        return primo;
    }
}
