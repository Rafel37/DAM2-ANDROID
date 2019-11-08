package com.example.myapplication.basedatos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.myapplication.utils.Usuario;

import androidx.annotation.Nullable;

public class HelperDB  extends SQLiteOpenHelper {

    public HelperDB(@Nullable Context context,
                    @Nullable String name,
                    @Nullable SQLiteDatabase.CursorFactory factory,
                    int version)
    {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT ," +
                        "%s TEXT NOT NULL , " +
                        "%s TEXT NOT NULL , " +
                        "%s TEXT NOT NULL )";
        db.execSQL(String.format(query, DatosBD.TAB_ALU,
                                        DatosBD._ID,
                                        DatosBD.TAB_ALU_COL_NOM,
                                        DatosBD.TAB_ALU_COL_APE,
                                        DatosBD.TAB_ALU_COL_CORR));



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

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
