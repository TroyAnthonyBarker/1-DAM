function cambiaColor() {
    var uno = document.getElementById("top");
    var dos = document.getElementById("bottom");
    var tres = document.getElementById("text");
    var randomColor1 = Math.floor(Math.random()*16777215).toString(16);
    var randomColor2 = Math.floor(Math.random()*16777215).toString(16);
    var randomColor3 = Math.floor(Math.random()*16777215).toString(16);

    uno.style.borderColor= "#" + randomColor1;
    dos.style.borderColor= "#" + randomColor2;
    tres.style.color= "#" + randomColor3;
}