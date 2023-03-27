const local = 'en-EN';

const hoy = new Date();
const diaActualString = hoy.getDay();
const diaActualNum = hoy.getDate();
const mesActual = hoy.getMonth();
const anyoActual = hoy.getFullYear();

const containerEventos = document.getElementById("containerEventos");
const showEventContainer = document.getElementById("showEvent");
const containerCreateEvent = document.getElementById("containerCreateEvent");
const containerShowEvent = document.getElementById("containerShowEvent");

const meses = [...Array(12).keys()];
const intlMes = new Intl.DateTimeFormat(local, {month: "long"});

const diasDeLaSemana = [...Array(7).keys()];
const intlDia = new Intl.DateTimeFormat(local, {weekday: "short"});

const nombreDeLosDiasDeLaSemana = diasDeLaSemana.map(diaKey => {
    var nombreDelDiaDeLaSemana = intlDia.format(new Date(2023, 4, diaKey + 1));
    nombreDelDiaDeLaSemana = nombreDelDiaDeLaSemana[0].toUpperCase() + nombreDelDiaDeLaSemana.substring(1);
    return nombreDelDiaDeLaSemana;
});

const renderizadorDeNombresDeDias = nombreDeLosDiasDeLaSemana.map(rendNombreDia => {
    return `<li class='nombreDia'>${rendNombreDia}</li>`
}).join('');

var mes = mesActual;
var anyo = anyoActual;

function actualizaMes(eventos){
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
            eventos.forEach(event => {
                event.fecha.substring()
                var string = event.fecha.split();
                var fechaTemp = new Date(string[2], string[1], string[0])
                if(fechaTemp.getMonth() == fechaRef.getMonth() && fechaTemp.getFullYear() == fechaRef.getFullYear() && fechaTemp.getDate() == (dia+1)){
                    var idEvent = "Event"+event.id;
                    if(fechaTemp.getDate()-hoy.getDate() >= 0 && fechaTemp.getDate()-hoy.getDate() <= 7 && fechaTemp.getMonth() == mesActual && fechaTemp.getFullYear() == anyoActual){
                        li = `<li ${contador == 0 ? clasePrimerAtributo: ''} class="dias events lessThanOneWeek" ${dia+1 == diaActualNum && mes == mesActual && anyo == anyoActual ? claseHoy: ''} id="${idEvent}" onclick="showEvent(this)">${dia+1}<p>${event.nombre}</p></li>`;
                    } else{
                        li = `<li ${contador == 0 ? clasePrimerAtributo: ''} class="dias events" ${dia+1 == diaActualNum && mes == mesActual && anyo == anyoActual ? claseHoy: ''} id="${idEvent}" onclick="showEvent(this)">${dia+1}<p>${event.nombre}</p></li>`;
                    }
                }
            });
            if (li == "") li = `<li ${contador == 0 ? clasePrimerAtributo: ''} class="dias" ${dia+1 == diaActualNum && mes == mesActual && anyo == anyoActual ? claseHoy: ''}>${dia+1}<p></p></li>`;
            return li;
        }
    ).join('');
    
    return {
        nombreDelMes,
        renderizadorDeDias,
        fechaRef
    };
};

function html() {
    getEvent().then(function(eventos){
        var renderizado = actualizaMes(eventos);
        var nombre = renderizado.nombreDelMes;
        var dias = renderizado.renderizadorDeDias;
        var fechaRef = renderizado.fechaRef;
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
    });
};

function incrementar(){
    mes++;
    update();
};

function decrementar(){
    mes--;
    update();
};

function update(){
    document.getElementById("cambiaCalendario").innerHTML = html();
};

update();

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
};

function showCreateEvento(){
    containerEventos.style.visibility = 'visible';
    containerCreateEvent.style.visibility = 'visible';
};

function createEvento(){
    var fecha = new Date(document.getElementById("fechaEvento").value);
    var nombre = document.getElementById("nombreEvento").value;
    var descripcion = document.getElementById("descripcionEvento").value;
    var event = new Evento(fecha, nombre, descripcion);
    event.createEvent();
    hideCreateEvento();
};

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
};

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