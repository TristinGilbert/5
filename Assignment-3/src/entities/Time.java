/*
 * This code is created to hold the time constructor and getters and setters
 * 
 * Authors: Max Van Arsdall and Tristin Gilbert
 * 
 * 
 */
package entities;

// Class for providing a date for the product subclasses

public class Time {

	//defining variables
	private int year;
	private int month;
	private int day;

	//constructor
	public Time(int year, int month, int day) {
		super();
		this.year = year;
		this.month = month;
		this.day = day;
	}

	//getters and setters
	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	@Override
	public String toString() {
		return "" + year + "-" + month + "-" + day;
	}

}
