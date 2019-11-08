package com.example.myapplication;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.myapplication.adaptador.AdaptadorRecycler;
import com.example.myapplication.basedatos.DatosBD;
import com.example.myapplication.basedatos.HelperDB;
import com.example.myapplication.utils.Usuario;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    HelperDB helperDB;
    SQLiteDatabase sqLiteDatabase;
    AdaptadorRecycler adaptadorRecycler;
    ArrayList<Usuario> listaUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        rellenarRecycler();
        rellenarRecycler(new Usuario("Nombre1", "Apellido1", "Correo1"));
        rellenarRecycler(new Usuario("Nombre2", "Apellido2", "Correo2"));
        rellenarRecycler(new Usuario("Nombre3", "Apellido3", "Correo3"));
        rellenarRecycler(new Usuario("Nombre4", "Apellido4", "Correo4"));
        rellenarRecycler(new Usuario("Nombre5", "Apellido5", "Correo5"));
        rellenarRecycler(new Usuario("Nombre6", "Apellido6", "Correo6"));
        rellenarRecycler(new Usuario("Nombre7", "Apellido7", "Correo7"));
        rellenarRecycler(new Usuario("Nombre8", "Apellido8", "Correo8"));
    }

    private void rellenarRecycler() {
        sqLiteDatabase = helperDB.getReadableDatabase();
        String query = "SELECT * FROM %s";
        Cursor c = sqLiteDatabase.rawQuery(String.format(query, DatosBD.TAB_ALU), null);
        while (c.moveToNext()) {
            String nombre = c.getString(c.getColumnIndex(DatosBD.TAB_ALU_COL_NOM));
            String apellido = c.getString(c.getColumnIndex(DatosBD.TAB_ALU_COL_APE));
            String correo = c.getString(c.getColumnIndex(DatosBD.TAB_ALU_COL_CORR));
            Usuario u = new Usuario(nombre, apellido, correo);
            listaUsuario.add(u);
        }
        adaptadorRecycler.notifyDataSetChanged();
        sqLiteDatabase.close();
    }

    private void instancias() {
        listaUsuario = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclermain);
        helperDB = new HelperDB(getApplicationContext(), DatosBD.DB_NAME, null, 1);
        adaptadorRecycler = new AdaptadorRecycler(getApplicationContext(), listaUsuario);
        recyclerView.setAdapter(adaptadorRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
    }

    public  void llenar(SQLiteDatabase db, Usuario u) {

        String query = "INSERT INTO %s ( %s, %s, %s ) VALUES ( '%s', '%s', '%S' ) ";
//        String queryD = "DELETE FROM %s";
        db.execSQL(String.format(query, DatosBD.TAB_ALU,
                DatosBD.TAB_ALU_COL_NOM,
                DatosBD.TAB_ALU_COL_APE,
                DatosBD.TAB_ALU_COL_CORR,
                u.getNombre(),
                u.getApellido(),
                u.getCorreo()));


        db.close();

    }
}
