/** Mantiene los parametros del juego
 * 
 */

package simonToche.logic;

import java.util.List;

public class Game {
	private static Hilo hilo;
	private static double timeFactor = 80;
	private static double foodLevel= 80;
	private static double studyLevel = 80;
	private static double sleepLevel = 80 ;
	private static double funLevel = 80;
	private static int week= 1;
	private static int day = 1;
	private static int hour = 1;
	private static int min = 1;
	private static Place place;
	private static List<Category> categories;
	private static double rateDiaFood = -1;
	private static double rateNocheFood = -1;
	private static double rateAumentoFood = -1;
	private static double rateActualFood  = 0;
	private static double rateDiaStudy = -1;
	private static double rateNocheStudy = -1;
	private static double rateAumentoStudy = -1;
	private static double rateActualStudy  = 0;
	private static double rateDiaSleep = -1;
	private static double rateNocheSleep = -1;
	private static double rateAumentoSleep = -1;
	private static double rateActualSleep  = 0;
	private static double rateDiaFun = -1;
	private static double rateNocheFun = -1;
	private static double rateAumentoFun = -1;
	private static double rateActualFun  = 0;
	protected static long duracion= 2000000000; //nano segundos

	private static class Hilo extends Thread {
		public String actividad;

		public Hilo(String actividad) {
			this.actividad = actividad;
		}

		public void run() {
			long start = System.nanoTime();
			long fin = start;
			Game.asignarRatePositivo(this.actividad);
			while (Game.duracion < fin - start) {
				
				if( ! Game.evaluarRates(this.actividad)){
					break;
				}
				fin++;
			}
			Game.asignarRate(actividad);
		}
	}

	/**
	 * @return the timeFactor
	 */
	public static double getTimeFactor() {
		return timeFactor;
	}

	public static boolean evaluarRates(String actividad) {
		if (actividad.equalsIgnoreCase("dormir")) {
			return Game.sleepLevel < 100;
		}
		if (actividad.equalsIgnoreCase("comer")) {
			return Game.foodLevel < 100;
		}
		if (actividad.equalsIgnoreCase("estudiar")) {
			return Game.studyLevel < 100;
		}
		if (actividad.equalsIgnoreCase("entretenerse")) {
			return Game.funLevel < 100;
		}
		return false;	
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

	private static void crearHilo(String string) {
		if (Game.hilo != null) {
			Game.hilo.stop();
			Game.hilo.destroy();
		}
		Game.hilo = new Hilo(string);
	}

	public static void comer() {
		crearHilo("comer");
	}

	public static void dormir() {
		crearHilo("dormir");
	}

	public static void entretenerse() {
		crearHilo("entretenerse");
	}

	public static void estudiar() {
		crearHilo("estudiar");
	}

	public static boolean esDia() {
		return Game.hour < 19;
	}
	
	private static void asignarRatePositivo(String actividad) {
		if (actividad.equalsIgnoreCase("dormir")
				&& Game.rateActualSleep != Game.rateAumentoSleep) {
			Game.rateActualSleep = Game.rateAumentoSleep;
		}
		else if (actividad.equalsIgnoreCase("comer")
				&& Game.rateActualFood != Game.rateAumentoFood) {
			Game.rateActualFood = Game.rateAumentoFood;
		}
		else if (actividad.equalsIgnoreCase("estudiar")
				&& Game.rateActualStudy != Game.rateAumentoStudy) {
			Game.rateActualStudy = Game.rateAumentoStudy;
		}
		else if (actividad.equalsIgnoreCase("entretenerse")
				&& Game.rateActualFun != Game.rateAumentoFun) {
			Game.rateActualFun = Game.rateAumentoFun;
		}	
	}

	public static void asignarRate(String actividad) {
		if (actividad.equalsIgnoreCase("dormir")) {
			if (Game.esDia()) {
				Game.rateActualSleep = Game.rateDiaSleep;
			}else{
				Game.rateActualSleep = Game.rateNocheSleep;
			}
		}
		if (actividad.equalsIgnoreCase("comer")) {
			if (Game.esDia()) {
				Game.rateActualFood = Game.rateDiaFood;
			}else{
				Game.rateActualFood = Game.rateNocheFood;
			}
		}
		if (actividad.equalsIgnoreCase("estudiar")) {
			if (Game.esDia()) {
				Game.rateActualStudy = Game.rateDiaStudy;
			}else{
				Game.rateActualStudy = Game.rateNocheStudy;
			}
		}
		if (actividad.equalsIgnoreCase("entretenerse")) {
			if (Game.esDia()) {
				Game.rateActualFun = Game.rateDiaFun;
			}else{
				Game.rateActualFun = Game.rateNocheFun;
			}
		}
	}
	
	
	public static void actualizar(int mins){
		cambiarValoresNecesidad( mins);
		cambiarValoresTiempo( mins);	
	}

	private static void cambiarValoresTiempo(int mins) {
		Game.min += mins;
		if((Game.min % 60) == 0){
			Game.hour ++;
			if((Game.hour % 24) == 0){
				Game.day ++;
				if((Game.day % 7) == 0){
					Game.week++;
					if((Game.week % 13) == 0){
						Game.gameOver();
					}
				}
			}
		}
		
	}

	private static void gameOver() {
	}

	private static void cambiarValoresNecesidad(int mins) {
		Game.foodLevel +=  (Game.rateActualFood *  mins);
		Game.funLevel += (Game.rateActualFun *  mins);
		Game.sleepLevel += (Game.rateActualSleep *  mins);
		Game.studyLevel += (Game.rateActualStudy *  mins);
	}
	
	
	
	
	

}
