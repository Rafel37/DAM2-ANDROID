package com.example.javier.practica_navigation.DatosBD;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class HelperDatabase extends SQLiteOpenHelper {

    public HelperDatabase(@Nullable @android.support.annotation.Nullable Context context, @Nullable @android.support.annotation.Nullable String name, @Nullable @android.support.annotation.Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+ DatosBD.TABLA_SEC+"("+
                DatosBD._ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+
                DatosBD.TABLA_SEC_TIP+ " TEXT NOT NULL,"+
                DatosBD.TABLA_SEC_SUB_TIP+ " TEXT NOT NULL,"+
                DatosBD.TABLA_SEC_NOM+" TEXT NOT NULL,"+
                DatosBD.TABLA_SEC_URL+" TEXT NOT NULL,"+
                DatosBD.TABLA_SEC_DESC+" TEXT NOT NULL)");

        rellenarBd(db);
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
                DatosBD.TABLA_SEC_DESC,
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
                DatosBD.TABLA_SEC_DESC,
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
                DatosBD.TABLA_SEC_DESC,
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
                DatosBD.TABLA_SEC_DESC,
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
                DatosBD.TABLA_SEC_DESC,
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
                DatosBD.TABLA_SEC_DESC,
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
                DatosBD.TABLA_SEC_DESC,
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
                DatosBD.TABLA_SEC_DESC,
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
                DatosBD.TABLA_SEC_DESC,
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
                DatosBD.TABLA_SEC_DESC,
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
                DatosBD.TABLA_SEC_DESC,
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
                DatosBD.TABLA_SEC_DESC,
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
                DatosBD.TABLA_SEC_DESC,
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
                DatosBD.TABLA_SEC_DESC,
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
                DatosBD.TABLA_SEC_DESC,
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
                DatosBD.TABLA_SEC_DESC,
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
                DatosBD.TABLA_SEC_DESC,
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
                DatosBD.TABLA_SEC_DESC,
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
                DatosBD.TABLA_SEC_DESC,
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
                DatosBD.TABLA_SEC_DESC,
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
                DatosBD.TABLA_SEC_DESC,
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
                DatosBD.TABLA_SEC_DESC,
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
                DatosBD.TABLA_SEC_DESC,
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
                DatosBD.TABLA_SEC_DESC,
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
                DatosBD.TABLA_SEC_DESC,
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
                DatosBD.TABLA_SEC_DESC,
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
                DatosBD.TABLA_SEC_DESC,
                "futbol",
                "mundial",
                "",
                "",
                ""));
        baseDatosBD.close();


    }

}
