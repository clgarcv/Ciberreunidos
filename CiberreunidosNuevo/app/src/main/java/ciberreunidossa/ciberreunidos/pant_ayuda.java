package ciberreunidossa.ciberreunidos;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class pant_ayuda extends AppCompatActivity {

    MediaPlayer clic;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pant_ayuda);

        clic = MediaPlayer.create(this, R.raw.clic);
        clic.setAudioStreamType(AudioManager.STREAM_MUSIC);

        ImageButton btn_ay_ppt = (ImageButton) findViewById(R.id.btn_ayu_ppt);
        ImageButton btn_ay_ahorcado = (ImageButton) findViewById(R.id.btn_ayu_ahorcado);
        ImageButton btn_ay_enraya = (ImageButton) findViewById(R.id.btn_ayu_enraya);
        ImageButton btn_ay_conecta = (ImageButton) findViewById(R.id.btn_ayu_conect4);

        final TextView txt_titulo = (TextView) findViewById(R.id.txtTitulo);
        final TextView txt_ayuda = (TextView) findViewById(R.id.txtInfo);


        //onClick para boton ayuda piedra papel tijera
        btn_ay_ppt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clic.start();
                txt_titulo.setText("Piedra, papel o tijera");
                txt_ayuda.setText("En primer lugar se selecionará el número de rondas que se desea jugar, pudiendo ser 3, 5 o 7 rondas. Al seleccionar la ronda comenzará el juego, dando como ganador al mejor del número de rondas selecionadas. Por ejemplo si seleciona 3 rondas, ganará el mejor de 3.\n");
            }
        });

        //onClick para boton ayuda ahorcado
        btn_ay_ahorcado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clic.start();
                txt_titulo.setText("Ahorcado");
                txt_ayuda.setText("El objetivo será encontrar la palabra escondida antes de completar el ahorcado. Para ello se iran pulsando letras de una en una. Si la letra forma parte de la palabra se colocará en la posición correcta, en caso contrario, que la letra no este en la palabra se añadira una parte al ahorcado. El juego termina cuando se complete la palabra o se complete el ahorcado.\n");
            }
        });


        //onClick para boton ayuda 3 en raya
        btn_ay_enraya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clic.start();
                txt_titulo.setText("3 en raya");
                txt_ayuda.setText("El funcionamiento del juego consiste en conseguir poner 3 fichas iguales adyacentes, bien sea en horizontal, vertical o en diagonal. En primer lugar tendrá que selccionar con que ficha desea jugar, X o O. \n");
            }
        });

        //onClick para boton ayuda parchis

        btn_ay_conecta.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                clic.start();
                txt_titulo.setText("Conecta 4");
                txt_ayuda.setText("El objetivo de Conecta 4 es alinear cuatro fichas sobre un tablero formado por seis filas y seis columnas. Por turnos, los jugadores deben introducir una ficha en la columna que prefieran y ésta caerá a la posición más baja. Gana la partida el primero que consiga alinear cuatro fichas consecutivas de un mismo color en horizontal, vertical o diagona.\n");
            }
        });


    }

    @Override
    public void onPause() {
        super.onPause();
        Intent service = new Intent(this, ServicioAudio.class);
        stopService(service);
        //melodia.stop();
    }

    @Override
    public void onResume() {
        super.onResume();
        Intent service = new Intent(this, ServicioAudio.class);
        startService(service);
       /* melodia = MediaPlayer.create(this, R.raw.musicainicio);
        melodia.setAudioStreamType(AudioManager.STREAM_MUSIC);
        melodia.setLooping(true);
        melodia.start();*/
    }

}
