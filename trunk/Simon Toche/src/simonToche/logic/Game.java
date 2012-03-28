/** Mantiene los parametros del juego
 * 
 */

package simonToche.logic;

import java.util.List;
import java.util.Random;

public class Game {

	private static String estado = "";
	private static Random generator = new Random();
	private static double timeFactor = 80;
	private static double foodLevel = 80;
	private static double studyLevel = 80;
	private static double sleepLevel = 80;
	private static double funLevel = 80;
	private static int week = 1;
	private static int day = 1;
	private static int hour = 1;
	private static int min = 1;
	private static Place place;
	private static List<Category> categories;
	private static double rateDiaFood = -0.277;
	private static double rateNocheFood = -0.166;
	private static double rateAumentoFood = 1.2;
	private static double rateActualFood = 0;
	private static double rateDiaStudy = -0.04;
	private static double rateNocheStudy = -0.03;
	private static double rateAumentoStudy = 0.3;
	private static double rateActualStudy = 0;
	private static double rateDiaSleep = -0.104;
	private static double rateNocheSleep = -0.27;
	private static double rateAumentoSleep = 0.208;
	private static double rateActualSleep = 0;
	private static double rateDiaFun = -0.2777;
	private static double rateNocheFun = -0.33333;
	private static double rateAumentoFun = 0.36666;
	private static double rateActualFun = 0;
	private static String actividadActual = "";
	private static int minutosActividad = 0;

	/**
	 * @return the timeFactor
	 */
	public static double getTimeFactor() {
		return timeFactor;
	}

	/**
	 * @param timeFactor
	 *            the timeFactor to set
	 */
	public static void setTimeFactor(double timeFactor) {
		Game.timeFactor = timeFactor;
	}

	/**
	 * @return the foodLevel
	 */
	public static double getFoodLevel() {
		return foodLevel;
	}

	/**
	 * @param foodLevel
	 *            the foodLevel to set
	 */
	public static void setFoodLevel(double foodLevel) {
		Game.foodLevel = foodLevel;
	}

	/**
	 * @return the studyLevel
	 */
	public static double getStudyLevel() {
		return studyLevel;
	}

	/**
	 * @param studyLevel
	 *            the studyLevel to set
	 */
	public static void setStudyLevel(double studyLevel) {
		Game.studyLevel = studyLevel;
	}

	/**
	 * @return the sleepLevel
	 */
	public static double getSleepLevel() {
		return sleepLevel;
	}

	/**
	 * @param sleepLevel
	 *            the sleepLevel to set
	 */
	public static void setSleepLevel(double sleepLevel) {
		Game.sleepLevel = sleepLevel;
	}

	/**
	 * @return the funLevel
	 */
	public static double getFunLevel() {
		return funLevel;
	}

	/**
	 * @param funLevel
	 *            the funLevel to set
	 */
	public static void setFunLevel(double funLevel) {
		Game.funLevel = funLevel;
	}

	/**
	 * @return the week
	 */
	public static int getWeek() {
		return week;
	}

	/**
	 * @param week
	 *            the week to set
	 */
	public static void setWeek(int week) {
		Game.week = week;
	}

	/**
	 * @return the day
	 */
	public static int getDay() {
		return day;
	}

	/**
	 * @param day
	 *            the day to set
	 */
	public static void setDay(int day) {
		Game.day = day;
	}

	/**
	 * @return the hour
	 */
	public static int getHour() {
		return hour;
	}

	/**
	 * @param hour
	 *            the hour to set
	 */
	public static void setHour(int hour) {
		Game.hour = hour;
	}

	/**
	 * @return the place
	 */
	public static Place getPlace() {
		return place;
	}

	/**
	 * @param place
	 *            the place to set
	 */
	public static void setPlace(Place place) {
		Game.place = place;
	}

	/**
	 * @return the categories
	 */
	public static List<Category> getCategories() {
		return categories;
	}

	/**
	 * @param categories
	 *            the categories to set
	 */
	public static void setCategories(List<Category> categories) {
		Game.categories = categories;
	}

