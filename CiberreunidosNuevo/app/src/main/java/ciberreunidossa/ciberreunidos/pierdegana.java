package ciberreunidossa.ciberreunidos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class pierdegana extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pierdegana);
        Button jugar= (Button) findViewById(R.id.jugar);
        Button menu= (Button) findViewById(R.id.menu);
        Bundle bundle = getIntent().getExtras();
        final String resultado= bundle.getString("resultado");
        TextView texto=(TextView) findViewById(R.id.resultado);
        if( resultado.equals("gana")) {
            texto.setText("HAS GANADO");
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
                Intent i = new Intent(pierdegana.this,  pant_ppal.class);
                startActivity(i);
            }
        });
    }
}
