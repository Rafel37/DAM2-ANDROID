<?php

    require 'OperacionesAlumnos.php';

    if ($_SERVER['REQUEST_METHOD']=='GET') {
        $parametro1 = $_GET['nombre'];

        $retorno = Operaciones::borrarAlumno($parametro1); 
        if ($retorno) {
            print json_encode(
                array(
                    'estado' => '1',
                    'mensaje' => 'Alumno borrado con exito'
                )
            );
        } else {

            print json_encode(
                array(
                    'estado' => '2',
                    'mensaje' => 'Alumno no borrado'
                )
            );
        }  

    } else {
        print json_encode(
                array(
                    'estado' => '3',
                    'mensaje' => 'No se obtuvo el parametro'
                )
            );
    }

/*BORRAR COMPROBANDO SI EL USUARIO EXISTE
<?php
    
    require 'OperacionesAlumnos.php';

    if ($_SERVER['REQUEST_METHOD'] == 'GET') {
        if(isset($_GET['nombre'])) {
            # code...
            $parametro = $_GET['nombre'];
            $consulta = Operaciones::getAlumno($parametro);
                if ($consulta) {

                    $consulta2 = Operaciones::borrarAlumno($parametro);
                    $consulta2;
                    print json_encode(
                    array(
                    'estado' => '1',
                    'mensaje' => 'El usuario existía y ha sido borrado'));
                } 
                else{

                    print json_encode(
                    array(
                    'estado' => '2',
                    'mensaje' => 'El usuario no existe'));
                    } 
            }       
        }
     else {
        print json_encode(
                    array(
                    'estado' => '3',
                    'mensaje' => 'falta get'));
                    } 
?>
*/
?>