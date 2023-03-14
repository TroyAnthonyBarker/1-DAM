const local = 'en-EN';

const hoy = new Date();
const diaActualString = hoy.getDay();
const diaActualNum = hoy.getDate();
const mesActual = hoy.getMonth();
const anyoActual = hoy.getFullYear();

var mes = mesActual;
var anyo = anyoActual;

const meses = [...Array(12).keys()];
const intlMes = new Intl.DateTimeFormat(local, {month: "long"});

const diasDeLaSemana = [...Array(7).keys()];
const intlDia = new Intl.DateTimeFormat(local, {weekday: "short"});

const nombreDeLosDiasDeLaSemana = diasDeLaSemana.map(diaKey => {
    var nombreDelDiaDeLaSemana = intlDia.format(new Date(2023, 4, diaKey + 1));
    nombreDelDiaDeLaSemana = nombreDelDiaDeLaSemana[0].toUpperCase() + nombreDelDiaDeLaSemana.substring(1);
    return nombreDelDiaDeLaSemana;
})

const renderizadorDeNombresDeDias = nombreDeLosDiasDeLaSemana.map(rendNombreDia => {
    return `<li class='nombreDia'>${rendNombreDia}</li>`
}).join('')

function actualizaMes(){
    var dias = [...Array(new Date(anyo, mes+1, 0).getDate()).keys()];       // Días del mes a mostrar
    var primerDia = new Date(anyo, mes, 1).getDay();                        // Identifica el primer Día del mes
    var fechaRef = new Date(anyo, mes)                                      // Identifica el año y el mes a mostrar
    var nombreDelMes = intlMes.format(fechaRef);                            // Cambia el mes de numero a String (0 -> Enero)
    var eventos = getEvent();

    console.log("Primer log eventos");
    console.log(eventos);

    console.log("Fecha de referencia");
    console.log(fechaRef)


    nombreDelMes = nombreDelMes[0].toUpperCase() + nombreDelMes.substring(1);   // Hace que la primera letra sea mayuscula


    var clasePrimerAtributo = `class='dias primerDia' style='--primerDia: ${primerDia}'`;   // Añade una custom property para indicar en que día de la semana empieza el mes
    var claseHoy = `id="hoy`;       // Identifica si es Hoy
    
    var renderizadorDeDias = dias.map(              // Renderiza los días del mes
        (dia, contador)=>{
            return `<li ${contador == 0 ? clasePrimerAtributo: ''} class="dias" ${diaActualNum == (dia + 1) && mesActual == mes && anyoActual == anyo ? claseHoy: ''}>${dia+1}<p></p></li>`
        }
    ).join('')
    

    return {
        nombreDelMes,
        renderizadorDeDias,
        fechaRef
    }
}

function html() {
    var nombre = actualizaMes().nombreDelMes;
    var dias = actualizaMes().renderizadorDeDias;
    var fechaRef = actualizaMes().fechaRef;
    return ` <article>
    <h1>
        <button onclick='decrementar()'>&#x2b9c</button>
        ${nombre} ${fechaRef.getFullYear()}
        <button onclick='incrementar()'>&#x2b9e</button>
    </h1>
    <ol>
        ${renderizadorDeNombresDeDias} ${dias}
    </ol>
    </article>
    `
};

document.getElementById("cambiaCalendario").innerHTML = html();

function incrementar(){
    mes++;
    update();
}
function decrementar(){
    mes--;
    update();
}

function update(){
    document.getElementById("cambiaCalendario").innerHTML = html();
}

update();

const contenedorCrearEvento = document.getElementById("containerCrearEvento")

function hideCreateEvento(){
    contenedorCrearEvento.style.visibility = 'hidden';
    var fechaEvento = document.getElementById("fechaEvento");
    var nombre = document.getElementById("nombreEvento");
    var descripcion = document.getElementById("descripcionEvento");
    fechaEvento.value ='';
    nombre.value = '';
    descripcion.value = '';
}

function showCreateEvento(){
    contenedorCrearEvento.style.visibility = 'visible';
}

function createEvento(){
    var fecha = new Date(document.getElementById("fechaEvento").value);
    var nombre = document.getElementById("nombreEvento").value;
    var descripcion = document.getElementById("descripcionEvento").value;
    var event = new Evento(fecha, nombre, descripcion);
    event.createEvent();
    hideCreateEvento();
    event.getEvent();
}

function getEvent() {
    var eventos = [];
    $.ajax({
        url: '../../PHP/Calendario/RequestCalendarioComida.php',
        type: 'GET',
        dataType: 'json',
        success: function(response) {
            $.each(response, function(index, event) {
                eventos.push(event);
            });
        },
        error: function(xhr, status, error) {
            console.log(xhr.responseText);
        }
    });
    return eventos;
}
