package ciberreunidossa.ciberreunidos;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import logicappt.ppt;

public class juego_piedrapapeltijera extends AppCompatActivity {
    public  ppt ppt= new ppt();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego_piedrapapeltijera);

        ImageButton piedra= (ImageButton) findViewById(R.id.piedra);
        ImageButton tijera= (ImageButton) findViewById(R.id.tijera);
        ImageButton papel= (ImageButton) findViewById(R.id.papel);

        //botones
            //boton piedra
        piedra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ImageButton im1= (ImageButton) findViewById(R.id.imageButton_1);
                ImageButton im2= (ImageButton) findViewById(R.id.imageButton_2);
                im1.setBackgroundResource(R.drawable.piedra_btn);
                if (im1.getBackground()!= null){
                   if(ppt.generaOpcion()=="piedra"){
                       im2.setBackgroundResource(R.drawable.piedra_btn);
                   }
                    else if(ppt.generaOpcion()=="papel"){
                       im2.setBackgroundResource(R.drawable.papel_btn);
                        System.out.println("pierdes");
                   }
                    else {
                       im2.setBackgroundResource(R.drawable.tijera_btn);
                       System.out.println("ganas");
                   }
                }
            }
        });
            //boton tijera
        tijera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageButton im1= (ImageButton) findViewById(R.id.imageButton_1);
                ImageButton im2= (ImageButton) findViewById(R.id.imageButton_2);
                im1.setBackgroundResource(R.drawable.tijera_btn);
                if (im1.getBackground()!= null){
                    if(ppt.generaOpcion()=="piedra"){
                        im2.setBackgroundResource(R.drawable.piedra_btn);
                        System.out.println("pierdes");
                    }
                    else if(ppt.generaOpcion()=="papel"){
                        im2.setBackgroundResource(R.drawable.papel_btn);
                        System.out.println("ganas");
                    }
                    else {
                        im2.setBackgroundResource(R.drawable.tijera_btn);
                    }
                }
            }
        });
            //boton papel
        papel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageButton im1= (ImageButton) findViewById(R.id.imageButton_1);
                ImageButton im2= (ImageButton) findViewById(R.id.imageButton_2);
                im1.setBackgroundResource(R.drawable.papel_btn);
                if (im1.getBackground()!= null){
                    if(ppt.generaOpcion()=="piedra"){
                        im2.setBackgroundResource(R.drawable.piedra_btn);
                        TextView marcador1= (TextView) findViewById(R.id.punt_jug1);
                        sumar_punto(marcador1);
                        System.out.println("ganas");
                    }
                    else if(ppt.generaOpcion()=="papel"){
                        im2.setBackgroundResource(R.drawable.papel_btn);
                    }
                    else {
                        im2.setBackgroundResource(R.drawable.tijera_btn);
                        System.out.println("pierdes");
                        TextView marcador1= (TextView) findViewById(R.id.punt_jug2);
                        sumar_punto(marcador1);
                    }
                }
            }
        });
    }
    public void sumar_punto(TextView marcador){
        marcador.getText();
        char a= marcador.getText().charAt(0);
        int i= Character.digit(a, 10);
        i++;
        char b= Integer.toString(i).charAt(0);
        marcador.setText(new String(new char[] {b} ));
    }
}
