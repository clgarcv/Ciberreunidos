package ciberreunidossa.ciberreunidos;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Daniel on 05/05/2016.
 */
public class ServicioAudio extends Service {
    MediaPlayer mp;
    @Override
    public IBinder onBind(Intent intent) {
        // TODO Auto-generated method stub
        return null;
    }
    public void onCreate()
    {
        mp = MediaPlayer.create(this, R.raw.musicainicio);
        mp.setLooping(true);
    }
    public void onDestroy()
    {
        mp.stop();

    }
    public void onStart(Intent intent, int startid){
        mp.start();
    }

}
