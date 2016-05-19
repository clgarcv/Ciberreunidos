package ciberreunidossa.ciberreunidos;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

public class piedrapapeltijera extends AppCompatActivity {

    MediaPlayer clic;
    MiMusica musica;
    SharedPreferences sharedPrefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_piedrapapeltijerainicio);

        clic = MediaPlayer.create(this, R.raw.clic);
        clic.setAudioStreamType(AudioManager.STREAM_MUSIC);
        sharedPrefs = getSharedPreferences("opciones", MODE_PRIVATE);

        musica.melodia = MediaPlayer.create(this, R.raw.ppt);
        musica.melodia.setAudioStreamType(AudioManager.STREAM_MUSIC);

        Button bt_3= (Button) findViewById(R.id.tres);
        Button bt_5= (Button) findViewById(R.id.cinco);
        Button bt_7= (Button) findViewById(R.id.siete);

            bt_3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (sharedPrefs.getBoolean("efectos", true)) {
                        clic.start();
                    }
                    Intent i = new Intent(piedrapapeltijera.this, juego_piedrapapeltijera.class);
                    i.putExtra("ronda", "3");
                    i.putExtra("melodia", musica);
                    startActivity(i);
                }
            });


            bt_5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (sharedPrefs.getBoolean("efectos", true)) {
                        clic.start();
                    }
                    Intent i = new Intent(piedrapapeltijera.this, juego_piedrapapeltijera.class);
                    i.putExtra("ronda", "5");
                    i.putExtra("melodia", musica);
                    startActivity(i);
                }
            });


            bt_7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (sharedPrefs.getBoolean("efectos", true)) {
                        clic.start();
                    }
                    Intent i = new Intent(piedrapapeltijera.this, juego_piedrapapeltijera.class);
                    i.putExtra("ronda", "7");
                    i.putExtra("melodia", musica);
                    startActivity(i);
                }
            });

    }
    //Cambio comportamiento boton atras
    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            this.startActivity(new Intent(piedrapapeltijera.this, pant_ppal.class));
        }
        return true;
    }

    @Override
    public void onPause() {
        super.onPause();
        musica.melodia.pause();
        //Intent service = new Intent(this, ServicioAudio.class);
        //stopService(service);
        //melodia.stop();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (sharedPrefs.getBoolean("musica", true)) {
            musica.melodia.start();
        }
       // Intent service = new Intent(this, ServicioAudio.class);
        //startService(service);
       /* melodia = MediaPlayer.create(this, R.raw.musicainicio);
        melodia.setAudioStreamType(AudioManager.STREAM_MUSIC);
        melodia.setLooping(true);
        melodia.start();*/
    }



}