	private static void resetearRates() {
		// TODO Auto-generated method stub
		asignarRate("comer");
		asignarRate("dormir");
		asignarRate("entretenerse");
		asignarRate("estudiar");
	}

	public static void comer() {
		resetearRates();
		Double aleatorio = Game.generator.nextDouble();
		if (aleatorio < 0.15) {
			generarEstadoAleatorio("comer");
		} else {
			System.out.println("Cambiando actividad actual a comer");
			Game.actividadActual = "comer";
			Game.minutosActividad = 60;
			Game.asignarRatePositivo("comer");
		}
	}

	public static void dormir() {
		resetearRates();
		Double aleatorio = Game.generator.nextDouble();
		if (aleatorio < 0.15) {
			generarEstadoAleatorio("dormir");
		} else {
			Game.actividadActual = "dormir";
			Game.minutosActividad = 480;
			Game.asignarRatePositivo("dormir");
		}
	}

	public static void entretenerse() {
		resetearRates();
		Double aleatorio = Game.generator.nextDouble();
		if (aleatorio < 0.15) {
			generarEstadoAleatorio("entretenerse");
		} else {
			Game.actividadActual = "entretenerse";
			Game.minutosActividad = 120;
			Game.asignarRatePositivo("entretenerse");
		}
	}

	public static void estudiar() {
		resetearRates();
		Double aleatorio = Game.generator.nextDouble();
		if (aleatorio < 0.15) {
			generarEstadoAleatorio("estudiar");
		} else {
			Game.actividadActual = "estudiar";
			Game.minutosActividad = 360;
			Game.asignarRatePositivo("estudiar");
		}
	}

	public static boolean esDia() {
		return Game.hour < 19;
	}

	public static int getMinutes() {
		return Game.min;
	}

	private static void asignarRatePositivo(String actividad) {
		if (actividad.equalsIgnoreCase("dormir")) {
			Game.rateActualSleep = Game.rateAumentoSleep;
		} else if (actividad.equalsIgnoreCase("comer")) {
			Game.rateActualFood = Game.rateAumentoFood;
		} else if (actividad.equalsIgnoreCase("estudiar")) {
			Game.rateActualStudy = Game.rateAumentoStudy;
		} else if (actividad.equalsIgnoreCase("entretenerse")) {
			Game.rateActualFun = Game.rateAumentoFun;
		}
	}

	public static void asignarRate(String actividad) {
		if (actividad.equalsIgnoreCase("dormir")) {
			if (Game.esDia()) {
				Game.rateActualSleep = Game.rateDiaSleep;
			} else {
				Game.rateActualSleep = Game.rateNocheSleep;
			}
		} else if (actividad.equalsIgnoreCase("comer")) {
			if (Game.esDia()) {
				Game.rateActualFood = Game.rateDiaFood;
			} else {
				Game.rateActualFood = Game.rateNocheFood;
			}
		} else if (actividad.equalsIgnoreCase("estudiar")) {
			if (Game.esDia()) {
				Game.rateActualStudy = Game.rateDiaStudy;
			} else {
				Game.rateActualStudy = Game.rateNocheStudy;
			}
		} else if (actividad.equalsIgnoreCase("entretenerse")) {
			if (Game.esDia()) {
				Game.rateActualFun = Game.rateDiaFun;
			} else {
				Game.rateActualFun = Game.rateNocheFun;
			}
		}
	}

	public static boolean actualizar(int mins) {
		cambiarValoresNecesidad(mins);
		cambiarValoresTiempo(mins);
		// System.out.println("Comida: " + foodLevel + ", " + "Estudio: "
		// + studyLevel + ", " + "Sleep: " + sleepLevel + ", " + "Fun: "
		// + funLevel);
		if (!Game.actividadActual.equals("")) {
			Game.minutosActividad -= mins;
			// Si ya se acabo el tiempo en que se iba a realizar la actividad o
			// los niveles se llenan
			if (Game.minutosActividad <= 0 || Game.foodLevel >= 100.0
					|| Game.studyLevel >= 100.0 || Game.funLevel >= 100.0
					|| Game.sleepLevel >= 100.0) {
				Game.actividadActual = "";
				resetearRates();
			} else {
				Game.asignarRatePositivo(Game.actividadActual);
			}
		}
		return Game.gameOver();
	}

