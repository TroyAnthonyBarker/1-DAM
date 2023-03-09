let acceptCookies = confirm("Ver cookies");
var contenedor = document.getElementById('containerCookies');

if (!localStorage.getItem('cookies')){
    alert(acceptCookies);

    if (acceptCookies){
        contenedor.style.visibility = 'visible';
    } else {
        closeWindow();
    }
}

function closeWindow(){
    window.close();
}

function acceptNecessary(){
    contenedor.style.visibility = 'hidden';
    localStorage.setItem("Hola", "algo.txt")
}

function showCookies(){
    var limitedCookiesInfo = document.getElementById('limitedInformationOnCookies');
    limitedCookiesInfo.style.visibility = 'hidden';
    var unlimitedCookiesInfo = document.getElementById('unlimitedInformationOnCookies');
    unlimitedCookiesInfo.style.visibility = 'visible';
}