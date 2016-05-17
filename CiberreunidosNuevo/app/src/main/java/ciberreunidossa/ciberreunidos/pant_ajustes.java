package ciberreunidossa.ciberreunidos;


import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ToggleButton;

public class pant_ajustes extends AppCompatActivity {

    MiMusica musica;
    MediaPlayer efectos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pant_ajustes);

        //musica = (MiMusica) getIntent().getExtras().getSerializable("melodia");
        //efectos = (MediaPlayer) getIntent().getExtras().getSerializable("efectos");

        ToggleButton btn_musica = (ToggleButton) findViewById(R.id.btn_musica);

        ToggleButton btn_efectos = (ToggleButton) findViewById(R.id.btn_efectos);

/*
        if (btn_musica.getText().toString().compareTo("ON") == 0) {
            //si el boton esta encendido activamos la musica
            musica.melodia.setVolume(0, 0);


        } else if (btn_musica.getText().toString().compareTo("OFF") == 0) {
            //si el boton esta apagado muteamos la musica
            musica.melodia.setVolume(100, 100);
        }

        if (btn_efectos.getText().toString().compareTo("ON") == 0) {
            //si el boton esta encendido activamos los efectos
            efectos.setVolume(0, 0);

        } else if (btn_efectos.getText().toString().compareTo("OFF") == 0) {
            //si el boton esta apagado muteamos los efectos
            efectos.setVolume(100, 100);
        }


        btn_musica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
*/
    }

    @Override
    public void onPause() {
        super.onPause();
        //Intent service = new Intent(this, ServicioAudio.class);
        //stopService(service);
        //melodia.stop();
    }

    @Override
    public void onResume() {
        super.onResume();
        //Intent service = new Intent(this, ServicioAudio.class);
        //startService(service);
       /* melodia = MediaPlayer.create(this, R.raw.musicainicio);
        melodia.setAudioStreamType(AudioManager.STREAM_MUSIC);
        melodia.setLooping(true);
        melodia.start();*/
    }


}
