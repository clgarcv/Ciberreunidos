package ciberreunidossa.ciberreunidos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class pant_ppal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pant_ppal);

        ImageButton btn_ppt = (ImageButton) findViewById(R.id.btn_ppt);
        ImageButton btn_ahorcado = (ImageButton) findViewById(R.id.btn_ahorcado);
        ImageButton btn_enraya = (ImageButton) findViewById(R.id.btn_enraya);
        ImageButton btn_parchis = (ImageButton) findViewById(R.id.btn_parchis);

        //definimos las funciones onClick para los botones

        btn_ppt.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                Intent i = new Intent(pant_ppal.this, piedrapapeltijera.class);
                startActivity(i);
            }
        });




    }
}
