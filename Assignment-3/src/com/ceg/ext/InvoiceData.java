package com.ceg.ext;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import entities.Address;

/*
 * This is a collection of utility methods that define a general API for
 * interacting with the database supporting this application.
 * 15 methods in total, add more if required.
 * Donot change any method signatures or the package name.
 * 
 */

public class InvoiceData {

	/**
	 * 1. Method that removes every person record from the database
	 */
	public static void removeAllPersons() {
		Connection conn = getConnection();
		PreparedStatement ps = null;
		// removes all ProductList, all Invoice
		removeAllInvoices();
		String a = "Delete from Customer";
		try {
			ps = conn.prepareStatement(a);
			ps.executeUpdate();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 2. Method to add a person record to the database with the provided data.
	 * 
	 * @param personCode
	 * @param firstName
	 * @param lastName
	 * @param street
	 * @param city
	 * @param state
	 * @param zip
	 * @param country
	 */
	public static void addPerson(String personCode, String firstName, String lastName, Address address) {
	}

	/**
	 * 3. Adds an email record corresponding person record corresponding to the
	 * provided <code>personCode</code>
	 * 
	 * @param personCode
	 * @param email
	 */
	public static void addEmail(String personCode, String emailAddress) {
		Connection conn = getConnection();
		PreparedStatement ps = null;
		String a = "Insert into Email (personId, emailAddress) values ((Select p.personId from Person p where p.personCode = ?), ?)";
		try {
			ps = conn.prepareStatement(a);
			ps.setString(1, personCode);
			ps.setString(2, emailAddress);
			ps.executeUpdate();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 4. Method that removes every customer record from the database
	 */

	public static void removeAllCustomers() {
		Connection conn = getConnection();
		PreparedStatement ps = null;
		// removes all ProductList, all Invoice
		removeAllInvoices();
		String a = "Delete from Customer";
		try {
			ps = conn.prepareStatement(a);
			ps.executeUpdate();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public static void addCustomer(String customerCode, String customerType, String primaryContact, String customerName,
			String customerAddress) {

		Connection conn = getConnection();
		PreparedStatement ps = null;
		String a = "INSERT INTO Customer (customerCode, customerType, primaryContact, customerName, customerAdderss) VALUES ((SELECT c.customerId FROM Customer c WHERE c.customerCode = ?), ?, ?, ?, ?)";
		try {
			ps = conn.prepareStatement(a);
			ps.setString(1, customerCode);
			ps.setString(2, customerType);
			ps.setString(3, primaryContact);
			ps.setString(4, customerName);
			ps.setString(5, customerAddress);
			ps.executeUpdate();
			ps.close();
			conn.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 5. Removes all product records from the database
	 */
	public static void removeAllProducts() {
		Connection conn = getConnection();
		PreparedStatement ps = null;
		// removes all ProductList and all Invoice
		removeAllInvoices();
		String a = "Delete from Product";
		try {
			ps = conn.prepareStatement(a);
			ps.executeUpdate();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 6. Adds a SaleAgreement record to the database with the provided data.
	 */
	public static void addSaleAgreement(String productCode, String salesDate, String salesTime, String address,
			double totalCost, double downPayment, double monthlyPayment, int payableMonths, double interestRate) {

		Connection conn = getConnection();
		PreparedStatement ps = null;
		String a = "INSERT INTO SalesAgreement (productId, salesDate, salesTime, address, totalcost, downPayment, montlyPayment, payableMonths, interestRate) VALUES ((SELECT p.productId FROM Product p WHERE p.productCode = ?), ?, ?, ?, ?, ?, ?, ?);";
		try {
			ps = conn.prepareStatement(a);
			ps.setString(1, productCode);
			ps.setString(2, salesDate);
			ps.setString(3, salesTime);
			ps.setString(4, address);
			ps.setDouble(5, totalCost);
			ps.setDouble(6, downPayment);
			ps.setDouble(7, monthlyPayment);
			ps.setInt(8, payableMonths);
			ps.setDouble(9, interestRate);
			ps.executeUpdate();
			ps.close();
			conn.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 7. Adds a LeaseAgreement record to the database with the provided data.
	 */
	public static void addLeaseAgreement(String productCode, String startDate, String endDate, String address,
			String customerName, double deposit, double monthlyCost) {
		Connection conn = getConnection();
		PreparedStatement ps = null;
		String a = "INSERT INTO LeaseAgreement (productId, startDate, endDate, address, customerName, deposit, monthlyCost) VALUES ((SELECT p.productId FROM Product p WHERE p.productCode = ?), ?, ?, ?, ?, ?, ?);";
		try {
			ps = conn.prepareStatement(a);
			ps.setString(1, productCode);
			ps.setString(2, startDate);
			ps.setString(3, endDate);
			ps.setString(4, address);
			ps.setString(5, customerName);
			ps.setDouble(6, deposit);
			ps.setDouble(7, monthlyCost);
			ps.executeUpdate();
			ps.close();
			conn.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 8. Adds a ParkingPass record to the database with the provided data.
	 */
	public static void addParkingPass(String productCode, double parkingFee) {
		Connection conn = getConnection();
		PreparedStatement ps = null;
		String a = "INSERT INTO ParkingPass (productId, parkingFee) VALUES ((SELECT p.productId FROM Product p WHERE p.productCode = ?), ?);";
		try {
			ps = conn.prepareStatement(a);
			ps.setString(1, productCode);
			ps.setDouble(2, parkingFee);
			ps.executeUpdate();
			ps.close();
			conn.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 9. Adds an Amenity record to the database with the provided data.
	 */
	public static void addAmenity(String productCode, String name, double cost) {

		Connection conn = getConnection();
		PreparedStatement ps = null;
		String a = "INSERT INTO Amenity (productId, name, cost) VALUES ((SELECT p.productId FROM Product p WHERE p.productCode = ?), ?,?);";
		try {
			ps = conn.prepareStatement(a);
			ps.setString(1, productCode);
			ps.setString(2, name);
			ps.setDouble(3, cost);
			ps.executeUpdate();
			ps.close();
			conn.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 10. Removes all invoice records from the database
	 */
	public static void removeAllInvoices() {
		Connection conn = getConnection();
		PreparedStatement ps = null;
		String a = "Delete from InvoiceProductList";
		String b = "Delete from Invoice";
		try {
			ps = conn.prepareStatement(a);
			ps.executeUpdate();
			ps = conn.prepareStatement(b);
			ps.executeUpdate();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 11. Adds an invoice record to the database with the given data.
	 */
	public static void addInvoice(String invoiceCode, String customerCode, String realtorCode, String invoiceDate) {
		Connection conn = getConnection();
		PreparedStatement ps = null;
		String a = "INSERT INTO Invoice (invoiceId, customerId, personId, invoiceDate) VALUES ((SELECT i.invoiceId FROM invoice i WHERE i.invoiceCode = ?), (SELECT c.customerId FROM Customer c WHERE c.customerCode = ?), (SELECT p.personId FROM Person p WEHRE p.personCode = ?), ?);";
		try {
			ps = conn.prepareStatement(a);
			ps.setString(1, invoiceCode);
			ps.setString(2, customerCode);
			ps.setString(3, realtorCode);
			ps.setString(4, invoiceDate);
			ps.executeUpdate();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 12. Adds a particular SaleAgreement (corresponding to
	 * <code>productCode</code> to an invoice corresponding to the provided
	 * <code>invoiceCode</code> with the given number of units
	 */

	public static void addSaleAgreementToInvoice(String invoiceCode, String productCode, int quantity) {
		Connection conn = getConnection();
		PreparedStatement ps = null;
		String a = "INSERT INTO InvoiceProductList (invoiceId, productId, quantity, apartmentAttachement) VALUES ((SELECT i.invoiceId FROM invoice i WHERE i.invoiceCode = ?), (SELECT p.productId FROM Product p WHERE p.productCode = ?), ?, ?);";
		try {
			ps = conn.prepareStatement(a);
			ps.setString(1, invoiceCode);
			ps.setString(2, productCode);
			ps.setInt(3, quantity);
			ps.setString(4, null);
			ps.executeUpdate();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 13. Adds a particular LeaseAgreement (corresponding to
	 * <code>productCode</code> to an invoice corresponding to the provided
	 * <code>invoiceCode</code> with the given begin/end dates
	 */
	public static void addLeaseAgreementToInvoice(String invoiceCode, String productCode, int quantity) {
		Connection conn = getConnection();
		PreparedStatement ps = null;
		String a = "INSERT INTO InvoiceProductList (invoiceId, productId, quantity, apartmentAttachement) VALUES ((SELECT i.invoiceId FROM invoice i WHERE i.invoiceCode = ?), (SELECT p.productId FROM Product p WHERE p.productCode = ?), ?, ?);";
		try {
			ps = conn.prepareStatement(a);
			ps.setString(1, invoiceCode);
			ps.setString(2, productCode);
			ps.setInt(3, quantity);
			ps.setString(4, null);
			ps.executeUpdate();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 14. Adds a particular ParkingPass (corresponding to <code>productCode</code>
	 * to an invoice corresponding to the provided <code>invoiceCode</code> with the
	 * given number of quantity. NOTE: agreementCode may be null
	 */
	public static void addParkingPassToInvoice(String invoiceCode, String productCode, int quantity,
			String apartmentAttachment) {
		Connection conn = getConnection();
		PreparedStatement ps = null;
		String a = "INSERT INTO InvoiceProductList (invoiceId, productId, quantity, apartmentAttachement) VALUES ((SELECT i.invoiceId FROM invoice i WHERE i.invoiceCode = ?), (SELECT p.productId FROM Product p WHERE p.productCode = ?), ?, ?);";
		try {
			ps = conn.prepareStatement(a);
			ps.setString(1, invoiceCode);
			ps.setString(2, productCode);
			ps.setInt(3, quantity);
			ps.setString(4, apartmentAttachment);
			ps.executeUpdate();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 15. Adds a particular amenity (corresponding to <code>productCode</code> to
	 * an invoice corresponding to the provided <code>invoiceCode</code> with the
	 * given number of quantity.
	 */
	public static void addAmenityToInvoice(String invoiceCode, String productCode, int quantity) {
	}

	public static Connection getConnection() {
		Connection conn = null;
		String url = "jdbc:mysql://cse.unl.edu/sstratton";
		String user = "sstratton";
		String password = "I3:5mL";
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return conn;
	}

}
