/*
 * This code is created to hold the DateTime constructor and getters and setters
 * Combines Time and Fulltime
 * 
 * Authors: Max Van Arsdall and Gavin Teet
 * 
 * 
 */
package entities;

public class DateTime {
	//defining variables
	private Time date;
	private FullTime time;

	//constructor
	public DateTime(Time date, FullTime time) {
		super();
		this.date = date;
		this.time = time;
	}
	
	//getters and setters
	public Time getDate() {
		return date;
	}

	public void setDate(Time date) {
		this.date = date;
	}

	public FullTime getTime() {
		return time;
	}

	public void setTime(FullTime time) {
		this.time = time;
	}
}
