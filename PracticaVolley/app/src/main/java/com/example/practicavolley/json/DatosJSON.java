package com.example.practicavolley.json;

import android.provider.BaseColumns;

public interface DatosJSON extends BaseColumns {

    String JSON_NAME_T = "teams";
    String LEAGUE_T = "strLeague";
    String ID_TEAM_T = "idTeam";
    String NOMBRE_T = "strTeam";
    String IMAGEN_ESTADIO_T = "strStadiumThumb";
    String IMAGEN_CAMISETA_T = "strTeamJersey";
    String IMAGEN_ESCUDO_T = "strTeamBadge";

    String JSON_NAME_J = "player";
    String IMAGEN_J = "strThumb";
    String NOMBRE_J = "strPlayer";
    String POSICION_J = "strPosition";
}
