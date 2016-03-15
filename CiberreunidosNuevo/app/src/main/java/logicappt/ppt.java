package logicappt;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by Daniel on 15/03/2016.
 */

/*public static void main(String[] args) {
		// TODO Auto-generated method stub

		ppt piedrapapeltiejra = new ppt();
		Scanner sc = new Scanner(System.in);
		System.out.println("por favor introduce el numero de rondas");
		int rondas = sc.nextInt();
		ppt juego= new ppt(rondas);
		juego.juego();}*/
    
public class ppt {

    private String[] opciones = { "piedra", "papel", "tijera" };
    private int rondas;
    private int vm;
    private int vj;
    public int getRondas() {
        return rondas;
    }

    public void setRondas(int rondas) {
        this.rondas = rondas;
    }

    public int getVm() {
        return vm;
    }

    public void setVm(int vm) {
        this.vm = vm;
    }

    public int getVj() {
        return vj;
    }

    public void setVj(int vj) {
        this.vj = vj;
    }



    public ppt() {
        rondas = 3;
        vm = 0;
        vj = 0;
    }

    public ppt(int r) {
        rondas = r;
        vm = 0;
        vj = 0;
    }

    public String generaOpcion() {
        Random r = new Random();
        return opciones[r.nextInt(3)];
    }

    public void juego() {
        int i = 1;
        while (i <= rondas) {
            System.out.println("¿Piedra, Papel o Tijera?");
            Scanner sc = new Scanner(System.in);
            String respuesta = sc.nextLine();
            String maquina = generaOpcion();
            System.out.println(respuesta+" vs "+ maquina);

            if (respuesta.toLowerCase().equals(maquina)) {
                System.out.println("Empate,no cuenta");
                i--;
            } else if (respuesta.toLowerCase().equals("piedra")
                    && maquina.equals("papel")) {
                System.out.println("Pierdes");
                vm++;
            } else if (respuesta.toLowerCase().equals("piedra")
                    && maquina.equals("tijera")) {
                System.out.println("Ganas");
                vj++;
            } else if (respuesta.toLowerCase().equals("papel")
                    && maquina.equals("tijera")) {
                System.out.println("Pierdes");
                vm++;
            } else if (respuesta.toLowerCase().equals("papel")
                    && maquina.equals("piedra")) {
                System.out.println("Ganas");
                vj++;
            } else if (respuesta.toLowerCase().equals("tijera")
                    && maquina.equals("papel")) {
                System.out.println("Ganas");
                vj++;
            } else if (respuesta.toLowerCase().equals("tijera")
                    && maquina.equals("piedra")) {
                System.out.println("Pierdes");
                vm++;
            }
            System.out.println("Jugador: "+vj);
            System.out.println("Maquina: "+vm);
            i++;
        }
        resultado();
    }

    public void resultado (){

        if (vj>vm){
            System.out.println("HAS GANADO!!!!!!!!!!");
            System.out.println("Victorias: "+vj);
            System.out.println("Derrotas: "+vm);
        }else{
            System.out.println("Perdiste :(");
            System.out.println("Victorias: "+vj);
            System.out.println("Derrotas: "+vm);
        }
    }
}
