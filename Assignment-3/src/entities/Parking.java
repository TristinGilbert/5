/*
 * This code is created to hold the Parking constructor and getters and setters
 * 
 * Authors: Max Van Arsdall and Tristin Gilbert
 * 
 * 
 */
package entities;

public class Parking extends Product {

	//defining varaibles
	private double parkingFee;

	// Constructor
	public Parking(String code, String type, double parkingFee) {
		super(code, type);
		this.parkingFee = parkingFee;
	}

	//getters and setters
	public double getParkingFee() {
		return parkingFee;
	}

	

	public void setParkingFee(double parkingFee) {
		this.parkingFee = parkingFee;
	}

	//gets price
	@Override
	public double getPrice() {
		// TODO Auto-generated method stub
		return getParkingFee();
	}



	//override function to print product name
	@Override
	public String getProductName() {
		// TODO Auto-generated method stub
		String parking = "";
		parking = "Parking Pass";
		return parking;
	}

	@Override
	public String getInvoiceAddress() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
