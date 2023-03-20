const local = 'en-EN';

const hoy = new Date();
const diaActualString = hoy.getDay();
const diaActualNum = hoy.getDate();
const mesActual = hoy.getMonth();
const anyoActual = hoy.getFullYear();

const hardCodedEvents = [
    /* EVENTO 1 */ {
    id: 1,
    fecha: new Date("2022-12-15"),
    nombre: "Evaluaciones",
    descripcion: "Evaluaciones del primer trimestre"
    },
    /* EVENTO 2 */ {
    id: 2,
    fecha: new Date("2023-03-21"),
    nombre: "Evaluaciones",
    descripcion: "Evaluaciones del segundo trimestre"
    },
    /* EVENTO 3 */ {
    id: 3,
    fecha: new Date("2023-06-13"),
    nombre: "Evaluaciones",
    descripcion: "Evaluaciones del tercer trimestre"
    },
    /* EVENTO 4 */ {
    id: 4,
    fecha: new Date("2023-06-21"),
    nombre: "Fin de curso",
    descripcion: "Final de curso 1ºDAM"
}];

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


    nombreDelMes = nombreDelMes[0].toUpperCase() + nombreDelMes.substring(1);   // Hace que la primera letra sea mayuscula


    var clasePrimerAtributo = `class='dias primerDia' style='--primerDia: ${primerDia}'`;   // Añade una custom property para indicar en que día de la semana empieza el mes
    var claseHoy = `id="hoy"`;       // Identifica si es Hoy
    
    
    var renderizadorDeDias = dias.map(              // Renderiza los días del mes
        (dia, contador)=>{
            var li = "";
            hardCodedEvents.forEach(event => {
                if(event.fecha.getMonth() == fechaRef.getMonth() && event.fecha.getFullYear() == fechaRef.getFullYear() && event.fecha.getDate() == (dia+1)){
                    var idEvent = "Event"+event.id;
                    if(event.fecha.getDate()-hoy.getDate() >= 0 && event.fecha.getDate()-hoy.getDate() <= 7){
                        li = `<li ${contador == 0 ? clasePrimerAtributo: ''} class="dias events lessThanOneWeek" ${dia+1 == diaActualNum && mes == mesActual && anyo == anyoActual ? claseHoy: ''} id="${idEvent}" onclick="showEvent(this)">${dia+1}<p>${event.nombre}</p></li>`;
                    } else{
                        li = `<li ${contador == 0 ? clasePrimerAtributo: ''} class="dias events" ${dia+1 == diaActualNum && mes == mesActual && anyo == anyoActual ? claseHoy: ''} id="${idEvent}" onclick="showEvent(this)">${dia+1}<p>${event.nombre}</p></li>`;
                    }
                }
            });
            if (li == "") li = `<li ${contador == 0 ? clasePrimerAtributo: ''} class="dias" ${dia+1 == diaActualNum && mes == mesActual && anyo == anyoActual ? claseHoy: ''}>${dia+1}<p></p></li>`;
            return li;
        }
    ).join('')
    

    return {
        nombreDelMes,
        renderizadorDeDias,
        fechaRef
    }
}

function prueba(){
    getEvent().then(function(eventos) {
        eventos.forEach(event => {
            console.log(event.nombre + " fecha " + event.fecha);
        });
    });;
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

const containerEventos = document.getElementById("containerEventos");
const showEventContainer = document.getElementById("showEvent");
const containerCreateEvent = document.getElementById("containerCreateEvent");
const containerShowEvent = document.getElementById("containerShowEvent");

function hideCreateEvento(){
    containerEventos.style.visibility = 'hidden';
    showEventContainer.style.visibility = 'hidden';
    containerCreateEvent.style.visibility = 'hidden';
    containerShowEvent.style.visibility = 'hidden';
    var fechaEvento = document.getElementById("fechaEvento");
    var nombre = document.getElementById("nombreEvento");
    var descripcion = document.getElementById("descripcionEvento");
    fechaEvento.value ='';
    nombre.value = '';
    descripcion.value = '';
}

function showCreateEvento(){
    containerEventos.style.visibility = 'visible';
    containerCreateEvent.style.visibility = 'visible';
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

function getJSONData() {
    return new Promise(function(resolve, reject) {
        $.ajax({
            url: '../../PHP/Calendario/RequestCalendarioComida.php',
            type: 'GET',
            dataType: 'json',
            success: function(response) {
                resolve(response);
            },
            error: function(xhr, status, error) {
                reject(error);
            }
        });
    });
}

function getEvent() {
    return getJSONData().then(function(data) {
        var eventos = [];
        $.each(data, function(index, object) {
            eventos.push(object);
        });
        return eventos;
    }).catch(function(error) {
        console.log(error);
    });
}

function showEvent(element){
    containerEventos.style.visibility = 'visible';
    containerShowEvent.style.visibility = 'visible';
    showEventContainer.style.visibility = 'visible';
    var id = element.id;
    var eventHTML;
    hardCodedEvents.forEach(event =>{
        var idEvent = "Event"+event.id;
        if (id == idEvent){
            console.log(id + ' ' + idEvent)
            eventHTML = `<section class="x">
            <img src="../../IMG/Calendario/X.png" alt="X" onclick="hideCreateEvento()">
        </section>
        <p class="titulos">Event</p>
        <section>
            <p class="subtitulos">Date</p>
            <div id="contenedorFecha">
                <input type="date" name="" id="fechaEvento" disabled value="${event.fecha.toISOString().substring(0,10)}">
            </div>
        </section>
        <section>
            <p class="subtitulos">Name</p>
            <input type="text" name="nombre" id="nombreEvento" disabled value="${event.nombre}">
        </section>
        <section>
            <p class="subtitulos">Description</p>
            <textarea name="descripcion" id="descripcionEvento" disabled>${event.descripcion}</textarea>
        </section>`;
        }
    })
    console.log(eventHTML)
    showEventContainer.innerHTML = '';
    showEventContainer.innerHTML = eventHTML;
}