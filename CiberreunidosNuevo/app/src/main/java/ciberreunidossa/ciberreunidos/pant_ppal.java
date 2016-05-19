package ciberreunidossa.ciberreunidos;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class pant_ppal extends AppCompatActivity {
    MediaPlayer clic, melodia;
    Intent service;
    SharedPreferences sharedPrefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pant_ppal);

        sharedPrefs = getSharedPreferences("opciones", MODE_PRIVATE);
        //Audio musica = new Audio(getWindow().getContext(), new File(R.raw.musicainicio));

        ImageButton btn_ppt = (ImageButton) findViewById(R.id.btn_ppt);
        ImageButton btn_ahorcado = (ImageButton) findViewById(R.id.btn_ahorcado);
        ImageButton btn_enraya = (ImageButton) findViewById(R.id.btn_enraya);
        ImageButton btn_conecta = (ImageButton) findViewById(R.id.btn_conecta);
        ImageButton btn_ajustes = (ImageButton) findViewById(R.id.btn_ajustes);
        ImageButton btn_ayuda = (ImageButton) findViewById(R.id.btn_ayuda);
        ImageButton btn_candado = (ImageButton) findViewById(R.id.btn_candado);
        clic = MediaPlayer.create(this, R.raw.clic);
        clic.setAudioStreamType(AudioManager.STREAM_MUSIC);

        //ser.onCreate();

        //melodia.start();

        //definimos las funciones onClick para los botones
        //onClick para boton piedra papel tijera
        btn_ppt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sharedPrefs.getBoolean("efectos", true)) {
                    clic.start();
                }

                Intent i = new Intent(pant_ppal.this, piedrapapeltijera.class);
                startActivity(i);
            }
        });

        //onClick para boton ahorcado
        btn_ahorcado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sharedPrefs.getBoolean("efectos", true)) {
                    clic.start();
                }

                Intent i = new Intent(pant_ppal.this, pant_nivelAhorcado.class);
                startActivity(i);
            }
        });

        //onClick para boton 3 en raya
        btn_enraya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sharedPrefs.getBoolean("efectos", true)) {
                    clic.start();
                }

                Intent i = new Intent(pant_ppal.this, pant_JugadoresPartida.class);
                i.putExtra("juego", "enraya");
                startActivity(i);
            }
        });

        //onClick para boton conecta 4
        btn_conecta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sharedPrefs.getBoolean("efectos", true)) {
                    clic.start();
                }

                Intent i = new Intent(pant_ppal.this, pant_JugadoresPartida.class);
                i.putExtra("juego", "conecta");
                startActivity(i);
            }
        });

        //onClick para boton ajustes
        btn_ajustes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sharedPrefs.getBoolean("efectos", true)) {
                    clic.start();
                }

                Intent i = new Intent(pant_ppal.this, pant_ajustes.class);
                // i.putExtra("melodia", service);
                // i.putExtra("efectos", (Serializable) clic);
                startActivity(i);
            }
        });

        //onClick para boton ayuda
        btn_ayuda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sharedPrefs.getBoolean("efectos", true)) {
                    clic.start();
                }

                Intent i = new Intent(pant_ppal.this, pant_ayuda.class);
                startActivity(i);

            }
        });
        btn_candado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast1 =
                        Toast.makeText(getApplicationContext(),
                                "No disponible", Toast.LENGTH_SHORT);
                toast1.show();
            }
        });

    }

    //Boton atras para salir de la aplicacion
    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        super.onKeyUp(keyCode, event);
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);

        }
        return true;
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
        service = new Intent(this, ServicioAudio.class);

        if (sharedPrefs.getBoolean("musica", true)) {
            startService(service);
        }

       /* melodia = MediaPlayer.create(this, R.raw.musicainicio);
        melodia.setAudioStreamType(AudioManager.STREAM_MUSIC);
        melodia.setLooping(true);
        melodia.start();*/
    }


}
