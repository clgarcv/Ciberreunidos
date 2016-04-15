package ciberreunidossa.ciberreunidos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class pierdegana extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pierdegana);
        Bundle bundle = getIntent().getExtras();
        final String juego = bundle.getString("juego");

        Button menu = (Button) findViewById(R.id.menu);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(pierdegana.this,pant_ppal.class);
                startActivity(i);
            }
        });


        switch (juego){
            case "ppt": ppt();
                break;
            case "ahorcado": ahorcado();
                break;
            case "3enraya":
                enraya(bundle);
                break;

        }

    }
    public void enraya(Bundle b){
        Button jugar = (Button) findViewById(R.id.jugar);
        final int nJug = b.getInt("jugadores");
        if(nJug==2){
            final String ganador = b.getString("ganador");
            TextView texto = (TextView) findViewById(R.id.resultado);
            if(ganador==null){
                texto.setText("¡LÁSTIMA!\nHa habido un empate entre los jugadores");
                texto.setTextSize(40);
            }else{
                texto.setText("¡ENHORABUENA!\nEl ganador es el "+ganador);
                texto.setTextSize(40);
            }
            jugar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(pierdegana.this, pant_JugadoresEnraya.class);
                    startActivity(i);
                }
            });
        }
    }

    public void ppt(){
        Button jugar = (Button) findViewById(R.id.jugar);

        Bundle bundle = getIntent().getExtras();
        final String resultado = bundle.getString("resultado");
        final String vj = bundle.getString("vj");
        final String vm = bundle.getString("vm");
        TextView texto = (TextView) findViewById(R.id.resultado);
        if (resultado.equals("victoria")) {
            texto.setText("VICTORIA\n" + vj + "-" + vm);
        } else {
            texto.setText("DERROTA\n" + vj + "-" + vm);
        }
        jugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(pierdegana.this, piedrapapeltijera.class);
                startActivity(i);
            }
        });


    }

    public void ahorcado(){
        Button jugar = (Button) findViewById(R.id.jugar);
        Button menu = (Button) findViewById(R.id.menu);
        Bundle bundle = getIntent().getExtras();
        final String resultado = bundle.getString("resultado");
        final String solucion = bundle.getString("solucion");
        TextView texto = (TextView) findViewById(R.id.resultado);
        if (resultado.equals("victoria")) {
            texto.setText("¡ENHORABUENA!\nHas ganado ");
            texto.setTextSize(40);
        } else {
            texto.setText("¡LÁSTIMA!\nLa palabra era "+solucion.toUpperCase());
            texto.setTextSize(40);
        }
        jugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(pierdegana.this, pant_nivelAhorcado.class);
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
