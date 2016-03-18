package ciberreunidossa.ciberreunidos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import logicappt.ppt;

public class juego_piedrapapeltijera extends AppCompatActivity{
    public  ppt ppt= new ppt();
    public boolean ganaR=false;
    int j=0;
    int r=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego_piedrapapeltijera);
        Bundle bundle = getIntent().getExtras();
        final String rondas= bundle.getString("ronda");
        ImageButton piedra= (ImageButton) findViewById(R.id.piedra);
        ImageButton tijera= (ImageButton) findViewById(R.id.tijera);
        ImageButton papel= (ImageButton) findViewById(R.id.papel);
        final TextView m1= (TextView) findViewById(R.id.punt_jug1);
        final TextView m2= (TextView) findViewById(R.id.punt_jug2);
        System.out.println(rondas);
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
                if(ganaR){
                    TextView txt_ronda= (TextView) findViewById(R.id.textView);
                    cambiar_ronda(txt_ronda);
                }
                terminarPartida(m1, m2, rondas);
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
                if(ganaR){
                    TextView txt_ronda= (TextView) findViewById(R.id.textView);
                    cambiar_ronda(txt_ronda);
                }
                terminarPartida(m1, m2, rondas);
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
                if(ganaR){
                    TextView txt_ronda= (TextView) findViewById(R.id.textView);
                    cambiar_ronda(txt_ronda);
                }
                terminarPartida(m1,m2,rondas);
            }
        });
    }
    //Esta funcion suma un punto en el marcador indicado.
    //coge el texto del marcador, lo pasa a entero, le suma uno y pone el resulatdo en el marcador
    public void sumar_punto(TextView marcador){
        marcador.getText();
        char a= marcador.getText().charAt(0);
        int i= Character.digit(a, 10);
        i++;
        char b= Integer.toString(i).charAt(0);
        marcador.setText(new String(new char[]{b}));
    }
    //con esta funcion, ponemos una imagen en la mano del jugador 2, para ello le pasamos un string
    //que sera sacado con una funcion aleatoria.
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
    // Esta función lo que hace es comparar las manos de los 2 jugadores y poner
    // al marcador el punto del ganador de esa ronda.Tambien dice si se ha ganado
    // una ronda o a habido un empate, en ese caso no gana nadie la ronda.
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
    // Esta función cambia el numero de ronda en el texto
    public void cambiar_ronda(TextView marcador){
        marcador.getText();
        char a= marcador.getText().charAt(6);
        int i= Character.digit(a, 10);
        i++;
        r++;
        // si hay mas de 9 rondas jugadas, poner RONDA 1x
        // puesto que no va a haber mas de 13 rondas, puesto que cuando un jugador
        // llega a 7(maximo de puntos que podemos jugar) termina la partida
        if (r>9){
            char b= Integer.toString(i).charAt(0);
            char c= Integer.toString(j).charAt(0);
            marcador.setText(new String(new char[]{'R','O','N','D','A',' ','1',c}));
            j++;
        }
        else{
            char b= Integer.toString(i).charAt(0);
            marcador.setText(new String(new char[]{'R','O','N','D','A',' ',b}));
        }

    }
    // Esta funcion comprueba los marcadores y si es igual al maximo de puntos
    // entonces salta a las actividades de ganar o perder en funcion de quien
    // de los 2 jugadores gana
    public void terminarPartida(TextView m1,TextView m2,String rondas){
        m1.getText();
        m2.getText();
        if(m1.getText().toString().equals(rondas) || m2.getText().toString().equals(rondas) ){
            if(m1.getText().toString().equals(rondas)){
                Intent i = new Intent(juego_piedrapapeltijera.this,  pierdegana.class);
                i.putExtra("resultado","gana");
                startActivity(i);
            }
            else{
                Intent i = new Intent(juego_piedrapapeltijera.this, pierdegana.class);
                i.putExtra("resultado","pierde");
                startActivity(i);
            }
        }
    }

}
