const favicon = `<link rel="shortcut icon" href="../../IMG/Comun/ComidaFavicon.ico" type="image/x-icon">`;
const cssComun = `<link rel="stylesheet" href="../../CSS/Comun/Comun.css">`;

document.head.innerHTML = favicon + cssComun + document.head.innerHTML;

document.querySelector('header').innerHTML = `<nav class="Sinfondo">
<li><a href="" class="Sinfondo"><img src="../../IMG/Comun/menu.png" alt="Menú Desplegable"></a>
    <ul class="Place">
        <li><a href="../PaginaPrincipal/HomePageComida.html">Inicio</a></li>
        <li><a href="../CVexterno/CurriculoGordonJamesRamsay.html">CV Externo</a></li>
        <li><a href="../Escala/Escala-Comida.html">Escala</a></li>
        <li><a href="../Frases/FrasesComida.html">Frases</a></li>
        <li><a href="../Dialogo/DialogoComida.html">Diálogo</a></li>
        <li><a href="../Comparativa/ComparativaComida.html">Comparativas</a></li>
        <li><a href="../Resenyas/ResenasComida.html">Reseñas</a> </li>
        <li><a href="../Obras/ObrasComida.html">Obras</a></li>
        <li><a href="../Formulario/FormularioComida.html">Formulario</a></li>
        <li><a href="../Calendario/CalendarioComida.html">Calendario</a></li>
        <li><a href="../Historia/HistoriaComida.html">Historia</a></li>
    </ul>
</li>
</nav>
<h1><a href="../PaginaPrincipal/HomePageComida.html">Comida</a></h1>
`;