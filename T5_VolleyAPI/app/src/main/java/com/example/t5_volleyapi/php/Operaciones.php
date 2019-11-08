<?php

	require 'Database.php';
	
	class Operaciones {

		function __construct()
		{
			
		}

		public static function getAlumno($nombre){
            $consulta = "SELECT * FROM usuario WHERE nombre = ?";

            try {
            $comando = Database::getInstance()->getDb()->prepare($consulta);
            $comando->execute(array($nombre));
            $row = $comando->fetch(PDO::FETCH_ASSOC);
            return $row;

            } catch (PDOException $e) {
             return -1;
            }
        }

        public static function getAlumnos(){
            $comando = 'SELECT * FROM usuarios';
            $sentencia = Database::getInstance()->getDb()->prepare($comando);
            $sentencia ->execute();
            return $sentencia->fetchAll(PDO::FETCH_ASSOC);
        }

		public static function insertarAlumno($nombre, $apellidos, $correo, $contrasena, $curso, $conocimiento_previo) {

            $comando = 'INSERT INTO usuarios (nombre, apellidos, correo, contrasena, curso, conocimiento_previo) VALUES (?,?,?,?,?,?)';

            $sentencia = Database::getInstance()->getDb()->prepare($comando);
            return $sentencia->execute(array(
                    $nombre,
                    $apellidos,
                    $correo,
                    $contrasena,
                    $curso,
                    $conocimiento_previo));
        }

		public static function borrarAlumno($nombre) {

            $comando = 'DELETE FROM usuarios WHERE nombre=?';

            $sentencia = Database::getInstance()->getDb()->prepare($comando);
            return $sentencia->execute(array($nombre));
        }

        public static function borrarAlumnoCompleto($nombre) {

            $comando = 'DELETE FROM usuarios WHERE id = (SELECT id WHERE nombre =?)';

            $sentencia = Database::getInstance()->getDb()->prepare($comando);
            return $sentencia->execute(array($nombre));
        }

        public static function actualizarAlumno($nombre,$nombreN) {

            $comando = 'UPDATE usuarios SET nombre = ? WHERE nombre=?';

            $sentencia = Database::getInstance()->getDb()->prepare($comando);
            return $sentencia->execute(array($nombreN,$nombre));
        }
        
	}
?>