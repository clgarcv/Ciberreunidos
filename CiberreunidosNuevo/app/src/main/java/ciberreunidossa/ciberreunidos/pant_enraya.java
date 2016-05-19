package ciberreunidossa.ciberreunidos;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class pant_enraya extends AppCompatActivity {

    static int contador;
    int tablero[][] = new int[3][3];
    final List<ImageButton> botones = new ArrayList<ImageButton>();

    private int[] opciones = {0, 1, 2};
    String ganador;

    MediaPlayer clic;
    MiMusica musica;
    SharedPreferences sharedPrefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pant_enraya);

        clic = MediaPlayer.create(this, R.raw.clic);
        clic.setAudioStreamType(AudioManager.STREAM_MUSIC);

        musica = (MiMusica)getIntent().getExtras().getSerializable("melodia");
        sharedPrefs = getSharedPreferences("opciones", MODE_PRIVATE);

        contador = 1;
        //obtenemos el numero de jugadores
        Bundle bundle = getIntent().getExtras();
        final int nJug = bundle.getInt("njugadores");


        //primera fila del tablero
        final ImageButton c1_1 = (ImageButton) findViewById(R.id.img11);

        final ImageButton c1_2 = (ImageButton) findViewById(R.id.img12);

        final ImageButton c1_3 = (ImageButton) findViewById(R.id.img13);

        //segunda fila del tablero
        final ImageButton c2_1 = (ImageButton) findViewById(R.id.img21);

        final ImageButton c2_2 = (ImageButton) findViewById(R.id.img22);

        final ImageButton c2_3 = (ImageButton) findViewById(R.id.img23);

        //tercera fila del tablero
        final ImageButton c3_1 = (ImageButton) findViewById(R.id.img31);

        final ImageButton c3_2 = (ImageButton) findViewById(R.id.img32);

        final ImageButton c3_3 = (ImageButton) findViewById(R.id.img33);

        botones.add(c1_1);
        botones.add(c1_2);
        botones.add(c1_3);
        botones.add(c2_1);
        botones.add(c2_2);
        botones.add(c2_3);
        botones.add(c3_1);
        botones.add(c3_2);
        botones.add(c3_3);


        inicializaTablero(tablero);
