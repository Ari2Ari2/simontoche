package simonToche.android;

import java.io.IOException;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;

public class Player {

	private static MediaPlayer reproductor = new MediaPlayer();
	private final static int file = R.raw.songotchi;

	public Player(Context context) {
		AssetFileDescriptor afd = context.getResources().openRawResourceFd(Player.file);
		reproductor.reset();
		try {
			reproductor.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getDeclaredLength());
			reproductor.prepare();
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

	public void play(){
		reproductor.start();
	}
}
