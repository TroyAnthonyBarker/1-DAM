<?php
    $id = $_POST["id"];
    require("../Calendario/ConexionCalendarioComida.php");
    $sql = "DELETE FROM eventos WHERE id = $id";
    mysqli_query($conexion, $sql);
    echo 1;
?>