import java.util.Random;

public class Principal {

	public static void main(String[] args) {
		
		//Crea un nuevo coche llamado Coche y pasando los parametros marca, modelo y color

		Coche c = new Coche("Fiat","500","Rojo");
		Coche c2 = new Coche("Audi","A4","Negro");
		Coche c3 = new Coche("Renault","4L","Gris");

		// En las variables velocidad_nuevaX hay un número entre el 0 y el 80

		Random aleatorio = new Random();
		int velocidad_nueva1 = aleatorio.nextInt(80);
		int velocidad_nueva2 = aleatorio.nextInt(80);
		int velocidad_nueva3 = aleatorio.nextInt(80);


		//Asigna la velocidad de aceleración de los coches

		c2.acelera(velocidad_nueva1);
		c3.acelera(velocidad_nueva2);
		c.acelera(velocidad_nueva3);

		//Muestra por pantalla

		System.out.println("----- INFO DE LOS 3 COCHES------");
		System.out.println("-----------------------------");	

		//Llama a los coche creados

		c.pinta();
		c2.pinta();
		c3.pinta();

		// Queremos saber las velocidades en este punto

		// En las variables velocidad_nuevaX hay un número entre el 0 y el 100

		 velocidad_nueva1 = aleatorio.nextInt(100);
		 velocidad_nueva2 = aleatorio.nextInt(100);
		 velocidad_nueva3 = aleatorio.nextInt(100);

		//Asigna la frenada de los coches

		 c.frena(velocidad_nueva1);
		 c2.frena(velocidad_nueva2);
		 c3.frena(velocidad_nueva3);

		// Queremos saber las velocidades en este punto

		//Muestra por pantalla
		
		System.out.println("----- INFO DE LOS 3 COCHES------");
		System.out.println("-----------------------------");


		c.pinta();
		c2.pinta();
		c3.pinta();
		
	}

}
