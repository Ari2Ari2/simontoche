package simonToche.logic;

import java.util.List;

public class Category {

	List<Activity> activities;
	private String name;
	private String color;
	
	
	/** Look for the activities in this.activities that match the 
	 * category and return them in a List.
	 * 
	 * @param category The Category to match activities.
	 * @return The list of activities that belongs to category.
	 */
	public List<Activity> getActivitiesByCategory(Category category){
		throw new UnsupportedOperationException();
	}


	/**
	 * @return the activities
	 */
	public List<Activity> getActivities() {
		return activities;
	}


	/**
	 * @param activities the activities to set
	 */
	public void setActivities(List<Activity> activities) {
		this.activities = activities;
	}


	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}


	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}
	
	
	
}
