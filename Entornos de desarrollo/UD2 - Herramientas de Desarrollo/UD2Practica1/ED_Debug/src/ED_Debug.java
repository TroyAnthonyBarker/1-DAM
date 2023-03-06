public class ED_Debug {


    public static void funcion1() {

        int a=2;

        String string1 = "string1";

        String string2 = "string2";


        // Qué hacen estas dos líneas de código???

        string2= string2.substring(0, string2.length()-1); //Guarda el valor de string2 - la última posición
        string2=string2+"1"; //Guarda el valor de string2 y concatena 1 al final de la string

        // Esta función tiene errores
        // Por qué no va el ==  ???
        //Porque para comparar string se utiliza equal, debido a que con el == comparas la posición de memoria

        // Qué tengo que hacer para solucionarlo???
        // Tienes que utilizar la función String.equals

        if(string1.equals(string2)) {
            System.out.println("SON IGUALES " + a);

        }
        else {
            System.out.println("SON DIFERENTES");
        }



    }


    public static void funcion2() {

        System.out.println("--------------------");
        System.out.println("Esta es la función 2");
        System.out.println("Cómo hago la llamada para que funcione????");


    }



    public static void main(String[] args) {
        // TODO Auto-generated method stub

        int a = 3;
        int i;

        for(i = 0; i<10; i++)
            a *= i;

        System.out.println("El valor de a es: "+a);


        funcion1();


        //Esta función no me va ... ¿ por que ?
        // Por que en el método funcion2 lo has declarado como public y no lo has declarado como static
        //Al ser el main static tienes que declararlo como static

        // Tengo dos soluciones .. ¿como?
        // Declararlo como static
        funcion2();

        ED_Debug.funcion2();

    }

}