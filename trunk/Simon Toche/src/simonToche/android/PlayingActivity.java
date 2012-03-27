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
import android.os.Handler;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class PlayingActivity extends Activity {

	private Place place;
	private Handler handler;
	private Animation blinker;
	String actividadActual;
	private Runnable runnable = new Runnable() {
		@Override
		public void run() {
			if(Game.evaluarEstado().equals("gano") || Game.evaluarEstado().equals("perdio")){
				finish();
			}
			ProgressBar eb = (ProgressBar) findViewById(R.id.eat_bar);
			ProgressBar fb = (ProgressBar) findViewById(R.id.fun_bar);
			ProgressBar sb = (ProgressBar) findViewById(R.id.sleep_bar);
			ProgressBar stb = (ProgressBar) findViewById(R.id.study_bar);
			TextView sem = (TextView) findViewById(R.id.semana);
			TextView dia = (TextView) findViewById(R.id.dia);
			TextView hora = (TextView) findViewById(R.id.hora);
			if(eb == null) finish();
			eb.setProgress((int) Game.getFoodLevel());
			fb.setProgress((int) Game.getFunLevel());
			sb.setProgress((int) Game.getSleepLevel());
			stb.setProgress((int) Game.getStudyLevel());
			startBlinkAnimations(eb, fb, sb, stb);
			sem.setText("Sem " + Game.getWeek());
			dia.setText("Dia " + Game.getDay());
			// wv.loadUrl("file:///android_res/drawable/piggie_bank.gif");
			hora.setText((Game.getHour() > 9 ? Game.getHour() : "0"
					+ Game.getHour())
					+ ":"
					+ (Game.getMinutes() > 9 ? Game.getMinutes() : "0"
							+ Game.getMinutes()));
			evaluarEstado();
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

		private void evaluarEstado() {
			String estado = Game.evaluarEstado();
			if (estado.isEmpty()) {

			} else if (estado.equals("gano")) {
				System.out.println("Actualizando estado a gano");
				setContentView(R.layout.gano_layout);
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				finish();
			} else if (estado.equals("perdio")) {
				System.out.println("Actualizando estado a perdio");
				setContentView(R.layout.perdio_layout);
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				finish();
			} else {
				setMessage(estado);
				Game.resetEstado();
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
		System.out.println("Creando PlayingActivity");
		Bundle params = getIntent().getExtras();
		String tag = "";
		if (params != null) {
			tag = params.getString("tag");
		}
		this.place = new Place();
		if (tag.equalsIgnoreCase("casa")) {
			setContentView(R.layout.house_playing_view);
			place.setBackground("casa");
		} else if (tag.equalsIgnoreCase("centro comercial")) {
			setContentView(R.layout.mall_playing_view);
			place.setBackground("centro comercial");
		} else if (tag.equalsIgnoreCase("universidad")) {
			setContentView(R.layout.university_playing_view);
			place.setBackground("universidad");
		}
		handler = new Handler();
		handler.post(runnable);
		blinker = AnimationUtils.loadAnimation(this, R.anim.blink);
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
		WebView wv = (WebView) findViewById(R.id.central_emoticon);
		actividadActual = Game.getActividadActual();
		cambiarEmoticon(wv, actividadActual);
		startTransactionAnimation(true);

	}

	private void cambiarEmoticon(WebView wv, String actividad) {
		System.out.println("Cambiando emoticon a " + actividad);
		wv.invalidate();
		wv.setBackgroundColor(0x00000000);
		if (actividad.equalsIgnoreCase("comer")) {
			wv.loadUrl("file:///android_res/drawable/comiendo.gif");
		} else if (actividad.equalsIgnoreCase("dormir")) {
			System.out.println("Loading durmiendo.gif");
			wv.loadUrl("file:///android_res/drawable/durmiendo.gif");
		} else if (actividad.equalsIgnoreCase("estudiar")) {
			wv.loadUrl("file:///android_res/drawable/estudiando.gif");
		} else if (actividad.equalsIgnoreCase("entretenerse")) {
			wv.loadUrl("file:///android_res/drawable/divertido.gif");
		} else {
			wv.loadUrl("file:///android_res/drawable/feliz.gif");
		}
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

	public void setMessage(String msg) {
		TextView tv = (TextView) findViewById(R.id.main_message);
		tv.setText(msg);
		Animation a = AnimationUtils.loadAnimation(this, R.anim.desvanecer);
		a.setFillAfter(true);
		tv.startAnimation(a);
	}

	public void elegirAccion(View v) {
		String tag = (String) v.getTag();
		// System.out.println("El lugar es: " + this.place);
		if (this.place.getBackground().equals("centro comercial")
				&& (tag.equals("sleeping") || tag.equals("studying"))) {
			if (findViewById(R.id.time_map_bar).getVisibility() == View.VISIBLE) {
				toggleTimeMapBar(findViewById(R.id.middle_button));
			}
			if (tag.equals("sleeping")) {
				setMessage("No vine a un centro comercial a dormir");
			} else {
				setMessage("¿Estudiar en un centro comercial?\nClaro...");
			}
		} else {
			startTransactionAnimation(false);
			Intent i = new Intent(PlayingActivity.this, SelectActivity.class);
			i.putExtra("Place", this.place);
			i.putExtra("tag", tag);
			startActivity(i);
		}
	}

	public void startTransactionAnimation(boolean entrada) {
		if (!entrada
				&& findViewById(R.id.time_map_bar).getVisibility() == View.VISIBLE) {
			toggleTimeMapBar(findViewById(R.id.middle_button));
		}
		View v = findViewById(R.id.sfu);
		TranslateAnimation trans = new TranslateAnimation(0f, 0f,
				(entrada ? -1000f : 0f), (entrada ? 0f : -1000f));
		trans.setDuration(1500);
		trans.setFillAfter(true);
		v.startAnimation(trans);
	}

	public void toggleTimeMapBar(View v) {
		((TextView) findViewById(R.id.main_message)).setText("");
		View bar = findViewById(R.id.time_map_bar);
		ImageButton button = (ImageButton) v;
		if (bar.getVisibility() == View.INVISIBLE) {
			bar.setVisibility(View.VISIBLE);
			button.setImageResource(R.drawable.up_arrow);
		} else {
			bar.setVisibility(View.INVISIBLE);
			button.setImageResource(R.drawable.down_arrow);
		}
	}

	public void goToMap(View v) {
		Intent i = new Intent(PlayingActivity.this, MoveActivity.class);
		i.putExtra("place", "");
		startActivity(i);
		finish();
	}

}
