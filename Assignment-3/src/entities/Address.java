/*
 * This code is created to hold the Address constructor and getters and setters
 * 
 * Authors: Max Van Arsdall and Tristin Gilbert
 * 
 * 
 */
package entities;

public class Address {
	//defining variables
	private String street;
	private String city;
	private String state;
	private String zip;
	private String country;

	// Constructor
	public Address(String street, String city, String state, String zip, String country) {
		super();
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.country = country;

	}
	
	//getters and setters
	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	//prints out an address
	@Override
	public String toString() {
		return " " + street + "\n  " + city + ", " + state + " " + zip + " "
				+ country;
	}

}