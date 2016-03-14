package ppt;

import java.util.Scanner;

public class ppal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ppt piedrapapeltiejra = new ppt();
		Scanner sc = new Scanner(System.in);
		System.out.println("por favor introduce el numeor de rondas");
		int rondas = sc.nextInt();
		
		
		int ganador = piedrapapeltiejra.piedrapapeltijera(rondas);
		System.out.println("El ganador es: " + (ganador == -1 ? "Empate" : ganador));

	}

}
