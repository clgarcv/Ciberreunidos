package ciberreunidossa.ciberreunidos;


public class Conecta4 {
    static final int NFILAS = 6;
    static final int NCOLUMNAS = 6;
    static final int VACIO = 0;
    static final int MAQUINA = 2;
    private final String MAQUINASTR = "2222";
    static final int JUGADOR = 1;
    private final String JUGADORSTR = "1111";
    private int tablero[][];
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
        else if(tablero[f][c]== MAQUINA){
            return false;
        }
        else
            return true;
    }

    //comprobar que el tablero esta lleno de fichas, es decir que en la matriz no haya ceros
    public boolean tableroLleno() {
        for (int i = 0; i < NFILAS; i++)
            for (int j = 0; j < NCOLUMNAS; j++)
                if (tablero[i][j] == VACIO)
                    return false;

        return true;
    }

    //poner una ficha para el Jugador (valor de jugador = 1)
    public void setJugador(int f, int c) {

        tablero[f][c] = JUGADOR;
    }

    //poner una ficha para la Maquina
    public void setMaquina(int f, int c){

        tablero[f][c] = MAQUINA;
    }

    //comprobar si el juego a finalizado, si el tablero esta lleno o si el juego ya no esta activo
    public boolean finalJuego() {
        if (tableroLleno()|| comprobarCuatro(1) || comprobarCuatro(2))
            return true;

        return false;
    }

    //comprobar si hay 4 fichas para que gane alguien
    boolean comprobarCuatro(int turno) {
        if (comprobarFilas(turno) || comprobarColumnas(turno) || comprobarDiagonales(turno)) {

            return true;
        }
        return false;
    }

    //comprueba que haya 4 fichas iguales en una fila
    boolean comprobarFilas(int turno) {
        String cadena = turno == JUGADOR ? JUGADORSTR : MAQUINASTR;

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

