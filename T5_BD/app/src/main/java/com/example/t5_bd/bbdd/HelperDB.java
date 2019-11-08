package com.example.t5_bd.bbdd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class HelperDB extends SQLiteOpenHelper {

    public HelperDB(@androidx.annotation.Nullable Context context,
                    @androidx.annotation.Nullable String name,
                    @androidx.annotation.Nullable SQLiteDatabase.CursorFactory factory,
                    int version) {

        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + DatosBaseDatos.TAB_ALU + " (" +
                DatosBaseDatos._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                DatosBaseDatos.TAB_ALU_COL_NAME + " TEXT NOT NULL," +
                DatosBaseDatos.TAB_ALU_COL_APE + " TEXT NOT NULL," +
                DatosBaseDatos.TAB_ALU_COL_CORR + " TEXT NOT NULL" + ")" );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
