package ciberreunidossa.ciberreunidos;

import java.util.Random;
public class Conecta4 {
    static final int NFILAS = 6;
    static final int NCOLUMNAS = 6;
    static final int VACIO = 0;
    static final int MAQUINA = 2;
    private final String MAQUINASTR = "2222";
    static final int JUGADOR = 1;
    private final String JUGADORSTR = "1111";
    private int tablero[][];
    private boolean juego_activo = true;
    public Conecta4() {
        tablero = new int[NFILAS][NCOLUMNAS];

        for (int i = 0; i < NFILAS; i++)
            for (int j = 0; j < NCOLUMNAS; j++)
                tablero[i][j] = VACIO;
    }
    //comprobar si esta vacia la casilla
    public boolean estaVacio(int f, int c) {

        if (tablero[f][c] == JUGADOR) {
            return false;
        }
        else if(tablero[f][c]==MAQUINA){
            return false;
        }
        else
            return true;

    }
    //comprobar si en esa posicion hay una ficha del jugador
    public boolean estaJugador(int f, int c) {

        if (tablero[f][c] == JUGADOR) {
            return true;
        } else
            return false;

    }
    //comprobar que el tablero esta lleno de fichas, es decir que en la matriz no haya ceros
    public boolean tableroLleno() {
        for (int i = 0; i < NFILAS; i++)
            for (int j = 0; j < NCOLUMNAS; j++)
                if (tablero[i][j] == VACIO)
                    return false;

        return true;
    }
    //comprobar si se puede colocar una ficha en una posicion
    public boolean sePuedeColocarFicha(int f, int c) {

        if (tablero[f][c] == VACIO) {
            return true;
        } else
            return false;

    }
    //inteligencia de la máquina
    public void juegaMaquina() {
        int i;
        int fila = -1, columna;
        Random r = new Random();

        do {
            columna = r.nextInt(NCOLUMNAS);

            for (i = 0; i < NFILAS; i++)
                if (tablero[i][columna] == VACIO) {
                    fila = i;
                    break;
                }
        } while (fila < 0);

        tablero[fila][columna] = MAQUINA;
    }
    //comprobar si en esa posicion esta una ficha de la maquina
    public boolean estaMaquina(int f, int c) {

        if (tablero[f][c] == MAQUINA) {
            return true;
        } else
            return false;
    }
    //te devuelve la ficha que hay en el tablero en esa posicion
    public int getTablero(int f, int c) {

        return tablero[f][c];

    }
    //poner una ficha para el Jugador (valor de jugador = 1)
    public void setJugador(int f, int c) {

        tablero[f][c] = JUGADOR;
    }
    //comprobar si el juego a finalizado, si el tablero esta lleno o si el juego ya no esta activo
    public boolean finalJuego() {
        if (tableroLleno()|| !juego_activo)
            return true;

        return false;
    }
    //comprobar si hay 4 fichas para que gane alguien
    boolean comprobarCuatro(int turno) {
        if (comprobarFilas(turno) || comprobarColumnas(turno) || comprobarDiagonales(turno)) {
            juego_activo = false;
            return true;
        }
        return false;
    }
    //comprueba que haya 4 fichas iguales en una fila
    boolean comprobarFilas(int turno) {
        String cadena = turno == JUGADOR ? JUGADORSTR : MAQUINASTR  ;

        for (int i = 0; i < NFILAS; i++) {
            String str = "";
            for (int j = 0; j < NCOLUMNAS; j++)
                str += Integer.toString(tablero[i][j]);
            if (str.contains(cadena))
                return true;
        }

        return false;
    }
    //comprueba que haya 4 fichas iguales en una columna
    boolean comprobarColumnas(int turno) {

        String cadena = turno == JUGADOR ? JUGADORSTR : MAQUINASTR;

        for (int i = 0; i < NCOLUMNAS; i++) {
            String str = "";
            for (int j = 0; j < NFILAS; j++)
                str += Integer.toString(tablero[j][i]);
            if (str.contains(cadena))
                return true;
        }

        return false;
    }
    //comprobar que haya 4 fichas iguales en las diagonales
    boolean comprobarDiagonales(int turno) {
        for (int i=0;i<3;i++)
            for (int j=3;j<NCOLUMNAS;j++)
                if(tablero[i][j]==turno && tablero[i+1][j-1]==turno && tablero[i+2][j-2]==turno && tablero[i+3][j-3]==turno)
                    return true;
        for (int i=0;i<3;i++)
            for (int j=0;j<4;j++)
                if(tablero[i][j]==turno && tablero[i+1][j+1]==turno && tablero[i+2][j+2]==turno && tablero[i+3][j+3]==turno)
                    return true;
        return false;
    }
}

