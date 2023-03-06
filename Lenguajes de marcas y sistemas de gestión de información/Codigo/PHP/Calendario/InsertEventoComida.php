<?php
    $fechaEvento = $_POST["fechaEvento"];
    $nombre = $_POST["nombre"];
    $descripcion = $_POST["descripcion"];

    require("ConexionCalendarioComida.php");
    $sql = "INSERT INTO eventos(fechaEvento, nombre, descripcion) VALUES ('$fechaEvento', '$nombre', '$descripcion')"
    mysqli_query($conexion, $sql);
    echo 1;
?>