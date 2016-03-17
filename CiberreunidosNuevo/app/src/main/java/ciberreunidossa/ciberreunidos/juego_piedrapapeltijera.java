package ciberreunidossa.ciberreunidos;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import logicappt.ppt;

public class juego_piedrapapeltijera extends AppCompatActivity {
    public  ppt ppt= new ppt();
    public int jugador1;
    public boolean ganaR=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego_piedrapapeltijera);
        Bundle bundle = getIntent().getExtras();
        String rondas= bundle.getString("ronda");
        ImageButton piedra= (ImageButton) findViewById(R.id.piedra);
        ImageButton tijera= (ImageButton) findViewById(R.id.tijera);
        ImageButton papel= (ImageButton) findViewById(R.id.papel);
        TextView m1= (TextView) findViewById(R.id.punt_jug1);
        TextView m2= (TextView) findViewById(R.id.punt_jug2);
        TextView txt_ronda= (TextView) findViewById(R.id.textView);
        System.out.println(rondas);
       /*while(m1.getText().toString() != rondas || m2.getText().toString() != rondas){
            if(ganaR!= true){
                cambiar_ronda(txt_ronda);
            }
        }*/
        //botones
            //boton piedra
        piedra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageButton im1= (ImageButton) findViewById(R.id.imageButton_1);
                im1.setBackgroundResource(R.drawable.piedra_btn);
                int jugador1= 3;
                int jugador2= jugador2(ppt.generaOpcion());
                juego(jugador1,jugador2);

            }
        });
            //boton tijera
        tijera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageButton im1= (ImageButton) findViewById(R.id.imageButton_1);
                im1.setBackgroundResource(R.drawable.tijera_btn);
                int jugador1= 2;
                int jugador2= jugador2(ppt.generaOpcion());
                juego(jugador1, jugador2);
            }
        });
            //boton papel
        papel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageButton im1= (ImageButton) findViewById(R.id.imageButton_1);
                im1.setBackgroundResource(R.drawable.papel_btn);
                int jugador1= 1;
                int jugador2= jugador2(ppt.generaOpcion());
                juego(jugador1,jugador2);
            }
        });
    }
    public void sumar_punto(TextView marcador){
        marcador.getText();
        char a= marcador.getText().charAt(0);
        int i= Character.digit(a, 10);
        i++;
        char b= Integer.toString(i).charAt(0);
        marcador.setText(new String(new char[]{b}));
    }

    public int jugador2(String s){
        int i;
        ImageButton im2= (ImageButton) findViewById(R.id.imageButton_2);
        if(s=="papel"){
            im2.setBackgroundResource(R.drawable.papel_btn);
            i=1;}
        else if(s=="tijera"){
            im2.setBackgroundResource(R.drawable.tijera_btn);
            i=2;}
        else{
            im2.setBackgroundResource(R.drawable.piedra_btn);
            i=3;}
        return i;
    }

    public void juego(int valorJug1,int valorJug2){
        // papel - tijera o tijera - piedra o piedra - papel, gana el segundo
        if(valorJug1 == 1 && valorJug2 == 2 || valorJug1 == 2 && valorJug2 == 3 || valorJug1 == 3 && valorJug2 == 1 ){
            TextView marcador2= (TextView) findViewById(R.id.punt_jug2);
            sumar_punto(marcador2);
            ganaR=true;
        }
        //tijera - papel o piedra - tijera o papel - piedra, gana el primero
        else if (valorJug1 == 2 && valorJug2 == 1 || valorJug1 == 3 && valorJug2 == 2 || valorJug1 == 1 && valorJug2 == 3) {
            TextView marcador1= (TextView) findViewById(R.id.punt_jug1);
            sumar_punto(marcador1);
            ganaR=true;
        }
        else{ganaR=false;}

    }
    public void cambiar_ronda(TextView marcador){
        marcador.getText();
        char a= marcador.getText().charAt(6);
        int i= Character.digit(a, 10);
        i++;
        char b= Integer.toString(i).charAt(0);
        marcador.setText(new String(new char[]{'R','O','N','D','A',' ',b}));
    }
}
