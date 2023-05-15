

function diceRoll() {
    var player1 = 0;
    var player2 = 0;
    var dicePlayer1 = parseInt(document.getElementById("numSelect1").value)
    var dicePlayer2 = parseInt(document.getElementById("numSelect2").value)
    var imgPlayer1 = ``;
    var imgPlayer2 = ``;
    console.log(dicePlayer1)
    for (let index = 0; index < dicePlayer1; index++) {
        let randomNumber = parseInt(Math.random() * 6 + 1);
        player1 += randomNumber;
        var dice = "d"+randomNumber+".jpg"
        imgPlayer1 += `<section><img src="../../IMG/dados/${dice}" alt="${randomNumber}"></section>`
        
    }
    for (let index = 0; index < dicePlayer2; index++) {
        let randomNumber = parseInt(Math.random() * 6 + 1);
        player2 += randomNumber;
        var dice = "d"+randomNumber+".jpg"
        imgPlayer2 += `<section><img src="../../IMG/dados/${dice}" alt="${randomNumber}"></section>`;
        
    }
    console.log(imgPlayer1)
    document.getElementById("Player1List").innerHTML = imgPlayer1;
    document.getElementById("Player2List").innerHTML = imgPlayer2;
    winner(player1, player2)
}

function winner(player1, player2){
    if (player1 > player2){
        document.getElementById("winner").innerHTML = `<p>Player 1 wins</p>`;
    } else if (player2 > player1){
        document.getElementById("winner").innerHTML =`<p>Player 2 wins</p>`;
    } else {
        document.getElementById("winner").innerHTML = `<p>Draw</p>`;
    }
}

