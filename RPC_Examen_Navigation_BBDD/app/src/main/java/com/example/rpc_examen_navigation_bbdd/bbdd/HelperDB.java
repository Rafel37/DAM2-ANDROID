package com.example.rpc_examen_navigation_bbdd.bbdd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.rpc_examen_navigation_bbdd.utils.Alumno;

import androidx.annotation.Nullable;

public class HelperDB extends SQLiteOpenHelper {

    public HelperDB(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE " + BaseDatos.TAB_CICLO + " ("
        + BaseDatos._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
        + BaseDatos.TAB_CICLO_NAM + " TEXT NOT NULL, "
        + BaseDatos.TAB_CICLO_APE + " TEXT NOT NULL, "
        + BaseDatos.TAB_CICLO_CICLO + " TEXT NOT NULL) ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


}
