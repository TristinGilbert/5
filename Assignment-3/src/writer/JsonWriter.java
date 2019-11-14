/*
 * This code is created to take the Person, Customer, and Product list and turn them into JSON files
 * 
 * Authors: Max Van Arsdall and Gavin Teet
 * 
 * 
 */
package writer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

import entities.Customer;
import entities.Person;
import entities.Product;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonWriter {

	public void jsonPersonConverter(List<Person> persons) {

		//creates json file for Persons
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		File jsonOutput = new File("data/Persons.json");

		PrintWriter jsonPrintWriter = null;

		try {
			jsonPrintWriter = new PrintWriter(jsonOutput);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		//iterates through list 
		for (Person aPerson : persons) {
			// Use toJson method to convert Person object into a String
			String personOutput = gson.toJson(aPerson);
			jsonPrintWriter.write(personOutput + "\n");
		}

		jsonPrintWriter.close();
	}

	public void jsonCustomerConverter(List<Customer> Customers) {
		//creates json file for Customer list
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		File jsonOutput = new File("data/Customers.json");

		PrintWriter jsonPrintWriter = null;

		try {
			jsonPrintWriter = new PrintWriter(jsonOutput);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		//reads through customer list
		for (Customer aCustomer : Customers) {
			// Use toJson method to convert Customer object into a String
			String personOutput = gson.toJson(aCustomer);
			jsonPrintWriter.write(personOutput + "\n");
		}

		jsonPrintWriter.close();
	}

	public void jsonProductConverter(List<Product> Products) {
		//creates Product json file
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		File jsonOutput = new File("data/Products.json");

		PrintWriter jsonPrintWriter = null;

		try {
			jsonPrintWriter = new PrintWriter(jsonOutput);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		//reads through product list
		for (Product aProduct : Products) {
			// Use toJson method to convert Product object into a String
			String personOutput = gson.toJson(aProduct);
			jsonPrintWriter.write(personOutput + "\n");
		}

		jsonPrintWriter.close();
	}
}
