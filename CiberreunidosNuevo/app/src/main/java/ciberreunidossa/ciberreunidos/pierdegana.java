package ciberreunidossa.ciberreunidos;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class pierdegana extends AppCompatActivity {

    MediaPlayer clic;
    MiMusica musica;
    SharedPreferences sharedPrefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pierdegana);

        clic = MediaPlayer.create(this, R.raw.clic);
        clic.setAudioStreamType(AudioManager.STREAM_MUSIC);
        sharedPrefs = getSharedPreferences("opciones", MODE_PRIVATE);

        Bundle bundle = getIntent().getExtras();
        final String juego = bundle.getString("juego");

        Button menu = (Button) findViewById(R.id.menu);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sharedPrefs.getBoolean("efectos", true)) {
                    clic.start();
                }
                Intent i = new Intent(pierdegana.this, pant_ppal.class);
                startActivity(i);
            }
        });


        switch (juego) {
            case "ppt":
                ppt();
                break;
            case "ahorcado":
                ahorcado();
                break;
            case "3enraya":
                enraya(bundle);
                break;
            case "conecta":
                conecta(bundle);
                break;

        }

    }

    public void enraya(Bundle b) {
        Button jugar = (Button) findViewById(R.id.jugar);
        final int nJug = b.getInt("jugadores");
        if (nJug == 2) {
            final String ganador = b.getString("ganador");
            TextView texto = (TextView) findViewById(R.id.resultado);
            if (ganador == null) {
                texto.setText("¡LÁSTIMA!\nHa habido un empate");
                texto.setTextSize(40);
                musica.melodia = MediaPlayer.create(this, R.raw.lose);
                musica.melodia.setAudioStreamType(AudioManager.STREAM_MUSIC);
                if (sharedPrefs.getBoolean("musica", true)) {
                    musica.melodia.start();
                }
            } else {
                texto.setText("¡ENHORABUENA!\nEl ganador es el " + ganador);
                texto.setTextSize(40);
                musica.melodia = MediaPlayer.create(this, R.raw.win);
                musica.melodia.setAudioStreamType(AudioManager.STREAM_MUSIC);
                if (sharedPrefs.getBoolean("musica", true)) {
                    musica.melodia.start();
                }

            }

        } else {
            final String ganador = b.getString("ganador");
            TextView texto = (TextView) findViewById(R.id.resultado);
            if (ganador == null) {
                texto.setText("¡VAYA!\nHa habido un empate");
                texto.setTextSize(40);
                musica.melodia = MediaPlayer.create(this, R.raw.lose);
                musica.melodia.setAudioStreamType(AudioManager.STREAM_MUSIC);
                if (sharedPrefs.getBoolean("musica", true)) {
                    musica.melodia.start();
                }
            } else if (ganador.equals("Jugador 2")) {
                texto.setText("¡LÁSTIMA!\nHas perdido");
                texto.setTextSize(40);
                musica.melodia = MediaPlayer.create(this, R.raw.lose);
                musica.melodia.setAudioStreamType(AudioManager.STREAM_MUSIC);
                musica.melodia.start();

            } else {
                texto.setText("¡ENHORABUENA!\nEres el vencedor");
                texto.setTextSize(40);
                musica.melodia = MediaPlayer.create(this, R.raw.win);
                musica.melodia.setAudioStreamType(AudioManager.STREAM_MUSIC);
                if (sharedPrefs.getBoolean("musica", true)) {
                    musica.melodia.start();
                }

            }

        }
        jugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sharedPrefs.getBoolean("efectos", true)) {
                    clic.start();
                }
                Intent i = new Intent(pierdegana.this, pant_JugadoresPartida.class);
                i.putExtra("juego", "enraya");
                startActivity(i);
            }
        });
    }

    public void ppt() {
        Button jugar = (Button) findViewById(R.id.jugar);

        Bundle bundle = getIntent().getExtras();
        final String resultado = bundle.getString("resultado");
        final String vj = bundle.getString("vj");
        final String vm = bundle.getString("vm");
        TextView texto = (TextView) findViewById(R.id.resultado);
        if (resultado.equals("victoria")) {
            texto.setText("VICTORIA\n" + vj + "-" + vm);
            musica.melodia = MediaPlayer.create(this, R.raw.win);
            musica.melodia.setAudioStreamType(AudioManager.STREAM_MUSIC);
            if (sharedPrefs.getBoolean("musica", true)) {
                musica.melodia.start();
            }
        } else {
            texto.setText("DERROTA\n" + vj + "-" + vm);
            musica.melodia = MediaPlayer.create(this, R.raw.lose);
            musica.melodia.setAudioStreamType(AudioManager.STREAM_MUSIC);
            if (sharedPrefs.getBoolean("musica", true)) {
                musica.melodia.start();
            }
        }
        jugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clic.start();
                Intent i = new Intent(pierdegana.this, piedrapapeltijera.class);
                startActivity(i);
            }
        });


    }

    public void ahorcado() {
        Button jugar = (Button) findViewById(R.id.jugar);
        Button menu = (Button) findViewById(R.id.menu);
        Bundle bundle = getIntent().getExtras();
        final String resultado = bundle.getString("resultado");
        final String solucion = bundle.getString("solucion");
        TextView texto = (TextView) findViewById(R.id.resultado);
        if (resultado.equals("victoria")) {
            texto.setText("¡ENHORABUENA!\nHas ganado ");
            texto.setTextSize(40);
            musica.melodia = MediaPlayer.create(this, R.raw.win);
            musica.melodia.setAudioStreamType(AudioManager.STREAM_MUSIC);
            if (sharedPrefs.getBoolean("musica", true)) {
                musica.melodia.start();
            }
        } else {
            texto.setText("¡LÁSTIMA!\nLa palabra era " + solucion.toUpperCase());
            texto.setTextSize(40);
            musica.melodia = MediaPlayer.create(this, R.raw.lose);
            musica.melodia.setAudioStreamType(AudioManager.STREAM_MUSIC);
            if (sharedPrefs.getBoolean("musica", true)) {
                musica.melodia.start();
            }
        }
        jugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sharedPrefs.getBoolean("efectos", true)) {
                    clic.start();
                }
                Intent i = new Intent(pierdegana.this, pant_nivelAhorcado.class);
                startActivity(i);
            }
        });

    }

    public void conecta(Bundle b) {
        Button jugar = (Button) findViewById(R.id.jugar);
        final int nJug = b.getInt("jugadores");
        if (nJug == 2) {
            final String ganador = b.getString("ganador");
            TextView texto = (TextView) findViewById(R.id.resultado);
            if (ganador == null) {
                texto.setText("¡LÁSTIMA!\nHa habido un empate");
                texto.setTextSize(40);
                musica.melodia = MediaPlayer.create(this, R.raw.lose);
                musica.melodia.setAudioStreamType(AudioManager.STREAM_MUSIC);
                if (sharedPrefs.getBoolean("musica", true)) {
                    musica.melodia.start();
                }
            } else {
                texto.setText("¡ENHORABUENA!\nEl ganador es el " + ganador);
                texto.setTextSize(40);
                musica.melodia = MediaPlayer.create(this, R.raw.win);
                musica.melodia.setAudioStreamType(AudioManager.STREAM_MUSIC);
                if (sharedPrefs.getBoolean("musica", true)) {
                    musica.melodia.start();
                }
            }

        } else {
            final String ganador = b.getString("ganador");
            TextView texto = (TextView) findViewById(R.id.resultado);
            if (ganador == null) {
                texto.setText("¡VAYA!\nHa habido un empate");
                texto.setTextSize(40);
                musica.melodia = MediaPlayer.create(this, R.raw.lose);
                musica.melodia.setAudioStreamType(AudioManager.STREAM_MUSIC);
                if (sharedPrefs.getBoolean("musica", true)) {
                    musica.melodia.start();
                }
            } else if (ganador.equals("Jugador 2")) {
                texto.setText("¡LÁSTIMA!\nHas perdido");
                texto.setTextSize(40);
                musica.melodia = MediaPlayer.create(this, R.raw.lose);
                musica.melodia.setAudioStreamType(AudioManager.STREAM_MUSIC);
                if (sharedPrefs.getBoolean("musica", true)) {
                    musica.melodia.start();
                }

            } else {
                texto.setText("¡ENHORABUENA!\nEres el vencedor");
                texto.setTextSize(40);
                musica.melodia = MediaPlayer.create(this, R.raw.win);
                musica.melodia.setAudioStreamType(AudioManager.STREAM_MUSIC);
                if (sharedPrefs.getBoolean("musica", true)) {
                    musica.melodia.start();
                }

            }

        }
        jugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sharedPrefs.getBoolean("efectos", true)) {
                    clic.start();
                }
                Intent i = new Intent(pierdegana.this, pant_JugadoresPartida.class);
                i.putExtra("juego", "conecta");
                startActivity(i);
            }
        });
    }

    //Cambio del comportamiento del boton atras para que nos lleve a la pantalla principal
    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            this.startActivity(new Intent(pierdegana.this, pant_ppal.class));
        }
        return true;
    }
}
