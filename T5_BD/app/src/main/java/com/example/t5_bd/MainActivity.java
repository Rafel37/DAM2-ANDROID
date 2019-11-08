package com.example.t5_bd;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.t5_bd.bbdd.DatosBaseDatos;
import com.example.t5_bd.bbdd.HelperDB;

public class MainActivity extends AppCompatActivity {

    HelperDB helperDB;
    SQLiteDatabase baseDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
    }

    private void instancias() {
        helperDB = new HelperDB(getApplicationContext(), DatosBaseDatos.DB_NAME, null,1);
        baseDatos = helperDB.getReadableDatabase();
        baseDatos.close();
    }

}
