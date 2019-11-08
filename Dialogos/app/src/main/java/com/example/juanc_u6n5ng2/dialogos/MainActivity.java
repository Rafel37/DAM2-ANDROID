package com.example.juanc_u6n5ng2.dialogos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.juanc_u6n5ng2.dialogos.dialogos.DialogoConfirmacion;
import com.example.juanc_u6n5ng2.dialogos.dialogos.DialogoConfirmacionDos;
import com.example.juanc_u6n5ng2.dialogos.dialogos.DialogoListaMultiple;
import com.example.juanc_u6n5ng2.dialogos.dialogos.DialogoListaSimple;
import com.example.juanc_u6n5ng2.dialogos.dialogos.DialogoPerso;
import com.example.juanc_u6n5ng2.dialogos.dialogos.DialogoSiNo;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,
        DialogoConfirmacion.OnDialogoConfirmacionListener, DialogoSiNo.OnDialogoSINOListener,
        DialogoListaSimple.OnDialogoListaListener {

    Button bDialogoConfirmar, bDialogoConfirmarDos, bDialogoSiNo,
            bDialogoLista, bDialogoListaMultiple, bDialogoPerso;
    TextView textoConfirmar, textoConfirmarDos, textoSiNo,
            textoDialogoLista, textoDialogoListaMultiple, textoDialogoPerso;
    final static String TAG_DCONFIR = "Confirmacion";
    final static String TAG_DCONFIR_COM = "Confirmacion_COM";
    final static String TAG_DSINO = "SiNo";
    final static String TAG_DLISTA = "lista";
    final static String TAG_DLISTAMULTIPLE = "lista_multiple";
    final static String TAG_DPERSO = "listaPerso";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        acciones();
    }

    private void acciones() {
        bDialogoConfirmar.setOnClickListener(this);
        bDialogoConfirmarDos.setOnClickListener(this);
        bDialogoSiNo.setOnClickListener(this);
        bDialogoLista.setOnClickListener(this);
        bDialogoListaMultiple.setOnClickListener(this);
        bDialogoPerso.setOnClickListener(this);
    }

    private void instancias() {
        bDialogoConfirmar = findViewById(R.id.dialogoConfirmacion);
        textoConfirmar = findViewById(R.id.respuestaConfirmación);
        bDialogoConfirmarDos = findViewById(R.id.dialogoConfirmacionDos);
        textoConfirmarDos = findViewById(R.id.respuestaConfirmaciónDos);
        bDialogoSiNo = findViewById(R.id.dialogoSiNo);
        textoSiNo = findViewById(R.id.respuestaSiNo);
        bDialogoLista = findViewById(R.id.dialogoLista);
        textoDialogoLista = findViewById(R.id.respuestaLista);
        bDialogoListaMultiple = findViewById(R.id.dialogoListaMultiple);
        textoDialogoListaMultiple = findViewById(R.id.respuestaListaMutiple);
        bDialogoPerso = findViewById(R.id.dialogoPerso);
        textoDialogoPerso = findViewById(R.id.respuestaPerso);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.dialogoConfirmacion:
                DialogoConfirmacion d = new DialogoConfirmacion();
                d.show(getSupportFragmentManager(), TAG_DCONFIR);
                break;
            case R.id.dialogoConfirmacionDos:
                DialogoConfirmacionDos dDos = DialogoConfirmacionDos.newInstance("Título comunicado");
                dDos.show(getSupportFragmentManager(), TAG_DCONFIR_COM);
                break;
            case R.id.dialogoSiNo:
                DialogoSiNo dialogoSiNo = DialogoSiNo.newInstance("TITULO SINO");
                dialogoSiNo.show(getSupportFragmentManager(), TAG_DSINO);
                break;
            case R.id.dialogoLista:
                DialogoListaSimple dialogoListaSimple = new DialogoListaSimple();
                dialogoListaSimple.show(getSupportFragmentManager(), TAG_DLISTA);
                break;
            case R.id.dialogoListaMultiple:
                DialogoListaMultiple dialogoListaMultiple = new DialogoListaMultiple();
                dialogoListaMultiple.show(getSupportFragmentManager(), TAG_DLISTAMULTIPLE);
            case R.id.dialogoPerso:
                DialogoPerso dialogoPerso = new DialogoPerso();
                dialogoPerso.show(getSupportFragmentManager(), TAG_DPERSO);
        }
    }

    @Override
    public void onDialogoConfirmacionSelected() {
        textoConfirmar.setText("Confirmado");
    }

    @Override
    public void onDialogoSiSelected(String s) {
        textoSiNo.setText(s);
    }

    @Override
    public void onDialogoNoSelected(String s) {
        textoSiNo.setText(s);
    }

    @Override
    public void onDialogoNeutralSelected(String s) {
        textoSiNo.setText(s);
    }

    @Override
    public void onElementoListaSelected(String s) {
        textoDialogoLista.setText(s);
    }
}
