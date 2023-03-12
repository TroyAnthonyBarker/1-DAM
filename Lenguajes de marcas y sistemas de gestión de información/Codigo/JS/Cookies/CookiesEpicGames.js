const contenedor = document.getElementById('containerCookies');
const limitedCookiesInfo = document.getElementById('limitedInformationOnCookies');
const unlimitedCookiesInfo = document.getElementById('unlimitedInformationOnCookies');
const cookies = document.getElementsByName('cookies');


// Comprueba si ya se han acceptado las cookies

if (!(localStorage.getItem("almacenar") == "true")){
    let acceptCookies = confirm("Ver cookies");
    if (acceptCookies){
        contenedor.style.visibility = 'visible';
        limitedCookiesInfo.style.visibility = 'visible';
    } else {
        closeWindow();
    }
} else logCookies();

function closeWindow(){     //Cierra la pestaña del navegador
    window.close();
}

function acceptConfiguration(){         //Guarda las cookies seleccionadas 
    for (var i = 0; i < cookies.length; i++){
        if (cookies[i].checked) crearCookie(cookies[i].id, "true")
    }
    hideCookies();
    logCookies();
}

function acceptAllCookies(){            //Guarda todas las cookies
    for (var i = 0; i < cookies.length; i++){
        crearCookie(cookies[i].id, "true")
    }
    hideCookies();
    logCookies();
}

function showCookieConfiguration(){     //Muestra la configuración de cookies
    limitedCookiesInfo.style.visibility = 'hidden';
    unlimitedCookiesInfo.style.visibility = 'visible';
}

function hideCookies(){                 //Esconde el popup de las cookies
    contenedor.style.visibility = 'hidden';
    limitedCookiesInfo.style.visibility = 'hidden';
    unlimitedCookiesInfo.style.visibility = 'hidden';
}

function crearCookie(nombre, valor) {   //Crea las cookies utilizando como key el nombre que le pasas y como value el valor que le pasas
    localStorage.setItem(nombre, valor);
}

function logCookies(){                  //Envía a la consola las cookies que tienes acceptadas
    var cookie = "Cookies:\n"
    for (var i = 0; i < cookies.length; i++){
        cookie += cookies[i].id + ": " + localStorage.getItem(cookies[i].id) + "\n"
    }
    console.log(cookie)
}