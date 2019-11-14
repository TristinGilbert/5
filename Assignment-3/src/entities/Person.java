/*
 * This code is created to hold the Person constructor and getters and setters
 * 
 * Authors: Max Van Arsdall and Tristin Gilbert
 * 
 * 
 */
package entities;

import java.util.ArrayList;
import entities.Address;

public class Person {
	//defining variables
	private String personCode;
	private String firstName;
	private String lastName;
	private Address address;
	private ArrayList<String> emailAddresses;

	// Constructor
	public Person(String personCode, String firstName, String lastName, Address address, ArrayList<String> emailAddresses) {
		super();
		this.personCode = personCode;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.emailAddresses = emailAddresses;
	}

	//override function for printing
	@Override
	public String toString() {
		return "" + lastName + ", "  + firstName;
	}

	//getters and setters
	public String getPersonCode() {
		return personCode;
	}

	public void setPersonCode(String personCode) {
		this.personCode = personCode;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public ArrayList<String> getemailAddresses() {
		return emailAddresses;
	}

	public void setemailAddresses(ArrayList<String> emailAddresses) {
		this.emailAddresses = emailAddresses;
	}

}