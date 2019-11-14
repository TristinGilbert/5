/*
 * This code is created to hold the Amenity constructor and getters and setters
 * 
 * Authors: Max Van Arsdall and Tristin Gilbert
 * 
 * 
 */
package entities;

public class Amenity extends Product {

	//defining variables
	private String amenityName;
	private double cost;
	

	

	public Amenity(String code, String type, String amenityName, double cost) {
		super(code, type);
		this.amenityName = amenityName;
		this.cost = cost;
	}

	//getters and setters
	public String getamenityName() {
		return amenityName;
	}

	public void setamenityName(String amenityName) {
		this.amenityName = amenityName;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}
	
	//gets the cost of amenity
	@Override
	public double getPrice() {
		return cost;
	}

	//gets the product name
	@Override
	public String getProductName() {
		return amenityName;
	}
	
	@Override
	public String getInvoiceAddress() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