	private static void cambiarValoresTiempo(int mins) {
		if (Game.min + mins > 60) {
			int horas = (Game.min + mins) / 60;
			Game.min = (Game.min + mins) % 60;
			if (Game.hour + horas > 24) {
				Game.week += (Game.hour + horas) / 24;
				Game.hour = (Game.hour + horas) % 24;
			} else {
				Game.hour += horas;
			}
		} else {
			Game.min += mins;
		}
	}

	/**
	 * Verifica si el juego esta en un estado final y de estarlo coloca en la
	 * variable Game.estado "gano" o "perdio" segun sea el caso.
	 * 
	 */
	private static boolean gameOver() {
		if (Game.week > 12) {
			Game.estado = "gano";
		} else if (Game.foodLevel <= 0.0 || Game.studyLevel <= 0.0
				|| Game.funLevel <= 0.0 || Game.sleepLevel <= 0.0) {
			Game.estado = "perdio";
		}else{
			return false;
		}
		return true;
	}

	/**
	 * Aumenta los niveles de comida, diversion, sueno
	 * 
	 * @param mins
	 */
	private static void cambiarValoresNecesidad(int mins) {
		Game.foodLevel += (Game.rateActualFood * mins);
		if (Game.foodLevel > 100.0) {
			Game.foodLevel = 100.0;
		}
		Game.funLevel += (Game.rateActualFun * mins);
		if (Game.funLevel > 100.0) {
			Game.funLevel = 100.0;
		}
		Game.sleepLevel += (Game.rateActualSleep * mins);
		if (Game.sleepLevel > 100.0) {
			Game.sleepLevel = 100.0;
		}
		Game.studyLevel += (Game.rateActualStudy * mins);
		if (Game.studyLevel > 100.0) {
			Game.studyLevel = 100.0;
		}
	}

	public static String evaluarEstado() {
		return Game.estado;
	}

	public static void newGame() {
		resetearRates();
		Game.actividadActual = "";
		Game.estado = "";
		Game.week = 1;
		Game.hour = 5;
		Game.min = 0;
		foodLevel = 40;
		studyLevel = 90;
		sleepLevel = 100;
		funLevel = 80;

	}

	public static String getActividadActual() {
		System.out.println("Actividad Actual" + Game.actividadActual);
		return Game.actividadActual;
	}

