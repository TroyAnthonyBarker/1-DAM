function enviarFormulario() {
    var x = document.getElementById("x").value;
    var k = document.getElementById("k").value;
    var resultado = x;
    resultado++;
    console.log("x: " + x)
    console.log("k: " + k)
    console.log("e: " + resultado)

    for (var i = 2; i <= k; i++) {
        var potencia = 1;
        var factorial = 1;
        for (var j = 1; j <=i; j++) {
            potencia *= x
            console.log("potencia: " + potencia)
        }
        for (var z = 2; z <= i; z++){
            factorial *= z;
            console.log("factorial: " + factorial)
        }
        resultado += potencia/factorial
        console.log("resultado: " + resultado)
    }
    console.log(potencia)
    console.log(factorial)
    console.log(resultado)
    

    document.getElementById("resultado").value = resultado
}
