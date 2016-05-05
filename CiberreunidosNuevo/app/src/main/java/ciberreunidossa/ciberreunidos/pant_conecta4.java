package ciberreunidossa.ciberreunidos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class pant_conecta4 extends AppCompatActivity {
    private Conecta4 con;
    static int contador;
    final List<ImageView> botones = new ArrayList<ImageView>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pant_conecta4);
        con= new Conecta4();
        contador = 1;
        //columna 1
        ImageView con11=(ImageView) findViewById(R.id.con11); ImageView con12=(ImageView) findViewById(R.id.con12); ImageView con13=(ImageView) findViewById(R.id.con13);
        ImageView con14=(ImageView) findViewById(R.id.con14); ImageView con15=(ImageView) findViewById(R.id.con15); ImageView con16=(ImageView) findViewById(R.id.con16);
        botones.add(con11);botones.add(con12);botones.add(con13);botones.add(con14);botones.add(con15);botones.add(con16);

        //columna 2
        ImageView con21=(ImageView) findViewById(R.id.con21); ImageView con22=(ImageView) findViewById(R.id.con22); ImageView con23=(ImageView) findViewById(R.id.con23);
        ImageView con24=(ImageView) findViewById(R.id.con24); ImageView con25=(ImageView) findViewById(R.id.con25); ImageView con26=(ImageView) findViewById(R.id.con26);
        botones.add(con21);botones.add(con22);botones.add(con23);botones.add(con24);botones.add(con25);botones.add(con26);

        //columna 3
        ImageView con31=(ImageView) findViewById(R.id.con31); ImageView con32=(ImageView) findViewById(R.id.con32); ImageView con33=(ImageView) findViewById(R.id.con33);
        ImageView con34=(ImageView) findViewById(R.id.con34); ImageView con35=(ImageView) findViewById(R.id.con35); ImageView con36=(ImageView) findViewById(R.id.con36);
        botones.add(con31);botones.add(con32);botones.add(con33);botones.add(con34);botones.add(con35);botones.add(con36);

        //columna 4
        ImageView con41=(ImageView) findViewById(R.id.con41); ImageView con42=(ImageView) findViewById(R.id.con42); ImageView con43=(ImageView) findViewById(R.id.con43);
        ImageView con44=(ImageView) findViewById(R.id.con44); ImageView con45=(ImageView) findViewById(R.id.con45); ImageView con46=(ImageView) findViewById(R.id.con46);
        botones.add(con41);botones.add(con42);botones.add(con43);botones.add(con44);botones.add(con45);botones.add(con46);

        //columna 5
        ImageView con51=(ImageView) findViewById(R.id.con51); ImageView con52=(ImageView) findViewById(R.id.con52); ImageView con53=(ImageView) findViewById(R.id.con53);
        ImageView con54=(ImageView) findViewById(R.id.con54); ImageView con55=(ImageView) findViewById(R.id.con55); ImageView con56=(ImageView) findViewById(R.id.con56);
        botones.add(con51);botones.add(con52);botones.add(con53);botones.add(con54);botones.add(con55);botones.add(con56);

        //columna 6
        ImageView con61=(ImageView) findViewById(R.id.con61); ImageView con62=(ImageView) findViewById(R.id.con62); ImageView con63=(ImageView) findViewById(R.id.con63);
        ImageView con64=(ImageView) findViewById(R.id.con64); ImageView con65=(ImageView) findViewById(R.id.con65); ImageView con66=(ImageView) findViewById(R.id.con66);
        botones.add(con61);botones.add(con62);botones.add(con63);botones.add(con64);botones.add(con65);botones.add(con66);

        //con11.setImageResource(R.drawable.bola_amarilla);
        //con11.setImageResource(R.drawable.bola_roja);

        for (ImageView img: botones){
           img.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   if(!con.finalJuego()){

                   }
               }
           });
        }

    }


    //auxiliares
    private void aniadirImagen(int turno,int id){
        ImageView img= (ImageView) findViewById(id);
        if (contador % 2 == 0){
            img.setImageResource(R.drawable.bola_amarilla);
        }
        else{
            img.setImageResource(R.drawable.bola_roja);
        }
    }
    private void ponFicha(int id){
        if(id == R.id.con11|| id == R.id.con12 ||id == R.id.con13 || id == R.id.con14 || id == R.id.con15 || id == R.id.con16){
            if(con.estaVacio(0,5)){
                aniadirImagen(contador,R.id.con11);
                con.setJugador(0,5);
            }
            else{
                //continuar con los demas movimientos de la columna
            }

        }
    }
}
