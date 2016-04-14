package ciberreunidossa.ciberreunidos;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;

public class pant_enraya extends AppCompatActivity {

    static int contador = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pant_enraya);


        //obtenemos el numero de jugadores
        Bundle bundle = getIntent().getExtras();
        final int nJug = bundle.getInt("njugadores");

        if (nJug == 1) {
            //juega contra la maquina
            //el primero en pulsar sera el jugador uno que juega con X

        } else if (nJug == 2) {
            //dos jugadores

        }

        //primera fila del tablero
        final ImageButton c1_1 = (ImageButton) findViewById(R.id.img11);
        final ImageButton c1_2 = (ImageButton) findViewById(R.id.img12);
        final ImageButton c1_3 = (ImageButton) findViewById(R.id.img13);
        //segunda fila del tablero
        final ImageButton c2_1 = (ImageButton) findViewById(R.id.img21);
        final ImageButton c2_2 = (ImageButton) findViewById(R.id.img22);
        final ImageButton c2_3 = (ImageButton) findViewById(R.id.img23);
        //tercera fila del tablero
        final ImageButton c3_1 = (ImageButton) findViewById(R.id.img31);
        final ImageButton c3_2 = (ImageButton) findViewById(R.id.img32);
        final ImageButton c3_3 = (ImageButton) findViewById(R.id.img33);

        final List<ImageButton> botones = new ArrayList<ImageButton>();
        botones.add(c1_1);
        botones.add(c1_2);
        botones.add(c1_3);
        botones.add(c2_1);
        botones.add(c2_2);
        botones.add(c2_3);
        botones.add(c3_1);
        botones.add(c3_2);
        botones.add(c3_3);

        final int tablero[][] = new int[3][3];
        inicializaTablero(tablero);

        //creamos el evento que van a tener los botones
        final View.OnClickListener eventoBotones = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("he pulsado un boton");
                System.out.println(contador);
                //antes de nada comprobamos si la partida a terminado
                if(!finPartida(tablero)){
                    //si la partida no ha terminado podemos poner ficha

                    //en funcion del valor del contador pondra una X o una O

                    ImageButton btn = null;

                    switch (v.getId()){
                        case R.id.c11:
                            btn = c1_1;

                        case R.id.c12:
                            btn = c1_2;

                        case R.id.c13:
                            btn = c1_3;

                        case R.id.c21:
                            btn = c2_1;

                        case R.id.c22:
                            btn = c2_2;

                        case R.id.c23:
                            btn = c2_3;

                        case R.id.c31:
                            btn = c3_1;

                        case R.id.c32:
                            btn = c3_2;

                        case R.id.c33:
                            btn = c3_3;

                        default:

                    }

                    //cuando sea par pondra O
                    if(contador % 2 == 0){
                        btn.setImageResource(R.drawable.enraya_o);
                        //turno(tablero, )

                    } else {
                        //cuando sea impar X
                        btn.setImageResource(R.drawable.enraya_x);

                    }
                    contador++;
                }

            }
        };

        //se lo asignamos a cada boton
        for (ImageButton img : botones) {
            img.setOnClickListener(eventoBotones);

        }


    }

    //funciones auxiliares
    // inicializamos con -1.  0 representara la O y 1 la X
    private static void inicializaTablero(int[][] t) {
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t.length; j++) {
                t[i][j] = -1;
                System.out.println(t[i][j]);
            }
        }

    }

    private static void ponerFicha(int c, int f, int ficha, int[][] tablero) {

        if (tablero[f][c] == -1) {
            //si no hay ninguna ficha podemos ponerla
            tablero[f][c] = ficha;
        }
    }

    private static boolean hayLinea(int[][] t) {
        //ponemos los distintos casos donde puede darse una linea
        //hay 8 casos
        //filas
        if (t[1][1] == t[1][2] && t[1][1] == t[1][3]) {
            return true;
        } else if (t[2][1] == t[2][2] && t[2][1] == t[2][3]) {
            return true;
        } else if (t[3][1] == t[3][2] && t[3][1] == t[3][3]) {
            return true;
        } else
            //columnas
            if (t[1][1] == t[2][1] && t[1][1] == t[3][1]) {
                return true;
            } else if (t[1][2] == t[2][2] && t[1][2] == t[3][2]) {
                return true;
            } else if (t[1][3] == t[2][3] && t[1][3] == t[3][3]) {
                return true;
            } else
                //diagonales
                if (t[1][1] == t[2][2] && t[1][1] == t[3][3]) {
                    return true;
                }
        if (t[3][1] == t[2][2] && t[3][1] == t[1][3]) {
            return true;
        } else
            return false;
    }

    private static boolean finPartida(int[][] t) {
        boolean completo = false;
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t.length; j++) {
                if (t[i][j] != -1)
                    completo = true;
            }
        }
        return completo || hayLinea(t);
    }

    private static boolean turno(int[][] t, int f, int c, int ficha) {

        boolean fin = false;

        fin = finPartida(t);
        if (!fin) {
            ponerFicha(c, f, ficha, t);
        }
        fin = finPartida(t);

        return fin;


    }
}
