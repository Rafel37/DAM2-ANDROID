package com.example.rpc_2eva.json;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


public class HelperDB extends SQLiteOpenHelper {


    public HelperDB(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+ DatosJSON.JSON_NAME + "("+
                DatosJSON._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"+
                DatosJSON.CARTEL + "TEXT NOT NULL,"+
                DatosJSON.TITULO + "TEXT NOT NULL,"+
                DatosJSON.GENERO + "TEXT NOT NULL,"+
                DatosJSON.ID + "TEXT NOT NULL)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
