function enviarFormulario() {
    var formulario = document.getElementsByClassName("form");
    var suma = 0;

    for (var i = 0; i < formulario.length; i++) {
        if (formulario[i] != NaN) {
           suma += parseFloat(formulario[i].value); 
        }
    }

    document.getElementById("resultado").value = suma
    console.log(suma)
}
