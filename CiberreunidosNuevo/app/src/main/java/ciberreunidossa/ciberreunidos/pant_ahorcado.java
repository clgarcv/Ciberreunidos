package ciberreunidossa.ciberreunidos;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;


public class pant_ahorcado extends AppCompatActivity {

    String resultado = "";
    String palabra = "";
    int fallos = 0;

    String[] palabrasn1 = {"pera", "mesa", "casa", "reloj", "carta", "silla", "cama", "duda", "abeto", "cono", "sofa", "cartel", "letra", "saco", "papel", "marco"};

    String[] palabrasn2 = {"paraguas", "iceberg", "sombrilla", "ordenador", "impresora", "altavoz", "teclado", "comercial", "hachazo", "zanahoria", "galera", "pizarra", "perchero", "persiana", "lombriz", "zapatilla", "vestido", "lentilla"};

    String[] palabrasn3 = {"invernadero", "neandertal", "hostigar", "degollar", "pescuezo", "fascinante", "camioneta", "cacahuete", "onomatopeya", "impermeable", "disciplinado", "jerogrifico", "catalizador"};

    String[] palabraFin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pant_ahorcado);
        Bundle bundle = getIntent().getExtras();
        final String dificultad = bundle.getString("dificultad");
        if (dificultad.equals("facil")) {
            palabraFin = palabrasn1;
        } else if (dificultad.equals("media")) {
            palabraFin = palabrasn2;
        } else {
            palabraFin = palabrasn3;
        }
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
        eligePalabra();
        creaPalabra(palabra);
        System.out.println(palabra);

        final TextView texto = (TextView) findViewById(R.id.palabra);
        texto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("he pulsado el cuadro de texto");
                texto.requestFocus();
                //metodo para que al pulsar en la palabra aparezca el teclado
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.toggleSoftInput(InputMethodManager.SHOW_IMPLICIT, 0);
            }
        });


    }

    public void eligePalabra() {
        Random r = new Random();
        palabra = palabraFin[r.nextInt(palabraFin.length)];
    }

    public void creaPalabra(String s) {
        for (int i = 0; i < s.length(); i++) {
            resultado = resultado + "_ ";
        }
        final TextView texto = (TextView) findViewById(R.id.palabra);
        System.out.println(resultado);
        texto.setText(resultado);

    }

    public String ponLetra(String palabra, String resultado, String letra) {

        String[] palSep = palabra.toUpperCase().split("");
        String[] resultSep = resultado.toUpperCase().split(" ");

        resultado = "";

        for (int i = 0; i < palSep.length; i++) {
            //recorro la palabra y compruebo la posicion donde este la letra
            if (palSep[i].equals(letra)) {
                resultSep[i - 1] = letra;
            }
        }

        //generamos la palabra a mostrar
        for (String s : resultSep) {
            resultado = resultado + s + " ";
        }

        return resultado;
    }

    public boolean estaLetra(String palabra, String letra) {
        return palabra.toUpperCase().contains(letra.toUpperCase());
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_VOLUME_UP || keyCode == KeyEvent.KEYCODE_VOLUME_DOWN) {
            //no hace nada para q no cuente como fallo

        } else {
            int img = R.drawable.ahorcado_fallo_ + fallos;
            TextView texto = (TextView) findViewById(R.id.palabra);
            ImageView imgAhorcado = (ImageView) findViewById(R.id.img_ahocado);
            char l = (char) event.getUnicodeChar();
            String letra = Character.toString(l).toUpperCase();

            if (letra.matches("[A-Z]?")) {
                //texto.setText(Character.toString(letra));
                System.out.println(letra);

                if (estaLetra(palabra, letra)) {
                    //si la letra forma parte de la palabra la mostramos
                    resultado = ponLetra(palabra, resultado, letra);
                    texto.setText(resultado);
                } else {
                    fallos++;
                    //si la letra no forma parte de la palabra actualizamos el ahorcado
                    imgAhorcado.setImageResource(R.drawable.ahorcado_fallo_ + fallos);

                }
                System.out.println(resultado);
            }
        }

        return true;

    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            this.startActivity(new Intent(pant_ahorcado.this, pant_ppal.class));
        }
        if (fallos == 7) {
            //si ha perdido
            Intent i = new Intent(pant_ahorcado.this, pierdegana.class);
            i.putExtra("juego", "ahorcado");
            i.putExtra("resultado", "derrota");
            i.putExtra("solucion", palabra);
            startActivity(i);


        } else if (!resultado.contains("_")) {
            //si ha ganado
            //Transicion en el caso de que el jugador haya ganado
            Intent i = new Intent(pant_ahorcado.this, pierdegana.class);
            i.putExtra("juego", "ahorcado");
            i.putExtra("resultado", "victoria");
            startActivity(i);
        }


        return true;
    }

}


/* if (fallos == 7) {
                //si ha perdido
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {
                        Intent i = new Intent(pant_ahorcado.this, pierdegana.class);
                        i.putExtra("juego", "ahorcado");
                        i.putExtra("resultado", "derrota");
                        startActivity(i);
                    }

                }, 1000);

            } else if (!resultado.contains("_")) {
                //si ha ganado
                //Transicion en el caso de que el jugador haya ganado
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {
                        Intent i = new Intent(pant_ahorcado.this, pierdegana.class);
                        i.putExtra("juego", "ahorcado");
                        i.putExtra("resultado", "victoria");
                        startActivity(i);
                    }
                }, 1000);
            }
            */




