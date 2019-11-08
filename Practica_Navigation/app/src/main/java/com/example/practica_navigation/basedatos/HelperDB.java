package com.example.practica_navigation.basedatos;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
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
        db.execSQL("CREATE TABLE " + DatosBD.TABLA_SEC + "(" +
                DatosBD._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                DatosBD.TABLA_SEC_TIP +     " TEXT NOT NULL," +
                DatosBD.TABLA_SEC_SUB_TIP + " TEXT NOT NULL," +
                DatosBD.TABLA_SEC_NOM +     " TEXT NOT NULL," +
                DatosBD.TABLA_SEC_URL +     " TEXT NOT NULL," +
                DatosBD.TABLA_SEC_DES +     " TEXT NOT NULL)" );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    private void rellenarBd(SQLiteDatabase baseDatosBD) {
        String query = "INSERT INTO %s (%s,%s,%s,%s,%s) values('%s','%s','%s','%s','%s')";
        baseDatosBD.execSQL(String.format(query,
                DatosBD.TABLA_SEC,
                DatosBD.TABLA_SEC_TIP,
                DatosBD.TABLA_SEC_SUB_TIP,
                DatosBD.TABLA_SEC_NOM,
                DatosBD.TABLA_SEC_URL,
                DatosBD.TABLA_SEC_DES,
                "juegos",
                "ps4",
                "",
                "",
                ""));
        baseDatosBD.close();
        baseDatosBD.execSQL(String.format(query,
                DatosBD.TABLA_SEC,
                DatosBD.TABLA_SEC_TIP,
                DatosBD.TABLA_SEC_SUB_TIP,
                DatosBD.TABLA_SEC_NOM,
                DatosBD.TABLA_SEC_URL,
                DatosBD.TABLA_SEC_DES,
                "juegos",
                "ps4",
                "",
                "",
                ""));
        baseDatosBD.close();
        baseDatosBD.execSQL(String.format(query,
                DatosBD.TABLA_SEC,
                DatosBD.TABLA_SEC_TIP,
                DatosBD.TABLA_SEC_SUB_TIP,
                DatosBD.TABLA_SEC_NOM,
                DatosBD.TABLA_SEC_URL,
                DatosBD.TABLA_SEC_DES,
                "juegos",
                "ps4",
                "",
                "",
                ""));
        baseDatosBD.close();
        baseDatosBD.execSQL(String.format(query,
                DatosBD.TABLA_SEC,
                DatosBD.TABLA_SEC_TIP,
                DatosBD.TABLA_SEC_SUB_TIP,
                DatosBD.TABLA_SEC_NOM,
                DatosBD.TABLA_SEC_URL,
                DatosBD.TABLA_SEC_DES,
                "juegos",
                "pc",
                "",
                "",
                ""));
        baseDatosBD.close();
        baseDatosBD.execSQL(String.format(query,
                DatosBD.TABLA_SEC,
                DatosBD.TABLA_SEC_TIP,
                DatosBD.TABLA_SEC_SUB_TIP,
                DatosBD.TABLA_SEC_NOM,
                DatosBD.TABLA_SEC_URL,
                DatosBD.TABLA_SEC_DES,
                "juegos",
                "pc",
                "",
                "",
                ""));
        baseDatosBD.close();
        baseDatosBD.execSQL(String.format(query,
                DatosBD.TABLA_SEC,
                DatosBD.TABLA_SEC_TIP,
                DatosBD.TABLA_SEC_SUB_TIP,
                DatosBD.TABLA_SEC_NOM,
                DatosBD.TABLA_SEC_URL,
                DatosBD.TABLA_SEC_DES,
                "juegos",
                "pc",
                "",
                "",
                ""));
        baseDatosBD.close();
        baseDatosBD.execSQL(String.format(query,
                DatosBD.TABLA_SEC,
                DatosBD.TABLA_SEC_TIP,
                DatosBD.TABLA_SEC_SUB_TIP,
                DatosBD.TABLA_SEC_NOM,
                DatosBD.TABLA_SEC_URL,
                DatosBD.TABLA_SEC_DES,
                "juegos",
                "pc",
                "",
                "",
                ""));
        baseDatosBD.close();
        baseDatosBD.execSQL(String.format(query,
                DatosBD.TABLA_SEC,
                DatosBD.TABLA_SEC_TIP,
                DatosBD.TABLA_SEC_SUB_TIP,
                DatosBD.TABLA_SEC_NOM,
                DatosBD.TABLA_SEC_URL,
                DatosBD.TABLA_SEC_DES,
                "juegos",
                "xbox",
                "",
                "",
                ""));
        baseDatosBD.close();

        baseDatosBD.execSQL(String.format(query,
                DatosBD.TABLA_SEC,
                DatosBD.TABLA_SEC_TIP,
                DatosBD.TABLA_SEC_SUB_TIP,
                DatosBD.TABLA_SEC_NOM,
                DatosBD.TABLA_SEC_URL,
                DatosBD.TABLA_SEC_DES,
                "juegos",
                "xbox",
                "",
                "",
                ""));
        baseDatosBD.close();

        baseDatosBD.execSQL(String.format(query,
                DatosBD.TABLA_SEC,
                DatosBD.TABLA_SEC_TIP,
                DatosBD.TABLA_SEC_SUB_TIP,
                DatosBD.TABLA_SEC_NOM,
                DatosBD.TABLA_SEC_URL,
                DatosBD.TABLA_SEC_DES,
                "multimedia",
                "peliculas",
                "Como entrenar a tu dragon",
                "",
                ""));
        baseDatosBD.close();

        baseDatosBD.execSQL(String.format(query,
                DatosBD.TABLA_SEC,
                DatosBD.TABLA_SEC_TIP,
                DatosBD.TABLA_SEC_SUB_TIP,
                DatosBD.TABLA_SEC_NOM,
                DatosBD.TABLA_SEC_URL,
                DatosBD.TABLA_SEC_DES,
                "multimedia",
                "peliculas",
                "",
                "",
                ""));
        baseDatosBD.close();

        baseDatosBD.execSQL(String.format(query,
                DatosBD.TABLA_SEC,
                DatosBD.TABLA_SEC_TIP,
                DatosBD.TABLA_SEC_SUB_TIP,
                DatosBD.TABLA_SEC_NOM,
                DatosBD.TABLA_SEC_URL,
                DatosBD.TABLA_SEC_DES,
                "multimedia",
                "peliculas",
                "",
                "",
                ""));
        baseDatosBD.close();

        baseDatosBD.execSQL(String.format(query,
                DatosBD.TABLA_SEC,
                DatosBD.TABLA_SEC_TIP,
                DatosBD.TABLA_SEC_SUB_TIP,
                DatosBD.TABLA_SEC_NOM,
                DatosBD.TABLA_SEC_URL,
                DatosBD.TABLA_SEC_DES,
                "multimedia",
                "peliculas",
                "",
                "",
                ""));
        baseDatosBD.close();

        baseDatosBD.execSQL(String.format(query,
                DatosBD.TABLA_SEC,
                DatosBD.TABLA_SEC_TIP,
                DatosBD.TABLA_SEC_SUB_TIP,
                DatosBD.TABLA_SEC_NOM,
                DatosBD.TABLA_SEC_URL,
                DatosBD.TABLA_SEC_DES,
                "multimedia",
                "serie",
                "",
                "",
                ""));
        baseDatosBD.close();

        baseDatosBD.execSQL(String.format(query,
                DatosBD.TABLA_SEC,
                DatosBD.TABLA_SEC_TIP,
                DatosBD.TABLA_SEC_SUB_TIP,
                DatosBD.TABLA_SEC_NOM,
                DatosBD.TABLA_SEC_URL,
                DatosBD.TABLA_SEC_DES,
                "multimedia",
                "serie",
                "",
                "",
                ""));
        baseDatosBD.close();

        baseDatosBD.execSQL(String.format(query,
                DatosBD.TABLA_SEC,
                DatosBD.TABLA_SEC_TIP,
                DatosBD.TABLA_SEC_SUB_TIP,
                DatosBD.TABLA_SEC_NOM,
                DatosBD.TABLA_SEC_URL,
                DatosBD.TABLA_SEC_DES,
                "multimedia",
                "serie",
                "",
                "",
                ""));
        baseDatosBD.close();

        baseDatosBD.execSQL(String.format(query,
                DatosBD.TABLA_SEC,
                DatosBD.TABLA_SEC_TIP,
                DatosBD.TABLA_SEC_SUB_TIP,
                DatosBD.TABLA_SEC_NOM,
                DatosBD.TABLA_SEC_URL,
                DatosBD.TABLA_SEC_DES,
                "multimedia",
                "musica",
                "",
                "",
                ""));
        baseDatosBD.close();

        baseDatosBD.execSQL(String.format(query,
                DatosBD.TABLA_SEC,
                DatosBD.TABLA_SEC_TIP,
                DatosBD.TABLA_SEC_SUB_TIP,
                DatosBD.TABLA_SEC_NOM,
                DatosBD.TABLA_SEC_URL,
                DatosBD.TABLA_SEC_DES,
                "multimedia",
                "musica",
                "",
                "",
                ""));
        baseDatosBD.close();

        baseDatosBD.execSQL(String.format(query,
                DatosBD.TABLA_SEC,
                DatosBD.TABLA_SEC_TIP,
                DatosBD.TABLA_SEC_SUB_TIP,
                DatosBD.TABLA_SEC_NOM,
                DatosBD.TABLA_SEC_URL,
                DatosBD.TABLA_SEC_DES,
                "futbol",
                "la liga",
                "",
                "",
                ""));
        baseDatosBD.close();

        baseDatosBD.execSQL(String.format(query,
                DatosBD.TABLA_SEC,
                DatosBD.TABLA_SEC_TIP,
                DatosBD.TABLA_SEC_SUB_TIP,
                DatosBD.TABLA_SEC_NOM,
                DatosBD.TABLA_SEC_URL,
                DatosBD.TABLA_SEC_DES,
                "futbol",
                "la liga",
                "",
                "",
                ""));
        baseDatosBD.close();

        baseDatosBD.execSQL(String.format(query,
                DatosBD.TABLA_SEC,
                DatosBD.TABLA_SEC_TIP,
                DatosBD.TABLA_SEC_SUB_TIP,
                DatosBD.TABLA_SEC_NOM,
                DatosBD.TABLA_SEC_URL,
                DatosBD.TABLA_SEC_DES,
                "futbol",
                "la liga",
                "",
                "",
                ""));
        baseDatosBD.close();

        baseDatosBD.execSQL(String.format(query,
                DatosBD.TABLA_SEC,
                DatosBD.TABLA_SEC_TIP,
                DatosBD.TABLA_SEC_SUB_TIP,
                DatosBD.TABLA_SEC_NOM,
                DatosBD.TABLA_SEC_URL,
                DatosBD.TABLA_SEC_DES,
                "futbol",
                "champions",
                "",
                "",
                ""));
        baseDatosBD.close();

        baseDatosBD.execSQL(String.format(query,
                DatosBD.TABLA_SEC,
                DatosBD.TABLA_SEC_TIP,
                DatosBD.TABLA_SEC_SUB_TIP,
                DatosBD.TABLA_SEC_NOM,
                DatosBD.TABLA_SEC_URL,
                DatosBD.TABLA_SEC_DES,
                "futbol",
                "champions",
                "",
                "",
                ""));
        baseDatosBD.close();

        baseDatosBD.execSQL(String.format(query,
                DatosBD.TABLA_SEC,
                DatosBD.TABLA_SEC_TIP,
                DatosBD.TABLA_SEC_SUB_TIP,
                DatosBD.TABLA_SEC_NOM,
                DatosBD.TABLA_SEC_URL,
                DatosBD.TABLA_SEC_DES,
                "futbol",
                "champions",
                "",
                "",
                ""));
        baseDatosBD.close();

        baseDatosBD.execSQL(String.format(query,
                DatosBD.TABLA_SEC,
                DatosBD.TABLA_SEC_TIP,
                DatosBD.TABLA_SEC_SUB_TIP,
                DatosBD.TABLA_SEC_NOM,
                DatosBD.TABLA_SEC_URL,
                DatosBD.TABLA_SEC_DES,
                "futbol",
                "mundial",
                "",
                "",
                ""));
        baseDatosBD.close();
        baseDatosBD.execSQL(String.format(query,
                DatosBD.TABLA_SEC,
                DatosBD.TABLA_SEC_TIP,
                DatosBD.TABLA_SEC_SUB_TIP,
                DatosBD.TABLA_SEC_NOM,
                DatosBD.TABLA_SEC_URL,
                DatosBD.TABLA_SEC_DES,
                "futbol",
                "mundial",
                "",
                "",
                ""));
        baseDatosBD.close();
        baseDatosBD.execSQL(String.format(query,
                DatosBD.TABLA_SEC,
                DatosBD.TABLA_SEC_TIP,
                DatosBD.TABLA_SEC_SUB_TIP,
                DatosBD.TABLA_SEC_NOM,
                DatosBD.TABLA_SEC_URL,
                DatosBD.TABLA_SEC_DES,
                "futbol",
                "mundial",
                "",
                "",
                ""));
        baseDatosBD.close();


    }

}
