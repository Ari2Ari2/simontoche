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
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.ImageView.ScaleType;

public class SelectActivity extends android.app.Activity {

	private static Category category;
	private Handler handler;
	private Animation blinker;
	String actividadActual;
	private Runnable runnable = new Runnable() {
		@Override
		public void run() {
			ProgressBar eb = (ProgressBar) findViewById(R.id.eat_bar);
			ProgressBar fb = (ProgressBar) findViewById(R.id.fun_bar);
			ProgressBar sb = (ProgressBar) findViewById(R.id.sleep_bar);
			ProgressBar stb = (ProgressBar) findViewById(R.id.study_bar);
			if(eb == null) finish();
			eb.setProgress((int) Game.getFoodLevel());
			fb.setProgress((int) Game.getFunLevel());
			sb.setProgress((int) Game.getSleepLevel());
			stb.setProgress((int) Game.getStudyLevel());
//			startBlinkAnimations(eb, fb, sb, stb);
			
//			if(!actividadActual.equals(Game.getActividadActual())){
//				actividadActual = Game.getActividadActual();
//				cambiarEmoticon((WebView) findViewById(R.id.central_emoticon), actividadActual);
//			}
			handler.postDelayed(this, 500);
		}

		private void startBlinkAnimations(ProgressBar eb, ProgressBar fb,
				ProgressBar sb, ProgressBar stb) {
			// System.out.println("Actualizando animaciones");
			// System.out.println(fb.getProgress());
			// System.out.println(blinker);
			// System.out.println(fb.getAnimation());
			// TODO Auto-generated method stub
			if (eb.getProgress() <= 20) {
				if (eb.getAnimation() == null) {
					eb.startAnimation(blinker);
				}
			} else {
				eb.clearAnimation();
			}
			if (fb.getProgress() <= 20) {
				if (fb.getAnimation() == null) {
					fb.startAnimation(blinker);
				}
			} else {
				fb.clearAnimation();
			}
			if (sb.getProgress() <= 20) {
				if (sb.getAnimation() == null) {
					sb.startAnimation(blinker);
				}
			} else {
				sb.clearAnimation();
			}
			if (stb.getProgress() <= 20) {
				if (stb.getAnimation() == null) {
					stb.startAnimation(blinker);
				}
			} else {
				stb.clearAnimation();
			}
		}

	};

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
		}else if (p.getBackground().equalsIgnoreCase("universidad")) {
			this.contentUniversity(tagAccion);
		}		
		startTransitionAnimation(true);
		ImageButton button = (ImageButton)findViewById(R.id.middle_button);
		blinker = AnimationUtils.loadAnimation(this, R.anim.blink);
		handler = new Handler();
		handler.post(runnable);
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
		try{
			((ImageButton)findViewById(R.id.middle_button)).setImageResource(R.drawable.up_arrow);
			findViewById(R.id.time_map_bar).setVisibility(View.INVISIBLE);
		}catch(NullPointerException e){
			
		}
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
		Game.estudiar();
		this.finish();
	}

	public void elegirDormir(View v) {
		Game.dormir();
		this.finish();
	}

	public void elegirDiversion(View v) {
		Game.entretenerse();
		this.finish();
	}

	public void elegirComer(View v) {
		Game.comer();
		this.finish();
	}

	private void contentUniversity(String tag) {
		System.out.println("Setting content to " + tag);
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
		System.out.println("Setting content to " + tag);
		if (tag.equalsIgnoreCase("food")) {
			setContentView(R.layout.mall_eat_select_activity_view);
		}else if (tag.equalsIgnoreCase("fun")) {
			setContentView(R.layout.mall_fun_select_activity_view);
		}
	}

	private void contentHome(String tag) {
		System.out.println("Setting content to " + tag);
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
