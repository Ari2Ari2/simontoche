/** Esta actividad muestra el mapa con el lugar actual del personaje 
 * resaltado. Permite hacer click en los lugares disponibles para 
 * trasladarse a esos sitios.
 * 
 * Al hacer click en un lugar se actualiza la actividad PlayingActivity
 * para actualizar el lugar del personaje. Tambien se inicia la actividad
 * MovingActivity durante un tiempo que va a depender de la hora del
 * dia. 
 * 
 */

package simonToche.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MoveActivity extends Activity {

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(simonToche.android.R.layout.mapa);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onStart()
	 */
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onResume()
	 */
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
	}

	/*
	 * Va a onResume() si el usuario regresa a la actividad o a onStop() si la
	 * actividad deja de ser visible
	 * 
	 * @see android.app.Activity#onPause()
	 */
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}

	/*
	 * Va a onRestart() si el usuario navega hasta la actividad o a onDestroy()
	 * si la actividad va a terminar
	 * 
	 * @see android.app.Activity#onStop()
	 */
	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onDestroy()
	 */
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}

	/*
	 * Viene de onStop() y va a onStart()
	 * 
	 * @see android.app.Activity#onRestart()
	 */
	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
	}

	public void elegirLugar(View v) {
		String tag = (String) v.getTag();
		Intent i = new Intent(MoveActivity.this, MovingActivity.class);
		i.putExtra("tag", tag);
		startActivity(i);
		this.finish();
	}

}