//      inicializaTablero(tabAux);
        if (nJug == 1) {
            //juega contra la maquina
            //el primero en pulsar sera el jugador uno que juega con X
            for (ImageButton img : botones) {
                img.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (sharedPrefs.getBoolean("efectos", true)) {
                            clic.start();
                        }
                        actualizarTabla(v.getId());
                        añadirImagen(v.getId());
                        if (!finPartida()) {
                            contador++;
                            //comprobar si hay alguna posible linea

                            juegamaquina();
                            Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                public void run() {
                                    if (finPartida()) {
                                        Handler handler = new Handler();
                                        handler.postDelayed(new Runnable() {
                                            public void run() {
                                                Intent i = new Intent(pant_enraya.this, pierdegana.class);
                                                i.putExtra("juego", "3enraya");
                                                i.putExtra("ganador", ganador);
                                                startActivity(i);
                                            }
                                        }, 500);
                                    } else {
                                        for (ImageButton i : botones) {
                                            if (i.getDrawable() == null)
                                                i.setEnabled(true);
                                        }
                                        contador++;
                                    }
                                }
                            }, 500);
                        } else {
                            for (ImageButton i : botones) {
                                i.setEnabled(false);
                            }
                            Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                public void run() {
                                    Intent i = new Intent(pant_enraya.this, pierdegana.class);
                                    i.putExtra("juego", "3enraya");
                                    i.putExtra("ganador", ganador);
                                    startActivity(i);
                                }
                            }, 500);

                        }

                    }
                });

            }

        } else if (nJug == 2) {
            //dos jugadores
            for (ImageButton img : botones) {
                img.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (sharedPrefs.getBoolean("efectos", true)) {
                            clic.start();
                        }
                        actualizarTabla(v.getId());
                        añadirImagen(v.getId());
                        if (!finPartida()) {
                            contador++;

                        } else {
                            Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                public void run() {
                                    Intent i = new Intent(pant_enraya.this, pierdegana.class);
                                    i.putExtra("juego", "3enraya");
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
        if (sharedPrefs.getBoolean("musica", true)) {
            musica.melodia.start();
        }
    }

    public void juegamaquina() {
        for (ImageButton i : botones) {
            i.setEnabled(false);
        }
        Random r = new Random();
        int fila = r.nextInt(3);
        int col = r.nextInt(3);
        boolean aux = false;
        while (!aux) {
            if (tablero[fila][col] == -1) {
                tablero[fila][col] = 0;
                if (fila == 0 && col == 0) {
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            añadirImagen(R.id.img11);

                        }
                    }, 500);

                } else if (fila == 0 && col == 1) {
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            añadirImagen(R.id.img12);

                        }
                    }, 500);

                } else if (fila == 0 && col == 2) {
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            añadirImagen(R.id.img13);

                        }
                    }, 500);

                } else if (fila == 1 && col == 0) {
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            añadirImagen(R.id.img21);

                        }
                    }, 500);

                } else if (fila == 1 && col == 1) {
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            añadirImagen(R.id.img22);

                        }
                    }, 500);

                } else if (fila == 1 && col == 2) {
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            añadirImagen(R.id.img23);

                        }
                    }, 500);

                } else if (fila == 2 && col == 0) {
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            añadirImagen(R.id.img31);

                        }
                    }, 500);

                } else if (fila == 2 && col == 1) {
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            añadirImagen(R.id.img32);

                        }
                    }, 500);

                } else if (fila == 2 && col == 2) {
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            añadirImagen(R.id.img33);

                        }
                    }, 500);

                }
                aux = true;

            }
            fila = r.nextInt(3);
            col = r.nextInt(3);
        }


    }


    public void actualizarTabla(int id) {
        switch (id) {

            case R.id.img11:
                tablero[0][0] = (contador % 2 == 0) ? 0 : 1;
                break;
            case R.id.img12:
                tablero[0][1] = (contador % 2 == 0) ? 0 : 1;
                break;
            case R.id.img13:
                tablero[0][2] = (contador % 2 == 0) ? 0 : 1;
                break;
            case R.id.img21:
                tablero[1][0] = (contador % 2 == 0) ? 0 : 1;
                break;
            case R.id.img22:
                tablero[1][1] = (contador % 2 == 0) ? 0 : 1;
                break;
            case R.id.img23:
                tablero[1][2] = (contador % 2 == 0) ? 0 : 1;
                break;
            case R.id.img31:
                tablero[2][0] = (contador % 2 == 0) ? 0 : 1;
                break;
            case R.id.img32:
                tablero[2][1] = (contador % 2 == 0) ? 0 : 1;
                break;
            case R.id.img33:
                tablero[2][2] = (contador % 2 == 0) ? 0 : 1;
                break;
        }

    }

    public void añadirImagen(int id) {
        ImageButton b = (ImageButton) findViewById(id);
        if (contador % 2 == 0) {
            b.setImageResource(R.drawable.enraya_o);
            //turno(tablero, )

        } else {
            //cuando sea impar X
            b.setImageResource(R.drawable.enraya_x);

        }
        b.setEnabled(false);


    }

    private boolean tableroInicial() {
        int i = 0;
        while (i <= 2) {
            int j = 0;
            while (j <= 2) {
                if (tablero[i][j] != -1) {
                    return false;
                } else {
                    j++;
                }
            }
            i++;
        }
        return true;
    }

    //funciones auxiliares
    // inicializamos con -1.  0 representara la O y 1 la X
    private static void inicializaTablero(int[][] t) {
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t.length; j++) {
                t[i][j] = -1;
            }
        }

    }

    private static void ponerFicha(int c, int f, int ficha, int[][] tablero) {

        if (tablero[f][c] == -1) {
            //si no hay ninguna ficha podemos ponerla
            tablero[f][c] = ficha;
        }
    }

    private boolean hayLinea(int[][] t) {
        //ponemos los distintos casos donde puede darse una linea
        //hay 8 casos
        //filas
        if ((t[0][0] != -1 && t[0][0] == t[0][1] && t[0][0] == t[0][2]) || (t[0][0] != -1 && t[0][0] == t[1][0] && t[0][0] == t[2][0]) || (t[0][0] != -1 && t[0][0] == t[1][1] && t[0][0] == t[2][2])) {
            if (t[0][0] == 1) {
                ganador = "Jugador 1";
                return true;
            } else {
                ganador = "Jugador 2";
                return true;
            }
        } else if (t[1][0] != -1 && t[1][0] == t[1][1] && t[1][0] == t[1][2]) {
            if (t[1][0] == 1) {
                ganador = "Jugador 1";
                return true;
            } else {
                ganador = "Jugador 2";
                return true;
            }
        } else if (t[2][0] != -1 && t[2][0] == t[2][1] && t[2][0] == t[2][2] || (t[2][0] != -1 && t[2][0] == t[1][1] && t[2][0] == t[0][2])) {
            if (t[2][0] == 1) {
                ganador = "Jugador 1";
                return true;
            } else {
                ganador = "Jugador 2";
                return true;
            }
        } else if (t[0][1] != -1 && t[0][1] == t[1][1] && t[0][1] == t[2][1]) {
            if (t[0][1] == 1) {
                ganador = "Jugador 1";
                return true;
            } else {
                ganador = "Jugador 2";
                return true;
            }
        } else if (t[0][2] != -1 && t[0][2] == t[1][2] && t[0][2] == t[2][2]) {
            if (t[0][2] == 1) {
                ganador = "Jugador 1";
                return true;
            } else {
                ganador = "Jugador 2";
                return true;
            }
        } else {
            return false;
        }

    }

    private boolean finPartida() {
        return (hayLinea(tablero) || contador == 9);
    }

    private boolean posibleLinea(int[][] t) {
        //ponemos los distintos casos donde puede darse una linea
        //hay 8 casos
        //filas
        if ((t[0][0] != -1 && t[0][0] == t[0][1] && t[0][0] == t[0][2]) || (t[0][0] != -1 && t[0][0] == t[1][0] && t[0][0] == t[2][0]) || (t[0][0] != -1 && t[0][0] == t[1][1] && t[0][0] == t[2][2])) {
            if (t[0][0] == 1) {
                return true;
            } else {
                return true;
            }
        } else if (t[1][0] != -1 && t[1][0] == t[1][1] && t[1][0] == t[1][2]) {
            if (t[1][0] == 1) {
                return true;
            } else {
                return true;
            }
        } else if (t[2][0] != -1 && t[2][0] == t[2][1] && t[2][0] == t[2][2] || (t[2][0] != -1 && t[2][0] == t[1][1] && t[2][0] == t[0][2])) {
            if (t[2][0] == 1) {
                return true;
            } else {
                return true;
            }
        } else if (t[0][1] != -1 && t[0][1] == t[1][1] && t[0][1] == t[2][1]) {
            if (t[0][1] == 1) {
                return true;
            } else {
                return true;
            }
        } else if (t[0][2] != -1 && t[0][2] == t[1][2] && t[0][2] == t[2][2]) {
            if (t[0][2] == 1) {
                return true;
            } else {
                return true;
            }
        } else {
            return false;
        }

    }

}





