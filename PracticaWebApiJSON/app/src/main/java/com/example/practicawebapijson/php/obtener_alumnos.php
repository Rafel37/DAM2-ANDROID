<?php

    require 'OperacionesAlumnos.php';

    if ($_SERVER['REQUEST_METHOD'] == 'GET'){

        $consulta = Operaciones::getAlumnos();
        if($consulta){
            $datos['estado']=1;
            $datos['usuarios']=$consulta;

            print json_encode($datos);
        }
        else{
            print json_encode(array(
                "estado" => 2,
                "mensaje" => "Ha ocurrido un error"
            ));
        }
    }   

?>