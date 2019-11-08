package com.example.rpc_examen_navigation_bbdd;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;

import com.example.rpc_examen_navigation_bbdd.adaptadores.AdaptadorRecycler;
import com.example.rpc_examen_navigation_bbdd.bbdd.BaseDatos;
import com.example.rpc_examen_navigation_bbdd.bbdd.HelperDB;
import com.example.rpc_examen_navigation_bbdd.utils.Alumno;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    RecyclerView recyclerView;
    HelperDB helperDB;
    SQLiteDatabase sqLiteDatabase;
    AdaptadorRecycler adaptadorRecycler;
    ArrayList<Alumno> listAlumno;

    Button boton;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //SPINNER
        spinner = findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //BOTON
        boton = findViewById(R.id.insertarB);
        boton.setOnClickListener(this);



        //RECYCLER
        helperDB = new HelperDB(getApplicationContext(), BaseDatos.DB_NAME, null, 1);
        sqLiteDatabase = helperDB.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(" SELECT * FROM " + BaseDatos.TAB_CICLO, null);
        listAlumno = new ArrayList<>();
        if (cursor != null) {
            cursor.moveToFirst();
            do {
                String nombre = cursor.getString(cursor.getColumnIndex(BaseDatos.TAB_CICLO_NAM));
                String apellido = cursor.getString(cursor.getColumnIndex(BaseDatos.TAB_CICLO_APE));
                Alumno alumno = new Alumno(nombre, apellido);
                listAlumno.add(alumno);
            }while (cursor.moveToNext());
        }
        cursor.close();
        helperDB.close();


        adaptadorRecycler = new AdaptadorRecycler(getApplicationContext(), listAlumno);
        recyclerView.setAdapter(adaptadorRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
    }


    @Override
    public void onClick(View v) {
        rellenarRecycler(new Alumno("Nombre1", "Apellido1"));
        rellenarRecycler(new Alumno("Nombre2", "Apellido2"));
        rellenarRecycler(new Alumno("Nombre3", "Apellido3"));
        rellenarRecycler(new Alumno("Nombre4", "Apellido4"));
        rellenarRecycler(new Alumno("Nombre5", "Apellido5"));
        rellenarRecycler(new Alumno("Nombre6", "Apellido6"));
        rellenarRecycler(new Alumno("Nombre7", "Apellido7"));
        rellenarRecycler(new Alumno("Nombre8", "Apellido8"));
        llenarTabla(sqLiteDatabase, listAlumno);

    }

    private void rellenarRecycler(Alumno alumno) {
        sqLiteDatabase = helperDB.getReadableDatabase();
        String query = "SELECT * FROM %s";
        Cursor c = sqLiteDatabase.rawQuery(String.format(query, BaseDatos.TAB_CICLO), null);
        while (c.moveToNext()) {
            String nombre = c.getString(c.getColumnIndex(BaseDatos.TAB_CICLO_NAM));
            String apellido = c.getString(c.getColumnIndex(BaseDatos.TAB_CICLO_APE));
            Alumno u = new Alumno(nombre, apellido);
            listAlumno.add(u);
        }
        adaptadorRecycler.notifyDataSetChanged();
        sqLiteDatabase.close();
    }

    public void llenarTabla(SQLiteDatabase db, Alumno alumno){
        String query = "INSERT INTO %s ( %s, %s, %s) VALUES ( '%s' , '%s' , '%s' )";
        db.execSQL(query, BaseDatos.DB_NAME,
                BaseDatos.TAB_CICLO_NAM,
                BaseDatos.TAB_CICLO_APE,
                alumno.getNombre(),
                alumno.getApellido(),
                alumno.getNombre()
                );
    }
}
