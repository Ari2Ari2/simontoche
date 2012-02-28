package simonToche.logic;

import java.io.Serializable;
import java.util.List;

public class Place implements Serializable{
	
	private List<Activity> activities;
	private String background;

	
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
	 * @return the background
	 */
	public String getBackground() {
		return background;
	}


	/**
	 * @param background the background to set
	 */
	public void setBackground(String background) {
		this.background = background;
	}
	
	
	
}
