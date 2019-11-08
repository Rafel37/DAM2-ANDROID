package com.example.kalimero.primos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {

    TextView resultado , barraNum;
    SeekBar barra;
    Button calcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultado = findViewById(R.id.textResutlado);
        barra = findViewById(R.id.barra);
        barraNum = findViewById(R.id.barraNum);
        calcular = findViewById(R.id.calcular);

        acciones();
    }

    private void generarPrimos(int integer) {
        resultado.setText("");
        int primo = 2;
        for (int i = 0; i<integer; i++){
            if (esPrimo(primo)) {
                if (i == integer - 1)
                    resultado.append(String.valueOf(primo));
                else
                    resultado.append(String.valueOf(primo) + ", ");
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



    @Override
    public void onClick(View v) {

        generarPrimos(Integer.parseInt(barraNum.getText().toString()));
    }


    public void acciones () {

        resultado.setOnClickListener(this);
        barraNum.setOnClickListener(this);
        barra.setOnSeekBarChangeListener(this);
        calcular.setOnClickListener(this);
    }


    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

        barraNum.setText(String.valueOf(progress));
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}