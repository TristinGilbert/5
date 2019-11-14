/*
 * This code is created to hold the hashmaps to return customer, type, and fees information
 * 
 * Authors: Max Van Arsdall and Tristin Gilbert
 * 
 * 
 */
package entities;

import java.util.HashMap;

public class CustomerMap {

	private static HashMap<String, String> customerMapped = new HashMap<String, String>();

	public static void setCustomerMapped(HashMap<String, String> mapped) {
		customerMapped = mapped;
	}

	public static String findPersonName(String customerCode) {

		String name = customerMapped.get(customerCode);
		return name;
	}

	private static HashMap<String, String> customerType = new HashMap<String, String>();

	public static void setCustomerType(HashMap<String, String> map) {
		customerType = map;
	}

	public static String findCustomerType(String customerCode) {

		String type = "Checking";
		String customer = customerType.get(customerCode);

		for (int i = 0; i < customerType.size(); i++) {
			if (customer.equals("L")) {
				type = "[LowIncome]";
				return type;
			}

			if (customer.equals("G")) {
				type = "[General]";
				return type;
			}

		}

		return type;
	}

	public static double checkFees(String customerCode) {
		double fee = 0.00;
		String customer = customerType.get(customerCode);

		for (int i = 0; i < customerType.size(); i++) {

			if (customer.equals("L")) {
				fee = 50.75;
			}

			if (customer.equals("G")) {
				fee = 0.00;
			}
		}
		return fee;

	}
	

}
