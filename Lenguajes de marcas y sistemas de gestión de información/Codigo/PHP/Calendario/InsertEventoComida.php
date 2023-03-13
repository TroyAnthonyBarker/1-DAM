<?php
// Conexión a la base de datos MySQL
    require("../Calendario/ConexionCalendarioComida.php");

// Datos que recuperamos del fichero js al llamar a este fichero
    $fechaEvento = $_POST["fechaEvento"];
    $nombre = $_POST["nombre"];
    $descripcion = $_POST["descripcion"];

// Consulta SQL para insertar los eventos
    $sql = "INSERT INTO eventos(fecha, nombre, descripcion) VALUES ('$fechaEvento', '$nombre', '$descripcion')";
    mysqli_query($conexion, $sql);

// Devuelve 1 si la inserción se ha realizado con exito
    echo 1;

// Cerrar la conexión a la base de datos MySQL
    mysqli_close($conexion);
?>