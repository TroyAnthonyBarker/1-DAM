<?php
    $fechaEvento = $_POST["fechaEvento"];
    $nombre = $_POST["nombre"];
    $descripcion = $_POST["descripcion"];
    require("../Calendario/ConexionCalendarioComida.php");
    require("../Calendario/RequestCalendarioComida.php")
    $sql = "DROP INTO eventos(fecha, nombre, descripcion) VALUES ('$fechaEvento', '$nombre', '$descripcion')";
    mysqli_query($conexion, $sql);
    echo 1;
?>