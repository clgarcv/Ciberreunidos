package ciberreunidossa.ciberreunidos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Daniel on 10/05/2016.
 */
public class Padre extends AppCompatActivity {
    Intent service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        this.service = new Intent(this, ServicioAudio.class);
        startService(service);
       /* melodia = MediaPlayer.create(this, R.raw.musicainicio);
        melodia.setAudioStreamType(AudioManager.STREAM_MUSIC);
        melodia.setLooping(true);
        melodia.start();*/
    }
    public void onStop() {
        super.onStop();
        Intent service = new Intent(this, ServicioAudio.class);
        stopService(service);
        //melodia.stop();
    }
}
