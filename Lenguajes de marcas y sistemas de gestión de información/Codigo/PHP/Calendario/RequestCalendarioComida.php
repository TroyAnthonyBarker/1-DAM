<?php
    require("../Calendario/ConexionCalendarioComida.php");
    $query = "SELECT * FROM eventos";
    $message = '';
    $sql = mysqli_query($conexion, $query);

    while($result = mysqli_fetch_array($sql)) {
        $id = $result['id'];
        $fechaEvento = $result['fecha'];
        $nombre = $result['nombre'];
        if ($result['descripcion'] != null) $descripcion = $result['descripcion'];
        else $descripcion = '';
        $message .= '
            <p>'.$id.'</p>
            <p>'.$fechaEvento.'</p>
            <p>'.$nombre.'</p>
            <p>'.$descripcion.'</p>
        '
    }
    echo $message;
?>