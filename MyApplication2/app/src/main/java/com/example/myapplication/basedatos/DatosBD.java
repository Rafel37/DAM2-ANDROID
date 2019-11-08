package com.example.myapplication.basedatos;

import android.provider.BaseColumns;

public interface DatosBD extends BaseColumns {
    String TAB_ALU = "alumnos";
    String DB_NAME = "bdalumno";
    String TAB_ALU_COL_NOM = "nombre";
    String TAB_ALU_COL_APE = "apellido";
    String TAB_ALU_COL_CORR = "correo";
}



/*
#####ABRIMOS LOCALIZACION DEL SDK
cd /root/Android/Sdk

#####ABRIMOS LA CARPETA DONDE ESTA EL ADB
cd platform-tools/

#####INICIAMOS ADB COMO ROOT
./adb root

#####NOS METEMOS EN LA SHELL
./adb shell

#####ABRIMOS LOCALIZACION DE LOS PROYECTOS
cd /data/data/

#####BUSCAMOS NUESTRO PROYECTO
ls

#####NOS METEMOS AL PROYECTO
cd com.example.myapplication/

#####ABRIMOS LOCALIZACION DE LAS BBDD
cd databases/

#####BUSCAMOS NUESTRA BBDD
ls

#####ABRIMOS CONSOLA SQL
sqlite3 bdalumnos

#####SELECT PARA COMPROBAR QUE FUNCIONA
SELECT * FROM alumnos

*/