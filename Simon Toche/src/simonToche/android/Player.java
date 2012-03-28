package simonToche.android;

import java.io.IOException;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;

public class Player {

	private static MediaPlayer reproductor = new MediaPlayer();
	
	public static void create(Context c){
		try {
			AssetFileDescriptor afd = c.getResources().openRawResourceFd(R.raw.songotchi);
			reproductor.reset();
			reproductor.setDataSource(afd.getFileDescriptor(),afd.getStartOffset(), afd.getDeclaredLength());
			reproductor.prepare();
			afd.close();
//			System.out.println("Data source asignado");
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void play(){
		reproductor.start();
		reproductor.setLooping(true);
	}
	
	
	public static void pause(){
		reproductor.pause();
	}
	
	public static void destroy(){
		reproductor.stop();
		reproductor = null;
	}

	public static void play(Context context, int id, float vol1, float vol2) {
		// TODO Auto-generated method stub
		
		try {
			AssetFileDescriptor afd = context.getResources().openRawResourceFd(id);
			MediaPlayer mp = new MediaPlayer();
			mp.reset();
			mp.setDataSource(afd.getFileDescriptor(),afd.getStartOffset(), afd.getDeclaredLength());

			mp.prepare();
			mp.setVolume(vol1, vol2);
			mp.start();
			afd.close();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
