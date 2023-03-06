import java.util.Scanner; //Importa la herramienta Scanner
import java.lang.Math; //Importa la herramienta Math

public class Star_Wars_Codigos_Secretos {
    static Scanner sc; //Un Scanner para todos los métodos

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        boolean perder = false;

        Inicio();

        //Realiza el método Nivel1, le pasamos la variable perder
        //cuando termine de realizar el método, nos devuelve perder
        perder = Nivel1();

        System.out.println();

        //Si perder=true no entra, si perder=false entra
        if (!perder){

            //Realiza el método Nivel2, le pasamos la variable perder
            //cuando termine de realizar el método, nos devuelve perder
            perder = Nivel2();
            System.out.println();
        }

        //Si perder=true no entra, si perder=false entra
        if (!perder) {

            //Realiza el método Nivel1, le pasamos la variable perder
            //cuando termine de realizar el método, nos devuelve perder
            perder = Nivel3();
            System.out.println();
        }

        //Si perder=true no entra, si perder=false entra
        if (!perder) {

            //Realiza el método Nivel1, le pasamos la variable perder
            //cuando termine de realizar el método, nos devuelve perder
            perder = Nivel4();
            System.out.println();
        }

        //Si perder=true no entra, si perder=false entra
        if (!perder) {

            //Realiza el método Nivel1, le pasamos la variable perder
            //cuando termine de realizar el método, nos devuelve perder
            perder = Nivel5();
            System.out.println();
        }

        //Si perder=true realiza el método Perder, si perder=false realiza el método Ganar
        if (!perder) {

            //Realiza el método Ganar
            Ganar();
            System.out.println();
        } else if (perder){

            //Realiza el método Perder
            Perder();
            System.out.println();
        }


        //Realiza el método Fin
        Fin();

