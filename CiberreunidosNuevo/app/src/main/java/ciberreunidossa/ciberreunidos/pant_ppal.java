package ciberreunidossa.ciberreunidos;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageButton;

public class pant_ppal extends AppCompatActivity {
    MediaPlayer clic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pant_ppal);

        ImageButton btn_ppt = (ImageButton) findViewById(R.id.btn_ppt);
        ImageButton btn_ahorcado = (ImageButton) findViewById(R.id.btn_ahorcado);
        ImageButton btn_enraya = (ImageButton) findViewById(R.id.btn_enraya);
        ImageButton btn_conecta = (ImageButton) findViewById(R.id.btn_conecta);
        ImageButton btn_ajustes = (ImageButton) findViewById(R.id.btn_ajustes);
        ImageButton btn_ayuda = (ImageButton) findViewById(R.id.btn_ayuda);

        clic = MediaPlayer.create(this, R.raw.clic);
        clic.setAudioStreamType(AudioManager.STREAM_MUSIC);

        //definimos las funciones onClick para los botones
        //onClick para boton piedra papel tijera
        btn_ppt.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                clic.start();
                Intent i = new Intent(pant_ppal.this, piedrapapeltijera.class);
                startActivity(i);
            }
        });

        //onClick para boton ahorcado
        btn_ahorcado.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                clic.start();
                Intent i = new Intent(pant_ppal.this,pant_nivelAhorcado.class);
                startActivity(i);
            }
        });

        //onClick para boton 3 en raya
        btn_enraya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clic.start();
                Intent i = new Intent(pant_ppal.this, pant_JugadoresEnraya.class);
                startActivity(i);
            }
        });

        //onClick para boton ajustes
        btn_ajustes.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                clic.start();
                Intent i = new Intent(pant_ppal.this, pant_ajustes.class);
                startActivity(i);
            }
        });

        //onClick para boton ayuda
        btn_ayuda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clic.start();
                Intent i = new Intent(pant_ppal.this, pant_ayuda.class);
                startActivity(i);
            }
        });
        //onClick para boton parchis
        btn_conecta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
    //Boton atras para salir de la aplicacion
    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
        return true;
    }

    

}
