package ciberreunidossa.ciberreunidos;

import android.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;

public class pant_ahorcado extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pant_ahorcado);
        //getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
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

	public static String ponLetra(String pal, String l) {
		String result = "";

		String[] separada = pal.split("");
		// for (String s : separada)
		// System.out.print(s);

		for (String s : separada) {
			if (s.compareTo(l) == 0) {
				result = result + l +" ";
			} else
				result = result + "_ ";
		}
		return result;
	}

*
* */
