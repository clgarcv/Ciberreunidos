package ciberreunidossa.ciberreunidos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.WindowManager;
import android.widget.EditText;
import java.util.Random;
import android.view.View;


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
        //getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        final EditText editText = (EditText) findViewById(R.id.palabra);
        editText.requestFocus();
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
        eligePalabra();
        creaPalabra(palabra);


    }

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
        EditText texto = (EditText) findViewById(R.id.palabra);

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
        return  true;


    }


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
