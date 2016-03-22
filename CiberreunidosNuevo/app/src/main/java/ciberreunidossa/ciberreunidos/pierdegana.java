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
        Button jugar = (Button) findViewById(R.id.jugar);
        Button menu = (Button) findViewById(R.id.menu);
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

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(pierdegana.this,pant_ppal.class);
                startActivity(i);
            }
        });
    }

    //Cambio del comportamiento del boton atras para que nos lleve a la pagina de seleccionar ronda
    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            this.startActivity(new Intent(pierdegana.this, piedrapapeltijera.class));
        }
        return true;
    }
}
