/*
 * This code is created to hold the FullTime constructor and getters and setters
 * 
 * Authors: Max Van Arsdall
 * 
 * 
 */
package entities;

// Class for providing a date for the product subclasses

public class FullTime {
	//defining variables
	private int hour;
	private int minute;
	private int second;
	private int nano;

	//constructor
	public FullTime(int hour, int minute, int second, int nano) {
		super();
		this.hour = hour;
		this.minute = minute;
		this.second = second;
		this.nano = nano;
	}

	//getters and setters
	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}

	public int getSecond() {
		return second;
	}

	public void setSecond(int second) {
		this.second = second;
	}

	public int getNano() {
		return nano;
	}

	public void setNano(int nano) {
		this.nano = nano;
	}

}
