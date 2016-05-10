package ciberreunidossa.ciberreunidos;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Random;

public class juego_piedrapapeltijera extends Padre {
    //Ronda actual
    int r = 1;
    //Victorias jugador
    int vj;
    //Victorias maquina
    int vm;
    //Opciones maquina
    private String[] opciones = {"piedra", "papel", "tijera"};

    String maquina;

    MediaPlayer clic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego_piedrapapeltijera);
        ImageButton piedra = (ImageButton) findViewById(R.id.piedra);
        ImageButton tijera = (ImageButton) findViewById(R.id.tijera);
        ImageButton papel = (ImageButton) findViewById(R.id.papel);
        final TextView m1 = (TextView) findViewById(R.id.punt_jug1);
        final TextView m2 = (TextView) findViewById(R.id.punt_jug2);

        clic = MediaPlayer.create(this, R.raw.clic);
        clic.setAudioStreamType(AudioManager.STREAM_MUSIC);

        //boton piedra
        piedra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clic.start();
                ImageButton im1 = (ImageButton) findViewById(R.id.imageButton_1);
                im1.setBackgroundResource(R.drawable.piedra_btn);
                juego("piedra");
            }
        });
        //boton tijera
        tijera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clic.start();
                ImageButton im1 = (ImageButton) findViewById(R.id.imageButton_1);
                im1.setBackgroundResource(R.drawable.tijera_btn);
                juego("tijera");

            }
        });
        //boton papel
        papel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clic.start();
                ImageButton im1 = (ImageButton) findViewById(R.id.imageButton_1);
                im1.setBackgroundResource(R.drawable.papel_btn);
                juego("papel");
            }
        });
    }

    //Metodo que genera aleatoriamente la opcion de la maquina.
    public String generaOpcion() {
        Random r = new Random();
        return opciones[r.nextInt(3)];
    }

    //Muestra la imagen de la seleccion de la maquina
    public void mostrarseleccion(String s) {
        int i;
        ImageButton im2 = (ImageButton) findViewById(R.id.imageButton_2);
        if (s == "papel") {
            im2.setBackgroundResource(R.drawable.papel_btn);
        } else if (s == "tijera") {
            im2.setBackgroundResource(R.drawable.tijera_btn);
        } else {
            im2.setBackgroundResource(R.drawable.piedra_btn);
        }
    }

    //metodo que recoge el comportamiento del juego, pasandole como parametro la opcion del jugador
    public void juego(String jugador) {
        maquina = generaOpcion();//Generamos la opcion de la maquina
        //Ralentizar  la aparicion de la imagen de la maquina
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                mostrarseleccion(maquina);//La mostramos
            }
        }, 500);
        //En el caso de que ambas opciones sean las mismas, se suma unicamente ronda
        if (maquina.equals(jugador)) {
            r++;//Incrementamos ronda
            actualizar_marcadores();
        } else {
            //Casos en los que el jugador gana la ronda
            if ((jugador.equals("piedra") && maquina.equals("tijera")) || (jugador.equals("tijera") && maquina.equals("papel")) || (jugador.equals("papel") && maquina.equals("piedra"))) {
                vj++;//Sumamos la victoria al jugador
                r++;//Incrementamos ronda
                actualizar_marcadores();
                finpartida();//Comprobamos si alguno ha ganado la partida
                //Caso en el que el jugador pierde la ronda
            } else {
                vm++;//Sumamos la victoria a la maquina
                r++;//Incrementamos ronda
                actualizar_marcadores();
                finpartida();//Comprobamos si alguno ha ganado la partida
            }
        }
    }

    //Metodo que actualiza los marcadores y el numero de ronda
    public void actualizar_marcadores() {

        ImageButton piedra = (ImageButton) findViewById(R.id.piedra);
        ImageButton tijera = (ImageButton) findViewById(R.id.tijera);
        ImageButton papel = (ImageButton) findViewById(R.id.papel);
        //Desactivamos los botones para que no puedan ser pulsados
        piedra.setEnabled(false);
        tijera.setEnabled(false);
        papel.setEnabled(false);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {

                TextView marcador2 = (TextView) findViewById(R.id.punt_jug2);
                TextView marcador1 = (TextView) findViewById(R.id.punt_jug1);
                marcador1.setText(Integer.toString(vj));
                marcador2.setText(Integer.toString(vm));
            }
        }, 500);
        //Ralentizar  la aparicion de la nueva ronda y la pulsacion de los botones
        Handler handler1 = new Handler();
        handler1.postDelayed(new Runnable() {
            public void run() {
                ImageButton piedra = (ImageButton) findViewById(R.id.piedra);
                ImageButton tijera = (ImageButton) findViewById(R.id.tijera);
                ImageButton papel = (ImageButton) findViewById(R.id.papel);
                TextView txt_ronda = (TextView) findViewById(R.id.textView);
                txt_ronda.setText("RONDA " + Integer.toString(r));
                ImageButton im2 = (ImageButton) findViewById(R.id.imageButton_2);
                im2.setBackgroundResource(0);
                ImageButton im1 = (ImageButton) findViewById(R.id.imageButton_1);
                im1.setBackgroundResource(0);
                piedra.setEnabled(true);
                tijera.setEnabled(true);
                papel.setEnabled(true);
            }
        }, 1500);

    }

    //Metodo que determina si la partida a finalizado
    public void finpartida() {
        Bundle bundle = getIntent().getExtras();
        final String rondas = bundle.getString("ronda");
        //Si las rondas son 3
        if (Integer.parseInt(rondas) == 3) {
            //El jugador o la maquina gana en el momento en que llegen a las 2 victorias
            if (vj == 2) {
                victoria();
            } else if (vm == 2) {
                pierde();
            }
            //Si las rondas son 5
        } else if (Integer.parseInt(rondas) == 5) {
            //El jugador o la maquina gana en el momento en que llegen a las 3 victorias
            if (vj == 3) {
                victoria();
            } else if (vm == 3) {
                pierde();
            }
            //Si las rondas son 7
        } else {
            //El jugador o la maquina gana en el momento en que llegen a las 4 victorias
            if (vj == 4) {
                victoria();
            } else if (vm == 4) {
                pierde();
            }

        }

    }

    //Transicion en el caso de que el jugador haya ganado
    public void victoria() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                Intent i = new Intent(juego_piedrapapeltijera.this, pierdegana.class);
                i.putExtra("resultado", "victoria");
                i.putExtra("juego", "ppt");
                i.putExtra("vj", Integer.toString(vj));
                i.putExtra("vm", Integer.toString(vm));
                startActivity(i);
            }
        }, 1000);

    }

    //Transicion en el caso de que el jugador haya perdido
    public void pierde() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                Intent i = new Intent(juego_piedrapapeltijera.this, pierdegana.class);
                i.putExtra("resultado", "derrota");
                i.putExtra("juego", "ppt");
                i.putExtra("vj", Integer.toString(vj));
                i.putExtra("vm", Integer.toString(vm));
                startActivity(i);
            }

        }, 1000);

    }
}