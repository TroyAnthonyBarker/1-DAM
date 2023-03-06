<?php
    $host     = "localhost";
    $user     = "root";
    $password = "";
    $database = "calendario_bd";
    $conexion = mysqli_connect($host, $user, $password, $database);
    mysqli_set_charset($conexion, "utf8");
?>