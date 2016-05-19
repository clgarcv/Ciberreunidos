package ciberreunidossa.ciberreunidos;


import android.content.Intent;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ToggleButton;

public class pant_ajustes extends AppCompatActivity {

    MiMusica musica;
    MediaPlayer efectos;
    SharedPreferences sharedPrefs;
    Intent service;
    MediaPlayer clic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pant_ajustes);

        final ToggleButton btn_musica = (ToggleButton) findViewById(R.id.btn_musica);
        sharedPrefs = getSharedPreferences("opciones", MODE_PRIVATE);
        btn_musica.setChecked(sharedPrefs.getBoolean("musica", true));

        final ToggleButton btn_efectos = (ToggleButton) findViewById(R.id.btn_efectos);
        btn_efectos.setChecked(sharedPrefs.getBoolean("efectos", true));
        service = new Intent(this, ServicioAudio.class);
        clic = MediaPlayer.create(this, R.raw.clic);
        clic.setAudioStreamType(AudioManager.STREAM_MUSIC);

        final ImageView imagen_musica = (ImageView) findViewById(R.id.notas);
        final ImageView imagen_efectos = (ImageView) findViewById(R.id.altavoz);
        if (!sharedPrefs.getBoolean("efectos", true)) {
            imagen_efectos.setImageResource(R.drawable.altavoz_ajuste_off);
        }
        if (!sharedPrefs.getBoolean("musica", true)) {
            imagen_musica.setImageResource(R.drawable.ajustes_notas_off);
        }
        btn_musica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sharedPrefs.getBoolean("efectos", true)) {
                    clic.start();
                }
                if (btn_musica.isChecked()) {
                    SharedPreferences.Editor editor = getSharedPreferences("opciones", MODE_PRIVATE).edit();
                    editor.putBoolean("musica", true);
                    editor.commit();
                    startService(service);
                    imagen_musica.setImageResource(R.drawable.ajustes_notas);
                } else {
                    SharedPreferences.Editor editor = getSharedPreferences("opciones", MODE_PRIVATE).edit();
                    editor.putBoolean("musica", false);
                    editor.commit();
                    stopService(service);
                    imagen_musica.setImageResource(R.drawable.ajustes_notas_off);
                }
            }
        });
        btn_efectos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sharedPrefs.getBoolean("efectos", true)) {
                    clic.start();
                }
                if (btn_efectos.isChecked()) {
                    SharedPreferences.Editor editor = getSharedPreferences("opciones", MODE_PRIVATE).edit();
                    editor.putBoolean("efectos", true);
                    editor.commit();
                    imagen_efectos.setImageResource(R.drawable.altavoz_ajuste);
                } else {
                    SharedPreferences.Editor editor = getSharedPreferences("opciones", MODE_PRIVATE).edit();
                    editor.putBoolean("efectos", false);
                    editor.commit();
                    imagen_efectos.setImageResource(R.drawable.altavoz_ajuste_off);

                }
            }
        });


    }

    @Override
    public void onPause() {
        super.onPause();

        stopService(service);

    }

    @Override
    public void onResume() {
        super.onResume();

        if (sharedPrefs.getBoolean("musica", true)) {
            startService(service);
        }
       /* melodia = MediaPlayer.create(this, R.raw.musicainicio);
        melodia.setAudioStreamType(AudioManager.STREAM_MUSIC);
        melodia.setLooping(true);
        melodia.start();*/
    }


}
