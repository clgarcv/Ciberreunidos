package ciberreunidossa.ciberreunidos;

import android.inputmethodservice.KeyboardView;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;


public class pant_ahorcado extends AppCompatActivity {

    String resultado = "";
    String palabra;

    String[] palabrasn1 = {"A Coruña", "Álava", "Albacete", "Alicante", "Almería", "Araba", "Asturias", "Ávila",
            "Badajoz", "Baleares", "Barcelona", "Bizkaia", "Burgos", "Cáceres", "Cádiz", "Cantabria", "Castellón",
            "Ceuta", "Ciudad Real", "Córdoba", "Cuenca", "Gerona", "Gipuzkoa", "Girona", "Granada", "Guadalajara",
            "Huelva", "Huesca", "Illes Balears", "Jaén", "La Rioja", "Las Palmas", "León", "Lérida", "Lleida", "Lugo",
            "Madrid", "Málaga", "Melilla", "Murcia", "Navarra", "Orense", "Ourense", "Palencia", "Pontevedra",
            "Salamanca", "Santa Cruz de Tenerife", "Segovia", "Sevilla", "Soria", "Tarragona", "Teruel", "Toledo",
            "Valencia", "Valladolid", "Vizcaya", "Zamora", "Zaragoza"};

    String[] palabrasn2 = {"A Coruña", "Álava", "Albacete", "Alicante", "Almería", "Araba", "Asturias", "Ávila",
            "Badajoz", "Baleares", "Barcelona", "Bizkaia", "Burgos", "Cáceres", "Cádiz", "Cantabria", "Castellón",
            "Ceuta", "Ciudad Real", "Córdoba", "Cuenca", "Gerona", "Gipuzkoa", "Girona", "Granada", "Guadalajara",
            "Huelva", "Huesca", "Illes Balears", "Jaén", "La Rioja", "Las Palmas", "León", "Lérida", "Lleida", "Lugo",
            "Madrid", "Málaga", "Melilla", "Murcia", "Navarra", "Orense", "Ourense", "Palencia", "Pontevedra",
            "Salamanca", "Santa Cruz de Tenerife", "Segovia", "Sevilla", "Soria", "Tarragona", "Teruel", "Toledo",
            "Valencia", "Valladolid", "Vizcaya", "Zamora", "Zaragoza"};

    String[] palabrasn3 = {"A Coruña", "Álava", "Albacete", "Alicante", "Almería", "Araba", "Asturias", "Ávila",
            "Badajoz", "Baleares", "Barcelona", "Bizkaia", "Burgos", "Cáceres", "Cádiz", "Cantabria", "Castellón",
            "Ceuta", "Ciudad Real", "Córdoba", "Cuenca", "Gerona", "Gipuzkoa", "Girona", "Granada", "Guadalajara",
            "Huelva", "Huesca", "Illes Balears", "Jaén", "La Rioja", "Las Palmas", "León", "Lérida", "Lleida", "Lugo",
            "Madrid", "Málaga", "Melilla", "Murcia", "Navarra", "Orense", "Ourense", "Palencia", "Pontevedra",
            "Salamanca", "Santa Cruz de Tenerife", "Segovia", "Sevilla", "Soria", "Tarragona", "Teruel", "Toledo",
            "Valencia", "Valladolid", "Vizcaya", "Zamora", "Zaragoza"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pant_ahorcado);
        final TextView palabra = (TextView) findViewById(R.id.palabra);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);

        EditText aux = (EditText) findViewById(R.id.aux);
        aux.requestFocus();
        //eligePalabra();
        //creaPalabra(palabra.getText().toString());

        /*
        //onClick para boton ayuda piedra papel tijera
        palabra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
            }
        });
        */

    }
/*
    public void eligePalabra() {
        Random r = new Random();
        palabra = palabrasn1[r.nextInt(palabrasn1.length)];
    }

    public void creaPalabra(String s) {
        for (int i = 0; i < s.length(); i++) {
            resultado = resultado + "_ ";
        }
        EditText texto = (EditText) findViewById(R.id.palabra);
        texto.setText(resultado);
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        //Keyboard teclado
        TextView texto = (TextView) findViewById(R.id.palabra);
        EditText aux = (EditText) findViewById(R.id.aux);
        String l = aux.getText().toString();
        //texto.setText("");
        texto.setText(l);



        /*
        switch (keyCode) {

            case KeyEvent.KEYCODE_A:
                texto.setText("aaaa");
                break;
            case KeyEvent.KEYCODE_B:
                break;
            case KeyEvent.KEYCODE_C:
                break;
            case KeyEvent.KEYCODE_D:
                break;
            case KeyEvent.KEYCODE_E:
                break;
            case KeyEvent.KEYCODE_F:
                break;
            case KeyEvent.KEYCODE_G:
                break;
            case KeyEvent.KEYCODE_H:
                break;
            case KeyEvent.KEYCODE_I:
                break;
            case KeyEvent.KEYCODE_J:
                break;
            case KeyEvent.KEYCODE_K:
                break;
            case KeyEvent.KEYCODE_L:
                break;
            case KeyEvent.KEYCODE_M:
                break;
            case KeyEvent.KEYCODE_N:
                break;
            case KeyEvent.KEYCODE_O:
                break;
            case KeyEvent.KEYCODE_P:
                break;
            case KeyEvent.KEYCODE_Q:
                break;
            case KeyEvent.KEYCODE_R:
                break;
            case KeyEvent.KEYCODE_S:
                break;
            case KeyEvent.KEYCODE_T:
                break;
            case KeyEvent.KEYCODE_U:
                break;
            case KeyEvent.KEYCODE_V:
                break;
            case KeyEvent.KEYCODE_X:
                break;
            case KeyEvent.KEYCODE_Y:
                break;
            case KeyEvent.KEYCODE_Z:
                break;
            default:
                return super.onKeyUp(keyCode, event);
        }
        return true;


    }
*/

}


/*
*
* public class Ahorcado {

	String[] palabras = { "A Coruña", "Álava", "Albacete", "Alicante", "Almería", "Araba", "Asturias", "Ávila",
			"Badajoz", "Baleares", "Barcelona", "Bizkaia", "Burgos", "Cáceres", "Cádiz", "Cantabria", "Castellón",
			"Ceuta", "Ciudad Real", "Córdoba", "Cuenca", "Gerona", "Gipuzkoa", "Girona", "Granada", "Guadalajara",
			"Huelva", "Huesca", "Illes Balears", "Jaén", "La Rioja", "Las Palmas", "León", "Lérida", "Lleida", "Lugo",
			"Madrid", "Málaga", "Melilla", "Murcia", "Navarra", "Orense", "Ourense", "Palencia", "Pontevedra",
			"Salamanca", "Santa Cruz de Tenerife", "Segovia", "Sevilla", "Soria", "Tarragona", "Teruel", "Toledo",
			"Valencia", "Valladolid", "Vizcaya", "Zamora", "Zaragoza" };

	public static String creaPalabra(String s) {
		String result = "";

		for (int i = 0; i < s.length(); i++) {
			result = result + "_ ";
		}
		return result;
	}




*
* */
