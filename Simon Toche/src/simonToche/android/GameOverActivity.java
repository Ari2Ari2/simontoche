/** Actividad para hacer perder tiempo al personaje. Muestra una
 * imagen de tráfico correspondiente con el tiempo en el que se va a
 * mostrar la actividad. Una vez terminado el lapso de tiempo se 
 * regresa a la actividad PlayingActivity.
 * 
 */
package simonToche.android;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import simonToche.logic.Game;
import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Bundle;

public class GameOverActivity extends Activity {

	Intent intent;
	String tag;
	Timer timeoutTimer;
	
	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		if(Game.evaluarEstado().equals("gano")){
			setContentView(R.layout.gano_layout);
		}else{
			setContentView(R.layout.perdio_layout);
			
				new Thread(){
					public void run(){

						try {
						Player.pause();
						MediaPlayer mp = new MediaPlayer();
						AssetFileDescriptor afd = getResources().openRawResourceFd(R.raw.death1);
						mp.reset();
						mp.setDataSource(afd.getFileDescriptor(),afd.getStartOffset(), afd.getDeclaredLength());
						mp.prepare();
						MediaPlayer mp2 = new MediaPlayer();
						AssetFileDescriptor afd2 = getResources().openRawResourceFd(R.raw.death2);
						mp2.reset();
						mp2.setDataSource(afd2.getFileDescriptor(),afd.getStartOffset(), afd.getDeclaredLength());
						mp2.prepare();
						MediaPlayer mp3 = new MediaPlayer();
						AssetFileDescriptor afd3 = getResources().openRawResourceFd(R.raw.death3);
						mp3.reset();
						mp3.setDataSource(afd3.getFileDescriptor(),afd.getStartOffset(), afd.getDeclaredLength());
						mp3.prepare();
						mp3.start();
						afd.close();
						afd2.close();
						afd3.close();

						Thread.sleep(2000);
						mp.start();
						Thread.sleep(800);
						mp2.start();
						Thread.sleep(800);
						mp3.start();
						Thread.sleep(800);
						mp.start();
						mp2.start();
						Thread.sleep(800);
						mp2.start();
						Thread.sleep(800);
						mp3.start();
					} catch (IllegalArgumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalStateException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					}
				}.start();
				
			
			
		}
		timeoutTimer = new Timer();
        TimerTask timeoutTask = new TimerTask() {
            @Override
            public void run() {
                finish();
            }
        };
        timeoutTimer.schedule(timeoutTask, 10000);        
	}
	
}
