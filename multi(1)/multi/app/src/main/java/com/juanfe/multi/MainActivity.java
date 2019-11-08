package com.juanfe.multi;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Spinner;

import com.bumptech.glide.Glide;
import com.juanfe.multi.adaptadores.AdaptadorRecyclerPerso;
import com.juanfe.multi.db.Datos;
import com.juanfe.multi.db.HelperDataBase;
import com.juanfe.multi.fragments.FragmentDetalle;
import com.juanfe.multi.fragments.FragmentRecycler;

public class MainActivity extends AppCompatActivity implements AdaptadorRecyclerPerso.OnRecyclerClickListener {

    private static final String TAG_FRAG_1 = "fragment 1";
    private static final String TAG_FRAG_DETA = "fragment 2";
    private static final String TAG_FRAG_1_1 = "fragment1 pulsado boton de menu";
    FrameLayout sitio;
    NavigationView nav;
    SQLiteOpenHelper helper;
    SQLiteDatabase baseDatos;
    Spinner spinnerCebecera;
    SearchView busqueda;
    ImageView fondoHeader;
    Toolbar toolbar;
    int posicion;
    String palabra;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        crearBaseDatos();
        instancias();
        agregarFragment();
        acciones();
    }

    private void acciones() {

        spinnerCebecera.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0) {
                    Glide.with(getApplicationContext()).load("https://raw.githubusercontent.com/DevelopSys/clasepmdm/master/recursos/multimedia/all_back.jpg").into(fondoHeader);
                    fondoHeader.setBackground(getDrawable(R.drawable.all_back));
                    nav.getMenu().clear();
                    nav.inflateMenu(R.menu.menu_princ);
                    palabra = (String) spinnerCebecera.getAdapter().getItem(position);

                } else if (position == 1) {
                    Glide.with(getApplicationContext()).load("https://raw.githubusercontent.com/DevelopSys/clasepmdm/master/recursos/multimedia/game_back.jpg").into(fondoHeader);
                    nav.getMenu().clear();
                    nav.inflateMenu(R.menu.menu_juegos);
                    palabra = (String) spinnerCebecera.getAdapter().getItem(position);

                } else if (position == 2) {
                    Glide.with(getApplicationContext()).load("https://raw.githubusercontent.com/DevelopSys/clasepmdm/master/recursos/multimedia/cine_back.jpg").into(fondoHeader);
                    nav.getMenu().clear();
                    nav.inflateMenu(R.menu.menu_multi);
                    palabra = (String) spinnerCebecera.getAdapter().getItem(position);

                } else if (position == 3) {
                    Glide.with(getApplicationContext()).load("https://raw.githubusercontent.com/DevelopSys/clasepmdm/master/recursos/multimedia/footbal_back.jpg").into(fondoHeader);
                    nav.getMenu().clear();
                    nav.inflateMenu(R.menu.menu_futbol);
                    palabra = (String) spinnerCebecera.getAdapter().getItem(position);

                }
                posicion=position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.liga: pulsarBotonParaFragment((String) menuItem.getTitle());break;
                    case R.id.muldial:pulsarBotonParaFragment((String) menuItem.getTitle());break;
                    case R.id.champions:pulsarBotonParaFragment((String) menuItem.getTitle());break;
                    case R.id.ps4:pulsarBotonParaFragment((String) menuItem.getTitle());break;
                    case R.id.xbox:pulsarBotonParaFragment((String) menuItem.getTitle());break;
                    case R.id.juegos:pulsarBotonParaFragment((String) menuItem.getTitle());break;
                    case R.id.multimedia:pulsarBotonParaFragment((String) menuItem.getTitle());break;
                    case R.id.futbol:pulsarBotonParaFragment((String) menuItem.getTitle());break;
                    case R.id.pc:pulsarBotonParaFragment((String) menuItem.getTitle());break;
                    case R.id.cine:pulsarBotonParaFragment((String) menuItem.getTitle());break;
                    case R.id.series:pulsarBotonParaFragment((String) menuItem.getTitle());break;
                    case R.id.musica:pulsarBotonParaFragment((String) menuItem.getTitle());break;
                }
                return true;
            }
        });
        busqueda.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                baseDatos=helper.getReadableDatabase();
                String query = "select * from %s where %s='%s'";
                Cursor cursor=baseDatos.rawQuery(String.format(query,Datos.TABLA_SEC,Datos.TABLA_SEC_NOM,s),null);
                while (cursor.moveToNext()){

                }


                return true;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });
    }

    private void crearBaseDatos() {
        helper = new HelperDataBase(getApplicationContext(), Datos.DB_NAME, null, 1);
        rellenarJuegos(helper);
    }


    private void agregarFragment() {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(sitio.getId(), FragmentRecycler.newInstance(0), TAG_FRAG_1);
        ft.addToBackStack(TAG_FRAG_1);
        ft.commit();
    }
    private void pulsarBotonParaFragment(String nombre){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(sitio.getId(), FragmentRecycler.newInstance(nombre), TAG_FRAG_1_1);
        ft.addToBackStack(TAG_FRAG_1_1);
        ft.commit();


    }

    private void instancias() {
        toolbar = findViewById(R.id.tool);
        setSupportActionBar(toolbar);
        sitio = findViewById(R.id.sitio);
        nav = findViewById(R.id.navigation);
        spinnerCebecera = nav.getHeaderView(0).findViewById(R.id.spinnerCabecera);
        fondoHeader = nav.getHeaderView(0).findViewById(R.id.fondoHeader);
        busqueda = (SearchView) nav.getMenu().findItem(R.id.busqueda).getActionView();
        persoSpinner();


    }

    private void persoSpinner() {
        String[] opcion = {"principal", "juegos", "multimedia", "futbol"};
        ArrayAdapter<CharSequence> adaptadorSpinner = new ArrayAdapter<CharSequence>(getApplicationContext(), android.R.layout.simple_spinner_item, opcion);
        adaptadorSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCebecera.setAdapter(adaptadorSpinner);
    }

    private void rellenarJuegos(SQLiteOpenHelper helper) {
        baseDatos = helper.getWritableDatabase();
        String query = "INSERT INTO %s (%s,%s,%s,%s,%s) values('%s','%s','%s','%s','%s')";
        baseDatos.execSQL(String.format(query,
                Datos.TABLA_SEC,
                Datos.TABLA_SEC_TIP,
                Datos.TABLA_SEC_SUB_TIP,
                Datos.TABLA_SEC_NOM,
                Datos.TABLA_SEC_URL,
                Datos.TABLA_SEC_DESC,
                "juegos",
                "xbox",
                "fortnite",
                "https://images-eds-ssl.xboxlive.com/image?url=8Oaj9Ryq1G1_p3lLnXlsaZgGzAie6Mnu24_PawYuDYIoH77pJ.X5Z.MqQPibUVTcfs1uX_ofRXQhJNAZ_.6SmA79lEkTTy.PoehnBmWY6Z7Or6bqbqyKhVJ1q0cE8iVz7JALiMwagg0UBqDjBtDjimoEcFQZNYf2tuoimDNn__EWJN0OJGD7_4QZD1rIqGpd.GG2GTcTgiDT_wk41Sqmq48qP2UNdqCHc7hj5VJpv6g-&amp;h=300&amp;w=200&amp;format=jpg",
                "Fortnite es un videojuego del año 2017 desarrollado por la empresa Epic Games, lanzado como diferentes paquetes de software que presentan diferentes modos de juego, pero que comparten el mismo motor general de juego y las mecánicas. Fue anunciado en los Spike Video Game Awards en 2011"));
        baseDatos.close();
        baseDatos = helper.getWritableDatabase();
        baseDatos.execSQL(String.format(query,
                Datos.TABLA_SEC,
                Datos.TABLA_SEC_TIP,
                Datos.TABLA_SEC_SUB_TIP,
                Datos.TABLA_SEC_NOM,
                Datos.TABLA_SEC_URL,
                Datos.TABLA_SEC_DESC,
                "juegos",
                "ps4",
                "god of war",
                "https://images-na.ssl-images-amazon.com/images/I/51pY8rnKypL._SX302_BO1,204,203,200_.jpg",
                "La infancia de Kratos es explicada durante el desarrollo del primer juego. Es maltratado, como solía hacerse a los niños altos y fuertes en la Antigua Grecia. A su hermano, al tener una marca que el oráculo predijo la portaría el que causara la perdición del Olimpo, Ares lo secuestra y lo lleva al reino de la muerte. Luego de recibir entrenamiento, Kratos, ya casado y con una hija, Calíope, se convierte en un gran general del ejército espartano, a pesar de las advertencias de su esposa, el guerrero prometió no detenerse hasta que la gloria de Esparta estuviera en lo más alto. Las tácticas de sus ejércitos eran brutales, pero muy efectivas. Pero un día, un enfrentamiento contra el batallón de bárbaros dio un resultado adverso para su armada. Con su ejército destruido y a punto de ser asesinado por el líder bárbaro, Kratos pide la ayuda de Ares, el dios de la guerra, ofreciéndole su vida a cambio. El dios desciende de los cielos y acaba con todos los enemigos; luego entrega a Kratos las Espadas del Caos, que son adheridas a sus brazos por cadenas. El guerrero espartano sucumbe totalmente al poder de Ares, quien le exige ciertas tareas de destrucción y conquista. Las tácticas del ejército de Kratos son aún más brutales que antes, asesinando sanguinariamente a cualquiera que opusiera alguna mínima resistencia. En una de sus misiones, Kratos debía quemar una aldea que se oponía a la armada de Esparta. En su afán de sangre y gloria, Kratos quiso ingresar al templo de la aldea, el oráculo del pequeño pueblo le advierte que no debía entrar a aquel santuario. El guerrero la hace a un lado e ingresa, asesinando con sus espadas a todos los presentes. Cuando lanza por última vez sus espadas hacia sus víctimas, entiende que había asesinado a su esposa e hija. Kratos queda devastado y como castigo por tal acción y su brutalidad, Kratos tendría pegadas sobre su piel, las cenizas de su esposa e hija por la eternidad; aunque Ares le explica que hizo eso para convertirlo en el guerrero perfecto, aun así, el guerrero espartano renunció a seguir siendo el súbdito del dios de la guerra."
        ));
        baseDatos.close();
        baseDatos = helper.getWritableDatabase();
        baseDatos.execSQL(String.format(query,
                Datos.TABLA_SEC,
                Datos.TABLA_SEC_TIP,
                Datos.TABLA_SEC_SUB_TIP,
                Datos.TABLA_SEC_NOM,
                Datos.TABLA_SEC_URL,
                Datos.TABLA_SEC_DESC,
                "juegos",
                "xbox",
                "gears of war",
                "data:image/jpeg;base64,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",
                "Gears of War 4 tiene lugar 25 años después de los acontecimientos ocurridos en Gears of War 3, y según Rod Fergusson, Director de The Coalition, el propósito del estudio es devolver la saga a sus orígenes, con una ambientación y una historia más oscura y misteriosa, tal y como tuvo el primer Gears of War. El nuevo enemigo será \"El Enjambre\" (The swarm) quien se desconoce de donde viene. El juego estará protagonizado por 3 principales protagonistas y dos co-protagonistas en el equipo)"));
        baseDatos.close();
        baseDatos = helper.getWritableDatabase();
        baseDatos.execSQL(String.format(query,
                Datos.TABLA_SEC,
                Datos.TABLA_SEC_TIP,
                Datos.TABLA_SEC_SUB_TIP,
                Datos.TABLA_SEC_NOM,
                Datos.TABLA_SEC_URL,
                Datos.TABLA_SEC_DESC,
                "juegos",
                "ps4",
                "the last of us",
                "https://upload.wikimedia.org/wikipedia/en/thumb/4/46/Video_Game_Cover_-_The_Last_of_Us.jpg/220px-Video_Game_Cover_-_The_Last_of_Us.jpg",
                "The Last of Us es un videojuego de acción-aventura y supervivencia de terror desarrollado por la compañía estadounidense Naughty Dog y distribuido para la consola PlayStation 3 en 2013. La trama describe las vivencias de Joel y Ellie, un par de supervivientes de una pandemia en Estados Unidos que provoca la mutación de los seres humanos contagiados en criaturas caníbales."));
        baseDatos.close();
        baseDatos = helper.getWritableDatabase();
        baseDatos.execSQL(String.format(query,
                Datos.TABLA_SEC,
                Datos.TABLA_SEC_TIP,
                Datos.TABLA_SEC_SUB_TIP,
                Datos.TABLA_SEC_NOM,
                Datos.TABLA_SEC_URL,
                Datos.TABLA_SEC_DESC,
                "juegos",
                "pc",
                "world of warcraft",
                "https://img-cache.coolshop.com/0a51e804-7bbb-49c3-ba21-ef260d7d3c3e/wowbfa-fob-2d-uk.jpg",
                "World of Warcraft (abreviado como WoW, literalmente en español Mundo de Warcraft) es un videojuego de rol multijugador masivo en línea desarrollado por Blizzard Entertainment. Es el cuarto juego lanzado establecido en el universo fantástico de Warcraft, el cual fue introducido por primera vez por Warcraft: Orcs & Humans en 1994.4\u200B World of Warcraft transcurre dentro del mundo de Azeroth, cuatro años después de los sucesos finales de la anterior entrega de Warcraft, Warcraft III: The Frozen Throne.5\u200B Blizzard Entertainment anunció World of Warcraft el 2 de septiembre de 2001.6\u200B"));
        baseDatos.close();
        baseDatos = helper.getWritableDatabase();
        baseDatos.execSQL(String.format(query,
                Datos.TABLA_SEC,
                Datos.TABLA_SEC_TIP,
                Datos.TABLA_SEC_SUB_TIP,
                Datos.TABLA_SEC_NOM,
                Datos.TABLA_SEC_URL,
                Datos.TABLA_SEC_DESC,
                "juegos",
                "pc",
                "league of leyends ",
                "https://news-a.akamaihd.net/public/images/misc/GameBox.jpg",
                "League of Legends (también conocido por sus siglas LoL) es un videojuego del juego de género multiplayer online battle arena (MOBA) y deporte electrónico el cual fue desarrollado por Riot Games para Microsoft Windows y OS X. En un principio los servidores estaban alojados en la empresa GOA y fue vendida a la empresa china Tencent Holdings Limited."));
        baseDatos.close();
        baseDatos = helper.getWritableDatabase();
        baseDatos.execSQL(String.format(query,
                Datos.TABLA_SEC,
                Datos.TABLA_SEC_TIP,
                Datos.TABLA_SEC_SUB_TIP,
                Datos.TABLA_SEC_NOM,
                Datos.TABLA_SEC_URL,
                Datos.TABLA_SEC_DESC,
                "juegos",
                "pc",
                "imperium III",
                "https://cloud10.todocoleccion.online/videojuegos-pc/tc/2015/06/21/19/49966782.jpg",
                "Imperivm III: Las grandes batallas de Roma es un videojuego de estrategia para PC producido por FX Interactive, basado en hechos históricos ocurridos en Europa y el Norte de África. En concreto, el jugador puede revivir acontecimientos como las campañas de Marco Aurelio en Germania, la conquista de Egipto y Britania, el asedio de Alesia o la batalla de Zama."));
        baseDatos.close();
        baseDatos = helper.getWritableDatabase();
        baseDatos.execSQL(String.format(query,
                Datos.TABLA_SEC,
                Datos.TABLA_SEC_TIP,
                Datos.TABLA_SEC_SUB_TIP,
                Datos.TABLA_SEC_NOM,
                Datos.TABLA_SEC_URL,
                Datos.TABLA_SEC_DESC,
                "juegos",
                "xbox",
                "forzamotorsport",
                "data:image/jpeg;base64,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",
                ""));
        baseDatos.close();
        baseDatos = helper.getWritableDatabase();
        baseDatos.execSQL(String.format(query,
                Datos.TABLA_SEC,
                Datos.TABLA_SEC_TIP,
                Datos.TABLA_SEC_SUB_TIP,
                Datos.TABLA_SEC_NOM,
                Datos.TABLA_SEC_URL,
                Datos.TABLA_SEC_DESC,
                "juegos",
                "ps4",
                "gran turismo",
                "https://upload.wikimedia.org/wikipedia/commons/5/53/New_Gran_Turismo_logo.JPG",
                "Gran Turismo (GT) es una serie de videojuegos de carreras producida para Sony PlayStation, PlayStation 2, PlayStation Portable, PlayStation 3 y PlayStation 4. Todos los juegos, en su momento, mostraron meticulosos detalles en la simulación de las físicas de conducción y gran cantidad de vehículos, casi todos reproducciones con licencia de coches reales. El detalle gráfico de los coches fue igualmente realista y preciso. La primera entrega de Gran Turismo fue el juego más vendido y fabricado para la PlayStation original, y sus versiones subsecuentes han sido igual de exitosas. La saga suma 68 millones de unidades vendidas en todo el mundo a fecha de noviembre de 2012. Se la considera como la saga buque insignia de Sony por ser la más vendida y la más representativa que tiene, seguido de God Of War, Uncharted, Twisted Metal y Killzone"));
        baseDatos.close();
        baseDatos = helper.getWritableDatabase();
        baseDatos.execSQL(String.format(query,
                Datos.TABLA_SEC,
                Datos.TABLA_SEC_TIP,
                Datos.TABLA_SEC_SUB_TIP,
                Datos.TABLA_SEC_NOM,
                Datos.TABLA_SEC_URL,
                Datos.TABLA_SEC_DESC,
                "multimedia",
                "peliculas",
                "harry potter",
                "https://img.tviso.com/ES/poster/w430/08/a4/08a46f786f5dba47b9d200ff91ce56e7.jpg",
                "Harry descubre un poderoso libro y, mientras trata de descubrir sus orígenes, colabora con Dumbledore en la búsqueda de una serie de objetos mágicos que ayudarán en la destrucción de Lord Voldemort."));
        baseDatos.close();
        baseDatos = helper.getWritableDatabase();
        baseDatos.execSQL(String.format(query,
                Datos.TABLA_SEC,
                Datos.TABLA_SEC_TIP,
                Datos.TABLA_SEC_SUB_TIP,
                Datos.TABLA_SEC_NOM,
                Datos.TABLA_SEC_URL,
                Datos.TABLA_SEC_DESC,
                "multimedia",
                "peliculas",
                "infiniti war",
                "https://pics.filmaffinity.com/avengers_infinity_war-181539353-large.jpg",
                "Los superhéroes se alían para vencer al poderoso Thanos, el peor enemigo al que se han enfrentado. Si Thanos logra reunir las seis gemas del infinito: poder, tiempo, alma, realidad, mente y espacio, nadie podrá detenerlo."));
        baseDatos.close();
        baseDatos = helper.getWritableDatabase();
        baseDatos.execSQL(String.format(query,
                Datos.TABLA_SEC,
                Datos.TABLA_SEC_TIP,
                Datos.TABLA_SEC_SUB_TIP,
                Datos.TABLA_SEC_NOM,
                Datos.TABLA_SEC_URL,
                Datos.TABLA_SEC_DESC,
                "multimedia",
                "peliculas",
                "venom",
                "data:image/jpeg;base64,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",
                "El periodista Eddie Brock está investigando a Carlton Drake, el célebre fundador de Life Foundation. Brock establece una simbiosis con un ente alienígena que le ofrece superpoderes, pero el ser se apodera de su personalidad y lo vuelve perverso."));
        baseDatos.close();
        baseDatos = helper.getWritableDatabase();
        baseDatos.execSQL(String.format(query,
                Datos.TABLA_SEC,
                Datos.TABLA_SEC_TIP,
                Datos.TABLA_SEC_SUB_TIP,
                Datos.TABLA_SEC_NOM,
                Datos.TABLA_SEC_URL,
                Datos.TABLA_SEC_DESC,
                "multimedia",
                "serie",
                "juego de tronos",
                "https://www.formulatv.com/images/series/posters/400/422/1_m3.jpg",
                "La historia se desarrolla en un mundo ficticio de carácter medieval donde hay Siete Reinos. Hay tres líneas argumentales principales: la crónica de la guerra civil dinástica por el control de Poniente entre varias familias nobles que aspiran al Trono de Hierro, la creciente amenaza de los Otros, seres desconocidos que viven al otro lado de un inmenso muro de hielo que protege el Norte de Poniente, y el viaje de Daenerys Targaryen, la hija exiliada del rey que fue asesinado en una guerra civil anterior, y que pretende regresar a Poniente para reclamar sus derechos. Tras un largo verano de varios años, el temible invierno se acerca a los Siete Reinos. Lord Eddard Ned Stark, señor de Invernalia, deja sus dominios para ir a la corte de su amigo, el rey Robert Baratheon en Desembarco del Rey, la capital de los Siete Reinos. Stark se convierte en la Mano del Rey e intenta desentrañar una maraña de intrigas que pondrá en peligro su vida y la de todos los suyos. Mientras tanto diversas facciones conspiran con un solo objetivo: apoderarse del trono"));
        baseDatos.close();
        baseDatos = helper.getWritableDatabase();
        baseDatos.execSQL(String.format(query,
                Datos.TABLA_SEC,
                Datos.TABLA_SEC_TIP,
                Datos.TABLA_SEC_SUB_TIP,
                Datos.TABLA_SEC_NOM,
                Datos.TABLA_SEC_URL,
                Datos.TABLA_SEC_DESC,
                "multimedia",
                "serie",
                "gotham",
                "https://cdn4.megadede.com/cdn/media/serie/1/7/0/6/6-medium.jpg?v=3",
                "La historia de un policía que enfrenta a una ciudad corrupta y que lo lleva al borde del mal y relata el nacimiento de uno de los súper héroes más populares de nuestro tiempo."));
        baseDatos.close();
        baseDatos = helper.getWritableDatabase();
        baseDatos.execSQL(String.format(query,
                Datos.TABLA_SEC,
                Datos.TABLA_SEC_TIP,
                Datos.TABLA_SEC_SUB_TIP,
                Datos.TABLA_SEC_NOM,
                Datos.TABLA_SEC_URL,
                Datos.TABLA_SEC_DESC,
                "multimedia",
                "serie",
                "flash",
                "https://cdn8.megadede.com/cdn/media/serie/1/7/0/4/2-medium.jpg?v=4",
                "Nueve meses después de que el laboratorio S.T.A.R. explotara, Barry despierta del coma y descubre que tiene el poder de la súper velocidad. Con la ayuda de su nuevo equipo, Barry, denominado ahora Flash, luchará contra el crimen en Ciudad Central."));
        baseDatos.close();
        baseDatos = helper.getWritableDatabase();
        baseDatos.execSQL(String.format(query,
                Datos.TABLA_SEC,
                Datos.TABLA_SEC_TIP,
                Datos.TABLA_SEC_SUB_TIP,
                Datos.TABLA_SEC_NOM,
                Datos.TABLA_SEC_URL,
                Datos.TABLA_SEC_DESC,
                "multimedia",
                "musica",
                "Avicii",
                "https://img-cdn.hipertextual.com/files/2018/04/avicii-2500.jpg?strip=all&lossy=1&quality=60&resize=670%2C410&ssl=1",
                "levels"));
        baseDatos.close();
        baseDatos = helper.getWritableDatabase();
        baseDatos.execSQL(String.format(query,
                Datos.TABLA_SEC,
                Datos.TABLA_SEC_TIP,
                Datos.TABLA_SEC_SUB_TIP,
                Datos.TABLA_SEC_NOM,
                Datos.TABLA_SEC_URL,
                Datos.TABLA_SEC_DESC,
                "multimedia",
                "musica",
                "Marck Anthony",
                "http://magnusmedia.com/wp-content/uploads/2017/02/marc.jpg",
                "Colombia"));
        baseDatos.close();
        baseDatos = helper.getWritableDatabase();
        baseDatos.execSQL(String.format(query,
                Datos.TABLA_SEC,
                Datos.TABLA_SEC_TIP,
                Datos.TABLA_SEC_SUB_TIP,
                Datos.TABLA_SEC_NOM,
                Datos.TABLA_SEC_URL,
                Datos.TABLA_SEC_DESC,
                "multimedia",
                "musica",
                "Jennifer Lopez",
                "https://i.ytimg.com/vi/F2nvw2WzYtQ/hqdefault.jpg",
                "U.S.A"));
        baseDatos.close();
        baseDatos = helper.getWritableDatabase();
        baseDatos.execSQL(String.format(query,
                Datos.TABLA_SEC,
                Datos.TABLA_SEC_TIP,
                Datos.TABLA_SEC_SUB_TIP,
                Datos.TABLA_SEC_NOM,
                Datos.TABLA_SEC_URL,
                Datos.TABLA_SEC_DESC,
                "futbol",
                "la liga",
                "fc barcelona",
                "https://www.entradas.com/obj/media/ES-eventim/teaser/222x222/2018/FCBarcelona-18-19_222x222.jpg",
                ""));
        baseDatos.close();
        baseDatos = helper.getWritableDatabase();
        baseDatos.execSQL(String.format(query,
                Datos.TABLA_SEC,
                Datos.TABLA_SEC_TIP,
                Datos.TABLA_SEC_SUB_TIP,
                Datos.TABLA_SEC_NOM,
                Datos.TABLA_SEC_URL,
                Datos.TABLA_SEC_DESC,
                "futbol",
                "la liga",
                "Real robadrid",
                "https://upload.wikimedia.org/wikipedia/commons/1/10/Escudo_real_madrid_1941b.png",
                ""));
        baseDatos.close();
        baseDatos = helper.getWritableDatabase();
        baseDatos.execSQL(String.format(query,
                Datos.TABLA_SEC,
                Datos.TABLA_SEC_TIP,
                Datos.TABLA_SEC_SUB_TIP,
                Datos.TABLA_SEC_NOM,
                Datos.TABLA_SEC_URL,
                Datos.TABLA_SEC_DESC,
                "futbol",
                "la liga",
                "atletico de madrid",
                "http://as00.epimg.net/img/comunes/fotos/fichas/equipos/large/42.png",
                ""));
        baseDatos.close();
        baseDatos = helper.getWritableDatabase();
        baseDatos.execSQL(String.format(query,
                Datos.TABLA_SEC,
                Datos.TABLA_SEC_TIP,
                Datos.TABLA_SEC_SUB_TIP,
                Datos.TABLA_SEC_NOM,
                Datos.TABLA_SEC_URL,
                Datos.TABLA_SEC_DESC,
                "futbol",
                "champions",
                "",
                "",
                ""));
        baseDatos.close();
        baseDatos = helper.getWritableDatabase();
        baseDatos.execSQL(String.format(query,
                Datos.TABLA_SEC,
                Datos.TABLA_SEC_TIP,
                Datos.TABLA_SEC_SUB_TIP,
                Datos.TABLA_SEC_NOM,
                Datos.TABLA_SEC_URL,
                Datos.TABLA_SEC_DESC,
                "futbol",
                "champions",
                "",
                "",
                ""));
        baseDatos.close();
        baseDatos = helper.getWritableDatabase();
        baseDatos.execSQL(String.format(query,
                Datos.TABLA_SEC,
                Datos.TABLA_SEC_TIP,
                Datos.TABLA_SEC_SUB_TIP,
                Datos.TABLA_SEC_NOM,
                Datos.TABLA_SEC_URL,
                Datos.TABLA_SEC_DESC,
                "futbol",
                "champions",
                "",
                "",
                ""));
        baseDatos.close();
        baseDatos = helper.getWritableDatabase();
        baseDatos.execSQL(String.format(query,
                Datos.TABLA_SEC,
                Datos.TABLA_SEC_TIP,
                Datos.TABLA_SEC_SUB_TIP,
                Datos.TABLA_SEC_NOM,
                Datos.TABLA_SEC_URL,
                Datos.TABLA_SEC_DESC,
                "futbol",
                "mundial",
                "James rodriguez",
                "https://as.com/img/comunes/fotos/fichas/equipos/large/2087.png",
                "FC bayern de munich"));
        baseDatos.close();baseDatos = helper.getWritableDatabase();
        baseDatos.execSQL(String.format(query,
                Datos.TABLA_SEC,
                Datos.TABLA_SEC_TIP,
                Datos.TABLA_SEC_SUB_TIP,
                Datos.TABLA_SEC_NOM,
                Datos.TABLA_SEC_URL,
                Datos.TABLA_SEC_DESC,
                "futbol",
                "mundial",
                "Lionel Messi el mesias",
                "https://as.com/img/comunes/fotos/fichas/equipos/large/1879.png",
                "FC Barcelona"));
        baseDatos.close();baseDatos = helper.getWritableDatabase();
        baseDatos.execSQL(String.format(query,
                Datos.TABLA_SEC,
                Datos.TABLA_SEC_TIP,
                Datos.TABLA_SEC_SUB_TIP,
                Datos.TABLA_SEC_NOM,
                Datos.TABLA_SEC_URL,
                Datos.TABLA_SEC_DESC,
                "futbol",
                "mundial",
                "Andres Iniesta",
                "https://botw-pd.s3.amazonaws.com/styles/logo-thumbnail/s3/0019/6426/brand.gif?itok=j0MvLzfh",
                "Vissel Kobe"));
        baseDatos.close();


    }

    @Override
    public void onRecyclerClick(int pos) {
        FragmentManager fm  = getSupportFragmentManager();
        FragmentTransaction ft  =fm.beginTransaction();
        ft.add(sitio.getId(), FragmentDetalle.newInstance(palabra,pos),TAG_FRAG_DETA);
        ft.addToBackStack(TAG_FRAG_DETA);
        ft.commit();

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (getSupportFragmentManager().getBackStackEntryCount()<1){
            finish();
        }
    }
}
