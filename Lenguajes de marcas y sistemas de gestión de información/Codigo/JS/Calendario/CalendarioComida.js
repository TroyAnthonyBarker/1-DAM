/*
@AUTOR: TROY ANTHONY BARKER
@REVISOR: 
DESCRIPCIÓN: "PREGUNTAR A IVAN"
RIESGOS: 
*/

//DECLARACIÓN DE CONSTANTES DEL JAVASCRIPT
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


//DECLARACIÓN DE VARIABLES DEL JAVASCRIPT
var mes = mesActual;
var anyo = anyoActual;


//LA FUNCIÓN ACTUALIZAMES RENDERIZA LOS DIAS DEL MES, EL NOMBRE DEL MES Y EL AÑO DEL MES
function actualizaMes(eventos){
    var dias = [...Array(new Date(anyo, mes+1, 0).getDate()).keys()];       // Días del mes a mostrar
    var primerDia = new Date(anyo, mes, 1).getDay();                        // Identifica el primer Día del mes
    var fechaRef = new Date(anyo, mes)                                      // Identifica el año y el mes a mostrar
    var nombreDelMes = intlMes.format(fechaRef);                            // Cambia el mes de numero a String (0 -> Enero)


    nombreDelMes = nombreDelMes[0].toUpperCase() + nombreDelMes.substring(1);   // Hace que la primera letra sea mayuscula


    var clasePrimerAtributo = `class='dias primerDia' style='--primerDia: ${primerDia}'`;   // Añade una custom property para indicar en que día de la semana empieza el mes
    var claseHoy = `id="hoy"`;       // Identifica si es Hoy
    
    //COMPRUEBA EN CADA DÍA SI HAY UN EVENTO GUARDADO EN EL ARRAY "EVENTOS"
    var renderizadorDeDias = dias.map(              // Renderiza los días del mes
        (dia, contador)=>{
            var li = "";
            eventos.forEach(event => {
                var fechaTemp = new Date(event.fecha);
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

// ES UNA FUNCIÓN QUE INSERTA EN EL HTML UN CÓDIGO GENERADO EN ESTE JAVASCRIPT
function html() {
    return getEvent().then(function(eventos){
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

// ESTA FUNCIÓN INCREMENTA EL VALOR DE LA VARIABLE MES POR UNO
function incrementar(){
    mes++;
    update();
};

// ESTA FUNCIÓN DECREMENTA EL VALOR DE LA VARIABLE MES POR UNO
function decrementar(){
    mes--;
    update();
};

// ESTA FUNCIÓN ACTUALIZA EL HTML DEL CALENDARIO
function update(){
    html().then(function(calendario){
        document.getElementById("cambiaCalendario").innerHTML = calendario;
    });
};

update();

// ESCONDE UN DIV QUE CONTIENE "CREAR EVENTO"
function hideCreateEvento(){
    update();
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

// MUESTRA UN DIV QUE CONTIENE "CREAR EVENTO"
function showCreateEvento(){
    containerEventos.style.visibility = 'visible';
    containerCreateEvent.style.visibility = 'visible';
};

// RECOGE LOS DATOS DEL FORMULARIO "CREAR EVENTO" Y DECLARA E INSTANCIA UN OBJETO "EVENTO"
function createEvento(){
    var fecha = new Date(document.getElementById("fechaEvento").value);
    var nombre = document.getElementById("nombreEvento").value;
    var descripcion = document.getElementById("descripcionEvento").value;
    var event = new Evento(fecha, nombre, descripcion);
    event.createEvent();    // UTILIZA LA FUNCIÓN "CREATE EVENT" DE LA CLASE EVENTO PARA SUBIR EL EVENTO A LA BD
    hideCreateEvento();
};

// MUESTRA UN EVENTO ESPECIFICO
function showEvent(element){
    getEvent().then(function(eventos){
        containerEventos.style.visibility = 'visible';
        containerShowEvent.style.visibility = 'visible';
        showEventContainer.style.visibility = 'visible';
        var id = element.id;
        var eventHTML;
        eventos.forEach(event =>{
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
                    <input type="date" name="" id="fechaEvento" disabled value="${event.fecha}">
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
        showEventContainer.innerHTML = eventHTML;
    });
};

// CONSULTA LA BD Y RECUPERA UN ARRAY EN FORMATO JSON DE TODOS LOS EVENTOS ALMACENADOS
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

//  LLAMA LA FUNCIÓN "getJSONData" Y PASA EL ARRAY DE JSON A UN ARRAY DE JAVASCRIPT
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