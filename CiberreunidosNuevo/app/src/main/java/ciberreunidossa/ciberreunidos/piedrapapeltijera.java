package ciberreunidossa.ciberreunidos;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class piedrapapeltijera extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_piedrapapeltijerainicio);

        Button bt_3= (Button) findViewById(R.id.tres);
        Button bt_5= (Button) findViewById(R.id.cinco);
        Button bt_7= (Button) findViewById(R.id.siete);


       bt_3.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                Intent i = new Intent(piedrapapeltijera.this, juego_piedrapapeltijera.class); //cambiar clase
                i.putExtra("ronda",3);
                startActivity(i);
            }
        });


        bt_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(piedrapapeltijera.this, juego_piedrapapeltijera.class);
                i.putExtra("ronda",3);
                startActivity(i);
            }
        });
        bt_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(piedrapapeltijera.this, juego_piedrapapeltijera.class);
                i.putExtra("ronda",3);
                startActivity(i);
            }
        });

    }


}
