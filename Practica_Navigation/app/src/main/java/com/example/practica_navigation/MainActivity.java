package com.example.practica_navigation;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Spinner;

import com.example.practica_navigation.adaptador.AdaptadorRecycler;
import com.example.practica_navigation.basedatos.DatosBD;
import com.example.practica_navigation.basedatos.HelperDB;
import com.example.practica_navigation.fragments.FragmentDetalle;
import com.example.practica_navigation.fragments.FragmentRecycler;


public class MainActivity extends AppCompatActivity implements AdaptadorRecycler.OnRecyclerClickListener {

    private static final String TAG_FRAG_1 = "fragment 1";
    private static final String TAG_FRAG_DETA = "fragment 2";
    FrameLayout sitio;
    NavigationView nav;
    SQLiteOpenHelper helper;
    SQLiteDatabase baseDatos;
    Spinner spinnerCebecera;
    SearchView busqueda;
    ImageView imagen_fondo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        crearBaseDatosBD();
        instancias();
        agregarFragment();
        acciones();
    }

    private void acciones() {
        spinnerCebecera.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if(position==0){
                    imagen_fondo.setImageResource(R.drawable.all_back);
                    nav.getMenu().clear();
                    nav.inflateMenu(R.menu.menu_nav);

                } else if(position==1){
                    imagen_fondo.setImageResource(R.drawable.game_back);
                    nav.getMenu().clear();
                    nav.inflateMenu(R.menu.menu_juegos);

                }else if(position==2){
                    imagen_fondo.setImageResource(R.drawable.cine_back);
                    nav.getMenu().clear();
                    nav.inflateMenu(R.menu.menu_multi);

                }else if(position==3){
                    imagen_fondo.setImageResource(R.drawable.footbal_back);
                    nav.getMenu().clear();
                    nav.inflateMenu(R.menu.menu_fot);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    private void crearBaseDatosBD() {
        helper = new HelperDB(getApplicationContext(), DatosBD.DB_NAME, null, 1);
        rellenar(helper);
    }

    private void rellenar(SQLiteOpenHelper helper) {
        baseDatos = helper.getWritableDatabase();
        String query = "INSERT INTO %s (%s,%s,%s,%s,%s) values('%s','%s','%s','%s','%s')";
        baseDatos.execSQL(String.format(query,
                DatosBD.TABLA_SEC,
                DatosBD.TABLA_SEC_TIP,
                DatosBD.TABLA_SEC_SUB_TIP,
                DatosBD.TABLA_SEC_NOM,
                DatosBD.TABLA_SEC_URL,
                DatosBD.TABLA_SEC_DES,
                "juegos",
                "pc",
                "Half Live 3",
                "https://e00-elmundo.uecdn.es/assets/multimedia/imagenes/2017/08/25/15036678402837.jpg",
                "Valve por favor :("));
        baseDatos.close();
        baseDatos = helper.getWritableDatabase();
        baseDatos.execSQL(String.format(query,
                DatosBD.TABLA_SEC,
                DatosBD.TABLA_SEC_TIP,
                DatosBD.TABLA_SEC_SUB_TIP,
                DatosBD.TABLA_SEC_NOM,
                DatosBD.TABLA_SEC_URL,
                DatosBD.TABLA_SEC_DES,
                "multimedia",
                "cine",
                "Sharknado",
                "https://m.media-amazon.com/images/M/MV5BODcwZWFiNTEtNDgzMC00ZmE2LWExMzYtNzZhZDgzNDc5NDkyXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_.jpg",
                "enough said!"
        ));
        baseDatos.close();
        baseDatos = helper.getWritableDatabase();
        baseDatos.execSQL(String.format(query,
                DatosBD.TABLA_SEC,
                DatosBD.TABLA_SEC_TIP,
                DatosBD.TABLA_SEC_SUB_TIP,
                DatosBD.TABLA_SEC_NOM,
                DatosBD.TABLA_SEC_URL,
                DatosBD.TABLA_SEC_DES,
                "futbol",
                "la liga",
                "Real Jaen C.F.",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRxgArwWyvuakawCrlAyPSFw752biLzq-UDqsdOoaMD8MzPl43E",
                "real jaen cf"
        ));
        baseDatos.close();

    }


    private void agregarFragment() {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(sitio.getId(), FragmentRecycler.newInstance(0), TAG_FRAG_1);
        ft.addToBackStack(TAG_FRAG_1);
        ft.commit();
    }

    private void instancias() {
        sitio = findViewById(R.id.sitioFragment);
        nav = findViewById(R.id.navigation);
        spinnerCebecera = nav.getHeaderView(0).findViewById(R.id.spinnerHeader);
        imagen_fondo = nav.getHeaderView(0).findViewById(R.id.imagenHeader);
        busqueda = (SearchView) nav.getMenu().findItem(R.id.opcion5).getActionView();
        persoSpinner();

    }

    private void persoSpinner() {
        String[] opcion = {"principal", "juegos", "multimedia", "futbol"};
        ArrayAdapter<CharSequence> adaptadorSpinner = new ArrayAdapter<CharSequence>(getApplicationContext(), android.R.layout.simple_spinner_item, opcion);
        adaptadorSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCebecera.setAdapter(adaptadorSpinner);
    }


    @Override
    public void onRecyclerClick(int pos) {
        FragmentManager fm  = getSupportFragmentManager();
        FragmentTransaction ft  =fm.beginTransaction();
        ft.add(sitio.getId(), FragmentDetalle.newInstance(),TAG_FRAG_DETA);
        ft.addToBackStack(TAG_FRAG_DETA);
        ft.commit();

    }
}

