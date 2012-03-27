/** Mantiene los parametros del juego
 * 
 */

package simonToche.logic;
import java.util.List;
import java.util.Random;

public class Game {
	private static String estado = "" ;
	private static final int foodAumento = 0;
	private static final int sleepAumento = 0;
	private static final int studyAumento = 0;
	private static final int funAumento = 0;
	private static Random generator;
	private static Hilo hilo;
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

	private static class Hilo extends Thread {
		public String actividad;

		public Hilo(String actividad) {
			this.actividad = actividad;
		}

		public void run() {
			Game.asignarRatePositivo(this.actividad);
			boolean nivelApropiado = false ;
			double nivelInicial = Game.consultarNivel(this.actividad);
			while (! nivelApropiado ) {
				nivelApropiado = Game.consultarNivelApropiado(
						consultarNivelNombre(this.actividad) , nivelInicial);
			}
			Game.asignarRate(actividad);
		}
	}

	public static double consultarNivel(String actividad){
		if(actividad.equalsIgnoreCase("comer")){
			return Game.foodLevel;
		} else if (actividad.equalsIgnoreCase("dormir")){
			return Game.sleepLevel;
		}else if(actividad.equalsIgnoreCase("estudiar")){
			return Game.studyLevel;
		}else if(actividad.equalsIgnoreCase("entretenerse")){
			return Game.funLevel;
		}
		return 0;
	}
	
	public static String consultarNivelNombre(String actividad){
		if(actividad.equalsIgnoreCase("comer")){
			return "foodLevel";
		} else if (actividad.equalsIgnoreCase("dormir")){
			return "sleepLevel";
		}else if(actividad.equalsIgnoreCase("estudiar")){
			return "studyLevel";
		}else if(actividad.equalsIgnoreCase("entretenerse")){
			return "funLevel";
		}
		return "";
	}
	public static boolean consultarNivelApropiado(String nivel,
			 double nivelInicial) {
		if(nivel.equalsIgnoreCase("foodLevel")){
			return Game.foodLevel >= Game.foodAumento + nivelInicial  ;
		} else if (nivel.equalsIgnoreCase("sleepLevel")){
			return Game.sleepLevel >= Game.sleepAumento + nivelInicial  ;
		}else if(nivel.equalsIgnoreCase("studyLevel")){
			return Game.studyLevel>= Game.studyAumento + nivelInicial  ;
		}else if(nivel.equalsIgnoreCase("funLevel")){
			return Game.funLevel >= Game.funAumento + nivelInicial  ;
		}
		return false;
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
		resetearRates();
		if (Game.hilo != null) {
//			Game.hilo.stop();
//			Game.hilo.destroy();
		}
		Game.hilo = new Hilo(string);
		Game.hilo.start();
	}

	private static void resetearRates() {
		// TODO Auto-generated method stub
		asignarRate("comer");
		asignarRate("dormir");
		asignarRate("entretenserse");
		asignarRate("estudiar");
	}

	public static void comer() {
		if(Game.generator.nextDouble() < 0.5){
		crearHilo("comer");
		}else {
		Game.estado = "comer";
		}
	}

	public static void dormir() {
		if(Game.generator.nextDouble() < 0.5){
		crearHilo("dormir");
		}else {
		Game.estado = "dormir";
		}
	}

	public static void entretenerse() {
		if(Game.generator.nextDouble() < 0.5){
		crearHilo("entretenerse");
		}else {
		Game.estado = "entretenerse";
		}
	}

	public static void estudiar() {
		if(Game.generator.nextDouble() < 0.5){
		crearHilo("estudiar");
		}else {
		Game.estado = "estudiar";
		}
	}

	public static boolean esDia() {
		return Game.hour < 19;
	}
	
	public static int getMinutes(){
		return Game.min;
	}

	private static void asignarRatePositivo(String actividad) {
		if (actividad.equalsIgnoreCase("dormir")
				&& Game.rateActualSleep != Game.rateAumentoSleep) {
			Game.rateActualSleep = Game.rateAumentoSleep;
		} else if (actividad.equalsIgnoreCase("comer")
				&& Game.rateActualFood != Game.rateAumentoFood) {
			Game.rateActualFood = Game.rateAumentoFood;
		} else if (actividad.equalsIgnoreCase("estudiar")
				&& Game.rateActualStudy != Game.rateAumentoStudy) {
			Game.rateActualStudy = Game.rateAumentoStudy;
		} else if (actividad.equalsIgnoreCase("entretenerse")
				&& Game.rateActualFun != Game.rateAumentoFun) {
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
		}else if (actividad.equalsIgnoreCase("comer")) {
			if (Game.esDia()) {
				Game.rateActualFood = Game.rateDiaFood;
			} else {
				Game.rateActualFood = Game.rateNocheFood;
			}
		}else if (actividad.equalsIgnoreCase("estudiar")) {
			if (Game.esDia()) {
				Game.rateActualStudy = Game.rateDiaStudy;
			} else {
				Game.rateActualStudy = Game.rateNocheStudy;
			}
		}else if (actividad.equalsIgnoreCase("entretenerse")) {
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
		System.out.println("Comida: " + foodLevel + ", " +
				"Estudio: " + studyLevel + ", " +
				"Sleep: " + sleepLevel + ", " +
				"Fun: " + funLevel);
	}

	private static void cambiarValoresTiempo(int mins) {
		Game.min += mins;
		if ((Game.min % 60) == 0) {
			Game.hour++;
			if ((Game.hour % 24) == 0) {
				Game.day++;
				if ((Game.day % 7) == 0) {
					Game.week++;
					if ((Game.week % 13) == 0) {
						Game.gameOver();
					}
				}
			}
		}

	}

	private static void gameOver() {
		Game.estado = "gano";
	}

	private static void cambiarValoresNecesidad(int mins) {
		Game.foodLevel += (Game.rateActualFood * mins);
		Game.funLevel += (Game.rateActualFun * mins);
		Game.sleepLevel += (Game.rateActualSleep * mins);
		Game.studyLevel += (Game.rateActualStudy * mins);
	}

	public static String evaluarEstado() {
		return Game.estado;
	}
	
	public static void newGame(){
		resetearRates();
	}
}
