package com.example.kalimero.tablas;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class TableActivity extends AppCompatActivity implements View.OnClickListener {

    TextView editText;
    Button bAC, bMasMenos, bPorcentaje, bDivision, bMultiplicar, bResta, bSuma, bIgual, bComa,
            b0, b1, b2, b3, b4, b5, b6, b7, b8, b9;

    Button bSEN, bCOS, bTAN, bSQR, bRAD, bXfac, bE, bX2, bX3;

    double op1, op2;

    String operacion = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);


        //RELACIONAMOS LAS VARIABLES CON LOS IDs
        editText = findViewById(R.id.textView);


        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {

            bAC = findViewById(R.id.botonAC);
            bMasMenos = findViewById(R.id.botonMasMenos);
            bPorcentaje = findViewById(R.id.botonPorcentaje);
            bDivision = findViewById(R.id.botonDividir);
            bMultiplicar = findViewById(R.id.botonMultiplicar);
            bResta = findViewById(R.id.botonMenos);
            bSuma = findViewById(R.id.botonMas);
            bIgual = findViewById(R.id.botonIgual);
            bComa = findViewById(R.id.botonComa);

            bSEN = findViewById(R.id.botonSen);
            bCOS = findViewById(R.id.botonCos);
            bTAN = findViewById(R.id.botonTan);
            bSQR = findViewById(R.id.botonSQR);
            bRAD = findViewById(R.id.botonRAD);
            bXfac = findViewById(R.id.botonFactorial);
            bE = findViewById(R.id.botonE);
            bX2 = findViewById(R.id.botonX2);
            bX3 = findViewById(R.id.botonX3);

            b0 = findViewById(R.id.boton0);
            b1 = findViewById(R.id.boton1);
            b2 = findViewById(R.id.boton2);
            b3 = findViewById(R.id.boton3);
            b4 = findViewById(R.id.boton4);
            b5 = findViewById(R.id.boton5);
            b6 = findViewById(R.id.boton6);
            b7 = findViewById(R.id.boton7);
            b8 = findViewById(R.id.boton8);
            b9 = findViewById(R.id.boton9);

            accionesland();
        }



        else if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {

            bAC = findViewById(R.id.botonAC);
            bMasMenos = findViewById(R.id.botonMasMenos);
            bPorcentaje = findViewById(R.id.botonPorcentaje);
            bDivision = findViewById(R.id.botonDividir);
            bMultiplicar = findViewById(R.id.botonMultiplicar);
            bResta = findViewById(R.id.botonMenos);
            bSuma = findViewById(R.id.botonMas);
            bIgual = findViewById(R.id.botonIgual);
            bComa = findViewById(R.id.botonComa);

            b0 = findViewById(R.id.boton0);
            b1 = findViewById(R.id.boton1);
            b2 = findViewById(R.id.boton2);
            b3 = findViewById(R.id.boton3);
            b4 = findViewById(R.id.boton4);
            b5 = findViewById(R.id.boton5);
            b6 = findViewById(R.id.boton6);
            b7 = findViewById(R.id.boton7);
            b8 = findViewById(R.id.boton8);
            b9 = findViewById(R.id.boton9);

            accionesport();
        }
    }

    @Override
    public void onClick(View v) {

        if (operacion.equals("igual")) {
            editText.setText("");
            operacion = "";
        }

        switch (v.getId()) {

            //NUMEROS
            case R.id.boton1:
                editText.append(b1.getText().toString());
                break;

            case R.id.boton2:
                editText.append(b2.getText().toString());
                break;

            case R.id.boton3:
                editText.append(b3.getText().toString());
                break;

            case R.id.boton4:
                editText.append(b4.getText().toString());
                break;

            case R.id.boton5:
                editText.append(b5.getText().toString());
                break;

            case R.id.boton6:
                editText.append(b6.getText().toString());
                break;

            case R.id.boton7:
                editText.append(b7.getText().toString());
                break;

            case R.id.boton8:
                editText.append(b8.getText().toString());
                break;

            case R.id.boton9:
                editText.append(b9.getText().toString());
                break;

            case R.id.boton0:
                editText.append(b0.getText().toString());
                break;



            //OPERACIONES VERTICALES
            case R.id.botonComa:
                if (editText.getText().toString().contains(",")) {
                    break;
                }
                editText.append(bComa.getText().toString());
                break;

            case R.id.botonAC:
                editText.setText("");
                break;

            case R.id.botonMasMenos:
                editText.setText(String.valueOf(Double.valueOf(editText.getText().toString()) * -1));
                operacion = "igual";
                break;

            case R.id.botonPorcentaje:
                op1 = Double.valueOf(editText.getText().toString());
                editText.setText("");
                operacion = "resto";
                break;

            case R.id.botonDividir:
                op1 = Double.valueOf(editText.getText().toString());
                editText.setText("");
                operacion = "dividir";
                break;

            case R.id.botonMultiplicar:
                op1 = Double.valueOf(editText.getText().toString());
                editText.setText("");
                operacion = "multiplicar";
                break;

            case R.id.botonMenos:
                if (editText.getText().toString().contains("")) {
                    editText.setText("-");
                    break;
                }
                op1 = Double.valueOf(editText.getText().toString());
                editText.setText("");
                operacion = "restar";
                break;

            case R.id.botonMas:
                op1 = Double.valueOf(editText.getText().toString());
                editText.setText("");
                operacion = "sumar";
                break;

            //OPERACIONES HORIZANTALES


            case R.id.botonSen:
                op1 = Double.valueOf(editText.getText().toString());
                editText.setText(String.valueOf(Math.sin(op1)));
                operacion = "igual";
                break;

            case R.id.botonCos:
                op1 = Double.valueOf(editText.getText().toString());
                editText.setText(String.valueOf(Math.cos(op1)));
                operacion = "igual";
                break;

            case R.id.botonTan:
                op1 = Double.valueOf(editText.getText().toString());
                editText.setText(String.valueOf(Math.tan(op1)));
                operacion = "igual";
                break;


            case R.id.botonSQR:
                op1 = Double.valueOf(editText.getText().toString());
                editText.setText(String.valueOf(Math.sqrt(op1)));
                operacion = "igual";
                break;

            //todo
            case R.id.botonRAD:
                editText.setText("");
                operacion = "rad";
                break;


            case R.id.botonFactorial:
                op1 = Double.valueOf(editText.getText().toString());
                for (double i = op1 - 1; i > 0; i--) {
                    op1 = i * op1;
                }
                editText.setText(String.valueOf(op1));
                operacion = "igual";
                break;

            case R.id.botonE:
                editText.setText(String.valueOf(Math.E));
                break;

            case R.id.botonX3:
                op1 = Double.valueOf(editText.getText().toString());
                editText.setText(String.valueOf( op1 * op1 * op1));
                operacion = "igual";

                break;

            case R.id.botonX2:
                op1 = Double.valueOf(editText.getText().toString());
                editText.setText(String.valueOf( op1 * op1));
                operacion = "igual";
                break;


            //IGUAL
            case R.id.botonIgual:
                op2 = Double.valueOf(editText.getText().toString());

                if (operacion.equals("sumar")) {
                    editText.setText(String.valueOf(op1 + op2));
                }

                else if (operacion.equals("restar")) {
                    editText.setText(String.valueOf(op1 - op2));
                }

                else if (operacion.equals("multiplicar")) {
                    editText.setText(String.valueOf(op1 * op2));
                }

                else if (operacion.equals("dividir")) {
                    editText.setText(String.valueOf(op1 / op2));
                }

                else if (operacion.equals("resto")) {
                    editText.setText(String.valueOf(op1 % op2));
                    operacion = "";
                }

                //todo
                else if (operacion.equals("rad")) {
                    Toast.makeText(getApplicationContext(), "EN CONSTRUCCION", Toast.LENGTH_SHORT).show();
                    operacion = "";
                }

                operacion = "igual";

                break;
        }

    }

    private void accionesland() {

        bAC.setOnClickListener(this);
        bMasMenos.setOnClickListener(this);
        bPorcentaje.setOnClickListener(this);
        bDivision.setOnClickListener(this);
        bMultiplicar.setOnClickListener(this);
        bResta.setOnClickListener(this);
        bSuma.setOnClickListener(this);
        bIgual.setOnClickListener(this);
        bComa.setOnClickListener(this);

        bSEN.setOnClickListener(this);
        bCOS.setOnClickListener(this);
        bTAN.setOnClickListener(this);
        bSQR.setOnClickListener(this);
        bRAD.setOnClickListener(this);
        bXfac.setOnClickListener(this);
        bE.setOnClickListener(this);
        bX2.setOnClickListener(this);
        bX3.setOnClickListener(this);

        b0.setOnClickListener(this);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
        b7.setOnClickListener(this);
        b8.setOnClickListener(this);
        b9.setOnClickListener(this);
    }

    private void accionesport() {

        bAC.setOnClickListener(this);
        bMasMenos.setOnClickListener(this);
        bPorcentaje.setOnClickListener(this);
        bDivision.setOnClickListener(this);
        bMultiplicar.setOnClickListener(this);
        bResta.setOnClickListener(this);
        bSuma.setOnClickListener(this);
        bIgual.setOnClickListener(this);
        bComa.setOnClickListener(this);

        b0.setOnClickListener(this);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
        b7.setOnClickListener(this);
        b8.setOnClickListener(this);
        b9.setOnClickListener(this);
    }
}