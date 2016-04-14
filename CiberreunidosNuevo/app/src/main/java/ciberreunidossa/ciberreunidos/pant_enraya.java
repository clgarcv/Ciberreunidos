package ciberreunidossa.ciberreunidos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class pant_enraya extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pant_enraya);


        //obtenemos el numero de jugadores
        Bundle bundle = getIntent().getExtras();
        final int nJug = bundle.getInt("njugadores");

        if(nJug == 1) {
            //juega contra la maquina
            //el primero en pulsar sera el jugador uno que juega con X

        } else if (nJug == 2){
            //dos jugadores

        }

        //primera fila del tablero
        ImageButton c1_1= (ImageButton) findViewById(R.id.img11);
        ImageButton c12= (ImageButton) findViewById(R.id.img12);
        ImageButton c13= (ImageButton) findViewById(R.id.img13);
        //segunda fila del tablero
        ImageButton c21= (ImageButton) findViewById(R.id.img21);
        ImageButton c22= (ImageButton) findViewById(R.id.img22);
        ImageButton c23= (ImageButton) findViewById(R.id.img23);
        //tercera fila del tablero
        ImageButton c31= (ImageButton) findViewById(R.id.img31);
        ImageButton c32= (ImageButton) findViewById(R.id.img32);
        ImageButton c33= (ImageButton) findViewById(R.id.img33);

        final List<ImageButton> botones = new ArrayList<ImageButton>();
        botones.add(c1_1);
        botones.add(c12);
        botones.add(c13);
        botones.add(c21);
        botones.add(c22);
        botones.add(c23);
        botones.add(c31);
        botones.add(c32);
        botones.add(c33);

        final int tablero [][] = new int[3][3];
        inicializaTablero(tablero);

        for (ImageButton img : botones){
            img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //img.getId();
                    //turno(tablero, img.getId());
                }
            });

        }


    }

    //funciones auxiliares
    // inicializamos con -1.  0 representara la O y 1 la X
    private static void inicializaTablero(int [][] t){
        for (int i=0; i<t.length ;i++){
            for (int j=0; j<t.length ;j++){
                t[i][j]=-1;
                System.out.println(t[i][j]);
            }
        }

    }

    private static void ponerFicha(int c, int f, int ficha, int [][] tablero){

        if(tablero[f][c] == -1){
            //si no hay ninguna ficha podemos ponerla
            tablero[f][c] = ficha;
        }
    }

    private static boolean hayLinea(int [][] t){
        //ponemos los distintos casos donde puede darse una linea
        //hay 8 casos
        //filas
        if (t[1][1] == t[1][2] && t[1][1] == t[1][3]){
            return true;
        } else
        if (t[2][1] == t[2][2] && t[2][1] == t[2][3]){
            return true;
        } else
        if (t[3][1] == t[3][2] && t[3][1] == t[3][3]){
            return true;
        } else
        //columnas
        if (t[1][1] == t[2][1] && t[1][1] == t[3][1]){
            return true;
        } else
        if (t[1][2] == t[2][2] && t[1][2] == t[3][2]){
            return true;
        } else
        if (t[1][3] == t[2][3] && t[1][3] == t[3][3]){
            return true;
        } else
        //diagonales
        if (t[1][1] == t[2][2] && t[1][1] == t[3][3]){
            return true;
        }
        if (t[3][1] == t[2][2] && t[3][1] == t[1][3]){
            return true;
        } else
            return false;
    }

    private static boolean finPartida(int [][] t){
        boolean completo = false;
        for (int i=0; i<t.length ;i++){
            for (int j=0; j<t.length ;j++){
                if (t[i][j]!=-1)
                    completo = true;
            }
        }
        return completo || hayLinea(t);
    }

    private static boolean turno(int [][] t, int f, int c, int ficha){

        boolean fin = false;

        fin = finPartida(t);
        if(!fin){
            ponerFicha(c, f, ficha, t);
        }
        fin = finPartida(t);

        return fin;


    }
}
