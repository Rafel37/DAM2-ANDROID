<?php

    require 'OperacionesAlumnos.php';

    if ($_SERVER['REQUEST_METHOD'] == 'POST') {

        $body = json_decode(file_get_contents("php://input"), true);

        $retorno = Operaciones::insertarAlumno(
            $body['nombre'],
            $body['apellidos'],
            $body['correo'],
            $body['contrasena'],
            $body['curso'],
            $body['conocimiento_previo']);

        if ($retorno) {
            print json_encode(
                array(
                    'estado' => '1',
                    'mensaje' => 'El usuario creado con exito'));
        } 
        else {
            print json_encode(
                array(
                    'estado' => '2',
                    'mensaje' => 'El usuario no se ha podido crear')
            );  
        }
    }

    /*PARA HACERLO POR GET
<?php
    if ($_SERVER['REQUEST_METHOD'] == 'GET') {

    if (isset($_GET['nombre'])) {

        // Obtener parámetro idMeta
        $parametro1 = $_GET['nombre'];
        $parametro2 = $_GET['apellidos'];
        $parametro3 = $_GET['direccion'];
        $parametro4 = $_GET['telefono'];

        $retorno = Operaciones::insertarAlumno($parametro1,$parametro2,$parametro3,$parametro4);


        if ($retorno) {

            print json_encode(
                array(
                    'estado' => '1',
                    'mensaje' => 'Usuario agregado con éxito'
                )
            );
        } else {
            // Enviar respuesta de error general
            print json_encode(
                array(
                    'estado' => '2',
                    'mensaje' => 'Usuario no agregado'
                )
            );
        }

        } else {
            // Enviar respuesta de error
            print json_encode(
                array(
                    'estado' => '3',
                    'mensaje' => 'Se necesita un identificador'
                )
            );
        }
    }
?>
    */
?>