	private static void generarEstadoAleatorio(String actividad) {
		String estadoAleatorio ="";
		String lugar = Game.getPlace().getBackground();
		String[] causasNoComer = {"no hay comida" 
				,"no tienes dinero", "no te gusta esa comida" } ;
		String[] causasNoDormir = {"hay alguien que hace ruido" 
				, "no se puede dormir ", "tienes que estudiar" } ;
		String[] causasNoEntrenerse = {"se fue la luz" 
				, "no tienes dinero", "estas solo" } ;
		String[] causasNoEstudiar = {"no hay silencio" 
				, "no es el lugar apropiado", "no te puedes concentrar" } ;
		String[] adjetivos = {"Rayos!","OH no!","¿Que paso?"};
		String[] lugares = {"casa","universidad","centro comercial"};
		
		if(lugar.equals("casa")){
			if (actividad.equalsIgnoreCase("comer")){
				estadoAleatorio = adjetivos[ Math.abs(Game.generator.nextInt()) % 3 ] +
					" no pudiste "+ actividad	+ " porque " 
						+  causasNoComer[ Math.abs(Game.generator.nextInt()) % 3] 
								+ " en la casa";
			
			} else	if (actividad.equalsIgnoreCase("dormir")){
				estadoAleatorio = adjetivos[Math.abs(Game.generator.nextInt()) % 3 ] +
						" no pudiste "+ actividad	+ " porque " 
							+  causasNoDormir[Math.abs(Game.generator.nextInt()) % 3]
									+ " en la casa";
				
			} else	if (actividad.equalsIgnoreCase("estudiar")){
				estadoAleatorio = adjetivos[Math.abs(Game.generator.nextInt()) % 3 ]+
						" no pudiste "+ actividad	+ " porque " 
							+  causasNoEstudiar[ Math.abs(Game.generator.nextInt()) % 3]
									+ " en la casa";
			} else if (actividad.equalsIgnoreCase("entretenerse")){
				estadoAleatorio = adjetivos[Math.abs(Game.generator.nextInt()) % 3 ] +
						" no pudiste "+ actividad	+ " porque " 
							+  causasNoEntrenerse[ Math.abs(Game.generator.nextInt()) % 3]
									+ " en la casa";
			}
		}else if(lugar.equals("universidad")){
			if (actividad.equalsIgnoreCase("comer")){
				estadoAleatorio = adjetivos[Math.abs(Game.generator.nextInt()) % 3 ] +
					" no pudiste "+ actividad	+ " porque " 
						+  causasNoComer[ Math.abs(Game.generator.nextInt()) % 3] 
								+ " en la universidad";
			
			} else	if (actividad.equalsIgnoreCase("dormir")){
				estadoAleatorio = adjetivos[Math.abs(Game.generator.nextInt()) % 3 ] +
						" no pudiste "+ actividad	+ " porque " 
							+  causasNoDormir[ Math.abs(Game.generator.nextInt()) % 3]
									+ " en la universidad";
				
			} else	if (actividad.equalsIgnoreCase("estudiar")){
				estadoAleatorio = adjetivos[Math.abs(Game.generator.nextInt()) % 3] +
						" no pudiste "+ actividad	+ " porque " 
							+  causasNoEstudiar[ Math.abs(Game.generator.nextInt()) % 3]
									+ " en la universidad";
			} else if (actividad.equalsIgnoreCase("entretenerse")){
				estadoAleatorio = adjetivos[Math.abs(Game.generator.nextInt()) % 3 ] +
						" no pudiste "+ actividad	+ " porque " 
							+  causasNoEntrenerse[Math.abs(Game.generator.nextInt()) % 3]
									+ " en la universidad";
			
		}
			}else if (lugar.equals("centro comercial")){
			if (actividad.equalsIgnoreCase("comer")){
				estadoAleatorio = adjetivos[Math.abs(Game.generator.nextInt()) % 3 ] +
					" no pudiste "+ actividad	+ " porque " 
						+  causasNoComer[ Math.abs(Game.generator.nextInt()) % 3] 
								+ " en el mall";
			
			} else	if (actividad.equalsIgnoreCase("dormir")){
				estadoAleatorio = adjetivos[Math.abs(Game.generator.nextInt()) % 3] +
						" no pudiste "+ actividad	+ " porque " 
							+  causasNoDormir[ Math.abs(Game.generator.nextInt()) % 3]
									+ " en el mall";
				
			} else	if (actividad.equalsIgnoreCase("estudiar")){
				estadoAleatorio = adjetivos[Math.abs(Game.generator.nextInt()) % 3 ] +
						" no pudiste "+ actividad	+ " porque " 
							+  causasNoEstudiar[Math.abs(Game.generator.nextInt()) % 3]
									+ " en el mall";
			} else if (actividad.equalsIgnoreCase("entretenerse")){
				estadoAleatorio = adjetivos[Math.abs(Game.generator.nextInt()) % 3 ] +
						" no pudiste "+ actividad	+ " porque " 
							+  causasNoEntrenerse[ Math.abs(Game.generator.nextInt()) % 3]
									+ " en el mall";
		}
	}
		Game.estado = estadoAleatorio;
	}

	public static void resetEstado() {
		// TODO Auto-generated method stub
		estado = "";
		resetearRates();
	}
}
