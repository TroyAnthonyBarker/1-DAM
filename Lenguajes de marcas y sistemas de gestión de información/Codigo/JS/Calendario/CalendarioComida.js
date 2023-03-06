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
    var dias = [...Array(new Date(anyo, mes+1, 0).getDate()).keys()];
    var primerDia = new Date(anyo, mes, 1).getDay();
    var fechaRef = new Date(anyo, mes)
    var nombreDelMes = intlMes.format(fechaRef);
    nombreDelMes = nombreDelMes[0].toUpperCase() + nombreDelMes.substring(1);
    var clasePrimerAtributo = `class='dias primerDia' style='--primerDia: ${primerDia}'`;
    var claseHoy = `id="hoy"`
    var renderizadorDeDias = dias.map(
        (dia, contador)=>{
            if (dia+1 ==1){
                return `<li ${contador == 0 ? clasePrimerAtributo: ''} class="dias" ${diaActualNum == (dia + 1) && mesActual == mes && anyoActual == anyo ? claseHoy: ''}>${dia+1}<p class="evento">Hola</p></li>`
            } else {
                return `<li ${contador == 0 ? clasePrimerAtributo: ''} class="dias" ${diaActualNum == (dia + 1) && mesActual == mes && anyoActual == anyo ? claseHoy: ''}>${dia+1}<p></p></li>`
            }
        }
    ).join('')

    console.log(renderizadorDeDias)

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
    /*var diaEvento = document.getElementById("dia");
    var mesEvento = document.getElementById("mes");
    var anyoEvento = document.getElementById("anyo");*/
    var fechaEvento = document.getElementById("fechaEvento");
    var nombre = document.getElementById("nombreEvento");
    var descripcion = document.getElementById("descripcionEvento");
    /*diaEvento.value = '';
    mesEvento.value = '';
    anyoEvento.value = '';*/
    fechaEvento.value ='';
    nombre.value = '';
    descripcion.value = '';
}

function showCreateEvento(){
    contenedorCrearEvento.style.visibility = 'visible'
}

function createEvento(){
    var fecha = new Date(document.getElementById("fechaEvento").value);
    var nombre = document.getElementById("nombreEvento").value;
    var descripcion = document.getElementById("descripcionEvento").value;
    if (descripcion){
        var evento = new Evento(fecha, nombre);
    }else{
        var evento = new Evento(fecha, nombre, descripcion);
    }
    hideCreateEvento();
}

