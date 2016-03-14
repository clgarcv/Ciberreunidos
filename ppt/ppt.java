package ppt;

import java.util.Scanner;

public class ppt {

	public static int piedrapapeltijera(int rondas) {
		int jug1 = 1;
		int jug2 = 2;

		int punt_jug1 = 0;
		int punt_jug2 = 0;

		int valorJug1 = 0;
		int valorJug2 = 0;

		int ganador = -1;

		boolean seguir = true;
		int i = 1;

		while (seguir && i<=rondas) {
			Scanner sc = new Scanner(System.in);

			System.out.println("Ronda: " + i);
			// tomamos los valor en funcion de la carta selecionada
			System.out.println("introduce el valor del jugador 1");
			valorJug1 = sc.nextInt();

			System.out.println("introduce el valor del jugador 2");
			valorJug2 = sc.nextInt();

			// papel - tijera o tijera - piedra o piedra - papel, gana el
			// segundo
			if (valorJug1 == 1 && valorJug2 == 2 || valorJug1 == 2 && valorJug2 == 3
					|| valorJug1 == 3 && valorJug2 == 1) {
				punt_jug2++;
			} //tijera - papel o piedra - tijera o papel - piedra, gana el primero 
			else if (valorJug1 == 2 && valorJug2 == 1 || valorJug1 == 3 && valorJug2 == 2
					|| valorJug1 == 1 && valorJug2 == 3) {
				punt_jug1++;
			}
			
			if(punt_jug1 > rondas/2){
				ganador = jug1;
				seguir = false;
			} else if (punt_jug2 > rondas/2){
				ganador = jug2;
				seguir = false;
			}

			System.out.println("jugador 1 : " + punt_jug1);
			System.out.println("jugador 2 : " + punt_jug2);
			i++;
		}

		return ganador;
	}

}
