function Evento(fechaEvento, nombre){
    this.fechaEvento = fechaEvento;
    this.nombre = nombre;
    this.descripcion = "";
}

function Evento(fechaEvento, nombre, descripcion){
    this.fechaEvento = fechaEvento;
    this.nombre = nombre;
    this.descripcion = descripcion;
}

Evento.prototype.createEvento = function(){
    $.ajax({
        type: "POST",
        url: "../../PHP/Calendario/InsertEvento.php",
        data: {fechaEvento: this.fechaEvento, nombre: this.nombre, descripcion: this.descripcion},
        success: function (response){
            if (response == 1){
                alert("Evento creado")
            }
        }
    })
}

Evento.prototype.deleteEvento = function(){

}

Evento.prototype.getEvento = function() {

}