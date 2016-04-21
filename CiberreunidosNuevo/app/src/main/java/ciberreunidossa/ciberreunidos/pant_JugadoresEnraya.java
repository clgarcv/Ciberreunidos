package ciberreunidossa.ciberreunidos;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

public class pant_JugadoresEnraya extends AppCompatActivity {

    MediaPlayer clic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pant_jugadores_enraya);
        Button j1= (Button) findViewById(R.id.bt_1Jugador);
        Button j2= (Button) findViewById(R.id.bt_2Jugadores);

        clic = MediaPlayer.create(this, R.raw.clic);
        clic.setAudioStreamType(AudioManager.STREAM_MUSIC);

        j1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clic.start();
                Intent i = new Intent(pant_JugadoresEnraya.this, pant_enraya.class);
                i.putExtra("njugadores", 1);
                startActivity(i);
            }
        });
        j2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clic.start();
                Intent i = new Intent(pant_JugadoresEnraya.this, pant_enraya.class);
                i.putExtra("njugadores", 2);
                startActivity(i);
            }
        });
    }
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            this.startActivity(new Intent(pant_JugadoresEnraya.this, pant_ppal.class));
        }
        return true;
    }
}
