package com.example.joseg.tema3.EjerciciosClase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.joseg.tema3.R;

public class MenusActivity extends AppCompatActivity {

    Button boton1, boton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menus);
        boton1 = findViewById(R.id.btnmenuc1);
        boton2 = findViewById(R.id.btnmenuc2);
        registerForContextMenu(boton1);
        registerForContextMenu(boton2);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        switch (v.getId()){
            case R.id.btnmenuc1:
                getMenuInflater().inflate(R.menu.menu_contextual1,menu);
                break;
            case R.id.btnmenuc2:
                getMenuInflater().inflate(R.menu.menu_contextual2,menu);
                break;
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_principal,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.opcion_1:
                Toast.makeText(getApplicationContext(), "Pulsado opcion 1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.opcion_2:
                Toast.makeText(getApplicationContext(), "Pulsado opcion 2", Toast.LENGTH_SHORT).show();
                break;
            case R.id.opcion_3:
                Toast.makeText(getApplicationContext(), "Pulsado opcion 3", Toast.LENGTH_SHORT).show();
                break;
            case R.id.opciones:
                Toast.makeText(getApplicationContext(), "Pulsado opciones", Toast.LENGTH_SHORT).show();
                break;
            case R.id.opcion_4:
                Toast.makeText(getApplicationContext(), "Pulsado opcion 4", Toast.LENGTH_SHORT).show();
                break;
            case R.id.opcion_1mc:
                Toast.makeText(getApplicationContext(), "Pulsado opcion 1 contextual", Toast.LENGTH_SHORT).show();
                break;
            case R.id.opcion_2mc:
                Toast.makeText(getApplicationContext(), "Pulsado opcion 2 contextual", Toast.LENGTH_SHORT).show();
                break;
            case R.id.opcion_1mc2:
                Toast.makeText(getApplicationContext(), "Pulsado opcion 3 contextual", Toast.LENGTH_SHORT).show();
                break;
            case R.id.opcion_2mc2:
                Toast.makeText(getApplicationContext(), "Pulsado opcion 4 contextual", Toast.LENGTH_SHORT).show();
                break;
        }

        return true;
    }
}
