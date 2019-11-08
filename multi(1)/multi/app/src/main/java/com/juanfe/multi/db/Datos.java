package com.juanfe.multi.db;

import android.provider.BaseColumns;

public interface Datos extends BaseColumns {
    String DB_NAME = "multimedia";
    String TABLA_SEC ="secciones";
    String TABLA_SEC_TIP="tipo";
    String TABLA_SEC_SUB_TIP="subtipo";
    String TABLA_SEC_URL="url";
    String TABLA_SEC_NOM="nombre";
    String TABLA_SEC_DESC="descripcion";

}
