<?php
    // Establecer las variables de conexión
    $host     = "localhost";                                        
    $user     = "root";
    $password = "";
    $database = "calendario_bd";
    
    // Establecer la conexión con la base de datos
    $conexion = mysqli_connect($host, $user, $password, $database);
    
    // Establecer el conjunto de caracteres para la conexión
    mysqli_set_charset($conexion, "utf8");
?>

