package com.example.joseg.ejemplo.Elementos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.example.joseg.ejemplo.R;

public class ElementosActivity extends AppCompatActivity {

    CheckBox checkBox;
    RadioButton radioInvidual, radioGrupo0, radioGrupo1;
    RadioGroup radioGroup;
    ToggleButton toggleButton;
    Switch aSwitch;
    SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elementos);
        instancias();
        acciones();
    }

    private void acciones() {
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(getApplicationContext(),String.valueOf(isChecked),Toast.LENGTH_SHORT).show();
                checkBox.isChecked();
                checkBox.setSelected(false);
            }
        });
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.Radiogrp0Ejemplo:
                        Toast.makeText(getApplicationContext(),findViewById(checkedId).toString(),Toast.LENGTH_SHORT).show();
                        group.getCheckedRadioButtonId();
                        break;
                    case R.id.Radiogrp1Ejemplo:
                        Toast.makeText(getApplicationContext(),findViewById(checkedId).toString(),Toast.LENGTH_SHORT).show();
                        group.getCheckedRadioButtonId();
                        break;
                }
            }
        });
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            }
        });
        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            }
        });
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Toast.makeText(getApplicationContext(),findViewById(progress).toString(),Toast.LENGTH_SHORT).show();
                seekBar.getProgress();
                seekBar.setMax(100);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private void instancias() {
        checkBox = findViewById(R.id.checkboxejemplo);
        radioInvidual = findViewById(R.id.RadioinvEjemplo);
        radioGrupo0 = findViewById(R.id.Radiogrp0Ejemplo);
        radioGrupo1 = findViewById(R.id.Radiogrp1Ejemplo);
        radioGroup = findViewById(R.id.gruporadiosEjemplo);
        toggleButton = findViewById(R.id.togglebuttonEjemplo);
        aSwitch = findViewById(R.id.SwitchEjemplo);
        seekBar = findViewById(R.id.sekbarEjemplo);
    }
}
