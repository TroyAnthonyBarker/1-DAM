let acceptCookies = confirm("Ver cookies");
var contenedor = document.getElementById('containerCookies');

alert(acceptCookies);

if (acceptCookies){
    contenedor.style.display = 'visible'
} else {
    window.close()
}

