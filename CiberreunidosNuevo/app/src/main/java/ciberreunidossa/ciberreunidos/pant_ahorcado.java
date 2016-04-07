package ciberreunidossa.ciberreunidos;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;


public class pant_ahorcado extends AppCompatActivity {

    String resultado = "";
    String palabra="";
    int fallos = 0;

    String[] palabrasn1 = {"pera","mesa","casa","reloj","carta","silla","cama","lapiz","raton","movil","sofa","cartel","letra","boton","papel","marco"};

    String[] palabrasn2 = {"paraguas","iceberg","onomatopeya","invernadero","ordenador","impresora","altavoz","teclado","almacen","cacahuete","zanahoria","calefaccion","pizarra","perchero","persiana","tuberia","zapatilla","pestaña","lentilla"};

    String[] palabrasn3 = {"ventrilocuo","excentrico","hostigar","degollar","pescuezo","fascinante","extension","hachazo","hegemonia","impermeable","disciplinado","jerogrifico","lombriz"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pant_ahorcado);
        //final TextView palabraT = (TextView) findViewById(R.id.palabra);
        //final ImageView imgAhorcado = (ImageView) findViewById(R.id.img_ahocado);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);

        eligePalabra();
        creaPalabra(palabra);
        System.out.println(palabra);

    }

    public void eligePalabra() {
        Random r = new Random();
        palabra = palabrasn1[r.nextInt(palabrasn1.length)];
    }

    public void creaPalabra(String s) {
        for (int i = 0; i < s.length(); i++) {
            resultado = resultado + "_ ";
        }
        TextView texto = (TextView) findViewById(R.id.palabra);
        System.out.println(resultado);
        texto.setText(resultado);
    }

    public String ponLetra(String palabra, String resultado, String letra) {

        String [] palSep = palabra.toUpperCase().split("");
        String [] resultSep = resultado.toUpperCase().split(" ");

        resultado = "";

        for (int i = 0; i < palSep.length; i++) {
            //recorro la palabra y compruebo la posicion donde este la letra
            if(palSep[i].equals(letra)){
                resultSep[i-1] = letra;
            }
        }

        //generamos la palabra a mostrar
        for (String s : resultSep) {
            resultado = resultado + s +" ";
        }

        return resultado;
    }

    public boolean estaLetra (String palabra, String letra) {
        return palabra.toUpperCase().contains(letra.toUpperCase());
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {

        int img = R.drawable.ahorcado_fallo_+fallos;

        TextView texto = (TextView) findViewById(R.id.palabra);
        ImageView imgAhorcado = (ImageView) findViewById(R.id.img_ahocado);


        char l = (char) event.getUnicodeChar();
        String letra = Character.toString(l).toUpperCase();
        //texto.setText(Character.toString(letra));
        System.out.println(letra);

        if(estaLetra(palabra, letra)){
            //si la letra forma parte de la palabra la mostramos
            resultado = ponLetra(palabra, resultado, letra);
            texto.setText(resultado);
        } else {
            fallos++;
            //si la letra no forma parte de la palabra actualizamos el ahorcado
            imgAhorcado.setImageResource(R.drawable.ahorcado_fallo_+fallos);
            System.out.println(img);
            System.out.println(R.drawable.ahorcado_fallo_+fallos);
            System.out.println("la imagen del ahorcado modificada");
        }
        System.out.println(resultado);
        return true;

    }
}

