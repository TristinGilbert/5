/*
 * This code is created to hold the Sales constructor and getters and setters
 * 
 * Authors: Max Van Arsdall and Tristin Gilbert
 * 
 * 
 */

package entities;

public class Sales extends Product {

	//defining variables
	private DateTime dateTime;
	private Address address;
	private double totalCost;
	private double downPayment;
	private double monthlyPayment;
	private int payablemMonths;
	private double interestRate;

	// Constructor


	public Sales(String code, String type, DateTime dateTime, Address address, double totalCost, double downPayment,
			double monthlyPayment, int payableMonths, double interestRate) {
		super(code, type);
		this.dateTime = dateTime;
		this.address = address;
		this.totalCost = totalCost;
		this.downPayment = downPayment;
		this.monthlyPayment = monthlyPayment;
		this.payablemMonths = payableMonths;
		this.interestRate = interestRate;
	}

	//getters and setters
	public DateTime getDateTime() {
		return dateTime;
	}
	
	public void setDateTime(DateTime dateTime) {
		this.dateTime = dateTime;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	public double getDownPayment() {
		return downPayment;
	}

	public void setDownPayment(double downPayment) {
		this.downPayment = downPayment;
	}

	public double getMonthlyPayment() {
		return monthlyPayment;
	}

	public void setMonthlyPayment(double monthlyPayment) {
		this.monthlyPayment = monthlyPayment;
	}

	public int getPayableMonths() {
		return payablemMonths;
	}

	public void setPayableMonths(int payableMonths) {
		this.payablemMonths = payablemMonths;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	@Override
	public double getPrice() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public String getProductName() {
		return "";
	}
	
	
	//returns address
	@Override
	public String getInvoiceAddress() {
		// TODO Auto-generated method stub
		return getAddress().toString();
	}
	

	

}
