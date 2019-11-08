<?php
    
    require 'OperacionesAlumnos.php';

    if ($_SERVER['REQUEST_METHOD'] == 'GET') {
        if(isset($_GET['nombre'])) {

            $parametro = $_GET['nombre'];
            $parametro2 = $_GET['nombreNuevo'];

            $consulta = Operaciones::getAlumno($parametro);
            if ($consulta) {

                $consulta2 = Operaciones::actualizarAlumno($parametro,$parametro2);
                $consulta2;
                print json_encode(
                array(
                'estado' => '1',
                'mensaje' => 'El usuario ya existe'));
            } 
            else{

                print json_encode(
                array(
                'estado' => '2',
                'mensaje' => 'El usuario no existe'));
                } 
            }
            
        } else {
            print json_encode(
                    array(
                    'estado' => '3',
                    'mensaje' => 'falta get'));
        } 
?>