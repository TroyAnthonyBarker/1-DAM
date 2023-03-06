package es.iesmz.dam.ed.examen;

import es.iesmz.dam.ed.utilcolor;

import java.util.Scanner;

public class RecDebug {


	public static void main(String[] args) {

		utilcolor u1 = new utilcolor("RED","");

		System.out.println(u1);

		Scanner sc = new Scanner(System.in);
		String n = "";

		u1.setMsg("Dime un numero de 3 cifras: ");
		System.out.println(u1);
		n= sc.nextLine();

		int ce=0,de=0,un=0;
		int ran;
		for (int i = 0; i <3 ; i++) {

			ran = (int) Math.floor(Math.random()*10);
			ce = (i==0)?(Integer.parseInt(n)/100):ran;
			de = (i==1)?(Integer.parseInt(n)%100)/10:ran;
			un = (i==2)?((Integer.parseInt(n)%100)%10):ran;
		}

		int c = 0;

		ce = (Integer.parseInt(n)/100);
		de = (Integer.parseInt(n)%100)/10;
		un = ((Integer.parseInt(n)%100)%10);

		int s1 = un+ce+de;

		for (int i = 1; i <= s1; i++) {

			if( s1%i ==0 ){
				c++;
			}

		}

		if(c==2){
			u1.setColor("BLUE");
			u1.setMsg("S: "+String.valueOf(s1)+" valor: SI" );
		}
		else{
			u1.setColor("YELLOW");
			u1.setMsg("S: "+String.valueOf(s1)+" valor: NO" );
		}

		System.out.println(u1);

		sc.close();

	}

}
