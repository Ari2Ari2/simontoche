/** Esta actividad muestra las actividades disponibles que se pueden
 * realizar. Al hacer click en alguna de ellas se regresa a PlayingActivity
 * actualizando parametros necesarios como el estado de animo entre otros.
 * 
 */

package simonToche.android;

import java.util.List;

import simonToche.logic.Activity;
import simonToche.logic.Category;
import simonToche.logic.Game;
import simonToche.logic.Place;
import android.os.Bundle;
import android.view.View;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageButton;
import android.widget.ImageView.ScaleType;

public class SelectActivity extends android.app.Activity {

	private static Category category;

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
		Place p = (Place) getIntent().getSerializableExtra("Place");
		Game.setPlace(p);
		String tagAccion = params.getString("tag");
		if (p.getBackground().equalsIgnoreCase("casa")) {
			this.contentHome(tagAccion);
		}else if (p.getBackground().equalsIgnoreCase("centro comercial")) {
			this.contentMall(tagAccion);
		}else if (p.getBackground().equalsIgnoreCase("universodad")) {
			this.contentUniversity(tagAccion);
		}		
//		startTransitionAnimation(true);
		ImageButton button = (ImageButton)findViewById(R.id.middle_button);
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
		((ImageButton)findViewById(R.id.middle_button)).setImageResource(R.drawable.up_arrow);
		findViewById(R.id.time_map_bar).setVisibility(View.INVISIBLE);
		startTransitionAnimation(true);
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
		startTransitionAnimation(false);
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

	/**
	 * 
	 */
	private void setActivitiesButton() {
		List<Activity> activities = category.getActivities();
		ImageButton v;
		int borderId = getResources().getIdentifier(
				category.getName() + "_circle", "drawable", getPackageName());
		int numActivities = 8;
		int index = 1;
		for (Activity a : activities) {
			int resID = getResources().getIdentifier(a.getButton(), "drawable",
					getPackageName());
			System.out.println("Intentando obtener res: " + "button" + index);
			v = (ImageButton) findViewById(getResources().getIdentifier(
					"button" + index, "id", getPackageName()));
			v.setBackgroundResource(resID);
			v.setImageResource(borderId);
			v.setVisibility(View.VISIBLE);
			v.setScaleType(ScaleType.FIT_XY);
			++index;
		}
		while (index <= numActivities) {
			System.out.println("Obteniendo boton: " + index);
			v = (ImageButton) findViewById(getResources().getIdentifier(
					"button" + index, "id", getPackageName()));
			v.setBackgroundColor(View.INVISIBLE);
			v.setVisibility(View.INVISIBLE);
			++index;
		}
	}

	public void elegirEstudiar(View v) {
		String tag = (String) v.getTag();
		Game.estudiar();
		this.finish();
	}

	public void elegirDormir(View v) {
		String tag = (String) v.getTag();
		Game.dormir();
		this.finish();
	}

	public void elegirDiversion(View v) {
		String tag = (String) v.getTag();
		Game.entretenerse();
		this.finish();
	}

	public void elegirComer(View v) {
		String tag = (String) v.getTag();
		Game.comer();
		this.finish();
	}

	private void contentUniversity(String tag) {
		if (tag.equalsIgnoreCase("food")) {
			setContentView(R.layout.university_eat_select_activity_view);
		}else if (tag.equalsIgnoreCase("studying")) {
			setContentView(R.layout.university_study_select_activity_view);
		}else if (tag.equalsIgnoreCase("sleeping")) {
			setContentView(R.layout.university_sleep_select_activity_view);
		}else if (tag.equalsIgnoreCase("fun")) {
			setContentView(R.layout.university_fun_select_activity_view);
		}
	}

	private void contentMall(String tag) {
		// TODO Auto-generated method stub
		if (tag.equalsIgnoreCase("food")) {
			setContentView(R.layout.mall_eat_select_activity_view);
		}else if (tag.equalsIgnoreCase("fun")) {
			setContentView(R.layout.mall_fun_select_activity_view);
		}
	}

	private void contentHome(String tag) {
		// TODO Auto-generated method stub
		if (tag.equalsIgnoreCase("food")) {
			setContentView(R.layout.house_eat_select_activity_view);
		}else if (tag.equalsIgnoreCase("studying")) {
			setContentView(R.layout.house_study_select_activity_view);
		}else if (tag.equalsIgnoreCase("sleeping")) {
			setContentView(R.layout.house_sleep_select_activity_view);
		}else if (tag.equalsIgnoreCase("fun")) {
			setContentView(R.layout.house_fun_select_activity_view);
		}
	}
	
	public void toggleTimeMapBar(View v){
		finish();
	}
	

	
	public void startTransitionAnimation(boolean entrada){
		View v = findViewById(R.id.sfu);
		TranslateAnimation trans = new TranslateAnimation(0f, 0f, (entrada ? 1000f : 0f), (entrada ? 0f :1000f));
		trans.setDuration(1500);
		trans.setFillAfter(true);
		v.startAnimation(trans);
		
	}

}
