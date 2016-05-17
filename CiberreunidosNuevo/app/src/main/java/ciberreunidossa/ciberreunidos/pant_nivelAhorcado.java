package ciberreunidossa.ciberreunidos;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

public class pant_nivelAhorcado extends AppCompatActivity {

    MediaPlayer clic;
    MiMusica musica;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pant_nivel_ahorcado);
        Button facil= (Button) findViewById(R.id.bt_facil);
        Button media= (Button) findViewById(R.id.bt_media);
        Button dificil= (Button) findViewById(R.id.bt_dificil);

        clic = MediaPlayer.create(this, R.raw.clic);
        clic.setAudioStreamType(AudioManager.STREAM_MUSIC);

        musica.melodia = MediaPlayer.create(this, R.raw.ahorcado);
        musica.melodia.setAudioStreamType(AudioManager.STREAM_MUSIC);
        musica.melodia.start();

        facil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clic.start();
                Intent i = new Intent(pant_nivelAhorcado.this, pant_ahorcado.class);
                i.putExtra("dificultad", "facil");
                startActivity(i);
            }
        });
        media.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clic.start();
                Intent i = new Intent(pant_nivelAhorcado.this, pant_ahorcado.class);
                i.putExtra("dificultad", "media");
                startActivity(i);
            }
        });
        dificil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clic.start();
                Intent i = new Intent(pant_nivelAhorcado.this, pant_ahorcado.class);
                i.putExtra("dificultad", "dificil");
                startActivity(i);
            }
        });
    }

    //Cambio del comportamiento del boton atras para que nos lleve a la pantalla principal
    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            this.startActivity(new Intent(pant_nivelAhorcado.this, pant_ppal.class));
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
        musica.melodia.start();
    }
}
