/** Actividad para hacer perder tiempo al personaje. Muestra una
 * imagen de tráfico correspondiente con el tiempo en el que se va a
 * mostrar la actividad. Una vez terminado el lapso de tiempo se 
 * regresa a la actividad PlayingActivity.
 * 
 */
package simonToche.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class MovingActivity extends Activity {

	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.moving_activity_view);
		Bundle bundle = getIntent().getExtras();
		String tag = "";
		if(bundle != null){
			tag = bundle.getString("tag");
		}
		Intent i = new Intent(MovingActivity.this, PlayingActivity.class);
		i.putExtra("tag", tag);
		startActivity(i);
		this.finish();
	}
	
	/* (non-Javadoc)
	 * @see android.app.Activity#onStart()
	 */
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
	}
	
	/* (non-Javadoc)
	 * @see android.app.Activity#onResume()
	 */
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
	}

	/* Va a onResume() si el usuario regresa a la actividad
	 * o a onStop() si la actividad deja de ser visible
	 * 
	 * @see android.app.Activity#onPause()
	 */
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}
	
	/* Va a onRestart() si el usuario navega hasta
	 * la actividad o a onDestroy() si la actividad
	 * va a terminar
	 * 
	 * @see android.app.Activity#onStop()
	 */
	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
	}
	
	/* (non-Javadoc)
	 * @see android.app.Activity#onDestroy()
	 */
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}

	/* Viene de onStop() y va a onStart()
	 * 
	 * @see android.app.Activity#onRestart()
	 */
	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
	}
	
}
