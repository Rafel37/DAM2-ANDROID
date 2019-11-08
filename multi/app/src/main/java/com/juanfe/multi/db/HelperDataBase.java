package com.juanfe.multi.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class HelperDataBase extends SQLiteOpenHelper {

    public HelperDataBase(@Nullable @android.support.annotation.Nullable Context context, @Nullable @android.support.annotation.Nullable String name, @Nullable @android.support.annotation.Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+ Datos.TABLA_SEC+"("+
                Datos._ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+
                Datos.TABLA_SEC_TIP+ " TEXT NOT NULL,"+
                Datos.TABLA_SEC_SUB_TIP+ " TEXT NOT NULL,"+
                Datos.TABLA_SEC_NOM+" TEXT NOT NULL,"+
                Datos.TABLA_SEC_URL+" TEXT NOT NULL,"+
                Datos.TABLA_SEC_DESC+" TEXT NOT NULL)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
