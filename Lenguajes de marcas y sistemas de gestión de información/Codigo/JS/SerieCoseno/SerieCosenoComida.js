function enviarFormulario( bg    ) {
    var a = document.getElementById("a").value;
    var x = document.getElementById("x").value;
    var resultado = 0;
    var randomColor = Math.floor(Math.random()*16777215).toString(16);
    resultado++;
    console.log("x: " + x)
    console.log("a: " + a)
    console.log("cos: " + resultado)

    for (var i = 2; i <= x; i++) {
        var potencia = 1;
        var factorial = 1;
        var num = -1;
        for (var j = 1; j <= i; j++) {
            potencia *= a
            console.log("potencia: " + potencia)
        }
        for (var z = 2; z <= i; z++){
            factorial *= z;
            console.log("factorial: " + factorial)
        }
        for (var k = 0; k <= (potencia*i); k++){
            num *= k;
            console.log("algo: " + num)
        }

        resultado += num/factorial
        console.log("resultado: " + resultado)
    }
    console.log(potencia)
    console.log(factorial)
    console.log(resultado)
    

    document.getElementById("resultado").value = resultado

    document.body.style.backgroundColor = randomColor;
}
