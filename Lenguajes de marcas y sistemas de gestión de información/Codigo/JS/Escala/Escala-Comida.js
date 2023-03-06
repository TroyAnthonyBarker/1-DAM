// Obtener una referencia al elemento canvas del DOM
const $grafica = document.querySelector("#Nutricion");
// Las etiquetas son las porciones de la gráfica
const etiquetas = ["Carbohydrates", "Fats", "Proteins, vitamins, minerals and fibers"]
// Podemos tener varios conjuntos de datos. Comencemos con uno
const datosIngresos = {
    data: [55, 30, 15], // La data es un arreglo que debe tener la misma cantidad de valores que la cantidad de etiquetas
    // Ahora debería haber tantos background colors como datos, es decir, para este ejemplo, 4
    backgroundColor: [
        'rgba(232, 195, 158)',
        'rgba(245, 245, 245)',
        'rgba(255, 168, 80)',
    ],// Color de fondo
    borderColor: [
        'rgba(0, 0, 0)',
        'rgba(0, 0, 0)',
        'rgba(0, 0, 0)',
    ],// Color del borde
    borderWidth: 1,// Ancho del borde
};
new Chart($grafica, {
    type: 'pie',// Tipo de gráfica. Puede ser dougnhut o pie
    data: {
        labels: etiquetas,
        datasets: [
            datosIngresos,
            // Aquí más datos...
        ]
    },
});