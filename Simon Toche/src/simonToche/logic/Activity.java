package simonToche.logic;

import java.util.List;

public class Activity {

	private List<Event> events;
	private String button;
	private Category category;
	/**
	 * @return the events
	 */
	public List<Event> getEvents() {
		return events;
	}
	/**
	 * @param events the events to set
	 */
	public void setEvents(List<Event> events) {
		this.events = events;
	}
	/**
	 * @return the button
	 */
	public String getButton() {
		return button;
	}
	/**
	 * @param button the button to set
	 */
	public void setButton(String button) {
		this.button = button;
	}
	/**
	 * @return the category
	 */
	public Category getCategory() {
		return category;
	}
	/**
	 * @param category the category to set
	 */
	public void setCategory(Category category) {
		this.category = category;
	}
	
	
	
	
}
