const contenedorIMG = document.getElementById("containerIMG")
var img;

function expand(imgName){
    img = document.getElementById(imgName);
    contenedorIMG.style.visibility = 'visible'
    img.style.visibility = 'visible'
}

function hideIMG(){
    contenedorIMG.style.visibility = 'hidden'
    img.style.visibility = 'hidden'
}