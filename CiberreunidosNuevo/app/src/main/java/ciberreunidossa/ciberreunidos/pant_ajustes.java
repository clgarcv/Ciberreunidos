package ciberreunidossa.ciberreunidos;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.ToggleButton;

public class pant_ajustes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pant_ajustes);
        ToggleButton toggle = (ToggleButton) findViewById(R.id.btn_musica);
        toggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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
