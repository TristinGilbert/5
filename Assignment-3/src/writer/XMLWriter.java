package writer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

import com.thoughtworks.xstream.XStream;

import entities.Customer;
import entities.Person;
import entities.Product;

public class XMLWriter {

	public void xmlConverterPerson(List<Person> persons) {
		XStream  xstream = new XStream();
		
        File xmlOutput = new File("data/Persons.xml");
		
		PrintWriter xmlPrintWriter = null;
		try {
			xmlPrintWriter = new PrintWriter(xmlOutput);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		xmlPrintWriter.write("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n");
		
		xstream.alias("person", Person.class); 
		
		String personOutput = xstream.toXML(persons);
		xmlPrintWriter.write(personOutput);
		
		xmlPrintWriter.close();	
	}
	
	public void xmlConverterCustomer(List<Customer> customers) {
		XStream  xstream = new XStream();
		
        File xmlOutput = new File("data/Persons.xml");
		
		PrintWriter xmlPrintWriter = null;
		try {
			xmlPrintWriter = new PrintWriter(xmlOutput);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		xmlPrintWriter.write("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n");
		
		String customerOutput = xstream.toXML(customers);
		xmlPrintWriter.write(customerOutput);
		xmlPrintWriter.close();	
	}
	
	public void xmlConverterProduct(List<Product> products) {
		XStream  xstream = new XStream();
		
        File xmlOutput = new File("data/Prodcuts.xml");
		
		PrintWriter xmlPrintWriter = null;
		try {
			xmlPrintWriter = new PrintWriter(xmlOutput);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		xmlPrintWriter.write("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n");
		
		//xmPrinterWriter.write("<Products\n>");
		xstream.alias("product", Product.class); 
		

		String productOutput = xstream.toXML(products);
		xmlPrintWriter.write(productOutput);
		xmlPrintWriter.close();	
	}
	
	
	
}
