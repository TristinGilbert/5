/*
 * This code is a main file to create an invoice report
 * 
 * Authors: Max Van Arsdall and Tristin Gilbert
 * 
 * 
 */
package driver;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import entities.*;
import reader.FlatFileReader;

public class InvoiceReport {

	public static void main(String[] args) {
		
		
		
		ArrayList<Invoice> invoice;
		//file readers to get the lists into the main
		FlatFileReader fr = new FlatFileReader();

		/*
		* fr Reads data from the flat file; Creates Person objects; and Stores Person
		 * objects in a Person ArrayList
		 */
		List<Person> personList = fr.readPersons();

		/*
		 * fr Reads data from the flat file; Creates Customer objects; and Stores Customer
		 * objects in a Customer ArrayList
		 */
		List<Customer> customerList = fr.readCustomers(personList);

		/*
		 * fr Reads data from the flat file; Creates Product objects; and Stores Product
		 * objects in a Product ArrayList
		 */
		List<Product> productList = fr.readProducts(customerList);
				
		List<Invoice> invoiceList = fr.readInvoice();
		
		
		// printing the executive summary report
		System.out.println("Executive Summary Report");
		System.out.println("========================");
		System.out.println("");
		System.out.printf("%-10s %-25s %20s %25s %11s %11s %10s\n", "Invoice", "Customer", "Realtor", "Subtotal", "Fees", "Taxes", "Discount", "Total");
		
		double subTotal = 0;
		double fees = 0;
		double taxes = 0;
		double discount = 0;
		double total = 0;
		
		//enhanced for loop to print off 
		for(Invoice i: invoiceList) {
			System.out.printf("%-10s %s %-20s %10s $%10s %11s %10s %10s\n", i.getInvoiceCode(), CustomerMap.findPersonName(i.getInvoiceCustomer()), 
					CustomerMap.findCustomerType(i.getInvoiceCustomer()), PersonMapped.findPersonName(i.getPersonCode()), subTotal, 
					CustomerMap.checkFees(i.getInvoiceCustomer()), taxes, total, discount);
		}
		
		System.out.println("======================================================================================================================");
		
		System.out.println("TOTALS");
		System.out.println("");
		
		System.out.println("Individual Invoice Detail Reports");
		System.out.println("==============================================");
		
		//enhanced for loop to print out the individual invoice reports
		for(Invoice i: invoiceList) {
			System.out.printf("Invoice %s\n", i.getInvoiceCode());
			System.out.println("===========================");
			System.out.printf("Realtor: %s\n", PersonMapped.findPersonName(i.getPersonCode()));
			System.out.println("Customer info:");
			System.out.printf("  %s(%s)\n", CustomerMap.findPersonName(i.getInvoiceCustomer()),i.getInvoiceCustomer());
			System.out.printf("  %s\n", CustomerMap.findCustomerType(i.getInvoiceCustomer()));
			//search through customer list to find customer information
			for(Customer c: customerList) {
				if(c.getCode().equals(i.getInvoiceCustomer())) {
				System.out.printf("  %s\n", c.toString());
				}
			}
			System.out.println("---------------------");
			
			//prints out the products
			System.out.printf("%-10s %-75s  %10s   %10s   %10s\n", "Code", "Item", "Subtotal", "Tax", "Total");
			for(Product p: i.getProducts()) {
				if(p.getType().equals("P") || p.getType().equals("A")){
				//if statement to print out certain amount of lines
					System.out.printf("%-10s %-75s  %10.2f   %10s   %10s\n", p.getProductCode(), i.getItemName(p), i.getSubTotal(p), "Tax", "Total");
				}
				else if(p.getType().equals("L")) {
					Lease l = (Lease) p;
					System.out.printf("%-10s %-75s\n %-10s (%s units @ %s)\n", p.getProductCode(), i.getItemName(p), l.getStartDate(), p.getQuantity(), l.getMonthlyCost());
					
				}
				
			}
			System.out.println("");
			System.out.printf("%-20s %s\n", "", "=======================================");
			//System.out.printf("%-2os $%10.2f  $%10.2f  $%10.2f\n", "SUB-TOTALS", 0, 0,0);
			
			//if (0 != 0) {
				//System.out.printf("%-112s $%10.2f\n", "DISCOUNT", 0);
			//}
			//if (1 != 0) {
			//	System.out.printf("%-112s $%10.2f\n", "ADDITIONAL FEE", 0);
			//}
		//	System.out.printf("%-112s $%10.2f\n", "TOTAL", 0);
			System.out.println("");
			System.out.println("");
			System.out.println("                                 Thank you for your purchase!");
			System.out.println("");
			System.out.println("");
		
		}
		
	}

}