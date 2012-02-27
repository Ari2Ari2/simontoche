/** Mantiene los parametros del juego
 * 
 */

package simonToche.logic;

import java.util.List;

public class Game {
	
	private static double timeFactor;
	private static byte foodLevel;
	private static byte studyLevel;
	private static byte sleepLevel;
	private static byte funLevel;
	private static byte week;
	private static byte day;
	private static byte hour;
	private static Place place;
	private static List<Category> categories;
	
	
	
	/**
	 * @return the timeFactor
	 */
	public static double getTimeFactor() {
		return timeFactor;
	}
	/**
	 * @param timeFactor the timeFactor to set
	 */
	public static void setTimeFactor(double timeFactor) {
		Game.timeFactor = timeFactor;
	}
	/**
	 * @return the foodLevel
	 */
	public static byte getFoodLevel() {
		return foodLevel;
	}
	/**
	 * @param foodLevel the foodLevel to set
	 */
	public static void setFoodLevel(byte foodLevel) {
		Game.foodLevel = foodLevel;
	}
	/**
	 * @return the studyLevel
	 */
	public static byte getStudyLevel() {
		return studyLevel;
	}
	/**
	 * @param studyLevel the studyLevel to set
	 */
	public static void setStudyLevel(byte studyLevel) {
		Game.studyLevel = studyLevel;
	}
	/**
	 * @return the sleepLevel
	 */
	public static byte getSleepLevel() {
		return sleepLevel;
	}
	/**
	 * @param sleepLevel the sleepLevel to set
	 */
	public static void setSleepLevel(byte sleepLevel) {
		Game.sleepLevel = sleepLevel;
	}
	/**
	 * @return the funLevel
	 */
	public static byte getFunLevel() {
		return funLevel;
	}
	/**
	 * @param funLevel the funLevel to set
	 */
	public static void setFunLevel(byte funLevel) {
		Game.funLevel = funLevel;
	}
	/**
	 * @return the week
	 */
	public static byte getWeek() {
		return week;
	}
	/**
	 * @param week the week to set
	 */
	public static void setWeek(byte week) {
		Game.week = week;
	}
	/**
	 * @return the day
	 */
	public static byte getDay() {
		return day;
	}
	/**
	 * @param day the day to set
	 */
	public static void setDay(byte day) {
		Game.day = day;
	}
	/**
	 * @return the hour
	 */
	public static byte getHour() {
		return hour;
	}
	/**
	 * @param hour the hour to set
	 */
	public static void setHour(byte hour) {
		Game.hour = hour;
	}
	/**
	 * @return the place
	 */
	public static Place getPlace() {
		return place;
	}
	/**
	 * @param place the place to set
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
	 * @param categories the categories to set
	 */
	public static void setCategories(List<Category> categories) {
		Game.categories = categories;
	}
	
	

}
