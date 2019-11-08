package com.example.joseg.ejemplo.Intents.Util;

import com.example.joseg.ejemplo.R;

import java.util.ArrayList;

public class DataSet {

    private static ArrayList<BB> datosbb;
    private static ArrayList<DS1> datosds1;
    private static ArrayList<DS2> datosds2;
    private static ArrayList<DS3> datosds3;
    private static ArrayList<DS> datosds;
    private static ArrayList<J> juegos;

    public static DataSet newInstance(){

        DataSet dataSet = new DataSet();

        return dataSet;
    }

    public static ArrayList<BB> darDatosBB() {
        datosbb = new ArrayList<>();
        datosbb.add(new BB("Gascoigne", "El Padre Gascoigne es un cazador experimentado que ha sido infectado por la plaga que asola Yharnam. Gascoigne es un hombre mayor con barba y pelo grisaceos que lleva una venda cubriendole los ojos. Viste un atuendo y sombrero de tonalidades marrones que revela su pasado como antiguo miembro de la Iglesia de la Sanación, los cuales se pueden obtener mediante los mensajeros: Gorra de Gascoigne, Atuendo de Gascoigne, Guantes de Gascoigne, y Pantalones de Gascoigne. A pesar de su pasado en la Iglesia, el título que ostenta no tiene equivalente en esta, dado que el título de \"Padre\" lo poseen los clérigos de un país extranjero. \n" +
                "\n" +
                "Durante su batalla de jefe, se revela que Gascoigne está infectado con la plaga, lo que le causó el transformarse en una criatura similar a un lobo. En forma de bestia se hace más fuerte, más rápido y más agresivo, a costa de su cordura y humanidad. \n","Cazador/Bestia", R.drawable.gascoigne));
        datosbb.add(new BB("Eileen", "Eileen es una asesina cuyo deber es deshaserse de otros cazadores que han sido corrompidos por su sed de sangre. Al igual que el jugador ella viene de fuera de Yharnam y es una forastera en la region, pero su presencia en la ciudad es motivada por objetivos totalmente diferentes. \n" +
                "\n" +
                "Eileen es conocida por su Atuendo de plumas de cuervo, que es una tradicion pasada por los cazadores de cazadores para simbolizar el entierro celestial. \n","Cazador", R.drawable.eileen));
        datosbb.add(new BB("Djura", "Djura es un cazador legendario que, a pesar de su vejez, aún muestra una gran cantidad de habilidades cuando se enfrenta a las bestias y parece ser lo suficientemente fuerte como para usar su pistola de cadena.\n" +
                "\n" +
                "Djura tiene el cabello gris largo y relajado y luce una vieja barba gris holandesa. Aparentemente tiene un solo ojo, ya que usa una venda como un parche ocular improvisado para su ojo derecho. Djura está vestido con ropa hecha jirones y plateada, y viste un tricornio similar al set del cazador.","Cazador", R.drawable.djuraa));
        datosbb.add(new BB("Alfred", "Alfred se encuentra por primera vez en el Barrio de la Catedral detrás de la tumba que conduce al antiguo Yharnam. Es un verdugo de la banda de Logarius y recompensa al jugador con la insignia Wheel Hunter al completar su búsqueda para destruir a los Vilebloods.","Cazador", R.drawable.alfred));
        datosbb.add(new BB("Doll", "Puede ser vista en el Sueño del cazador como una muñeca de porcelana completamente desprovista de cualquier tipo de vida. Luego toma vida y proveerá servicios al cazador. Es un personaje clave en el argumento del juego y puede darle información sobre los hechos de la historia del juego. \n" +
                "\n" +
                "Para ello es preciso darle a la opción de \"Hablar\", para recibir de esta manera informaciones. \n" +
                "\n" +
                "Lo curioso del juego es que se puede encontrar un edificio que parece haber sido la inspiración para el Sueño del cazador y una muñeca inanimada que es idéntica a la que se encuentra en el Sueño del cazador. \n","Asistente", R.drawable.doll));
        datosbb.add(new BB("Lady Maria", "Lady Maria era ciudadana de Cainhurst y está relacionada directamente con la reina Annalise. Sin embargo, fue una de las primeras cazadoras en unirse a la caza nocturna, estudiando con Gehrman, el Primer Cazador. A pesar de ser una ciudadana de Cainhurst, que disfrutaba con sus extravagantes usos de la sangre, prefería a su Rakuyo, que requería destreza y habilidad en lugar de la sangre para ejercer con eficacia.\n" +
                "\n" +
                "En un momento desconocido en el tiempo, María renunció a su amada arma, arrojándola a un pozo cuando ya no podía soportarlo, y aparentemente se suicidó. Su conciencia fue llevada a la Pesadilla del Cazador.\n" +
                "\n" +
                "Gehrman tenía una curiosa manía sobre ella, incluso después de que ella desapareciera. La Muñeca estaba basada en ella, hasta sus rasgos faciales, pero, lamentablemente, carecía de personalidad, dejando a Gehrman amargado.","Cazador/Vileblood", R.drawable.ladymaria));
        datosbb.add(new BB("Annalise", "Annalise, Reina de los Vilebloods; También conocida como la reina no muerta, es el líder y el único miembro restante de los Vainbloods de Cainhurst, los otros han dejado o han sido asesinados por los Verdugos.\n" +
                "\n" +
                "Se la puede encontrar en el castillo de Forsaken Cainhurst, en el ala oculta detrás del trono de Martyr Logarius.","Vileblood", R.drawable.annalise));
        datosbb.add(new BB("Micolash", "Micolash, Anfitrión de la pesadilla lleva una versión del uniforme escolar de Mensis. Utiliza dos herramientas de cazador arcano, entre ellas el Augurio de Ebrietas y la llamada del abismo.","Erudito", R.drawable.micolash));
        datosbb.add(new BB("Gehrman", "Se trata de un anciano atado a una silla de ruedas. Gehrman es un personaje misterioso que parece actuar como el guía del cazador a través del juego. Este personaje fue visto brevemente por primera vez en el trailer primero del juego y se le vio por segunda vez en los últimos segundos del tráiler de la Gamescom, acompañado por su ayudante. \n" +
                "\n" +
                "Gehrman tiene el pelo gris y hasta los hombros, lleva un sombrero negro junto con una chaqueta de cuero marrón y pantalones, un manto hecho jirones y un pañuelo. Siempre se le puede ver sentado en una silla de ruedas adornada y llevando un bastón con él. Gehrman se puede encontrar en el sueño del cazador, el piso franco del jugador, y le dará consejos e información si decide hablar con él. \n" +
                "\n" +
                "Al final del juego te dejará elegir entre \"librarte\" del sueño matandote y haciendo que finalmente te despiertes o rechazar esa oferta. \n" +
                "\n" +
                "Si te opones a que te mate, tendrás que luchar contra él como jefe. Será un jefe muy agresivo y quitará mucha vida, pudiéndote hacer ataques viscerales. Llevará una escopeta y una guadaña y alternará fases de llevar la guadaña a dos manos con fases de llevar la escopeta en la mano izquierda y la hoja de la guadaña en la derecha. Hacerle ataques viscerales no es complicado pero es casi imposible en algunas fases, por lo que la mejor táctica, para vencerlo, es esquivar y atacar. \n","Cazador", R.drawable.gehrman));
        return datosbb;
    }

