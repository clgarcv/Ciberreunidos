package ciberreunidossa.ciberreunidos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;

public class pant_enraya extends AppCompatActivity {

    static int contador;
    int tablero[][] = new int[3][3];
    String ganador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pant_enraya);

        contador = 1;
        //obtenemos el numero de jugadores
        Bundle bundle = getIntent().getExtras();
        final int nJug = bundle.getInt("njugadores");


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


        inicializaTablero(tablero);
        if (nJug == 1) {
            //juega contra la maquina
            //el primero en pulsar sera el jugador uno que juega con X

        } else if (nJug == 2) {
            //dos jugadores
            for (ImageButton img : botones) {
                img.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        actualizarTabla(v.getId());
                        añadirImagen(v.getId());
                        if (!finPartida()) {
                            contador++;

                        } else {
                            Intent i = new Intent(pant_enraya.this, pierdegana.class);
                            i.putExtra("juego", "3enraya");
                            i.putExtra("jugadores", nJug);
                            i.putExtra("ganador",ganador);
                            startActivity(i);
                        }
                    }
                });

            }

        }


    }

    public void actualizarTabla(int id) {
        switch (id) {

            case R.id.img11:
                tablero[0][0] = (contador % 2 == 0) ? 0 : 1;
                break;
            case R.id.img12:
                tablero[0][1] = (contador % 2 == 0) ? 0 : 1;
                break;
            case R.id.img13:
                tablero[0][2] = (contador % 2 == 0) ? 0 : 1;
                break;
            case R.id.img21:
                tablero[1][0] = (contador % 2 == 0) ? 0 : 1;
                break;
            case R.id.img22:
                tablero[1][1] = (contador % 2 == 0) ? 0 : 1;
                break;
            case R.id.img23:
                tablero[1][2] = (contador % 2 == 0) ? 0 : 1;
                break;
            case R.id.img31:
                tablero[2][0] = (contador % 2 == 0) ? 0 : 1;
                break;
            case R.id.img32:
                tablero[2][1] = (contador % 2 == 0) ? 0 : 1;
                break;
            case R.id.img33:
                tablero[2][2] = (contador % 2 == 0) ? 0 : 1;
                break;
        }

    }

    public void añadirImagen(int id) {
        ImageButton b = (ImageButton) findViewById(id);
        if (contador % 2 == 0) {
            b.setImageResource(R.drawable.enraya_o);
            //turno(tablero, )

        } else {
            //cuando sea impar X
            b.setImageResource(R.drawable.enraya_x);

        }
        b.setEnabled(false);


    }

    private boolean tableroInicial() {
        int i = 0;
        while (i <= 2) {
            int j = 0;
            while (j <= 2) {
                if (tablero[i][j] != -1) {
                    return false;
                } else {
                    j++;
                }
            }
            i++;
        }
        return true;
    }


    //funciones auxiliares
    // inicializamos con -1.  0 representara la O y 1 la X
    private static void inicializaTablero(int[][] t) {
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t.length; j++) {
                t[i][j] = -1;
            }
        }

    }

    private static void ponerFicha(int c, int f, int ficha, int[][] tablero) {

        if (tablero[f][c] == -1) {
            //si no hay ninguna ficha podemos ponerla
            tablero[f][c] = ficha;
        }
    }

    private boolean hayLinea(int[][] t) {
        //ponemos los distintos casos donde puede darse una linea
        //hay 8 casos
        //filas

        if (( t[0][0]!=-1 && t[0][0] == t[0][1] && t[0][0] == t[0][2] ) || (t[1][0]!=-1 && t[1][0] == t[1][1] && t[1][0] == t[1][2]) || (t[2][0]!=-1 && t[2][0] == t[2][1] && t[2][0] == t[2][2])) {
            if(t[0][0]==1 || t[1][0]==1 || t[2][0]==1){
                ganador="Jugador 1";
                return true;
            }else{
                ganador="Jugador 2";
                return true;
            }

        } else if ((t[0][0]!=-1 && t[0][0] == t[1][0] && t[0][0] == t[2][0]) || (t[0][1]!=-1 && t[0][1] == t[1][1] && t[0][1] == t[2][1]) || (t[0][2]!=-1 && t[0][2] == t[1][2] && t[0][2] == t[2][2])) {
            if(t[0][0]==1 || t[0][1]==1 || t[0][2]==1){
                ganador="Jugador 1";
                return true;
            }else{
                ganador="Jugador 2";
                return true;
            }
        } else if ((t[0][0]!=-1 && t[0][0] == t[1][1] && t[0][0] == t[2][2]) || (t[2][0]!=-1 && t[2][0] == t[1][1] && t[2][0] == t[0][2])) {
            if(t[0][0]==1 || t[2][0]==1){
                ganador="Jugador 1";
                return true;
            }else{
                ganador="Jugador 2";
                return true;
            }
        } else {
            return false;
        }
    }


    private boolean finPartida() {
        return (contador == 9 || hayLinea(tablero));
    }

   /* private static boolean turno(int[][] t, int f, int c, int ficha) {

        boolean fin = false;

        fin = finPartida();
        if (!fin) {
            ponerFicha(c, f, ficha, t);
        }
        fin = finPartida();

        return fin;


    }*/
}
