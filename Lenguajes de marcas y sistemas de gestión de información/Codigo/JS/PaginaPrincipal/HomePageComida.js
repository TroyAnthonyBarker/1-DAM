var counter = 1;
setInterval(
    function(){
        document.getElementById('Slider' + counter).checked=true;
        counter++;
        if (counter > 5) {
            counter = 1
        }
    }, 3000
);
