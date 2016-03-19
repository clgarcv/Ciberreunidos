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
        final String vj= bundle.getString("vj");
        final String vm= bundle.getString("vm");
        TextView texto=(TextView) findViewById(R.id.resultado);
        if( resultado.equals("victoria")) {
            texto.setText("VICTORIA\n"+vj+"-"+vm);
        }else{
            texto.setText("DERROTA\n"+vj+"-"+vm);
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
                //De esta manera conseguimos que el boton atras no nos lleve de nuevo a esta misma pagina
                Intent i = getBaseContext().getPackageManager()
                        .getLaunchIntentForPackage( getBaseContext().getPackageName() );
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);

            }
        });
    }
}
