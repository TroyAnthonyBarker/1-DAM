/**
Diseña un programa Java que cree un tipo enumerado para los meses del año. El 
programa debe realizar las siguientes operaciones:
• Crear una variable m del tipo enumerado y asignarle el mes de marzo. 
Mostrar por pantalla su valor
 */

public class Ejercicio4 {
    //Declara una variable que solo puede tener de valor los siguientes parametros
    public enum meses {Enero, Febrero, Marzo, Abril, Mayo, Junio, Julio, Agosto, Septiembre, Octubre, Noviembre, Diciembre};
    public static void main(String[] args) {
    /**DATOS */
    meses m = meses.Marzo;

    /**ALGORITMO */
    //Muestra por pantalla
    System.out.println(m);
    }
}
