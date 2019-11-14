/*
 * This code is created to read in the .dat files, create classes with the data, and add it to a list
 * 
 * Authors: Max Van Arsdall and Tristin Gilbert
 * 
 * 
 */
package reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import entities.*;



public class FlatFileReader {

	//Arraylists used to store information
	ArrayList<Person> persons = new ArrayList<Person>();
	ArrayList<Customer> customers = new ArrayList<Customer>();
	ArrayList<Product> products = new ArrayList<Product>();
	ArrayList<Invoice> invoices = new ArrayList<Invoice>();
	
	public ArrayList<Person> readPersons() {
		Scanner sc = null;

		try {
			//read in file
			sc = new Scanner(new File("data/Persons.dat"));
			sc.nextLine(); // reads the number of records from the first line
			
			//hashmap
			HashMap<String, String> map = new HashMap<String, String>();

			// This Person ArrayList stores the Person objects
			ArrayList<Person> personList = new ArrayList<Person>();

			while (sc.hasNext()) {
				String line = sc.nextLine(); // reads each line starting from 2nd line
				String data[] = line.split(";"); // tokenizes the line and stores in a string array

				// Stores the array elements of each line into strings
				String personcode = data[0];
				String name[] = data[1].split(",");
				String personName = data[1];
				
				
				String addressHolder[] = data[2].split(",");
				String street = addressHolder[0];
				String city = addressHolder[1];
				String state = addressHolder[2];
				String zip = addressHolder[3];
				String country = addressHolder[4];
				// needs an array list?
				ArrayList<String> email = new ArrayList<String>();
				if (data.length > 3) {
					for (int i = 0; i < data[3].split(",").length; i++) {
						email.add(data[3].split(",")[i]);
					}
				
				
				
				//adds to hashmap
				map.put(personcode, personName);

				// Creates an Address object
				Address address = new Address(street, city, state, zip, country);

				// Creates a Person object
				Person person = new Person(personcode, name[1], name[0], address, email);

				// Adds the Person object into Person ArrayList
				personList.add(person);
				}
			}
			sc.close();
			PersonMapped.setPersonMapped(map);
			return personList;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}

	public ArrayList<Customer> readCustomers(List<Person> personList) {

		Scanner sc = null;

		try {
			//reads in the .dat file
			sc = new Scanner(new File("data/Customers.dat"));
			sc.nextLine(); // reads the number of records from the first line

			// This Customer ArrayList stores the Customer objects
			ArrayList<Customer> customerList = new ArrayList<Customer>();
			
			//hashmap
			HashMap<String, String> mapped = new HashMap<String, String>();
			HashMap<String, String> typeMap = new HashMap<String, String>();
		//	HashMap<String, String> personMap = new HashMap<String, String>();
		//	HashMap<String, String> streetMap = new HashMap<String, String>();
		//	HashMap<String, String> cityMap = new HashMap<String, String>();

			while (sc.hasNext()) {
				String line = sc.nextLine(); // reads each line starting from 2nd line
				String data[] = line.split(";"); // tokenizes the line and stores in a string array

				// Stores the array elements of each line into strings
				String customerCode = data[0];
				String type = data[1];
				String code = data[2];
				String name = data[3];
				
				//address is tokenized
				String addressHolder[] = data[4].split(",");
				String street = addressHolder[0];
				String city = addressHolder[1];
				String state = addressHolder[2];
				String zip = addressHolder[3];
				String country = addressHolder[4];

				// Creates an Address object
				Address address = new Address(street, city, state, zip, country);

				Person primaryContact = null;
				//gets the customer based off the primary contact
				for (int i = 0; i < personList.size(); i++) {
					if (code.equals(personList.get(i).getPersonCode())) {
						primaryContact = personList.get(i);
					}
				}
				
				//adds to hashmap
				mapped.put(customerCode, name);
				typeMap.put(customerCode, type);
			//	personMap.put(customerCode, );

				// Creates a Customer object
				Customer customer = new Customer(customerCode, primaryContact, name, address);

				// Adds the Customer object into Customer ArrayList
				customerList.add(customer);
			}
			sc.close();
			CustomerMap.setCustomerMapped(mapped);
			CustomerMap.setCustomerType(typeMap);
			return customerList;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}

	}

	public ArrayList<Product> readProducts(List<Customer> customerList) {
		Scanner sc = null;

		try {
			sc = new Scanner(new File("data/Products.dat"));
			sc.nextLine(); // reads the number of records from the first line

			// This Product ArrayList stores the Product objects
			ArrayList<Product> productList = new ArrayList<Product>();

			while (sc.hasNext()) {
				String line = sc.nextLine(); // reads each line starting from 2nd line
				String data[] = line.split(";"); // tokenizes the line and stores in a string array

				// Stores the array elements of each line into strings
				String productCode = data[0];
				String productType = data[1];

				//determines it is a lease product
				if (productType.equals("L")) {
					String startDate[] = data[2].split("-");
					//date is tokenized
					int startYear = Integer.parseInt(startDate[0]);
					int startMonth = Integer.parseInt(startDate[1]);
					int startDay = Integer.parseInt(startDate[2]);
					//end date is tokenized
					String endDate[] = data[3].split("-");
					int endYear = Integer.parseInt(endDate[0]);
					int endMonth = Integer.parseInt(endDate[1]);
					int endDay = Integer.parseInt(endDate[2]);

					//address is tokenized
					String addressContainer[] = data[4].split(",");
					String street = addressContainer[0];
					String city = addressContainer[1];
					String state = addressContainer[2];
					String zip = addressContainer[3];
					String country = addressContainer[4];
					String name = data[5];
					double deposit = Double.parseDouble(data[6]);
					double monthlyCost = Double.parseDouble(data[7]);

					//Finds customer with their name and adds to list
					Customer customer = null;
					for (int j = 0; j < customerList.size(); j++) {
						if (name.equals(customerList.get(j).getName())) {
							customer = customerList.get(j);
						}
					}
					
					// creates a time object
					Time startDateInput = new Time(startYear, startMonth, startDay);
					Time endDateInput = new Time(endYear, endMonth, endDay);

					// Creates an Address object
					Address address = new Address(street, city, state, zip, country);

					//Creates a lease object
					Product lease = new Lease(productCode, productType, startDateInput, endDateInput, address, customer, deposit, monthlyCost);

					productList.add(lease);

				//determines it is a sales object
				} else if (productType.equals("S")) {
					//Datetime is tokenized by date and time
					String dateTimes[] = data[2].split(" ");
					String firstDate[] = dateTimes[0].split("-");
					int year = Integer.parseInt(firstDate[0]);
					int month = Integer.parseInt(firstDate[1]);
					int day = Integer.parseInt(firstDate[2]);
					String firstTime[] = dateTimes[1].split(":");
					int hour = Integer.parseInt(firstTime[0]);
					int minute = Integer.parseInt(firstTime[1]);
					int second = 0;
					//checks for input length
					if (firstTime.length > 2) {
						second = Integer.parseInt(firstTime[2]);
					} else {
						second = 0;
					}
					int nano = 0;

					//address is tokenized
					String addressContainer[] = data[3].split(",");
					String street = addressContainer[0];
					String city = addressContainer[1];
					String state = addressContainer[2];
					String zip = addressContainer[3];
					String country = addressContainer[4];
					double totalCost = Double.parseDouble(data[4]);
					double downPayment = Double.parseDouble(data[5]);
					double monthlyPayment = Double.parseDouble(data[6]);
					int payableMonths = Integer.parseInt(data[7]);
					double interestRate = Double.parseDouble(data[8]);

					// creates a time object
					Time date = new Time(year, month, day);
					FullTime time = new FullTime(hour, minute, second, nano);
					DateTime dateTime = new DateTime(date, time);

					// Creates an Address object
					Address address = new Address(street, city, state, zip, country);

					//Creates a Sales object
					Product sales = new Sales(productCode, productType, dateTime, address, totalCost, downPayment, monthlyPayment, payableMonths,
							interestRate);

					productList.add(sales);
					
				//determines it is a parking object
				} else if (productType.equals("P")) {
					double parkingFee = Double.parseDouble(data[2]);
					
					
					//creates a parking object
					Product parking = new Parking(productCode, productType, parkingFee);

					productList.add(parking);
					
				//determines it is an Amenity object
				} else {
					String productName = data[2];
					double cost = Double.parseDouble(data[3]);
					
					//creates amenity object
					Product amenity = new Amenity(productCode, productType, productName, cost);

					productList.add(amenity);
				}

			}
			sc.close();
			products = productList;
			return productList;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	public ArrayList<Invoice> readInvoice() {

		Scanner sc = null;

		try {
			//reads in the .dat file
			sc = new Scanner(new File("data/invoices.dat"));
			sc.nextLine(); // reads the number of records from the first line

			// This Customer ArrayList stores the Customer objects
			
			ArrayList<Invoice> invoiceList = new ArrayList<Invoice>();
			

			while (sc.hasNext()) {
				String line = sc.nextLine(); // reads each line starting from 2nd line
				String data[] = line.split(";"); // tokenizes the line and stores in a string array

				// Stores the array elements of each line into strings
				String invoiceCode = data[0];
				String customerCode = data[1];
				String personCode = data[2];
				String dateTime[] = data[3].split("-");
				int year = Integer.parseInt(dateTime[0]);
				int month = Integer.parseInt(dateTime[1]);
				int day = Integer.parseInt(dateTime[2]);
				ArrayList<Product> productInvoice = new ArrayList<Product>();
				
				String productTokenized[] = data[4].split(",");
				
				//parsing the products from the invoice file
				for(String product : productTokenized) {
					String prodSecondToken[] = product.split(":");
					//adds to productInvoice the products
					if(prodSecondToken.length == 2) {
						//System.out.println(prodSecondToken[0]);
						for(Product p : products) {				
							if(p.getProductCode().equals(prodSecondToken[0])) {
								
								p.setQuantity(Integer.parseInt(prodSecondToken[1]));
								productInvoice.add(p);				
						}
					}
					}
					//adds parking to product Invoice
					if(prodSecondToken.length == 3) {
						for(Product p : products) {
							if(p.getProductCode().equals(prodSecondToken[0])) {
								Parking cloneP = new Parking(p.getProductCode(), "P", p.getPrice());
								cloneP.setQuantity(Integer.parseInt(prodSecondToken[1]));
								String additional = "";
								if(prodSecondToken.length > 2) {
									additional = prodSecondToken[2];
									productInvoice.add(cloneP);
								}
								else {
									productInvoice.add(cloneP);
								}
							}
						}
					}

					
				}
				
		
				
				Time invoiceDate = new Time(year, month, day);
				
				
				
				Invoice invoice = new Invoice(invoiceCode, customerCode, personCode, invoiceDate, productInvoice);
				
				invoiceList.add(invoice);
				
		
			
			}
			sc.close();
			return invoiceList;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}

	}

}
