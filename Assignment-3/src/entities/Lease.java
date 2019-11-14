/*
 * This code is created to hold the Lease constructor and getters and setters
 * 
 * Authors: Max Van Arsdall and Tristin Gilbert
 * 
 * 
 */
package entities;

import java.time.LocalDate;

public class Lease extends Product {
	//defining variables
	private Time startDate;
	private Time endDate;
	private Address address;
	private Customer customer;
	private double deposit;
	private double monthlyCost;

	// Constructor
	

	//getters and setters
	public String getStartDate() {
		return startDate.toString();
	}

	public Lease(String code, String type, Time startDate, Time endDate, Address address, Customer customer,
			double deposit, double monthlyCost) {
		super(code, type);
		this.startDate = startDate;
		this.endDate = endDate;
		this.address = address;
		this.customer = customer;
		this.deposit = deposit;
		this.monthlyCost = monthlyCost;
	}

	public void setStartDate(Time startDate) {
		this.startDate = startDate;
	}

	public Time getEndDate() {
		return endDate;
	}

	public void setEndDate(Time endDate) {
		this.endDate = endDate;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public double getDeposit() {
		return deposit;
	}

	public void setDeposit(double deposit) {
		this.deposit = deposit;
	}

	public double getMonthlyCost() {
		return monthlyCost;
	}

	public void setMonthlyCost(double monthlyCost) {
		this.monthlyCost = monthlyCost;
	}

	@Override
	public double getPrice() {
		// TODO Auto-generated method stub
		return 0;
	}

	//function to return invoice address
	@Override
	public String getInvoiceAddress() {
		// TODO Auto-generated method stub
		
		return getAddress().getStreet();
	}
	
	@Override
	public String getProductName() {
		return "Lease Agreement";
	}


	
	

}
