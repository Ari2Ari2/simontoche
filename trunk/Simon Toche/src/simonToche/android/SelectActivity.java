/** Esta actividad muestra las actividades disponibles que se pueden
 * realizar. Al hacer click en alguna de ellas se regresa a PlayingActivity
 * actualizando parametros necesarios como el estado de animo entre otros.
 * 
 */

package simonToche.android;

import java.util.ArrayList;
import java.util.List;

import simonToche.logic.Activity;
import simonToche.logic.Category;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView.ScaleType;

public class SelectActivity extends android.app.Activity {
	
	private static Category category;

	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.select_activity_view);
		View v = findViewById(R.id.time_menu);
		v.setVisibility(View.INVISIBLE);
		v = findViewById(R.id.middle_button);
		// Cambiar a boton subiendo
		
		category = new Category();
		category.setName("fun");
		Activity a = new Activity();
		a.setButton("biblioteca");
		Activity b = new Activity();
		b.setButton("disco");
		List<Activity> l = new ArrayList<Activity>();
		l.add(a);
		l.add(a);
		l.add(a);
		l.add(a);
		l.add(b);
		l.add(b);
		l.add(b);
		l.add(b);
		category.setActivities(l);
		this.setActivitiesButton();
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

	/**
	 * 
	 */
	private void setActivitiesButton(){
		List<Activity> activities = category.getActivities();
		ImageButton v;
		int borderId = getResources().getIdentifier(
				category.getName() + "_circle", 
				"drawable", 
				getPackageName());
		int numActivities = 8;
		int index = 1;
		for(Activity a: activities){
			int resID = getResources().getIdentifier(
					a.getButton(), 
					"drawable", 
					getPackageName());
			System.out.println("Intentando obtener res: " +"button" + index);
			v = (ImageButton) findViewById(
					getResources().getIdentifier(
					"button" + index, 
					"id", 
					getPackageName()));
			v.setBackgroundResource(resID);
			v.setImageResource(borderId);
			v.setVisibility(View.VISIBLE);
			v.setScaleType(ScaleType.FIT_XY);
			++index;
		}
		while(index <= numActivities){
			System.out.println("Obteniendo boton: " + index);
			v = (ImageButton) findViewById(getResources().getIdentifier(
					"button" + index, 
					"id", 
					getPackageName()));
			v.setBackgroundColor(View.INVISIBLE);
			v.setVisibility(View.INVISIBLE);
			++index;
		}		
	}
	
}