    public static ArrayList<DS1> darDatosDS1() {
        datosds1 = new ArrayList<>();
        return datosds1;
    }

    public static ArrayList<DS2> darDatosDS2() {
        datosds2 = new ArrayList<>();
        return datosds2;
    }

    public static ArrayList<DS3> darDatosDS3() {
        datosds3 = new ArrayList<>();
        return datosds3;
    }

    public static ArrayList<DS> darDatosDS() {
        datosds = new ArrayList<>();
        return datosds;
    }

    public static ArrayList<J> darJuegos() {
        juegos = new ArrayList<>();
        juegos.add(new J("BloodBorne",R.drawable.bloodborne));
        juegos.add(new J("Dark Souls 1",R.drawable.darksouls));
        juegos.add(new J("Dark Souls 2",R.drawable.darksouls2));
        juegos.add(new J("Dark Souls 3",R.drawable.darksouls3));
        juegos.add(new J("Demon Souls",R.drawable.demonsouls));
        return juegos;
    }

    public static ArrayList<BB> getDatosbb() {
        return datosbb;
    }

    public static ArrayList<DS1> getDatosds1() {
        return datosds1;
    }

    public static ArrayList<DS2> getDatosds2() {
        return datosds2;
    }

    public static ArrayList<DS3> getDatosds3() {
        return datosds3;
    }

    public static ArrayList<DS> getDatosds() {
        return datosds;
    }
}
