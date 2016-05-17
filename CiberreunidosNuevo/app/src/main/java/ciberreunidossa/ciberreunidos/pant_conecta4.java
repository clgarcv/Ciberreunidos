package ciberreunidossa.ciberreunidos;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class pant_conecta4 extends AppCompatActivity {
    private Conecta4 con;
    static int contador;
    String ganador;
    final List<ImageView> botones = new ArrayList<ImageView>();

    MediaPlayer clic;

    MiMusica musica;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pant_conecta4);

        clic = MediaPlayer.create(this, R.raw.clic);
        clic.setAudioStreamType(AudioManager.STREAM_MUSIC);

        musica = (MiMusica)getIntent().getExtras().getSerializable("melodia");

        con = new Conecta4();
        contador = 1;
        Bundle bundle = getIntent().getExtras();
        final int nJug = bundle.getInt("njugadores");
        //columna 1
        ImageView con11 = (ImageView) findViewById(R.id.con11);
        ImageView con12 = (ImageView) findViewById(R.id.con12);
        ImageView con13 = (ImageView) findViewById(R.id.con13);
        ImageView con14 = (ImageView) findViewById(R.id.con14);
        ImageView con15 = (ImageView) findViewById(R.id.con15);
        ImageView con16 = (ImageView) findViewById(R.id.con16);
        botones.add(con11);
        botones.add(con12);
        botones.add(con13);
        botones.add(con14);
        botones.add(con15);
        botones.add(con16);

        //columna 2
        ImageView con21 = (ImageView) findViewById(R.id.con21);
        ImageView con22 = (ImageView) findViewById(R.id.con22);
        ImageView con23 = (ImageView) findViewById(R.id.con23);
        ImageView con24 = (ImageView) findViewById(R.id.con24);
        ImageView con25 = (ImageView) findViewById(R.id.con25);
        ImageView con26 = (ImageView) findViewById(R.id.con26);
        botones.add(con21);
        botones.add(con22);
        botones.add(con23);
        botones.add(con24);
        botones.add(con25);
        botones.add(con26);

        //columna 3
        ImageView con31 = (ImageView) findViewById(R.id.con31);
        ImageView con32 = (ImageView) findViewById(R.id.con32);
        ImageView con33 = (ImageView) findViewById(R.id.con33);
        ImageView con34 = (ImageView) findViewById(R.id.con34);
        ImageView con35 = (ImageView) findViewById(R.id.con35);
        ImageView con36 = (ImageView) findViewById(R.id.con36);
        botones.add(con31);
        botones.add(con32);
        botones.add(con33);
        botones.add(con34);
        botones.add(con35);
        botones.add(con36);

        //columna 4
        ImageView con41 = (ImageView) findViewById(R.id.con41);
        ImageView con42 = (ImageView) findViewById(R.id.con42);
        ImageView con43 = (ImageView) findViewById(R.id.con43);
        ImageView con44 = (ImageView) findViewById(R.id.con44);
        ImageView con45 = (ImageView) findViewById(R.id.con45);
        ImageView con46 = (ImageView) findViewById(R.id.con46);
        botones.add(con41);
        botones.add(con42);
        botones.add(con43);
        botones.add(con44);
        botones.add(con45);
        botones.add(con46);

        //columna 5
        ImageView con51 = (ImageView) findViewById(R.id.con51);
        ImageView con52 = (ImageView) findViewById(R.id.con52);
        ImageView con53 = (ImageView) findViewById(R.id.con53);
        ImageView con54 = (ImageView) findViewById(R.id.con54);
        ImageView con55 = (ImageView) findViewById(R.id.con55);
        ImageView con56 = (ImageView) findViewById(R.id.con56);
        botones.add(con51);
        botones.add(con52);
        botones.add(con53);
        botones.add(con54);
        botones.add(con55);
        botones.add(con56);

        //columna 6
        ImageView con61 = (ImageView) findViewById(R.id.con61);
        ImageView con62 = (ImageView) findViewById(R.id.con62);
        ImageView con63 = (ImageView) findViewById(R.id.con63);
        ImageView con64 = (ImageView) findViewById(R.id.con64);
        ImageView con65 = (ImageView) findViewById(R.id.con65);
        ImageView con66 = (ImageView) findViewById(R.id.con66);
        botones.add(con61);
        botones.add(con62);
        botones.add(con63);
        botones.add(con64);
        botones.add(con65);
        botones.add(con66);

        if (nJug == 1) {
            for (ImageView img : botones) {
                img.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ponFicha(v.getId());
                        if (!con.finalJuego()) {
                            contador++;
                            juegaMaquina();

                            Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    if (con.finalJuego()) {
                                        Handler handler = new Handler();
                                        handler.postDelayed(new Runnable() {
                                            @Override
                                            public void run() {
                                                Intent i = new Intent(pant_conecta4.this, pierdegana.class);
                                                i.putExtra("juego", "conecta");
                                                if (con.comprobarCuatro(1)) ganador = "Jugador 1";
                                                else if (con.comprobarCuatro(2))
                                                    ganador = "Jugador 2";
                                                i.putExtra("ganador", ganador);
                                                startActivity(i);
                                            }
                                        }, 500);
                                    } else {
                                        for (ImageView i : botones) {
                                            if (i.getDrawable() == null) {
                                                i.setEnabled(true);
                                            }
                                        }
                                        contador++;
                                    }
                                }
                            }, 500);
                        } else {
                            for (ImageView i : botones) {
                                i.setEnabled(false);
                            }
                            Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    Intent i = new Intent(pant_conecta4.this, pierdegana.class);
                                    i.putExtra("juego", "conecta");
                                    if (con.comprobarCuatro(1)) ganador = "Jugador 1";
                                    else if (con.comprobarCuatro(2)) ganador = "Jugador 2";
                                    i.putExtra("ganador", ganador);
                                    startActivity(i);
                                }
                            }, 500);
                        }
                    }
                });

            }
        }
        // si son 2 jugadores
        else {
            for (ImageView img : botones) {
                img.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ponFicha(v.getId());
                        if (!con.finalJuego()) {
                            contador++;
                        } else {
                            if (con.comprobarCuatro(1)) {
                                ganador = "Jugador 1";
                            } else if (con.comprobarCuatro(2)) {
                                ganador = "Jugador 2";
                            }
                            Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                public void run() {
                                    Intent i = new Intent(pant_conecta4.this, pierdegana.class);
                                    i.putExtra("juego", "conecta");
                                    i.putExtra("jugadores", nJug);
                                    i.putExtra("ganador", ganador);
                                    startActivity(i);
                                }
                            }, 500);
                        }
                    }
                });
            }
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        musica.melodia.pause();
    }

    @Override
    public void onResume() {
        super.onResume();
        musica.melodia.start();
    }

    //auxiliares
    private void aniadirImagen(int turno, int id) {
        ImageView img = (ImageView) findViewById(id);
        if (contador % 2 == 0) {
            img.setImageResource(R.drawable.bola_amarilla);
        } else {
            img.setImageResource(R.drawable.bola_roja);
        }
    }

    private void aniadirenTabla(int contador, int f, int c) {
        if (contador % 2 == 0) {
            if (con.estaVacio(f, c)) {
                con.setMaquina(f, c);
            }
        } else {
            if (con.estaVacio(f, c)) {
                con.setJugador(f, c);
            }
        }
    }

    public void juegaMaquina() {
        Random r = new Random();
        int fila = r.nextInt(Conecta4.NFILAS);
        if (con.estaVacio(fila, 5)) {
            final int id = dameId(fila, 5);
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                public void run() {
                    aniadirImagen(2, id);
                }
            }, 500);
            con.setMaquina(fila, 5);
        } else if (con.estaVacio(fila, 4)) {
            final int id = dameId(fila, 4);
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                public void run() {
                    aniadirImagen(2, id);
                }
            }, 500);
            con.setMaquina(fila, 4);
        } else if (con.estaVacio(fila, 3)) {
            final int id = dameId(fila, 3);
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                public void run() {
                    aniadirImagen(2, id);
                }
            }, 500);
            con.setMaquina(fila, 3);
        } else if (con.estaVacio(fila, 2)) {
            final int id = dameId(fila, 2);
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                public void run() {
                    aniadirImagen(2, id);
                }
            }, 500);
            con.setMaquina(fila, 2);
        } else if (con.estaVacio(fila, 1)) {
            final int id = dameId(fila, 1);
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                public void run() {
                    aniadirImagen(2, id);
                }
            }, 500);
            con.setMaquina(fila, 1);
        } else if (con.estaVacio(fila, 0)) {
            final int id = dameId(fila, 0);
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                public void run() {
                    aniadirImagen(2, id);
                }
            }, 500);
            con.setMaquina(fila, 0);
        }
    }

    private void ponFicha(int id) {
        //columna 1
        if (id == R.id.con11 || id == R.id.con12 || id == R.id.con13 || id == R.id.con14 || id == R.id.con15 || id == R.id.con16) {
            if (con.estaVacio(0, 5)) {
                aniadirImagen(contador, R.id.con11);
                aniadirenTabla(contador, 0, 5);
            } else {
                if (con.estaVacio(0, 4)) {
                    aniadirImagen(contador, R.id.con12);
                    aniadirenTabla(contador, 0, 4);
                } else {
                    if (con.estaVacio(0, 3)) {
                        aniadirImagen(contador, R.id.con13);
                        aniadirenTabla(contador, 0, 3);
                    } else {
                        if (con.estaVacio(0, 2)) {
                            aniadirImagen(contador, R.id.con14);
                            aniadirenTabla(contador, 0, 2);
                        } else {
                            if (con.estaVacio(0, 1)) {
                                aniadirImagen(contador, R.id.con15);
                                aniadirenTabla(contador, 0, 1);
                            } else {
                                aniadirImagen(contador, R.id.con16);
                                aniadirenTabla(contador, 0, 0);
                            }
                        }
                    }
                }
            }
        }
        //columna 2
        else if (id == R.id.con21 || id == R.id.con22 || id == R.id.con23 || id == R.id.con24 || id == R.id.con25 || id == R.id.con26) {
            if (con.estaVacio(1, 5)) {
                aniadirImagen(contador, R.id.con21);
                aniadirenTabla(contador, 1, 5);
            } else {

                if (con.estaVacio(1, 4)) {
                    aniadirImagen(contador, R.id.con22);
                    aniadirenTabla(contador, 1, 4);
                } else {
                    if (con.estaVacio(1, 3)) {
                        aniadirImagen(contador, R.id.con23);
                        aniadirenTabla(contador, 1, 3);
                    } else {
                        if (con.estaVacio(1, 2)) {
                            aniadirImagen(contador, R.id.con24);
                            aniadirenTabla(contador, 1, 2);
                        } else {
                            if (con.estaVacio(1, 1)) {
                                aniadirImagen(contador, R.id.con25);
                                aniadirenTabla(contador, 1, 1);
                            } else {
                                aniadirImagen(contador, R.id.con26);
                                aniadirenTabla(contador, 1, 0);
                                ;
                            }
                        }
                    }
                }
            }
        }
        //columna 3
        else if (id == R.id.con31 || id == R.id.con32 || id == R.id.con33 || id == R.id.con34 || id == R.id.con35 || id == R.id.con36) {
            if (con.estaVacio(2, 5)) {
                aniadirImagen(contador, R.id.con31);
                aniadirenTabla(contador, 2, 5);
            } else {

                if (con.estaVacio(2, 4)) {
                    aniadirImagen(contador, R.id.con32);
                    aniadirenTabla(contador, 2, 4);
                } else {
                    if (con.estaVacio(2, 3)) {
                        aniadirImagen(contador, R.id.con33);
                        aniadirenTabla(contador, 2, 3);
                    } else {
                        if (con.estaVacio(2, 2)) {
                            aniadirImagen(contador, R.id.con34);
                            aniadirenTabla(contador, 2, 2);
                        } else {
                            if (con.estaVacio(2, 1)) {
                                aniadirImagen(contador, R.id.con35);
                                aniadirenTabla(contador, 2, 1);
                            } else {
                                aniadirImagen(contador, R.id.con36);
                                aniadirenTabla(contador, 2, 0);
                            }
                        }
                    }
                }
            }
        }
        //columna 4
        else if (id == R.id.con41 || id == R.id.con42 || id == R.id.con43 || id == R.id.con44 || id == R.id.con45 || id == R.id.con46) {
            if (con.estaVacio(3, 5)) {
                aniadirImagen(contador, R.id.con41);
                aniadirenTabla(contador, 3, 5);
            } else {
                if (con.estaVacio(3, 4)) {
                    aniadirImagen(contador, R.id.con42);
                    aniadirenTabla(contador, 3, 4);
                } else {
                    if (con.estaVacio(3, 3)) {
                        aniadirImagen(contador, R.id.con43);
                        aniadirenTabla(contador, 3, 3);
                    } else {
                        if (con.estaVacio(3, 2)) {
                            aniadirImagen(contador, R.id.con44);
                            aniadirenTabla(contador, 3, 2);
                        } else {
                            if (con.estaVacio(3, 1)) {
                                aniadirImagen(contador, R.id.con45);
                                aniadirenTabla(contador, 3, 1);
                            } else {
                                aniadirImagen(contador, R.id.con46);
                                aniadirenTabla(contador, 3, 0);
                            }
                        }
                    }
                }
            }
        }
        //columna 5
        else if (id == R.id.con51 || id == R.id.con52 || id == R.id.con53 || id == R.id.con54 || id == R.id.con55 || id == R.id.con56) {
            if (con.estaVacio(4, 5)) {
                aniadirImagen(contador, R.id.con51);
                aniadirenTabla(contador, 4, 5);
            } else {
                //continuar con los demas movimientos de la columna
                if (con.estaVacio(4, 4)) {
                    aniadirImagen(contador, R.id.con52);
                    aniadirenTabla(contador, 4, 4);
                } else {
                    if (con.estaVacio(4, 3)) {
                        aniadirImagen(contador, R.id.con53);
                        aniadirenTabla(contador, 4, 3);
                    } else {
                        if (con.estaVacio(4, 2)) {
                            aniadirImagen(contador, R.id.con54);
                            aniadirenTabla(contador, 4, 2);
                        } else {
                            if (con.estaVacio(4, 1)) {
                                aniadirImagen(contador, R.id.con55);
                                aniadirenTabla(contador, 4, 1);
                            } else {
                                aniadirImagen(contador, R.id.con56);
                                aniadirenTabla(contador, 4, 0);
                            }
                        }
                    }
                }
            }
        }
        //columna 6
        else if (id == R.id.con61 || id == R.id.con62 || id == R.id.con63 || id == R.id.con64 || id == R.id.con65 || id == R.id.con66) {
            if (con.estaVacio(5, 5)) {
                aniadirImagen(contador, R.id.con61);
                aniadirenTabla(contador, 5, 5);
            } else {

                if (con.estaVacio(5, 4)) {
                    aniadirImagen(contador, R.id.con62);
                    aniadirenTabla(contador, 5, 4);
                } else {
                    if (con.estaVacio(5, 3)) {
                        aniadirImagen(contador, R.id.con63);
                        aniadirenTabla(contador, 5, 3);
                    } else {
                        if (con.estaVacio(5, 2)) {
                            aniadirImagen(contador, R.id.con64);
                            aniadirenTabla(contador, 5, 2);
                        } else {
                            if (con.estaVacio(5, 1)) {
                                aniadirImagen(contador, R.id.con65);
                                aniadirenTabla(contador, 5, 1);
                            } else {
                                aniadirImagen(contador, R.id.con66);
                                aniadirenTabla(contador, 5, 0);
                            }
                        }
                    }
                }
            }
        }
    }

    private int dameId(int f, int c) {
        int id = -1;
        if (f == 0 && c == 5) {
            id = R.id.con11;
        } else if (f == 0 && c == 4) {
            id = R.id.con12;
        } else if (f == 0 && c == 3) {
            id = R.id.con13;
        } else if (f == 0 && c == 2) {
            id = R.id.con14;
        } else if (f == 0 && c == 1) {
            id = R.id.con15;
        } else if (f == 0 && c == 0) {
            id = R.id.con16;
        } else if (f == 1 && c == 5) {
            id = R.id.con21;
        } else if (f == 1 && c == 4) {
            id = R.id.con22;
        } else if (f == 1 && c == 3) {
            id = R.id.con23;
        } else if (f == 1 && c == 2) {
            id = R.id.con24;
        } else if (f == 1 && c == 1) {
            id = R.id.con25;
        } else if (f == 1 && c == 0) {
            id = R.id.con26;
        } else if (f == 2 && c == 5) {
            id = R.id.con31;
        } else if (f == 2 && c == 4) {
            id = R.id.con32;
        } else if (f == 2 && c == 3) {
            id = R.id.con33;
        } else if (f == 2 && c == 2) {
            id = R.id.con34;
        } else if (f == 2 && c == 1) {
            id = R.id.con35;
        } else if (f == 2 && c == 0) {
            id = R.id.con36;
        } else if (f == 3 && c == 5) {
            id = R.id.con41;
        } else if (f == 3 && c == 4) {
            id = R.id.con42;
        } else if (f == 3 && c == 3) {
            id = R.id.con43;
        } else if (f == 3 && c == 2) {
            id = R.id.con44;
        } else if (f == 3 && c == 1) {
            id = R.id.con45;
        } else if (f == 3 && c == 0) {
            id = R.id.con46;
        } else if (f == 4 && c == 5) {
            id = R.id.con51;
        } else if (f == 4 && c == 4) {
            id = R.id.con52;
        } else if (f == 4 && c == 3) {
            id = R.id.con53;
        } else if (f == 4 && c == 2) {
            id = R.id.con54;
        } else if (f == 4 && c == 1) {
            id = R.id.con55;
        } else if (f == 4 && c == 0) {
            id = R.id.con56;
        } else if (f == 5 && c == 5) {
            id = R.id.con61;
        } else if (f == 5 && c == 4) {
            id = R.id.con62;
        } else if (f == 5 && c == 3) {
            id = R.id.con63;
        } else if (f == 5 && c == 2) {
            id = R.id.con64;
        } else if (f == 5 && c == 1) {
            id = R.id.con65;
        } else if (f == 5 && c == 0) {
            id = R.id.con66;
        }
        return id;
    }

}
