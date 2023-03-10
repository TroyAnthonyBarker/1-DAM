const contenedor = document.getElementById('containerCookies');
const limitedCookiesInfo = document.getElementById('limitedInformationOnCookies');
const unlimitedCookiesInfo = document.getElementById('unlimitedInformationOnCookies');

if (!(localStorage.getItem("Necessary") == "true")){
    let acceptCookies = confirm("Ver cookies");
    if (acceptCookies){
        contenedor.style.visibility = 'visible';
        limitedCookiesInfo.style.visibility = 'visible';
    } else {
        closeWindow();
    }
}

function closeWindow(){
    window.close();
}

function acceptNecessary(){
    contenedor.style.visibility = 'hidden';
    unlimitedCookiesInfo.style.visibility = 'hidden';
    crearCookie("Necessary", "true")
}

function showCookies(){
    limitedCookiesInfo.style.visibility = 'hidden';
    unlimitedCookiesInfo.style.visibility = 'visible';
}

function crearCookie(nombre, valor) {
    localStorage.setItem(nombre, valor);
  }