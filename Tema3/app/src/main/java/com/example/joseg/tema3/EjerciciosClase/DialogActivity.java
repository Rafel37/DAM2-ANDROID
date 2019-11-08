package com.example.joseg.tema3.EjerciciosClase;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.joseg.tema3.EjerciciosClase.Dialogos.DialogoConfirmacion;
import com.example.joseg.tema3.EjerciciosClase.Dialogos.DialogoConfirmacion2;
import com.example.joseg.tema3.EjerciciosClase.Dialogos.DialogoFecha;
import com.example.joseg.tema3.EjerciciosClase.Dialogos.DialogoHora;
import com.example.joseg.tema3.EjerciciosClase.Dialogos.DialogoLista;
import com.example.joseg.tema3.EjerciciosClase.Dialogos.DialogoPersonalizado;
import com.example.joseg.tema3.EjerciciosClase.Dialogos.DialogoSiNo;
import com.example.joseg.tema3.EjerciciosClase.Dialogos.DialogoSpinner;
import com.example.joseg.tema3.EjerciciosClase.Utils.Persona;
import com.example.joseg.tema3.R;

public class DialogActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener, View.OnClickListener, DialogoConfirmacion.OnDialogoConfirmacionListener, DialogoSiNo.OnDialogoSiNoListener, DialogoLista.OnDialogoListaListener, DialogoPersonalizado.OnDialogoPersoListener {

    Button botondialogconfirmar, botondialogconfirmar2, botondialogoSiNo, botondialogolista, botondialogoperso, botondialogohora, botondialogofecha, botondialogospinner;
    TextView textoconfirmar, textoconfirmar2, textoSiNo, textolista, textoperso, textohora, textofecha, textospinner;
    final static String TAG_CON = "confirmacion";
    final static String TAG_CON2 = "confirmacion2";
    final static String TAG_CON3 = "Si/No";
    final static String TAG_CON4 = "Lista";
    final static String TAG_CON5 = "Perso";
    final static String TAG_CON6 = "Hora";
    final static String TAG_CON7 = "Fecha";
    final static String TAG_CON8 = "spinner";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        instancias();
        acciones();
    }

    private void acciones() {
        botondialogconfirmar.setOnClickListener(this);
        botondialogconfirmar2.setOnClickListener(this);
        botondialogoSiNo.setOnClickListener(this);
        botondialogolista.setOnClickListener(this);
        botondialogoperso.setOnClickListener(this);
        botondialogohora.setOnClickListener(this);
        botondialogofecha.setOnClickListener(this);
        botondialogospinner.setOnClickListener(this);
    }

    private void instancias() {
        botondialogconfirmar = findViewById(R.id.dialogoConfirmacion);
        textoconfirmar = findViewById(R.id.respuestaConfirmacion);
        botondialogconfirmar2 = findViewById(R.id.dialogoConfirmacion2);
        textoconfirmar2 = findViewById(R.id.respuestaConfirmacion2);
        botondialogoSiNo = findViewById(R.id.dialogoSiNo);
        textoSiNo = findViewById(R.id.respuestaSiNo);
        botondialogolista = findViewById(R.id.dialogoLista);
        textolista = findViewById(R.id.respuestaLista);
        botondialogoperso = findViewById(R.id.dialogoPerso);
        textoperso = findViewById(R.id.respuestaPerso);
        botondialogohora = findViewById(R.id.dialogoHora);
        textohora = findViewById(R.id.respuestaHora);
        botondialogofecha = findViewById(R.id.dialogoFecha);
        textofecha = findViewById(R.id.respuestaFecha);
        botondialogospinner = findViewById(R.id.dialogoSpinner);
        textospinner = findViewById(R.id.respuestaSpinner);
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.dialogoConfirmacion:
                DialogoConfirmacion d = new DialogoConfirmacion();
                d.show(getSupportFragmentManager(),TAG_CON);
                break;
            case R.id.dialogoConfirmacion2:
                DialogoConfirmacion2 d2 = DialogoConfirmacion2.newInstance("Titulo comunicado");
                d2.show(getSupportFragmentManager(),TAG_CON2);
                break;
            case R.id.dialogoSiNo:
                DialogoSiNo d3 = DialogoSiNo.newInstance("Titulo Si/No");
                d3.show(getSupportFragmentManager(),TAG_CON3);
                break;
            case R.id.dialogoLista:
                DialogoLista d4 = new DialogoLista();
                d4.show(getSupportFragmentManager(),TAG_CON4);
                break;
            case R.id.dialogoPerso:
                DialogoPersonalizado d5 = new DialogoPersonalizado();
                d5.show(getSupportFragmentManager(),TAG_CON5);
                break;
            case R.id.dialogoHora:
                DialogoHora d6 = new DialogoHora();
                d6.show(getSupportFragmentManager(),TAG_CON6);
                break;
            case R.id.dialogoFecha:
                DialogoFecha d7 = new DialogoFecha();
                d7.show(getSupportFragmentManager(),TAG_CON7);
                break;
            case R.id.dialogoSpinner:
                DialogoSpinner d8 = new DialogoSpinner();
                d8.show(getSupportFragmentManager(),TAG_CON8);
                break;
        }

    }

    @Override
    public void onDialogoConfirmacionSelected() {
        textoconfirmar.setText("Confirmado");
    }

    @Override
    public void onDialogoSiSelected(String s) {
        textoSiNo.setText(s);
    }

    @Override
    public void onDialogoNeutralSelected(String s) {
        textoSiNo.setText(s);
    }

    @Override
    public void onDialogoNoSelected(String s) {
        textoSiNo.setText(s);
    }

    @Override
    public void onDialogoElementoSelected(String opcion) {
        textolista.setText(opcion);
    }

    @Override
    public void onDialogoOkSelected(Persona p) {
        textoperso.setText(p.getNombre()+" "+p.getApellido()+", "+p.getEdad());
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        textohora.setText(String.format("%2d:%02d",hourOfDay,minute));
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        textofecha.setText(String.format("%2d/%2d/%2d",dayOfMonth,month+1,year));
    }
}
