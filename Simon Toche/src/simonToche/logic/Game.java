/** Mantiene los parametros del juego
 * 
 */

package simonToche.logic;

import java.util.List;
import java.util.Random;

public class Game {
	
	private static String estado = "";
	private static Random generator;
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
	private static double rateDiaFood = -0.139;
	private static double rateNocheFood = -0.092;
	private static double rateAumentoFood = 1.6;
	private static double rateActualFood = 0;
	private static double rateDiaStudy = -0.0347;
	private static double rateNocheStudy = -0.0231;
	private static double rateAumentoStudy = 0.27;
	private static double rateActualStudy = 0;
	private static double rateDiaSleep = -0.104;
	private static double rateNocheSleep = -0.27;
	private static double rateAumentoSleep = 0.208;
	private static double rateActualSleep = 0;
	private static double rateDiaFun = -0.2777;
	private static double rateNocheFun = -0.33333;
	private static double rateAumentoFun = 0.83333;
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
//		if (Game.generator.nextDouble() < 0.5) {
			Game.actividadActual = "comer";
			Game.minutosActividad = 60;
//		}else{
//			Game.estado = "Excepcion al comer";
//		}
	}

	public static void dormir() {
		resetearRates();
//		if (Game.generator.nextDouble() < 0.5) {
			Game.actividadActual = "dormir";
			Game.minutosActividad = 480;	
//		}else{
//			Game.estado = "Excepcion al dormir";
//		}
	}

	public static void entretenerse() {
		resetearRates();
//		if (Game.generator.nextDouble() < 0.5) {
			Game.actividadActual = "entretenerse";
			Game.minutosActividad = 120;
			Game.asignarRatePositivo("entretenerse");
			
//		}else{
//			Game.estado = "Excepcion al entretenerse";
//		}
	}

	public static void estudiar() {
		resetearRates();
//		if (Game.generator.nextDouble() < 0.5) {
			Game.actividadActual = "estudiar";
			Game.minutosActividad = 360;	
			Game.asignarRatePositivo("estudiar");
//		}else{
//			Game.estado = "Excepcion al estudiar";
//		}
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

	public static void actualizar(int mins) {
		cambiarValoresNecesidad(mins);
		cambiarValoresTiempo(mins);
//		System.out.println("Comida: " + foodLevel + ", " + "Estudio: "
//				+ studyLevel + ", " + "Sleep: " + sleepLevel + ", " + "Fun: "
//				+ funLevel);
		if (!Game.actividadActual.isEmpty()) {
			Game.minutosActividad -= mins;
			// Si ya se acabo el tiempo en que se iba a realizar la actividad o los niveles se llenan
			if (Game.minutosActividad <= 0 || Game.foodLevel >= 100.0 || 
				Game.studyLevel >= 100.0 || Game.funLevel >= 100.0 || Game.sleepLevel >= 100.0) {
				Game.actividadActual = "";
				resetearRates();
			}else{
				Game.asignarRatePositivo(Game.actividadActual);
			}
		}
		Game.gameOver();
	}

	private static void cambiarValoresTiempo(int mins) {
		if(Game.min + mins > 60){
			int horas = (Game.min + mins) / 60;
			Game.min = (Game.min +  mins) % 60;
			Game.min %= 60;
			if(Game.hour + horas > 24){
				Game.week += (Game.hour + horas) / 24;
				Game.hour = ( Game.hour + horas) % 24;
			}else{
				Game.hour += horas;
			}
		}else{
			Game.min += mins;
		}
	}

	/** Verifica si el juego esta en un estado final y de estarlo coloca en 
	 * la variable Game.estado "gano" o "perdio" segun sea el caso.
	 * 
	 */
	private static void gameOver() {
		if(Game.week > 12){
			Game.estado = "gano";
		}else if(Game.foodLevel <= 0.0 || Game.studyLevel <= 0.0 ||
				Game.funLevel <= 0.0 || Game.sleepLevel <= 0.0){
			Game.estado = "perdio";
		}
	}

	/** Aumenta los niveles de comida, diversion, sueno 
	 * 
	 * @param mins
	 */
	private static void cambiarValoresNecesidad(int mins) {
		Game.foodLevel += (Game.rateActualFood * mins);
		if(Game.foodLevel > 100.0){
			Game.foodLevel = 100.0;
		}
		Game.funLevel += (Game.rateActualFun * mins);
		if(Game.funLevel > 100.0){
			Game.funLevel = 100.0;
		}
		Game.sleepLevel += (Game.rateActualSleep * mins);
		if(Game.sleepLevel > 100.0){
			Game.sleepLevel = 100.0;
		}
		Game.studyLevel += (Game.rateActualStudy * mins);
		if(Game.studyLevel > 100.0){
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
		Game.hour = 7;
		Game.min = 0;
		foodLevel = 30;
		studyLevel = 50;
		sleepLevel = 70;
		funLevel = 90;
		
	}

	public static String getActividadActual() {
		System.out.println("Actividad Actual"+ Game.actividadActual);
		return Game.actividadActual;
	}

}
