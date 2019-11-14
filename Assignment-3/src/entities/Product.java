/*
 * This code is created to hold the Product constructor and getters and setters
 * 
 * Authors: Max Van Arsdall and Tristin Gilbert
 * 
 * 
 */

package entities;

public abstract class Product {
	//defining variables
	private String code;
	private String type;
	private Customer customer;
	private Integer quantity;
	

	//getters and setters
	public String getProductCode() {
		return code;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public void setProductCode(String productCode) {
		this.code = productCode;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Product(String code, String type) {
		super();
		this.code = code;
		this.type = type;
	}
	
	public abstract double getPrice();
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	};
	
	public Integer getQuantity() {
		return quantity;
	}
	
	//abstract classes extended through all products
	public abstract String getProductName();
	
	public abstract String getInvoiceAddress();
	


}
