class Evento {
    constructor(fechaEvento, nombre, descripcion){
        this.fechaEvento = fechaEvento.getFullYear() + '-' + ('0' + (fechaEvento.getMonth()+1)).slice(-2) + '-' + ('0' + fechaEvento.getDate()).slice(-2);
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    createEvent() {
        console.log("Datos de creacion de evento: "+this.fechaEvento + " " + this.nombre + " " + this.descripcion);
        $.support.cors = true;
        $.ajax({
            type: "POST",
            url: "../../PHP/Calendario/InsertEventoComida.php",
            data: { fechaEvento: this.fechaEvento, nombre: this.nombre, descripcion: this.descripcion },
            success: function (response) {
                if (response == 1) alert("Event created")
            },
            error: function (xhr, status, error) {
                console.log(xhr.responseText);
                console.log(status);
                console.log(error);
            }
        });    
    };
}



