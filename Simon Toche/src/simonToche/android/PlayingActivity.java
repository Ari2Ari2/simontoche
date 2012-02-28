/** En esta actividad se muestra el fondo de pantalla del lugar
 * en donde se encuentra el personaje, el estado de animo, la 
 * barra de estado, la barra de hora y mapa y los botones de las
 * categorias para las acciones.
 * 
 * Opcionalmente puede mostrar mensajes para informar sobre situcaciones
 * como por ejemplo: La barra de algun estado esta llegando muy bajo o
 * se intento realizar una actividad en un lugar erroneo, etc.
 * 
 * Al hacer click en un boton de categoria se inicia la actividad
 * SelectActivity en donde se le pasan las actividades que se pueden
 * realizar en el lugar donde se encuentra.
 * 
 * Al hacer click en el boton de mapa ubicado en la barra de hora y mapa
 * se inicia la actividad MoveActivity pasandole como parametro el lugar
 * donde se esta actualmente.
 * 
 * La barra de hora y mapa tiene un boton superior que al hacer click
 * la cambia entre visible e invisible.
 * 
 * El boton de menu y buscar no hacen nada. El boton de atras regresa a la
 * actividad MainMenuActivity y el de home termina la aplicación.
 * 
 */

package simonToche.android;

import simonToche.logic.Game;
import simonToche.logic.Place;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class PlayingActivity extends Activity {

	private Place place;

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		Bundle params = getIntent().getExtras();
		String tag = "";
		if (params != null) {
			tag = params.getString("tag");
		}
		this.place = new Place();
		if (tag.equalsIgnoreCase("home")) {
			setContentView(R.layout.house_playing_view);
			place.setBackground("home");
		} else if (tag.equalsIgnoreCase("mall")) {
			setContentView(R.layout.mall_playing_view);
			place.setBackground("mall");
		} else if (tag.equalsIgnoreCase("university")) {
			setContentView(R.layout.university_playing_view);
			place.setBackground("university");
		}
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

	@SuppressWarnings("unused")
	private void setBackground() {
		View v = findViewById(R.layout.playing_view);
		int resID = getResources().getIdentifier(
				Game.getPlace().getBackground(), "drawable", getPackageName());
		v.setBackgroundResource(resID);
	}

	public void elegirAccion(View v) {
		Intent i = new Intent(PlayingActivity.this, SelectActivity.class);
		i.putExtra("Place", this.place);
		String tag = (String) v.getTag();
		i.putExtra("tag", tag);
		startActivity(i);
	}

}