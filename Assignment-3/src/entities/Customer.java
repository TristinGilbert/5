/*
 * This code is created to hold the Customer constructor and getters and setters
 * 
 * Authors: Max Van Arsdall and Tristin Gilbert
 * 
 * 
 */
package entities;

import entities.Address;
import entities.Person;

public class Customer {
	//defining variables
	private String code;
	private String type;
	private Person primaryContact;
	private String name;
	private Address address;

	// Constructor
	public Customer(String code, Person primaryContact, String name, Address address) {
		super();
		this.code = code;
		this.primaryContact = primaryContact;
		this.name = name;
		this.address = address;
	}

	//getters and setters
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Person getPrimaryContact() {
		return primaryContact;
	}

	public void setPrimaryContact(Person primaryContact) {
		this.primaryContact = primaryContact;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	//override function to print primary contact and address
//	@Override
//	public String toString() {
//		return "" + primaryContact.toString() + "\n " + address.toString();
//	}
	

}