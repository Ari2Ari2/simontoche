/** Esta actividad muestra el la pantalla de inicio de la aplicacion
 * donde se muestran las opciones de New Game, Continue. Para salir
 * se usa el boton de Home o Return. El boton de Menu y Busqueda no
 * hacen nada.
 * 
 * Al Iniciar un nuevo juego se inicia la actividad PlayingActivity 
 * con los valores de partida por defecto.
 * 
 * Al continuar una partida se restauran los valores guardados y se 
 * inicia la actividad PlayingActivity. Si no hay valores guardados
 * el boton Continue debe estar desactivado.
 * 
 */

package simonToche.android;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class MainMenuActivity extends Activity {

	private TextView tv;

	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		tv = new TextView(this);
		tv.setText("En MainMenuActivity");
		setContentView(tv);
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