        //Cierra el Scanner
        sc.close();
    }

    public static int random(int min, int max){
        int random;

        //Devuelve un número random entre los valores max y min
        random =  (int) (min + Math.random() * (max - min + 1));
        return random;
    }

    public static void testInt() {

        //Si el valor introducido no es un int, muestra un mensaje
        while (!sc.hasNextInt()) {
            System.out.println("Eso no es un número entero!");
            sc.next(); // IMPORTANTE!
        }
    }

    public static boolean solucion(int solucion, int respuesta){

        //Si la respuesta introducida es igual a la solución devuelve perder=false, en caso de que sea distinto devuelve perder=true
        return respuesta != solucion;
    }
    public static void Inicio() {

        //Muestra un párrafo
        System.out.println("              === STAR WARS CÓDIGOS SECRETOS ===                    ");
        System.out.println("Hace mucho tiempo, en una galaxia muy, muy lejana… La Princesa Leia,");
        System.out.println("Luke, Skywalker, Han Solo, Chewbacca, C3PO y R2D2 viajan en una nave");
        System.out.println("imperial robada en una misión secreta para infiltrarse en otra estrella");
        System.out.println("de la muerte que el imperio está construyendo para destruirla.");
        System.out.println("(Presiona Intro para continuar)");

        //Mantiene el párrafo hasta que el usuario pulse intro para continuar
        sc.nextLine();
    }

    public static boolean Nivel1() {
        int s1 = random(0, 10), s2 =  random(20, 30), respuesta = 0, solucion = 0;
        boolean perder = false;

        //Muestra un párrafo
        System.out.println("Los problemas empiezan cuando deben realizar un salto hiperespacial hasta al");
        System.out.println("sistema " + s1 + " en el sector " + s2 + ", pero el sistema de navegación está estropeado y");
        System.out.println("el computador tiene problemas para calcular parte de las coordenadas de salto.");
        System.out.println("Chewbacca, piloto experto, se da cuenta que falta el cuarto número de la serie.");
        System.out.println("Recuerda de sus tiempos en la academia de pilotos que para calcularlo hay que");
        System.out.println("calcular el sumatorio entre el nº del sistema y el nº del sector (ambos inclusive).");
        System.out.println("¿Qué debe introducir?");

        //Calcular el sumatorio entre s1 y s2 (ambos inclusive).
        for (int i = s1; i <= s2; i++) {
            solucion += i;
        }

        //Comprueba si el dato introducido es un int
        testInt();
        respuesta = sc.nextInt();

        //Comprueba si la respuesta introducida es correcta, si lo es devuelve perder=falso, si no lo es devuelve perder=true
        perder = solucion(solucion, respuesta);
        return perder;
    }

    public static boolean Nivel2() {
        int p1 = random(1, 7), p2 = random(8, 12), solucion = 1, respuesta = 0;
        boolean perder = false;

        //Muestra un párrafo
        System.out.println("Gracias a Chewbacca consiguen llegar al sistema correcto y ven a lo lejos la estrella");
        System.out.println("de la muerte. Como van en una nave imperial robada se aproximan lentamente con");
        System.out.println("la intención de pasar desapercibidos. De repente suena el comunicador. “Aquí agente");
        System.out.println("de espaciopuerto " + p1 + " contactando con nave imperial " + p2 + ". No están destinados en este");
        System.out.println("sector. ¿Qué hacen aquí?”. Han Solo coge el comunicador e improvisa. “Eh… tenemos");
        System.out.println("un fallo en el… eh… condensador de fluzo... Solicitamos permiso para atracar y");
        System.out.println("reparar la nave”. El agente, que no se anda con tonterías, responde “Proporcione");
        System.out.println("código de acceso o abriremos fuego”. Han Solo ojea rápidamente el manual del piloto");
        System.out.println("que estaba en la guantera y da con la página correcta. El código es el productorio");
        System.out.println("entre el nº del agente y el nº de la nave (ambos inclusive).");
        System.out.println("¿Cuál es el código?");

        //Calcula el productorio entre p1 y p2 (ambos inclusive)
        for (int i = p1; i <= p2; i++) {
            solucion *= i;
        }

        //Comprueba si el dato introducido es un int
        testInt();
        respuesta = sc.nextInt();

        //Comprueba si la respuesta introducida es correcta, si lo es devuelve perder=falso, si no lo es devuelve perder=true
        perder = solucion(solucion, respuesta);
        return perder;
    }

    public static boolean Nivel3() {
        int n = random(50, 100), solucion = 1, respuesta = 0, factorial = 0;
        boolean perder = false;

        //Muestra un párrafo
        System.out.println("Han Solo proporciona el código correcto. Atracan en la estrella de la muerte, se");
        System.out.println("equipan con trajes de soldados imperiales que encuentran en la nave para pasar");
        System.out.println("desapercibidos y bajan. Ahora deben averiguar en qué nivel de los " + n + " existentes se");
        System.out.println("encuentra el reactor principal. Se dirigen al primer panel computerizado que");
        System.out.println("encuentran y la Princesa Leia intenta acceder a los planos de la nave pero necesita");
        System.out.println("introducir una clave de acceso. Entonces recuerda la información que le proporcionó");
        System.out.println("Lando Calrissian “La clave de acceso a los planos de la nave es el factorial de N/10");
        System.out.println("(redondeando N hacia abajo), donde N es el nº de niveles”.");
        System.out.println("¿Cual es el nivel correcto?");

        //Redondeando n hacia abajo
        factorial = n / 10;

        //Calcula el factorial de n redondeado hacia abajo
        for (int i = 1; i <= factorial; i++) {
            solucion *= i;
        }

        //Comprueba si el dato introducido es un int
        testInt();
        respuesta = sc.nextInt();

        //Comprueba si la respuesta introducida es correcta, si lo es devuelve perder=falso, si no lo es devuelve perder=true
        perder = solucion(solucion, respuesta);
        return perder;
    }

    public static boolean Nivel4() {
        int solucion = 0, respuesta, p = random(10, 100);
        boolean primo = true, perder = false;

        //Muestra un párrafo
        System.out.println("Gracias a la inteligencia de Leia llegan al nivel correcto y encuentran la puerta");
        System.out.println("acorazada que da al reactor principal. R2D2 se conecta al panel de acceso para");
        System.out.println("intentar hackear el sistema y abrir la puerta. Para desencriptar la clave necesita");
        System.out.println("verificar si el número " + p + " es primo o no. Si es primo introduce un 1, si no lo es introduce un 0");

        //Comprueba si p es un número primo
        for (int i = 2; i < p / 2; i++) {
            primo = p % i != 0;
            if (!primo) {
                break;
            }
        }

        //Si p es primo la solución es 1
        if (primo) {
            solucion = 1;
        }

        //El usuario solo puede introducir 1 o 0
        do {
            //Comprueba si el dato introducido es un int
            testInt();
            respuesta = sc.nextInt();
            //Si no responde el usuario con un 1 o 0, le mostramos un mensaje de error y que vuelvan a introducir
            if (respuesta < 0 || respuesta > 1) {
                System.out.println("Opcción erronea, vuelve a introducir.");
            }
        } while (respuesta != 0 && respuesta != 1);

        //Comprueba si la respuesta introducida es correcta, si lo es devuelve perder=falso, si no lo es devuelve perder=true
        perder = solucion(solucion, respuesta);
        return perder;
    }

    public static boolean Nivel5() {
        int respuesta, solucion, m = random(5, 10), s = random(5, 10), factorialM = 1, factorialS = 1;
        boolean perder = false;

        //Muestra un párrafo
        System.out.println("Consiguen entrar al reactor. Ya solo queda que Luke Skywalker coloque la bomba,");
        System.out.println("programe el temporizador y salir de allí corriendo. Necesita programarlo para que");
        System.out.println("explote en exactamente " + m + " minutos y " + s + " segundos, el tiempo suficiente para escapar");
        System.out.println("antes de que explote pero sin que el sistema de seguridad anti-explosivos detecte y");
        System.out.println("desactive la bomba. Pero el temporizador utiliza un reloj Zordgiano un tanto peculiar.");
        System.out.println("Para convertir los minutos y segundos al sistema Zordgiano hay que sumar el factorial");
        System.out.println("de M y el factorial de S. ¿Qué valor debe introducir?");

        //Calcula el factorial de m
        for (int i = 1; i <= m; i++) {
            factorialM *= i;
        }

        //Calcula el factorial de n
        for (int i = 1; i <= s; i++) {
            factorialS *= i;
        }

        //La solución es el factorial de m + el factorial de n
        solucion = factorialM + factorialS;
        
        //Comprueba si el dato introducido es un int
        testInt();
        respuesta = sc.nextInt();

        //Comprueba si la respuesta introducida es correcta, si lo es devuelve perder=falso, si no lo es devuelve perder=true
        perder = solucion(solucion, respuesta);
        return perder;
    }

    public static void Ganar() {

        //Muestra un párrafo en el que indica que has ganado
        System.out.println("Luke Skywalker introduce el tiempo correcto, activa el temporizador y empiezan a");
        System.out.println("sonar las alarmas. Salen de allí corriendo, no hay tiempo que perder. La nave se");
        System.out.println("convierte en un hervidero de soldados de arriba a abajo y entre el caos que les rodea");
        System.out.println("consiguen llegar a la nave y salir de allí a toda prisa. A medida que se alejan observan");
        System.out.println("por la ventana la imagen de la colosal estrella de la muerte explotando en el silencio");
        System.out.println("del espacio, desapareciendo para siempre junto a los restos del malvado imperio.");
        System.out.println();
        System.out.println("¡Has salvado la galaxia gracias a la Fuerza Jedi de las matemáticas! Enhorabuena ;D");
    }

    public static void Perder() {

        //Muestra un párrafo en el que indica que has perdido
        System.out.println("Ese no era el código correcto… La misión ha sido un fracaso… :( :( :(");
        System.out.println("Todavía no eres un Maestro Jedi de las Matemáticas. ¡Vuelve a intentarlo!");
    }

    public static void Fin() {
        //Muestra una línea que da las gracias por jugar
        System.out.println("Gracias por jugar :D");
    }
}