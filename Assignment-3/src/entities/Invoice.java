/*
 * This code is created to hold the invoice class and the methods within it
 * 
 * Authors: Max Van Arsdall and Tristin Gilbert
 * 
 * 
 */
package entities;

import java.util.ArrayList;

public class Invoice {
	private String invoiceCode;
	private String invoiceCustomer;
	private String personCode;
	private Time invoiceDate;
	private ArrayList<Product> products;
	
	//creates an invoice object
	public Invoice(String invoiceCode, String invoiceCustomer, String personCode, Time invoiceDate, ArrayList<Product> products) {
		super();
		this.invoiceCode = invoiceCode;
		this.invoiceCustomer = invoiceCustomer;
		this.personCode = personCode;
		this.invoiceDate = invoiceDate;
		this.products = products;
	}
	
	//getters and setters
	public String getInvoiceCode() {
		return invoiceCode;
	}

	public void setInvoiceCode(String invoiceCode) {
		this.invoiceCode = invoiceCode;
	}

	public String getInvoiceCustomer() {
		return invoiceCustomer;
	}

	public void setInvoiceCustomer(String invoiceCustomer) {
		this.invoiceCustomer = invoiceCustomer;
	}

	public String getPersonCode() {
		return personCode;
	}

	public void setPersonCode(String personCode) {
		this.personCode = personCode;
	}

	public Time getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(Time invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public ArrayList<Product> getProducts() {
		return products;
	}

	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}

	//override function to print information
	@Override
	public String toString() {
		return "Invoice [invoiceCode=" + invoiceCode + ", invoiceCustomer=" + invoiceCustomer + ", personCode="
				+ personCode + ", invoiceDate=" + invoiceDate + ", products=" + products + "]";
	}

	//gets subtotal
	public double getSubTotal(Product p) {
		double subTotal = 0.0;
		if(p.getType().equals("A")) {
			subTotal = p.getQuantity() * p.getPrice();
		}
		else if(p.getType().equals("S")){
		//	subTotal = p.getQuantity() * (p.g)
		}
		return subTotal;
	}
	
	//prints item name in individual report
	public String getItemName(Product p) {
		String itemName = "";
		if(p.getType().equals("A")) {
			itemName = itemName + p.getProductName() + " ";
			itemName += "(" + p.getQuantity() + " units @ " + p.getPrice() + "/unit)";
		}
		if(p.getType().equals("P")) {
			itemName = itemName + p.getProductName();
		}
		if(p.getType().equals("L")) {
			itemName = itemName + p.getProductName() + " @ " + p.getInvoiceAddress();
		}
		
		return itemName;
	}
	
	
	
	
	
	

}
