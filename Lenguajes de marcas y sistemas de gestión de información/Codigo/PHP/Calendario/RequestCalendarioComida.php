<?php
// Conexión a la base de datos MySQL
    require("../Calendario/ConexionCalendarioComida.php");

// Consulta SQL para recuperar los usuarios
    $query = "SELECT * FROM eventos";
    $result = mysqli_query($conexion, $query);

// Obtener los resultados de la consulta y almacenarlos en un array
    $eventos = array();
    while ($row = mysqli_fetch_assoc($result)) {
        $eventos[] = $row;
    }

// Devolver los datos como JSON
    header('Content-Type: application/json');
    echo json_encode($eventos);

// Cerrar la conexión a la base de datos MySQL
    mysqli_close($conexion);
?>
