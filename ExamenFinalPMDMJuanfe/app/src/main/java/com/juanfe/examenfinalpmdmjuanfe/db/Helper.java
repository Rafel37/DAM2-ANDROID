package com.juanfe.examenfinalpmdmjuanfe.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Helper extends SQLiteOpenHelper {
    public Helper(@Nullable @android.support.annotation.Nullable Context context,
                  @Nullable @android.support.annotation.Nullable String name,
                  @Nullable @android.support.annotation.Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+ Datos.Tabla + "("+
                Datos._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"+
                Datos.titulo + "TEXT NOT NULL,"+
                Datos.fecha + "TEXT NOT NULL,"+
                Datos.imagen + "TEXT NOT NULL,"+
                Datos.genero + "TEXT NOT NULL)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
